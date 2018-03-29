/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.javaparser.ast.type;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithTypeArguments;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ClassOrInterfaceTypeMetaModel;
import com.github.javaparser.metamodel.DerivedProperty;
import com.github.javaparser.metamodel.JavaParserMetaModel;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import static com.github.javaparser.utils.Utils.assertNotNull;

import javax.annotation.Generated;

import org.apache.commons.lang3.StringUtils;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import static com.github.javaparser.ast.NodeList.nodeList;

import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;
import static com.github.javaparser.utils.Utils.assertNonEmpty;

/**
 * A class or an interface type. <br/><code>Object</code> <br/><code>HashMap&lt;String, String></code>
 * <br/><code>java.util.Punchcard</code>
 * <p>
 * <p>Note that the syntax is ambiguous here, and JavaParser does not know what is to the left of the class. It assumes
 * cases like <code>Map.Entry</code> where Map is the scope of Entry. In <code>java.util.Punchcard</code>, it will not
 * recognize that java and util are parts of the package name. Instead, it will set util as the scope of Punchcard, as a
 * ClassOrInterfaceType (which it is not.) In turn, util will have java as its scope, also as a
 * ClassOrInterfaceType</p>
 *
 * @author Julio Vilmar Gesser
 */
public final class ClassOrInterfaceType extends ReferenceType implements NodeWithSimpleName<ClassOrInterfaceType>, NodeWithAnnotations<ClassOrInterfaceType>, NodeWithTypeArguments<ClassOrInterfaceType> {

    @OptionalProperty
    private ClassOrInterfaceType scope;

    private SimpleName name;

    @OptionalProperty
    private NodeList<Type> typeArguments;

    public ClassOrInterfaceType() {
        this(null, null, new SimpleName(), null, new NodeList<AnnotationExpr>());
    }

    /**
     * @deprecated use JavaParser.parseClassOrInterfaceType instead. This constructor does not understand generics.
     */
    public ClassOrInterfaceType(final String name) {
        this(null, null, new SimpleName(name), null, new NodeList<AnnotationExpr>());
    }

    public ClassOrInterfaceType(final ClassOrInterfaceType scope, final String name) {
        this(null, scope, new SimpleName(name), null, new NodeList<AnnotationExpr>());
    }

    public ClassOrInterfaceType(final ClassOrInterfaceType scope, final SimpleName name, final NodeList<Type> typeArguments) {
        this(null, scope, name, typeArguments, new NodeList<AnnotationExpr>());
    }

    @AllFieldsConstructor
    public ClassOrInterfaceType(final ClassOrInterfaceType scope, final SimpleName name, final NodeList<Type> typeArguments, final NodeList<AnnotationExpr> annotations) {
        this(null, scope, name, typeArguments, annotations);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public ClassOrInterfaceType(TokenRange tokenRange, ClassOrInterfaceType scope, SimpleName name, NodeList<Type> typeArguments, NodeList<AnnotationExpr> annotations) {
        super(tokenRange, annotations);
        setScope(scope);
        setName(name);
        setTypeArguments(typeArguments);
        customInitialization();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public SimpleName getName() {
        return name;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ClassOrInterfaceType getScope() {
        return scope;
    }

    public boolean isBoxedType() {
        return PrimitiveType.unboxMap.containsKey(name.getIdentifier());
    }

    public PrimitiveType toUnboxedType() throws UnsupportedOperationException {
        if (!isBoxedType()) {
            throw new UnsupportedOperationException(name + " isn't a boxed type.");
        }
        return new PrimitiveType(PrimitiveType.unboxMap.get(name.getIdentifier()));
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ClassOrInterfaceType setName(final SimpleName name) {
        assertNotNull(name);
        if (name == this.name) {
            return (ClassOrInterfaceType) this;
        }
        notifyPropertyChange(ObservableProperty.NAME, this.name, name);
        if (this.name != null)
            this.name.setParentNode(null);
        this.name = name;
        setAsParentNodeOf(name);
        return this;
    }

    /**
     * Sets the scope
     *
     * @param scope the scope, can be null
     * @return this, the ClassOrInterfaceType
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ClassOrInterfaceType setScope(final ClassOrInterfaceType scope) {
        if (scope == this.scope) {
            return (ClassOrInterfaceType) this;
        }
        notifyPropertyChange(ObservableProperty.SCOPE, this.scope, scope);
        if (this.scope != null)
            this.scope.setParentNode(null);
        this.scope = scope;
        setAsParentNodeOf(scope);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<Type> getTypeArguments() {
        return typeArguments;
    }

    /**
     * Sets the typeArguments
     *
     * @param typeArguments the typeArguments, can be null
     * @return this, the ClassOrInterfaceType
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ClassOrInterfaceType setTypeArguments(final NodeList<Type> typeArguments) {
        if (typeArguments == this.typeArguments) {
            return (ClassOrInterfaceType) this;
        }
        notifyPropertyChange(ObservableProperty.TYPE_ARGUMENTS, this.typeArguments, typeArguments);
        if (this.typeArguments != null)
            this.typeArguments.setParentNode(null);
        this.typeArguments = typeArguments;
        setAsParentNodeOf(typeArguments);
        return this;
    }

    @Override
    public ClassOrInterfaceType setAnnotations(NodeList<AnnotationExpr> annotations) {
        return (ClassOrInterfaceType) super.setAnnotations(annotations);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        if (scope != null) {
            if (node == scope) {
                removeScope();
                return true;
            }
        }
        if (typeArguments != null) {
            for (int i = 0; i < typeArguments.size(); i++) {
                if (typeArguments.get(i) == node) {
                    typeArguments.remove(i);
                    return true;
                }
            }
        }
        return super.remove(node);
    }

    @Override
    public String asString() {
        StringBuilder str = new StringBuilder();
        //getScope().ifPresent(s -> str.append(s.asString()).append("."));
        if(getScope()!=null){
        	str.append(getScope().asString()).append(".");
        }
        
        str.append(name.asString());
        //getTypeArguments().ifPresent(ta -> str.append(ta.stream().map(Type::asString).collect(joining(",", "<", ">"))));
        NodeList<Type> list= getTypeArguments();
        if(list!=null){
        	String []array=new String[list.size()];
        	for(int i = 0;i<list.size();i++){
        		array[i]=list.get(i).asString();
        	}
        	str.append("<").append(StringUtils.join(array,",")).append(">");
        }
        return str.toString();
    }

    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public ClassOrInterfaceType removeScope() {
        return setScope((ClassOrInterfaceType) null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public ClassOrInterfaceType clone() {
        return (ClassOrInterfaceType) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public ClassOrInterfaceTypeMetaModel getMetaModel() {
        return JavaParserMetaModel.classOrInterfaceTypeMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == name) {
            setName((SimpleName) replacementNode);
            return true;
        }
        if (scope != null) {
            if (node == scope) {
                setScope((ClassOrInterfaceType) replacementNode);
                return true;
            }
        }
        if (typeArguments != null) {
            for (int i = 0; i < typeArguments.size(); i++) {
                if (typeArguments.get(i) == node) {
                    typeArguments.set(i, (Type) replacementNode);
                    return true;
                }
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isClassOrInterfaceType() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ClassOrInterfaceType asClassOrInterfaceType() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifClassOrInterfaceType(Consumer<ClassOrInterfaceType> action) {
        action.accept(this);
    }

    @Override
    public ResolvedReferenceType resolve() {
        return getSymbolResolver().toResolvedType(this, ResolvedReferenceType.class);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ClassOrInterfaceType toClassOrInterfaceType() {
        return this;
    }
    
    // for NodeWithSimpleName
    public  ClassOrInterfaceType setName(String name) {
		 if(name!=null && "".equals(name)){
			 return setName(new SimpleName(name));
		 }else return null;
	}

   public String getNameAsString() {
   	return getName().getIdentifier();
	}
   
   //for NodeWithAnnotations
   public AnnotationExpr getAnnotation(int i) {
       return getAnnotations().get(i);
   }

   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType setAnnotation(int i, AnnotationExpr element) {
       getAnnotations().set(i, element);
       return (ClassOrInterfaceType) this;
   }

   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType addAnnotation(AnnotationExpr element) {
       getAnnotations().add(element);
       return (ClassOrInterfaceType) this;
   }

   /**
    * Annotates this
    *
    * @param name the name of the annotation
    * @return this
    */
   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType addAnnotation(String name) {
       NormalAnnotationExpr annotation = new NormalAnnotationExpr(
               parseName(name), new NodeList<MemberValuePair>());
       getAnnotations().add(annotation);
       return (ClassOrInterfaceType) this;
   }

   /**
    * Annotates this
    *
    * @param name the name of the annotation
    * @return the {@link NormalAnnotationExpr} added
    */
   @SuppressWarnings("unchecked")
   public NormalAnnotationExpr addAndGetAnnotation(String name) {
       NormalAnnotationExpr annotation = new NormalAnnotationExpr(
               parseName(name), new NodeList<MemberValuePair>());
       getAnnotations().add(annotation);
       return annotation;
   }

   /**
    * Annotates this node and automatically add the import
    *
    * @param clazz the class of the annotation
    * @return this
    */
   public ClassOrInterfaceType addAnnotation(Class<? extends Annotation> clazz) {
       tryAddImportToParentCompilationUnit(clazz);
       return addAnnotation(clazz.getSimpleName());
   }

   /**
    * Annotates this node and automatically add the import
    *
    * @param clazz the class of the annotation
    * @return the {@link NormalAnnotationExpr} added
    */
   public NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
       tryAddImportToParentCompilationUnit(clazz);
       return addAndGetAnnotation(clazz.getSimpleName());
   }

   /**
    * Annotates this with a marker annotation
    *
    * @param name the name of the annotation
    * @return this
    */
   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType addMarkerAnnotation(String name) {
       MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
               parseName(name));
       getAnnotations().add(markerAnnotationExpr);
       return (ClassOrInterfaceType) this;
   }

   /**
    * Annotates this with a marker annotation and automatically add the import
    *
    * @param clazz the class of the annotation
    * @return this
    */
   public ClassOrInterfaceType addMarkerAnnotation(Class<? extends Annotation> clazz) {
       tryAddImportToParentCompilationUnit(clazz);
       return addMarkerAnnotation(clazz.getSimpleName());
   }

   /**
    * Annotates this with a single member annotation
    *
    * @param name the name of the annotation
    * @param expression the part between ()
    * @return this
    */
   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType addSingleMemberAnnotation(String name, Expression expression) {
       SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
               parseName(name), expression);
       getAnnotations().add(singleMemberAnnotationExpr);
       return (ClassOrInterfaceType) this;
   }

   /**
    * Annotates this with a single member annotation
    *
    * @param name the name of the annotation
    * @param value the value, don't forget to add \"\" for a string value
    * @return this
    */
   public ClassOrInterfaceType addSingleMemberAnnotation(String name, String value) {
       return addSingleMemberAnnotation(name, parseExpression(value));
   }

   /**
    * Annotates this with a single member annotation and automatically add the import
    *
    * @param clazz the class of the annotation
    * @param value the value, don't forget to add \"\" for a string value
    * @return this
    */
   public ClassOrInterfaceType addSingleMemberAnnotation(Class<? extends Annotation> clazz,
                                       String value) {
       tryAddImportToParentCompilationUnit(clazz);
       return addSingleMemberAnnotation(clazz.getSimpleName(), value);
   }

   /**
    * Check whether an annotation with this name is present on this element
    *
    * @param annotationName the name of the annotation
    * @return true if found, false if not
    */
   public boolean isAnnotationPresent(String annotationName) {
      // return getAnnotations().stream().anyMatch(a -> a.getName().getIdentifier().equals(annotationName));
   	for (AnnotationExpr a : getAnnotations()) {
			if(a.getName().getIdentifier().equals(annotationName)) return true;
		}
   	return false;
   }

   /**
    * Check whether an annotation with this class is present on this element
    *
    * @param annotationClass the class of the annotation
    * @return true if found, false if not
    */
   public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
       return isAnnotationPresent(annotationClass.getSimpleName());
   }

   /**
    * Try to find an annotation by its name
    *
    * @param annotationName the name of the annotation
    */
   public AnnotationExpr getOptionalAnnotationByName(String annotationName) {
      // return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
   	for (AnnotationExpr a : getAnnotations()) {
		   if(a.getName().getIdentifier().equals(annotationName))	return a;
		}
   	return null;
   }
   
   public AnnotationExpr getAnnotationByName(String annotationName){
   	NodeList<AnnotationExpr> annotationList =getAnnotations();
   	for (AnnotationExpr annotationExpr : annotationList) {
			if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
		}
   	return null;
   }

   /**
    * Try to find an annotation by its class
    *
    * @param annotationClass the class of the annotation
    */
   public AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
       return getOptionalAnnotationByName(annotationClass.getSimpleName());
   }
   
   public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
   	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
   	if(optional!=null) return optional;
   	else return null;
   }
   
   //for  NodeWithTypeArguments
   @DerivedProperty
   public boolean isUsingDiamondOperator() {
       return getTypeArguments()!=null && getTypeArguments().isEmpty();
   }

   /**
    * Sets the type arguments to &lt>.
    */
   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType setDiamondOperator() {
       return setTypeArguments(new NodeList<Type>());
   }

   /**
    * Removes all type arguments, including the surrounding &lt;>.
    */
   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType removeTypeArguments() {
       return setTypeArguments((NodeList<Type>) null);
   }

   @SuppressWarnings("unchecked")
   public ClassOrInterfaceType setTypeArguments(Type... typeArguments) {
       return setTypeArguments(nodeList(typeArguments));
   }
   
}
