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
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.AssignExpr.Operator;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithJavadoc;
import com.github.javaparser.ast.nodeTypes.NodeWithVariables;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithAccessModifiers;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithFinalModifier;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithStaticModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.VoidType;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.javadoc.Javadoc;
import com.github.javaparser.metamodel.DerivedProperty;
import com.github.javaparser.metamodel.FieldDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import static com.github.javaparser.ast.Modifier.*;
import static com.github.javaparser.ast.NodeList.nodeList;
import static com.github.javaparser.utils.Utils.assertNotNull;
import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedConstructorDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedFieldDeclaration;

/**
 * The declaration of a field in a class. "private static int a=15*15;" in this example: <code>class X { private static
 * int a=15*15; }</code>
 *
 * <br/>All annotations preceding the type will be set on this object, not on the type.
 * JavaParser doesn't know if it they are applicable to the method or the type.
 *
 * @author Julio Vilmar Gesser
 */
public final class FieldDeclaration extends BodyDeclaration<FieldDeclaration> implements NodeWithJavadoc<FieldDeclaration>, NodeWithVariables<FieldDeclaration>, NodeWithAccessModifiers<FieldDeclaration>, NodeWithStaticModifier<FieldDeclaration>, NodeWithFinalModifier<FieldDeclaration>, Resolvable<ResolvedFieldDeclaration> {

    private EnumSet<Modifier> modifiers;

    @NonEmptyProperty
    private NodeList<VariableDeclarator> variables;

    public FieldDeclaration() {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), new NodeList<VariableDeclarator>());
    }

    public FieldDeclaration(EnumSet<Modifier> modifiers, VariableDeclarator variable) {
        this(null, modifiers, new NodeList<AnnotationExpr>(), nodeList(variable));
    }

    public FieldDeclaration(EnumSet<Modifier> modifiers, NodeList<VariableDeclarator> variables) {
        this(null, modifiers, new NodeList<AnnotationExpr>(), variables);
    }

    @AllFieldsConstructor
    public FieldDeclaration(EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, NodeList<VariableDeclarator> variables) {
        this(null, modifiers, annotations, variables);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public FieldDeclaration(TokenRange tokenRange, EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, NodeList<VariableDeclarator> variables) {
        super(tokenRange, annotations);
        setModifiers(modifiers);
        setVariables(variables);
        customInitialization();
    }

    /**
     * Creates a {@link FieldDeclaration}.
     *
     * @param modifiers modifiers
     * @param type type
     * @param name field name
     */
    public FieldDeclaration(EnumSet<Modifier> modifiers, Type type, String name) {
        this(assertNotNull(modifiers), new VariableDeclarator(type, assertNotNull(name)));
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
     * Return the modifiers of this member declaration.
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
    public FieldDeclaration setModifiers(final EnumSet<Modifier> modifiers) {
        assertNotNull(modifiers);
        if (modifiers == this.modifiers) {
            return (FieldDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
        this.modifiers = modifiers;
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public FieldDeclaration setVariables(final NodeList<VariableDeclarator> variables) {
        assertNotNull(variables);
        if (variables == this.variables) {
            return (FieldDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.VARIABLES, this.variables, variables);
        if (this.variables != null)
            this.variables.setParentNode(null);
        this.variables = variables;
        setAsParentNodeOf(variables);
        return this;
    }

    /**
     * Create a getter for this field, <b>will only work if this field declares only 1 identifier and if this field is
     * already added to a ClassOrInterfaceDeclaration</b>
     *
     * @return the {@link MethodDeclaration} created
     * @throws IllegalStateException if there is more than 1 variable identifier or if this field isn't attached to a
     * class or enum
     */
    public MethodDeclaration createGetter() {
        if (getVariables().size() != 1)
            throw new IllegalStateException("You can use this only when the field declares only 1 variable name");
        ClassOrInterfaceDeclaration parentClass = getAncestorOfType(ClassOrInterfaceDeclaration.class);
        EnumDeclaration parentEnum = getAncestorOfType(EnumDeclaration.class);
        if (!(parentClass!=null || parentEnum!=null) || (parentClass!=null && parentClass.isInterface()))
            throw new IllegalStateException("You can use this only when the field is attached to a class or an enum");
        VariableDeclarator variable = getVariable(0);
        String fieldName = variable.getNameAsString();
        String fieldNameUpper = fieldName.toUpperCase().substring(0, 1) + fieldName.substring(1, fieldName.length());
        final MethodDeclaration getter;
        //getter = parentClass.map(clazz -> clazz.addMethod("get" + fieldNameUpper, PUBLIC)).orElseGet(() -> parentEnum.get().addMethod("get" + fieldNameUpper, PUBLIC));
        if(parentClass!=null){
        	getter=parentClass.addMethod("get" + fieldNameUpper, PUBLIC);
        }else{
        	getter=parentEnum.addMethod("get" + fieldNameUpper, PUBLIC);
        }
        getter.setType(variable.getType());
        BlockStmt blockStmt = new BlockStmt();
        getter.setBody(blockStmt);
        blockStmt.addStatement(new ReturnStmt(fieldName));
        return getter;
    }

    /**
     * Create a setter for this field, <b>will only work if this field declares only 1 identifier and if this field is
     * already added to a ClassOrInterfaceDeclaration</b>
     *
     * @return the {@link MethodDeclaration} created
     * @throws IllegalStateException if there is more than 1 variable identifier or if this field isn't attached to a
     * class or enum
     */
    public MethodDeclaration createSetter() {
        if (getVariables().size() != 1)
            throw new IllegalStateException("You can use this only when the field declares only 1 variable name");
        ClassOrInterfaceDeclaration parentClass = getAncestorOfType(ClassOrInterfaceDeclaration.class);
        EnumDeclaration parentEnum = getAncestorOfType(EnumDeclaration.class);
        if (!(parentClass!=null || parentEnum!=null) || (parentClass!=null && parentClass.isInterface()))
            throw new IllegalStateException("You can use this only when the field is attached to a class or an enum");
        VariableDeclarator variable = getVariable(0);
        String fieldName = variable.getNameAsString();
        String fieldNameUpper = fieldName.toUpperCase().substring(0, 1) + fieldName.substring(1, fieldName.length());
        final MethodDeclaration setter;
       // setter = parentClass.map(clazz -> clazz.addMethod("set" + fieldNameUpper, PUBLIC)).orElseGet(() -> parentEnum.get().addMethod("set" + fieldNameUpper, PUBLIC));
       if(parentClass!=null){
    	   setter=parentClass.addMethod("set" + fieldNameUpper, PUBLIC);
       }else{
    	   setter= parentEnum.addMethod("set" + fieldNameUpper, PUBLIC);
       }
        
        setter.setType(new VoidType());
        setter.getParameters().add(new Parameter(variable.getType(), fieldName));
        BlockStmt blockStmt2 = new BlockStmt();
        setter.setBody(blockStmt2);
        blockStmt2.addStatement(new AssignExpr(new NameExpr("this." + fieldName), new NameExpr(fieldName), Operator.ASSIGN));
        return setter;
    }

    public boolean isTransient() {
        return getModifiers().contains(TRANSIENT);
    }

    public boolean isVolatile() {
        return getModifiers().contains(VOLATILE);
    }

    public FieldDeclaration setTransient(boolean set) {
        return setModifier(TRANSIENT, set);
    }

    public FieldDeclaration setVolatile(boolean set) {
        return setModifier(VOLATILE, set);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
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
    public FieldDeclaration clone() {
        return (FieldDeclaration) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public FieldDeclarationMetaModel getMetaModel() {
        return JavaParserMetaModel.fieldDeclarationMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
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
    public boolean isFieldDeclaration() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public FieldDeclaration asFieldDeclaration() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifFieldDeclaration(Consumer<FieldDeclaration> action) {
        action.accept(this);
    }

    @Override
    public ResolvedFieldDeclaration resolve() {
        return getSymbolResolver().resolveDeclaration(this, ResolvedFieldDeclaration.class);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public FieldDeclaration toFieldDeclaration() {
        return this;
    }
    
    
    //for NodeWithJavadoc
  public  JavadocComment getJavadocComment() {
    	Comment comment= getCommentOptional();
    	if(comment instanceof JavadocComment){
    		return (JavadocComment) comment;
    	}else return null;
    }

    /**
     * Gets the Javadoc for this node. You can set the Javadoc by calling setJavadocComment passing a Javadoc.
     *
     * @return The Javadoc for this node wrapped in an optional as it may be absent.
     */
    public   Javadoc getOptionalJavadoc() {
    	JavadocComment javadocComment=getJavadocComment();
    	if(javadocComment!=null){
    		return javadocComment.parse();
    	}else return null;
    	
    	//return getJavadocComment().map(JavadocComment::parse);
    }
    
    public  Javadoc getJavadoc() {
    	Javadoc oj=getOptionalJavadoc();
    	if(oj!=null) return oj;
    	else return null;
    }

    /**
     * Use this to store additional information to this node.
     *
     * @param comment to be set
     */
    @SuppressWarnings("unchecked")
    public  FieldDeclaration setJavadocComment(String comment) {
        return setJavadocComment(new JavadocComment(comment));
    }

    public  FieldDeclaration setJavadocComment(JavadocComment comment) {
        setComment(comment);
        return (FieldDeclaration) this;
    }

    public  FieldDeclaration setJavadocComment(String indentation, Javadoc javadoc) {
        JavadocComment comment = javadoc.toComment(indentation);
        return setJavadocComment(comment);
    }

    public  boolean removeJavaDocComment() {
        return hasJavaDocComment() && getCommentOptional().remove();
    }

    public  boolean hasJavaDocComment() {
        return getCommentOptional()!=null && getCommentOptional() instanceof JavadocComment;
    }
    
    //for NodeWithVariables
   
    public  VariableDeclarator getVariable(int i) {
        return getVariables().get(i);
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration setVariable(int i, VariableDeclarator variableDeclarator) {
        getVariables().set(i, variableDeclarator);
        return (FieldDeclaration) this;
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration addVariable(VariableDeclarator variableDeclarator) {
        getVariables().add(variableDeclarator);
        return (FieldDeclaration) this;
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

    static Type calculateMaximumCommonType(List<Type> types) {
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
    
    //for NodeWithStaticModifier
    
    public  boolean isStatic() {
        return getModifiers().contains(STATIC);
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration setStatic(boolean set) {
        return setModifier(STATIC, set);
    }

    //for NodeWithFinalModifier
    public boolean isFinal() {
        return getModifiers().contains(FINAL);
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration setFinal(boolean set) {
        return setModifier(FINAL, set);
    }

    //for NodeWithPublicModifier
    public  boolean isPublic() {
        return getModifiers().contains(PUBLIC);
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration setPublic(boolean set) {
        return setModifier(PUBLIC, set);
    }
    
    //for NodeWithPrivateModifier
    public  boolean isPrivate() {
        return getModifiers().contains(PRIVATE);
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration setPrivate(boolean set) {
        return setModifier(PRIVATE, set);
    }
    //for NodeWithProtectedModifier
    public  boolean isProtected() {
        return getModifiers().contains(PROTECTED);
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration setProtected(boolean set) {
        return setModifier(PROTECTED, set);
    }
    
    //for NodeWithModifiers
    @SuppressWarnings("unchecked")
	public FieldDeclaration addModifier(Modifier... modifiers) {
        EnumSet<Modifier> newModifiers = getModifiers().clone();
       
        List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
        enm.addAll(list);
        newModifiers.addAll(enm);
        setModifiers(newModifiers);
        return (FieldDeclaration) this;
    }

    @SuppressWarnings("unchecked")
	public FieldDeclaration removeModifier(Modifier... m) {
        EnumSet<Modifier> newModifiers = getModifiers().clone();
      
        List<Modifier> list=new ArrayList<>(Arrays.asList(m));
        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
        enm.addAll(list);
        newModifiers.removeAll(enm);
        
        setModifiers(newModifiers);
        return (FieldDeclaration) this;
    }
    public  FieldDeclaration setModifier(Modifier m, boolean set) {
        if (set) {
            return addModifier(m);
        } else {
            return removeModifier(m);
        }
    }

    
}
