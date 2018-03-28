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

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithJavadoc;
import com.github.javaparser.ast.nodeTypes.NodeWithMembers;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithAccessModifiers;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithStaticModifier;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithStrictfpModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.VoidType;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.javadoc.Javadoc;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.TypeDeclarationMetaModel;
import com.github.javaparser.utils.Utils;

import javax.annotation.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import static java.util.Collections.unmodifiableList;
import static com.github.javaparser.JavaParser.parseType;
import static com.github.javaparser.ast.Modifier.STATIC;
import static com.github.javaparser.ast.Modifier.STRICTFP;
import static com.github.javaparser.ast.Modifier.*;


/**
 * A base class for all types of type declarations.
 *
 * @author Julio Vilmar Gesser
 */
public abstract class TypeDeclaration<T extends TypeDeclaration<?>> extends BodyDeclaration<T> implements NodeWithSimpleName<T>, NodeWithJavadoc<T>, NodeWithMembers<T>, NodeWithAccessModifiers<T>, NodeWithStaticModifier<T>, NodeWithStrictfpModifier<T> {

    private SimpleName name;

    private EnumSet<Modifier> modifiers;

    private NodeList<BodyDeclaration<?>> members;

    public TypeDeclaration() {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), new SimpleName(), new NodeList<BodyDeclaration<?>>());
    }

    public TypeDeclaration(EnumSet<Modifier> modifiers, String name) {
        this(null, modifiers, new NodeList<AnnotationExpr>(), new SimpleName(name), new NodeList<BodyDeclaration<?>>());
    }

    @AllFieldsConstructor
    public TypeDeclaration(EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, SimpleName name, NodeList<BodyDeclaration<?>> members) {
        this(null, modifiers, annotations, name, members);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public TypeDeclaration(TokenRange tokenRange, EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, SimpleName name, NodeList<BodyDeclaration<?>> members) {
        super(tokenRange, annotations);
        setModifiers(modifiers);
        setName(name);
        setMembers(members);
        customInitialization();
    }

    /**
     * Adds the given declaration to the specified type.
     *
     * @param decl member declaration
     */
    public T addMember(BodyDeclaration<?> decl) {
        NodeList<BodyDeclaration<?>> members = getMembers();
        members.add(decl);
        return (T) this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<BodyDeclaration<?>> getMembers() {
        return members;
    }

    /**
     * Return the modifiers of this type declaration.
     *
     * @return modifiers
     * @see Modifier
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public EnumSet<Modifier> getModifiers() {
        return modifiers;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    @SuppressWarnings("unchecked")
    public T setMembers(final NodeList<BodyDeclaration<?>> members) {
        assertNotNull(members);
        if (members == this.members) {
            return (T) this;
        }
        notifyPropertyChange(ObservableProperty.MEMBERS, this.members, members);
        if (this.members != null)
            this.members.setParentNode(null);
        this.members = members;
        setAsParentNodeOf(members);
        return (T) this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    @SuppressWarnings("unchecked")
    public T setModifiers(final EnumSet<Modifier> modifiers) {
        assertNotNull(modifiers);
        if (modifiers == this.modifiers) {
            return (T) this;
        }
        notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
        this.modifiers = modifiers;
        return (T) this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    @SuppressWarnings("unchecked")
    public T setName(final SimpleName name) {
        assertNotNull(name);
        if (name == this.name) {
            return (T) this;
        }
        notifyPropertyChange(ObservableProperty.NAME, this.name, name);
        if (this.name != null)
            this.name.setParentNode(null);
        this.name = name;
        setAsParentNodeOf(name);
        return (T) this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public SimpleName getName() {
        return name;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i) == node) {
                members.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    /**
     * @return is this type's parent a CompilationUnit?
     */
    public boolean isTopLevelType() {
        //return getOptionalParentNode().map(p -> p instanceof CompilationUnit).orElse(false);
    	Node node=getOptionalParentNode();
    	if(node!=null){
    		return node instanceof CompilationUnit;
    	}
    	return false;
    }

    /**
     * @return methods or constructors whose signatures match the passed signature.
     */
    public List<CallableDeclaration<?>> getCallablesWithSignature(CallableDeclaration.Signature signature) {
        /*return getMembers().stream()
        		.filter(m -> m instanceof CallableDeclaration)
        		.map(m -> ((CallableDeclaration<?>) m))
        		.filter(m -> m.getSignature().equals(signature))
        		.collect(toList());*/
    	
    	List<CallableDeclaration<?>> list=new ArrayList<>();
    	for (BodyDeclaration<?> m : getMembers()) {
			if(m instanceof CallableDeclaration){
				CallableDeclaration<?> c=(CallableDeclaration<?>) m;
				if(c.getSignature().equals(signature)){
					list.add(c);
				}
			}
		}
    	return list;
    }

    /**
     * @return is this type's parent a TypeDeclaration?
     * NOTE: many people are confused over terminology. Refer to https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html .
     */
    public boolean isNestedType() {
        //return getOptionalParentNode().map(p -> p instanceof TypeDeclaration).orElse(false);
    	Node node=getOptionalParentNode();
    	if(node!=null){
    		return (node instanceof TypeDeclaration);
    	}
    	return false;
    	
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public TypeDeclaration<?> clone() {
        return (TypeDeclaration<?>) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public TypeDeclarationMetaModel getMetaModel() {
        return JavaParserMetaModel.typeDeclarationMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i) == node) {
                members.set(i, (BodyDeclaration) replacementNode);
                return true;
            }
        }
        if (node == name) {
            setName((SimpleName) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isTypeDeclaration() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public TypeDeclaration asTypeDeclaration() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifTypeDeclaration(Consumer<TypeDeclaration> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public TypeDeclaration toTypeDeclaration() {
        return this;
    }
    
    public  T setName(String name) {
    	Utils.assertNonEmpty(name);
        return setName(new SimpleName(name));
	}

    public String getNameAsString() {
    	return getName().getIdentifier();
	}
    
    //for NodeWithJavadoc
    public  JavadocComment getJavadocComment() {
    	Comment comment= getCommentOptional();
    	if(comment instanceof JavadocComment){
    		return (JavadocComment) comment;
    	}else return null;
	}

   
    public  Javadoc getOptionalJavadoc() {
    	JavadocComment javadocComment=getJavadocComment();
    	if(javadocComment!=null){
    		return javadocComment.parse();
    	}else return null;
	}
    
    public  Javadoc getJavadoc() {
    	Javadoc oj=getOptionalJavadoc();
    	if(oj!=null) return oj;
    	else return null;
	}

   
    @SuppressWarnings("unchecked")
    public  T setJavadocComment(String comment) {
    	return setJavadocComment(new JavadocComment(comment));
	}

    public  T setJavadocComment(JavadocComment comment) {
    	 setComment(comment);
         return (T) this;
	}

    public  T setJavadocComment(String indentation, Javadoc javadoc) {
    	 JavadocComment comment = javadoc.toComment(indentation);
         return setJavadocComment(comment);
	}
    
    public  boolean removeJavaDocComment() {
        return hasJavaDocComment() && getCommentOptional().remove();
    }

    public  boolean hasJavaDocComment() {
        return getCommentOptional()!=null && getCommentOptional() instanceof JavadocComment;
    }
    
    //for NodeWithMembers
    
    public BodyDeclaration<?> getMember(int i) {
        return getMembers().get(i);
    }

    @SuppressWarnings("unchecked")
    public T setMember(int i, BodyDeclaration<?> member) {
        getMembers().set(i, member);
        return (T) this;
    }

    /**
     * Add a field to this and automatically add the import of the type if needed
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public  FieldDeclaration addField(Class<?> typeClass, String name, Modifier... modifiers) {
        tryAddImportToParentCompilationUnit(typeClass);
        return addField(typeClass.getSimpleName(), name, modifiers);
    }

    /**
     * Add a field to this.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public  FieldDeclaration addField(String type, String name, Modifier... modifiers) {
        return addField(parseType(type), name, modifiers);
    }

   
    public FieldDeclaration addField(Type type, String name, Modifier... modifiers) {
        FieldDeclaration fieldDeclaration = new FieldDeclaration();
        VariableDeclarator variable = new VariableDeclarator(type, name);
        fieldDeclaration.getVariables().add(variable);
       /* fieldDeclaration.setModifiers(Arrays.stream(modifiers)
                .collect(toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        
        EnumSet<Modifier> enumSet=EnumSet.noneOf(Modifier.class);
        List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
        enumSet.addAll(list);
        fieldDeclaration.setModifiers(enumSet);
        getMembers().add(fieldDeclaration);
        return fieldDeclaration;
    }

    /**
     * Add a field to this.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @param initializer the initializer of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public FieldDeclaration addFieldWithInitializer(Type type, String name, Expression initializer, Modifier... modifiers) {
        FieldDeclaration declaration = addField(type, name, modifiers);
        declaration.getVariables().iterator().next().setInitializer(initializer);
        return declaration;
    }

    /**
     * Add a private field to this.
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public  FieldDeclaration addPrivateField(Class<?> typeClass, String name) {
        return addField(typeClass, name, Modifier.PRIVATE);
    }

    /**
     * Add a private field to this and automatically add the import of the type if
     * needed.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public FieldDeclaration addPrivateField(String type, String name) {
        return addField(type, name, Modifier.PRIVATE);
    }

    /**
     * Add a public field to this.
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public FieldDeclaration addPublicField(Class<?> typeClass, String name) {
        return addField(typeClass, name, Modifier.PUBLIC);
    }

    /**
     * Add a public field to this and automatically add the import of the type if
     * needed.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public FieldDeclaration addPublicField(String type, String name) {
        return addField(type, name, Modifier.PUBLIC);
    }

    /**
     * Add a protected field to this.
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public FieldDeclaration addProtectedField(Class<?> typeClass, String name) {
        return addField(typeClass, name, Modifier.PROTECTED);
    }

    /**
     * Add a protected field to this and automatically add the import of the type
     * if needed.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public FieldDeclaration addProtectedField(String type, String name) {
        return addField(type, name, Modifier.PROTECTED);
    }

    /**
     * Adds a methods with void return by default to this.
     *
     * @param methodName the method name
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link MethodDeclaration} created
     */
    public MethodDeclaration addMethod(String methodName, Modifier... modifiers) {
        MethodDeclaration methodDeclaration = new MethodDeclaration();
        methodDeclaration.setName(methodName);
        methodDeclaration.setType(new VoidType());
        /*methodDeclaration.setModifiers(Arrays.stream(modifiers)
                .collect(toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
        EnumSet enumSet=EnumSet.noneOf(Modifier.class);
        enumSet.addAll(list);
        methodDeclaration.setModifiers(enumSet);
        getMembers().add(methodDeclaration);
        return methodDeclaration;
    }

    /**
     * Add an initializer block ({@link InitializerDeclaration}) to this.
     */
    public BlockStmt addInitializer() {
        BlockStmt block = new BlockStmt();
        InitializerDeclaration initializerDeclaration = new InitializerDeclaration(false, block);
        getMembers().add(initializerDeclaration);
        return block;
    }

    /**
     * Add a static initializer block ({@link InitializerDeclaration}) to this.
     */
    public BlockStmt addStaticInitializer() {
        BlockStmt block = new BlockStmt();
        InitializerDeclaration initializerDeclaration = new InitializerDeclaration(true, block);
        getMembers().add(initializerDeclaration);
        return block;
    }

    /**
     * Try to find a {@link MethodDeclaration} by its name
     *
     * @param name the name of the method
     * @return the methods found (multiple in case of overloading)
     */
    public List<MethodDeclaration> getMethodsByName(String name) {
       /* return unmodifiableList(getMethods().stream()
                .filter(m -> m.getNameAsString().equals(name))
                .collect(toList()));*/
    	List<MethodDeclaration> result=new ArrayList<>();
      for (MethodDeclaration m : getMethods()) {
		if(m.getNameAsString().equals(name)) result.add(m);
	  }
      return unmodifiableList(result);
    	
    }

    /**
     * Find all methods in the members of this node.
     *
     * @return the methods found. This list is immutable.
     */
    public List<MethodDeclaration> getMethods() {
       /* return unmodifiableList(getMembers().stream()
                .filter(m -> m instanceof MethodDeclaration)
                .map(m -> (MethodDeclaration) m)
                .collect(toList()));*/
    	List<MethodDeclaration> result=new ArrayList<>();
    	for (BodyDeclaration<?> m : getMembers()) {
			if(m instanceof MethodDeclaration){
				result.add((MethodDeclaration) m);
			}
		}
    return 	unmodifiableList(result);
    	
    	
    }

    /**
     * Try to find a {@link MethodDeclaration} by its parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the methods found (multiple in case of overloading)
     */
    public List<MethodDeclaration> getMethodsByParameterTypes(String... paramTypes) {
        /*return unmodifiableList(getMethods().stream()
                .filter(m -> m.hasParametersOfType(paramTypes))
                .collect(toList()));*/
    	
    	List<MethodDeclaration> result=new ArrayList<>();
    	for (MethodDeclaration m : getMethods()) {
			if(m.hasParametersOfType(paramTypes)) result.add(m);
		}
    	
    	return unmodifiableList(result);
    }

    /**
     * Try to find {@link MethodDeclaration}s by their name and parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the methods found (multiple in case of overloading)
     */
    public List<MethodDeclaration> getMethodsBySignature(String name, String... paramTypes) {
       /* return unmodifiableList(getMethodsByName(name).stream()
                .filter(m -> m.hasParametersOfType(paramTypes))
                .collect(toList()));*/
    	
    	List<MethodDeclaration> result=new ArrayList<>();
    	for (MethodDeclaration m : getMethodsByName(name)) {
			if(m.hasParametersOfType(paramTypes)) result.add(m);
		}
    	return unmodifiableList(result);
    }

    /**
     * Try to find a {@link MethodDeclaration} by its parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the methods found (multiple in case of overloading)
     */
    public List<MethodDeclaration> getMethodsByParameterTypes(Class<?>... paramTypes) {
        /*return unmodifiableList(getMethods().stream()
                .filter(m -> m.hasParametersOfType(paramTypes))
                .collect(toList()));*/
    	
    	List<MethodDeclaration> result=new ArrayList<>();
    	for (MethodDeclaration m : getMethods()) {
			if(m.hasParametersOfType(paramTypes)) result.add(m);
		}
    	return unmodifiableList(result);
    }

    /**
     * Try to find a {@link FieldDeclaration} by its name
     *
     * @param name the name of the field
     * @return null if not found, the FieldDeclaration otherwise
     */
    public FieldDeclaration getFieldByName(String name) {
        /*return getMembers().stream()
                .filter(m -> m instanceof FieldDeclaration)
                .map(f -> (FieldDeclaration) f)
                .filter(f -> f.getVariables().stream()
                        .anyMatch(var -> var.getNameAsString().equals(name)))
                .findFirst();*/
    	for (BodyDeclaration<?> m : getMembers()) {
			if(m instanceof FieldDeclaration){
				FieldDeclaration f=(FieldDeclaration) m;
				NodeList<VariableDeclarator> list=f.getVariables();
				for (VariableDeclarator var : list) {
					if(var.getNameAsString().equals(name)) return f;
				}
			}
		}
    	return null;
    }

    /**
     * Find all fields in the members of this node.
     *
     * @return the fields found. This list is immutable.
     */
    public List<FieldDeclaration> getFields() {
       /* return unmodifiableList(getMembers().stream()
                .filter(m -> m instanceof FieldDeclaration)
                .map(m -> (FieldDeclaration) m)
                .collect(toList()));*/
    	List<FieldDeclaration> result=new ArrayList<>();
    	for (BodyDeclaration<?> m : getMembers()) {
			if(m instanceof FieldDeclaration){
				result.add((FieldDeclaration) m);
			}
		}
    return 	unmodifiableList(result);
    	
    }
    
    
    //for NodeWithStaticModifier
    
    public  boolean isStatic() {
        return getModifiers().contains(STATIC);
    }

    @SuppressWarnings("unchecked")
	public T setStatic(boolean set) {
        return setModifier(STATIC, set);
    }
    
     //for NodeWithStrictfpModifier
    
    public  boolean isStrictfp() {
        return getModifiers().contains(STRICTFP);
    }

    @SuppressWarnings("unchecked")
	public T setStrictfp(boolean set) {
        return setModifier(STRICTFP, set);
    }
    
    
    //for NodeWithPublicModifier
    public  boolean isPublic() {
        return getModifiers().contains(PUBLIC);
    }

    @SuppressWarnings("unchecked")
	public T setPublic(boolean set) {
        return setModifier(PUBLIC, set);
    }
    
    //for NodeWithPrivateModifier
    public  boolean isPrivate() {
        return getModifiers().contains(PRIVATE);
    }

    @SuppressWarnings("unchecked")
	public T setPrivate(boolean set) {
        return setModifier(PRIVATE, set);
    }
    
    //for NodeWithProtectedModifier
    public  boolean isProtected() {
        return getModifiers().contains(PROTECTED);
    }

    @SuppressWarnings("unchecked")
	public T setProtected(boolean set) {
        return setModifier(PROTECTED, set);
    }
    
    //for NodeWithModifiers
    @SuppressWarnings("unchecked")
	public T addModifier(Modifier... modifiers) {
        EnumSet<Modifier> newModifiers = getModifiers().clone();
        /*newModifiers.addAll(Arrays.stream(modifiers)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
        enm.addAll(list);
        newModifiers.addAll(enm);
        setModifiers(newModifiers);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
	public T removeModifier(Modifier... m) {
        EnumSet<Modifier> newModifiers = getModifiers().clone();
       /* newModifiers.removeAll(Arrays.stream(m)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        List<Modifier> list=new ArrayList<>(Arrays.asList(m));
        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
        enm.addAll(list);
        newModifiers.removeAll(enm);
        
        setModifiers(newModifiers);
        return (T) this;
    }
    public  T setModifier(Modifier m, boolean set) {
        if (set) {
            return addModifier(m);
        } else {
            return removeModifier(m);
        }
    }
    
 
    
}
