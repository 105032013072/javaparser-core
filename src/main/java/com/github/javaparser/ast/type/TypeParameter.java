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

import com.github.javaparser.Consumer;
import com.github.javaparser.Range;
import com.github.javaparser.ast.AllFieldsConstructor;
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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import static com.github.javaparser.utils.Utils.assertNotNull;


import java.lang.annotation.Annotation;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.TypeParameterMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import javax.annotation.Generated;

import org.apache.commons.lang3.StringUtils;

import com.github.javaparser.TokenRange;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.types.ResolvedTypeVariable;
import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;

/**
 * A type parameter.
 * <br/><code>&lt;<b>U</b>> U getU() { ... }</code>
 * <br/><code>class D &lt;<b>@Brain T extends B & A & @Tripe C</b>> { ... }</code>
 * <p>U and T are type parameter names.
 * <br/>B, A, and C are type parameter bounds.
 * <br/>Tripe is an annotation on type parameter bound C.
 * <br/>Brain is an annotation on type parameter T.
 *
 * @author Julio Vilmar Gesser
 * @see com.github.javaparser.ast.nodeTypes.NodeWithTypeParameters
 */
public final class TypeParameter extends ReferenceType implements NodeWithSimpleName<TypeParameter>, NodeWithAnnotations<TypeParameter> {

    private SimpleName name;

    private NodeList<ClassOrInterfaceType> typeBound;

    public TypeParameter() {
        this(null, new SimpleName(), new NodeList<ClassOrInterfaceType>(), new NodeList<AnnotationExpr>());
    }

    public TypeParameter(final String name) {
        this(null, new SimpleName(name), new NodeList<ClassOrInterfaceType>(), new NodeList<AnnotationExpr>());
    }

    public TypeParameter(final String name, final NodeList<ClassOrInterfaceType> typeBound) {
        this(null, new SimpleName(name), typeBound, new NodeList<AnnotationExpr>());
    }

    /**
     * @deprecated range shouldn't be in utility constructors.
     */
    @Deprecated
    public TypeParameter(Range range, final SimpleName name, final NodeList<ClassOrInterfaceType> typeBound) {
        this(null, name, typeBound, new NodeList<AnnotationExpr>());
        setRange(range);
    }

    @AllFieldsConstructor
    public TypeParameter(SimpleName name, NodeList<ClassOrInterfaceType> typeBound, NodeList<AnnotationExpr> annotations) {
        this(null, name, typeBound, annotations);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public TypeParameter(TokenRange tokenRange, SimpleName name, NodeList<ClassOrInterfaceType> typeBound, NodeList<AnnotationExpr> annotations) {
        super(tokenRange, annotations);
        setName(name);
        setTypeBound(typeBound);
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

    /**
     * Return the name of the paramenter.
     *
     * @return the name of the paramenter
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public SimpleName getName() {
        return name;
    }

    /**
     * Return the list of {@link ClassOrInterfaceType} that this parameter
     * extends. Return <code>null</code> null if there are no type.
     *
     * @return list of types that this paramente extends or <code>null</code>
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<ClassOrInterfaceType> getTypeBound() {
        return typeBound;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public TypeParameter setName(final SimpleName name) {
        assertNotNull(name);
        if (name == this.name) {
            return (TypeParameter) this;
        }
        notifyPropertyChange(ObservableProperty.NAME, this.name, name);
        if (this.name != null)
            this.name.setParentNode(null);
        this.name = name;
        setAsParentNodeOf(name);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public TypeParameter setTypeBound(final NodeList<ClassOrInterfaceType> typeBound) {
        assertNotNull(typeBound);
        if (typeBound == this.typeBound) {
            return (TypeParameter) this;
        }
        notifyPropertyChange(ObservableProperty.TYPE_BOUND, this.typeBound, typeBound);
        if (this.typeBound != null)
            this.typeBound.setParentNode(null);
        this.typeBound = typeBound;
        setAsParentNodeOf(typeBound);
        return this;
    }

    @Override
    public TypeParameter setAnnotations(NodeList<AnnotationExpr> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < typeBound.size(); i++) {
            if (typeBound.get(i) == node) {
                typeBound.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    public String asString() {
        StringBuilder str = new StringBuilder(getNameAsString());
       // getTypeBound().ifNonEmpty(l -> str.append(l.stream().map(ClassOrInterfaceType::asString).collect(joining("&", " extends ", ""))));
        NodeList<ClassOrInterfaceType> list=  getTypeBound();
        String [] array=new String[list.size()];
       
        if(list!=null && list.size()>0){
        	for (int i=0;i<list.size();i++) {
				array[i]=list.get(i).asString();
			}
        	str.append(" extends ").append(StringUtils.join(array,"&"));
        }
        return str.toString();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public TypeParameter clone() {
        return (TypeParameter) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public TypeParameterMetaModel getMetaModel() {
        return JavaParserMetaModel.typeParameterMetaModel;
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
        for (int i = 0; i < typeBound.size(); i++) {
            if (typeBound.get(i) == node) {
                typeBound.set(i, (ClassOrInterfaceType) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isTypeParameter() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public TypeParameter asTypeParameter() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifTypeParameter(Consumer<TypeParameter> action) {
        action.accept(this);
    }

    @Override
    public ResolvedTypeVariable resolve() {
        return getSymbolResolver().toResolvedType(this, ResolvedTypeVariable.class);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public TypeParameter toTypeParameter() {
        return this;
    }
    
    // for NodeWithSimpleName
    public  TypeParameter setName(String name) {
		 if(name!=null && "".equals(name)){
			 return setName(new SimpleName(name));
		 }else return null;
	}

   public String getNameAsString() {
   	return getName().getIdentifier();
	}
   
   // for NodeWithAnnotations
   public AnnotationExpr getAnnotation(int i) {
       return getAnnotations().get(i);
   }

   @SuppressWarnings("unchecked")
   public TypeParameter setAnnotation(int i, AnnotationExpr element) {
       getAnnotations().set(i, element);
       return (TypeParameter) this;
   }

   @SuppressWarnings("unchecked")
   public TypeParameter addAnnotation(AnnotationExpr element) {
       getAnnotations().add(element);
       return (TypeParameter) this;
   }

   /**
    * Annotates this
    *
    * @param name the name of the annotation
    * @return this
    */
   @SuppressWarnings("unchecked")
   public TypeParameter addAnnotation(String name) {
       NormalAnnotationExpr annotation = new NormalAnnotationExpr(
               parseName(name), new NodeList<MemberValuePair>());
       getAnnotations().add(annotation);
       return (TypeParameter) this;
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
   public TypeParameter addAnnotation(Class<? extends Annotation> clazz) {
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
   public TypeParameter addMarkerAnnotation(String name) {
       MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
               parseName(name));
       getAnnotations().add(markerAnnotationExpr);
       return (TypeParameter) this;
   }

   /**
    * Annotates this with a marker annotation and automatically add the import
    *
    * @param clazz the class of the annotation
    * @return this
    */
   public TypeParameter addMarkerAnnotation(Class<? extends Annotation> clazz) {
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
   public TypeParameter addSingleMemberAnnotation(String name, Expression expression) {
       SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
               parseName(name), expression);
       getAnnotations().add(singleMemberAnnotationExpr);
       return (TypeParameter) this;
   }

   /**
    * Annotates this with a single member annotation
    *
    * @param name the name of the annotation
    * @param value the value, don't forget to add \"\" for a string value
    * @return this
    */
   public TypeParameter addSingleMemberAnnotation(String name, String value) {
       return addSingleMemberAnnotation(name, parseExpression(value));
   }

   /**
    * Annotates this with a single member annotation and automatically add the import
    *
    * @param clazz the class of the annotation
    * @param value the value, don't forget to add \"\" for a string value
    * @return this
    */
   public TypeParameter addSingleMemberAnnotation(Class<? extends Annotation> clazz,
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
   
   public  AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
       return getOptionalAnnotationByName(annotationClass.getSimpleName());
   }
   
   public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
   	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
   	if(optional!=null) return optional;
   	else return null;
   }
}
