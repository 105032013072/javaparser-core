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
package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.VoidType;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;


import static com.github.javaparser.JavaParser.parseType;
import static java.util.Collections.unmodifiableList;


import java.util.ArrayList;

/**
 * A node having members.
 * <p>
 * The main reason for this interface is to permit users to manipulate homogeneously all nodes with a getMembers
 * method.
 */
public interface NodeWithMembers<N extends Node> {
    /**
     * @return all members inside the braces of this node,
     * like fields, methods, nested types, etc.
     */
    NodeList<BodyDeclaration<?>> getMembers();

    void tryAddImportToParentCompilationUnit(Class<?> clazz);

    public abstract BodyDeclaration<?> getMember(int i);

    @SuppressWarnings("unchecked")
    public abstract N setMember(int i, BodyDeclaration<?> member);

    @SuppressWarnings("unchecked")
    public abstract N addMember(BodyDeclaration<?> member);

    N setMembers(NodeList<BodyDeclaration<?>> members);

    /**
     * Add a field to this and automatically add the import of the type if needed
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addField(Class<?> typeClass, String name, Modifier... modifiers);

    /**
     * Add a field to this.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addField(String type, String name, Modifier... modifiers);

    /**
     * Add a field to this.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addField(Type type, String name, Modifier... modifiers);

    /**
     * Add a field to this.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @param initializer the initializer of the field
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addFieldWithInitializer(Type type, String name, Expression initializer, Modifier... modifiers);

    /**
     * Add a private field to this.
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addPrivateField(Class<?> typeClass, String name);

    /**
     * Add a private field to this and automatically add the import of the type if
     * needed.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addPrivateField(String type, String name);

    /**
     * Add a public field to this.
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addPublicField(Class<?> typeClass, String name);

    /**
     * Add a public field to this and automatically add the import of the type if
     * needed.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addPublicField(String type, String name);

    /**
     * Add a protected field to this.
     *
     * @param typeClass the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addProtectedField(Class<?> typeClass, String name);

    /**
     * Add a protected field to this and automatically add the import of the type
     * if needed.
     *
     * @param type the type of the field
     * @param name the name of the field
     * @return the {@link FieldDeclaration} created
     */
    public abstract FieldDeclaration addProtectedField(String type, String name);

    /**
     * Adds a methods with void return by default to this.
     *
     * @param methodName the method name
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the {@link MethodDeclaration} created
     */
    public abstract MethodDeclaration addMethod(String methodName, Modifier... modifiers);

    /**
     * Add an initializer block ({@link InitializerDeclaration}) to this.
     */
    public abstract BlockStmt addInitializer();

    /**
     * Add a static initializer block ({@link InitializerDeclaration}) to this.
     */
    public abstract BlockStmt addStaticInitializer();

    /**
     * Try to find a {@link MethodDeclaration} by its name
     *
     * @param name the name of the method
     * @return the methods found (multiple in case of overloading)
     */
    public abstract List<MethodDeclaration> getMethodsByName(String name);

    /**
     * Find all methods in the members of this node.
     *
     * @return the methods found. This list is immutable.
     */
    public abstract List<MethodDeclaration> getMethods();

    /**
     * Try to find a {@link MethodDeclaration} by its parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the methods found (multiple in case of overloading)
     */
    public abstract List<MethodDeclaration> getMethodsByParameterTypes(String... paramTypes);

    /**
     * Try to find {@link MethodDeclaration}s by their name and parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the methods found (multiple in case of overloading)
     */
    public abstract List<MethodDeclaration> getMethodsBySignature(String name, String... paramTypes);

    /**
     * Try to find a {@link MethodDeclaration} by its parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the methods found (multiple in case of overloading)
     */
    public abstract List<MethodDeclaration> getMethodsByParameterTypes(Class<?>... paramTypes);

    /**
     * Try to find a {@link FieldDeclaration} by its name
     *
     * @param name the name of the field
     * @return null if not found, the FieldDeclaration otherwise
     */
    public abstract FieldDeclaration getFieldByName(String name);

    /**
     * Find all fields in the members of this node.
     *
     * @return the fields found. This list is immutable.
     */
    public abstract List<FieldDeclaration> getFields();
}
