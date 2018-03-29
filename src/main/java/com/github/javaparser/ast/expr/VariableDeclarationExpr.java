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
package com.github.javaparser.ast.expr;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithVariables;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithFinalModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.DerivedProperty;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;
import com.github.javaparser.metamodel.VariableDeclarationExprMetaModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.javaparser.ast.NodeList.nodeList;
import static com.github.javaparser.utils.Utils.assertNotNull;
import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import static com.github.javaparser.ast.Modifier.FINAL;
import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;

/**
 * A declaration of variables.
 * It is an expression, so it can be put in places like the initializer of a for loop,
 * or the resources part of the try statement.
 * <br/><code>final int x=3, y=55</code>
 *
 * <br/>All annotations preceding the type will be set on this object, not on the type.
 * JavaParser doesn't know if it they are applicable to the method or the type.
 *
 * @author Julio Vilmar Gesser
 */
public final class VariableDeclarationExpr extends Expression implements NodeWithFinalModifier<VariableDeclarationExpr>, NodeWithAnnotations<VariableDeclarationExpr>, NodeWithVariables<VariableDeclarationExpr> {

    private EnumSet<Modifier> modifiers;

    private NodeList<AnnotationExpr> annotations;

    @NonEmptyProperty
    private NodeList<VariableDeclarator> variables;

    public VariableDeclarationExpr() {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), new NodeList<VariableDeclarator>());
    }

    public VariableDeclarationExpr(final Type type, String variableName) {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), nodeList(new VariableDeclarator(type, variableName)));
    }

    public VariableDeclarationExpr(VariableDeclarator var) {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), nodeList(var));
    }

    public VariableDeclarationExpr(final Type type, String variableName, Modifier... modifiers) {
    	
        this(null, getEnumSet(modifiers), new NodeList<AnnotationExpr>(), nodeList(new VariableDeclarator(type, variableName)));
    	
    	//this(null, Arrays.stream(modifiers).collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))), new NodeList<>(), nodeList(new VariableDeclarator(type, variableName)));
    }

    

	public VariableDeclarationExpr(VariableDeclarator var, Modifier... modifiers) {
        this(null, getEnumSet(modifiers), new NodeList<AnnotationExpr>(), nodeList(var));
    }

    public VariableDeclarationExpr(final NodeList<VariableDeclarator> variables) {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), variables);
    }

    public VariableDeclarationExpr(final EnumSet<Modifier> modifiers, final NodeList<VariableDeclarator> variables) {
        this(null, modifiers, new NodeList<AnnotationExpr>(), variables);
    }

    @AllFieldsConstructor
    public VariableDeclarationExpr(final EnumSet<Modifier> modifiers, final NodeList<AnnotationExpr> annotations, final NodeList<VariableDeclarator> variables) {
        this(null, modifiers, annotations, variables);
    }
    
    private static EnumSet<Modifier> getEnumSet(Modifier[] modifiers) {
    	EnumSet enumSet=EnumSet.noneOf(Modifier.class);
    	enumSet.add(Arrays.asList(modifiers));
		return enumSet;
	}

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public VariableDeclarationExpr(TokenRange tokenRange, EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, NodeList<VariableDeclarator> variables) {
        super(tokenRange);
        setModifiers(modifiers);
        setAnnotations(annotations);
        setVariables(variables);
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
    public NodeList<AnnotationExpr> getAnnotations() {
        return annotations;
    }

    /**
     * Return the modifiers of this variable declaration.
     *
     * @return modifiers
     * @see Modifier
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public EnumSet<Modifier> getModifiers() {
        return modifiers;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<VariableDeclarator> getVariables() {
        return variables;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public VariableDeclarationExpr setAnnotations(final NodeList<AnnotationExpr> annotations) {
        assertNotNull(annotations);
        if (annotations == this.annotations) {
            return (VariableDeclarationExpr) this;
        }
        notifyPropertyChange(ObservableProperty.ANNOTATIONS, this.annotations, annotations);
        if (this.annotations != null)
            this.annotations.setParentNode(null);
        this.annotations = annotations;
        setAsParentNodeOf(annotations);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public VariableDeclarationExpr setModifiers(final EnumSet<Modifier> modifiers) {
        assertNotNull(modifiers);
        if (modifiers == this.modifiers) {
            return (VariableDeclarationExpr) this;
        }
        notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
        this.modifiers = modifiers;
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public VariableDeclarationExpr setVariables(final NodeList<VariableDeclarator> variables) {
        assertNotNull(variables);
        if (variables == this.variables) {
            return (VariableDeclarationExpr) this;
        }
        notifyPropertyChange(ObservableProperty.VARIABLES, this.variables, variables);
        if (this.variables != null)
            this.variables.setParentNode(null);
        this.variables = variables;
        setAsParentNodeOf(variables);
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
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i) == node) {
                variables.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public VariableDeclarationExpr clone() {
        return (VariableDeclarationExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public VariableDeclarationExprMetaModel getMetaModel() {
        return JavaParserMetaModel.variableDeclarationExprMetaModel;
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
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i) == node) {
                variables.set(i, (VariableDeclarator) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isVariableDeclarationExpr() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public VariableDeclarationExpr asVariableDeclarationExpr() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifVariableDeclarationExpr(Consumer<VariableDeclarationExpr> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public VariableDeclarationExpr toVariableDeclarationExpr() {
        return this;
    }
    
    //for NodeWithFinalModifier
    public boolean isFinal() {
        return getModifiers().contains(FINAL);
    }

    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr setFinal(boolean set) {
        return setModifier(FINAL, set);
    }
    
    //for NodeWithAnnotations
    public AnnotationExpr getAnnotation(int i) {
        return getAnnotations().get(i);
    }

    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr setAnnotation(int i, AnnotationExpr element) {
        getAnnotations().set(i, element);
        return (VariableDeclarationExpr) this;
    }

    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr addAnnotation(AnnotationExpr element) {
        getAnnotations().add(element);
        return (VariableDeclarationExpr) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr addAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return (VariableDeclarationExpr) this;
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
    public VariableDeclarationExpr addAnnotation(Class<? extends Annotation> clazz) {
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
    public VariableDeclarationExpr addMarkerAnnotation(String name) {
        MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
                parseName(name));
        getAnnotations().add(markerAnnotationExpr);
        return (VariableDeclarationExpr) this;
    }

    /**
     * Annotates this with a marker annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public  VariableDeclarationExpr addMarkerAnnotation(Class<? extends Annotation> clazz) {
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
    public VariableDeclarationExpr addSingleMemberAnnotation(String name, Expression expression) {
        SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
                parseName(name), expression);
        getAnnotations().add(singleMemberAnnotationExpr);
        return (VariableDeclarationExpr) this;
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public VariableDeclarationExpr addSingleMemberAnnotation(String name, String value) {
        return addSingleMemberAnnotation(name, parseExpression(value));
    }

    /**
     * Annotates this with a single member annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public VariableDeclarationExpr addSingleMemberAnnotation(Class<? extends Annotation> clazz,
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
    
    //for NodeWithVariables
    public VariableDeclarator getVariable(int i) {
        return getVariables().get(i);
    }

    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr setVariable(int i, VariableDeclarator variableDeclarator) {
        getVariables().set(i, variableDeclarator);
        return (VariableDeclarationExpr) this;
    }

    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr addVariable(VariableDeclarator variableDeclarator) {
        getVariables().add(variableDeclarator);
        return (VariableDeclarationExpr) this;
    }

    /**
     * Returns the type that is shared between all variables.
     * This is a shortcut for when you are certain that all variables share one type.
     * What makes this difficult is arrays, and being able to set the type.
     * <br/>For <code>int a;</code> this is int.
     * <br/>For <code>int a,b,c,d;</code> this is also int.
     * <br/>For <code>int a,b[],c;</code> this is an assertion error since b is an int[], not an int.
     * <br/>For <code>int a,b;</code>, then doing setType(String) on b, this is an assertion error. It is also a situation that you don't really want.
     */
    public Type getCommonType() {
        NodeList<VariableDeclarator> variables = getVariables();
        if (variables.isEmpty()) {
            throw new AssertionError("There is no common type since there are no variables.");
        }
        Type type = variables.get(0).getType();
        for (int i = 1; i < variables.size(); i++) {
            if (!variables.get(i).getType().equals(type)) {
                throw new AssertionError("The variables do not have a common type.");
            }
        }
        return type;
    }

    /**
     * Returns the element type.
     * <br/>For <code>int a;</code> this is int.
     * <br/>For <code>int a,b,c,d;</code> this is also int.
     * <br/>For <code>int a,b[],c;</code> this is also int. Note: no mention of b being an array.
     * <br/>For <code>int a,b;</code>, then doing setType(String) on b, then calling getElementType(). This is an assertion error. It is also a situation that you don't really want.
     */
    public Type getElementType() {
        NodeList<VariableDeclarator> variables = getVariables();
        if (variables.isEmpty()) {
            throw new AssertionError("There is no element type since there are no variables.");
        }
        Type type = variables.get(0).getType().getElementType();
        for (int i = 1; i < variables.size(); i++) {
            if (!variables.get(i).getType().getElementType().equals(type)) {
                throw new AssertionError("The variables do not have a common type.");
            }
        }
        return type;
    }

    /**
     * Returns the type that maximum shared type between all variables.
     * The minimum common type does never include annotations on the array level.
     * <p>
     * <br/>For <code>int a;</code> this is int.
     * <br/>For <code>int a,b,c,d;</code> this is also int.
     * <br/>For <code>int a,b[],c;</code> this is also int.
     * <br/>For <code>int[] a[][],b[],c[][];</code> this is int[][].
     */
    @DerivedProperty
    public Type getMaximumCommonType() {
       // return calculateMaximumCommonType(getVariables().stream().map(v -> v.getType()).collect(Collectors.toList()));
    	List<Type> list=new ArrayList<>();
    	for (VariableDeclarator v : getVariables()) {
			list.add(v.getType());
		}
    	return calculateMaximumCommonType(list);
    	
    }

    public static Type calculateMaximumCommonType(List<Type> types) {
        // we use a local class because we cannot use an helper static method in an interface
        class Helper {
          
            private Type toArrayLevel(Type type, int level) {
                if (level > type.getArrayLevel()) {
                    return null;
                }
                for (int i = type.getArrayLevel(); i > level; i--) {
                    if (!(type instanceof ArrayType)) {
                        return null;
                    }
                    type = ((ArrayType) type).getComponentType();
                }
                return type;
            }
        }

        Helper helper = new Helper();
        int level = 0;
        boolean keepGoing = true;
      
        while (keepGoing) {
            final int currentLevel = level;
            
            /*Object[] values = types.stream().map(v -> {
                Optional<Type> t = helper.toArrayLevel(v, currentLevel);
                return t.map(Node::toString).orElse(null);
            }).distinct().toArray();*/
            Set<String> set=new HashSet();
            for (Type type : types) {
            	Type t = helper.toArrayLevel(type, currentLevel);
                if(t!=null) set.add(t.asString());
			}
            Object[] values=new Object[set.size()];
            set.toArray(values);
            
            
            if (values.length == 1 && values[0] != null) {
                level++;
            } else {
                keepGoing = false;
            }
        }
        return helper.toArrayLevel(types.get(0), --level);
    }
    //for NodeWithModifiers
    
    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr addModifier(Modifier... modifiers) {
        EnumSet<Modifier> newModifiers = getModifiers().clone();
        /*newModifiers.addAll(Arrays.stream(modifiers)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
        enm.addAll(list);
        newModifiers.addAll(enm);
        setModifiers(newModifiers);
        return (VariableDeclarationExpr) this;
    }

    @SuppressWarnings("unchecked")
    public VariableDeclarationExpr removeModifier(Modifier... m) {
        EnumSet<Modifier> newModifiers = getModifiers().clone();
       /* newModifiers.removeAll(Arrays.stream(m)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        List<Modifier> list=new ArrayList<>(Arrays.asList(m));
        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
        enm.addAll(list);
        newModifiers.removeAll(enm);
        
        setModifiers(newModifiers);
        return (VariableDeclarationExpr) this;
    }
    public VariableDeclarationExpr setModifier(Modifier m, boolean set) {
        if (set) {
            return addModifier(m);
        } else {
            return removeModifier(m);
        }
    }
}
