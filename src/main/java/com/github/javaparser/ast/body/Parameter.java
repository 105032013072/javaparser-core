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
package com.github.javaparser.ast.body;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Modifier;
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
import com.github.javaparser.ast.nodeTypes.NodeWithType;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithFinalModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.ParameterMetaModel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import static com.github.javaparser.utils.Utils.assertNotNull;
import javax.annotation.Generated;
import com.github.javaparser.TokenRange;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedConstructorDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedParameterDeclaration;
import com.github.javaparser.utils.Utils;
import static com.github.javaparser.JavaParser.parseType;
import static com.github.javaparser.JavaParser.parseName;
import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.ast.Modifier.FINAL;

/**
 * The parameters to a method or lambda. Lambda parameters may have inferred types, in that case "type" is UnknownType.
 * <br/>Note that <a href="https://en.wikipedia.org/wiki/Parameter_(computer_programming)#Parameters_and_arguments">parameters
 * are different from arguments.</a> <br/>"String x" and "float y" are the parameters in <code>int abc(String x, float
 * y) {...}</code>
 *
 * <br/>All annotations preceding the type will be set on this object, not on the type.
 * JavaParser doesn't know if it they are applicable to the parameter or the type.
 *
 * @author Julio Vilmar Gesser
 */
public final class Parameter extends Node implements NodeWithType<Parameter, Type>, NodeWithAnnotations<Parameter>, NodeWithSimpleName<Parameter>, NodeWithFinalModifier<Parameter>, Resolvable<ResolvedParameterDeclaration> {

    private Type type;

    private boolean isVarArgs;

    private NodeList<AnnotationExpr> varArgsAnnotations;

    private EnumSet<Modifier> modifiers;

    private NodeList<AnnotationExpr> annotations;

    private SimpleName name;

    public Parameter() {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), new ClassOrInterfaceType(), false, new NodeList<AnnotationExpr>(), new SimpleName());
    }

    public Parameter(Type type, SimpleName name) {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), type, false, new NodeList<AnnotationExpr>(), name);
    }

    /**
     * Creates a new {@link Parameter}.
     *
     * @param type type of the parameter
     * @param name name of the parameter
     */
    public Parameter(Type type, String name) {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), type, false, new NodeList<AnnotationExpr>(), new SimpleName(name));
    }

    public Parameter(EnumSet<Modifier> modifiers, Type type, SimpleName name) {
        this(null, modifiers, new NodeList<AnnotationExpr>(), type, false, new NodeList<AnnotationExpr>(), name);
    }

    @AllFieldsConstructor
    public Parameter(EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, Type type, boolean isVarArgs, NodeList<AnnotationExpr> varArgsAnnotations, SimpleName name) {
        this(null, modifiers, annotations, type, isVarArgs, varArgsAnnotations, name);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public Parameter(TokenRange tokenRange, EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, Type type, boolean isVarArgs, NodeList<AnnotationExpr> varArgsAnnotations, SimpleName name) {
        super(tokenRange);
        setModifiers(modifiers);
        setAnnotations(annotations);
        setType(type);
        setVarArgs(isVarArgs);
        setVarArgsAnnotations(varArgsAnnotations);
        setName(name);
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
    public Type getType() {
        return type;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public boolean isVarArgs() {
        return isVarArgs;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Parameter setType(final Type type) {
        assertNotNull(type);
        if (type == this.type) {
            return (Parameter) this;
        }
        notifyPropertyChange(ObservableProperty.TYPE, this.type, type);
        if (this.type != null)
            this.type.setParentNode(null);
        this.type = type;
        setAsParentNodeOf(type);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Parameter setVarArgs(final boolean isVarArgs) {
        if (isVarArgs == this.isVarArgs) {
            return (Parameter) this;
        }
        notifyPropertyChange(ObservableProperty.VAR_ARGS, this.isVarArgs, isVarArgs);
        this.isVarArgs = isVarArgs;
        return this;
    }

    /**
     * @return the list returned could be immutable (in that case it will be empty)
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<AnnotationExpr> getAnnotations() {
        return annotations;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public SimpleName getName() {
        return name;
    }

    /**
     * Return the modifiers of this parameter declaration.
     *
     * @return modifiers
     * @see Modifier
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public EnumSet<Modifier> getModifiers() {
        return modifiers;
    }

    /**
     * @param annotations a null value is currently treated as an empty list. This behavior could change in the future,
     * so please avoid passing null
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Parameter setAnnotations(final NodeList<AnnotationExpr> annotations) {
        assertNotNull(annotations);
        if (annotations == this.annotations) {
            return (Parameter) this;
        }
        notifyPropertyChange(ObservableProperty.ANNOTATIONS, this.annotations, annotations);
        if (this.annotations != null)
            this.annotations.setParentNode(null);
        this.annotations = annotations;
        setAsParentNodeOf(annotations);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Parameter setName(final SimpleName name) {
        assertNotNull(name);
        if (name == this.name) {
            return (Parameter) this;
        }
        notifyPropertyChange(ObservableProperty.NAME, this.name, name);
        if (this.name != null)
            this.name.setParentNode(null);
        this.name = name;
        setAsParentNodeOf(name);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Parameter setModifiers(final EnumSet<Modifier> modifiers) {
        assertNotNull(modifiers);
        if (modifiers == this.modifiers) {
            return (Parameter) this;
        }
        notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
        this.modifiers = modifiers;
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < annotations.size(); i++) {
            if (annotations.get(i) == node) {
                annotations.remove(i);
                return true;
            }
        }
        for (int i = 0; i < varArgsAnnotations.size(); i++) {
            if (varArgsAnnotations.get(i) == node) {
                varArgsAnnotations.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<AnnotationExpr> getVarArgsAnnotations() {
        return varArgsAnnotations;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Parameter setVarArgsAnnotations(final NodeList<AnnotationExpr> varArgsAnnotations) {
        assertNotNull(varArgsAnnotations);
        if (varArgsAnnotations == this.varArgsAnnotations) {
            return (Parameter) this;
        }
        notifyPropertyChange(ObservableProperty.VAR_ARGS_ANNOTATIONS, this.varArgsAnnotations, varArgsAnnotations);
        if (this.varArgsAnnotations != null)
            this.varArgsAnnotations.setParentNode(null);
        this.varArgsAnnotations = varArgsAnnotations;
        setAsParentNodeOf(varArgsAnnotations);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public Parameter clone() {
        return (Parameter) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public ParameterMetaModel getMetaModel() {
        return JavaParserMetaModel.parameterMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        for (int i = 0; i < annotations.size(); i++) {
            if (annotations.get(i) == node) {
                annotations.set(i, (AnnotationExpr) replacementNode);
                return true;
            }
        }
        if (node == name) {
            setName((SimpleName) replacementNode);
            return true;
        }
        if (node == type) {
            setType((Type) replacementNode);
            return true;
        }
        for (int i = 0; i < varArgsAnnotations.size(); i++) {
            if (varArgsAnnotations.get(i) == node) {
                varArgsAnnotations.set(i, (AnnotationExpr) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    public ResolvedParameterDeclaration resolve() {
        return getSymbolResolver().resolveDeclaration(this, ResolvedParameterDeclaration.class);
    }
    
    
    //for NodeWithType
    @SuppressWarnings("unchecked")
	public Parameter setType(Class<?> typeClass) {
        tryAddImportToParentCompilationUnit(typeClass);
        return setType((Type) parseType(typeClass.getSimpleName()));
    }

    @SuppressWarnings("unchecked")
	public Parameter setType(final String typeString) {
        Utils.assertNonEmpty(typeString);
        return setType((Type) parseType(typeString));
    }
    
    //for NodeWithAnnotations
    @Override
    public AnnotationExpr getAnnotation(int i) {
    	 return getAnnotations().get(i);
    }
    
   
    @SuppressWarnings("unchecked")
	public Parameter setAnnotation(int i, AnnotationExpr element) {
        getAnnotations().set(i, element);
        return (Parameter) this;
    }

    @SuppressWarnings("unchecked")
	public Parameter addAnnotation(AnnotationExpr element) {
        getAnnotations().add(element);
        return (Parameter) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
	public Parameter addAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return (Parameter) this;
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
    public Parameter addAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    public  NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
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
    public Parameter addMarkerAnnotation(String name) {
        MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
                parseName(name));
        getAnnotations().add(markerAnnotationExpr);
        return (Parameter) this;
    }

    /**
     * Annotates this with a marker annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public Parameter addMarkerAnnotation(Class<? extends Annotation> clazz) {
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
    public Parameter addSingleMemberAnnotation(String name, Expression expression) {
        SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
                parseName(name), expression);
        getAnnotations().add(singleMemberAnnotationExpr);
        return (Parameter) this;
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public Parameter addSingleMemberAnnotation(String name, String value) {
        return addSingleMemberAnnotation(name, parseExpression(value));
    }

    /**
     * Annotates this with a single member annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public Parameter addSingleMemberAnnotation(Class<? extends Annotation> clazz,
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
    public  boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return isAnnotationPresent(annotationClass.getSimpleName());
    }

    /**
     * Try to find an annotation by its name
     *
     * @param annotationName the name of the annotation
     */
    public  AnnotationExpr getOptionalAnnotationByName(String annotationName) {
       // return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
    	for (AnnotationExpr a : getAnnotations()) {
		   if(a.getName().getIdentifier().equals(annotationName))	return a;
		}
    	return null;
    }
    
    public  AnnotationExpr getAnnotationByName(String annotationName){
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
    
    public  AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
    	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
    	if(optional!=null) return optional;
    	else return null;
    }
    //for NodeWithSimpleName
    public  Parameter setName(String name) {
		 if(name!=null && "".equals(name)){
			 return setName(new SimpleName(name));
		 }else return null;
	}

   public String getNameAsString() {
   	return getName().getIdentifier();
	}
   
   //for NodeWithFinalModifier
   public  boolean isFinal() {
       return getModifiers().contains(FINAL);
   }

   @SuppressWarnings("unchecked")
public Parameter setFinal(boolean set) {
       return setModifier(FINAL, set);
   }
   
   //for  NodeWithModifiers
	
   @SuppressWarnings("unchecked")
public Parameter addModifier(Modifier... modifiers) {
       EnumSet<Modifier> newModifiers = getModifiers().clone();
       
       List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
       EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
       enm.addAll(list);
       newModifiers.addAll(enm);
       setModifiers(newModifiers);
       return (Parameter) this;
   }

   @SuppressWarnings("unchecked")
public Parameter removeModifier(Modifier... m) {
       EnumSet<Modifier> newModifiers = getModifiers().clone();

       List<Modifier> list=new ArrayList<>(Arrays.asList(m));
       EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
       enm.addAll(list);
       newModifiers.removeAll(enm);
       
       setModifiers(newModifiers);
       return (Parameter) this;
   }
   public  Parameter setModifier(Modifier m, boolean set) {
       if (set) {
           return addModifier(m);
       } else {
           return removeModifier(m);
       }
   }




}
