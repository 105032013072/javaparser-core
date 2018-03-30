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

package com.github.javaparser.resolution.declarations;

import com.github.javaparser.ast.AccessSpecifier;
import com.github.javaparser.resolution.MethodUsage;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.resolution.types.ResolvedType;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;


/**
 * @author Federico Tomassetti
 */
public interface ResolvedReferenceTypeDeclaration extends ResolvedTypeDeclaration,
        ResolvedTypeParametrizable {

    @Override
    public ResolvedReferenceTypeDeclaration asReferenceType();

    ///
    /// Ancestors
    ///

    /**
     * The list of all the direct ancestors of the current declaration.
     * Note that the ancestor can be parametrized types with values specified. For example:
     * <p>
     * class A implements Comparable&lt;String&gt; {}
     * <p>
     * In this case the ancestor is Comparable&lt;String&gt;
     */
    List<ResolvedReferenceType> getAncestors();

    /**
     * The list of all the ancestors of the current declaration, direct and indirect.
     * This list does not contains duplicates with the exacting same type parameters.
     */
    public List<ResolvedReferenceType> getAllAncestors();

    ///
    /// Fields
    ///

    /**
     * Note that the type of the field should be expressed using the type variables of this particular type.
     * Consider for example:
     * <p>
     * class Foo<E> { E field; }
     * <p>
     * class Bar extends Foo<String> { }
     * <p>
     * When calling getField("field") on Foo I should get a FieldDeclaration with type E, while calling it on
     * Bar I should get a FieldDeclaration with type String.
     */
    public ResolvedFieldDeclaration getField(String name);

    /**
     * Consider only field or inherited field which is not private.
     */
    public ResolvedFieldDeclaration getVisibleField(String name);

    /**
     * Has this type a field with the given name?
     */
    public boolean hasField(String name);
    

    /**
     * Either a declared field or inherited field which is not private.
     */
    public boolean hasVisibleField(String name);

    /**
     * Return a list of all fields, either declared in this declaration or inherited.
     */
    List<ResolvedFieldDeclaration> getAllFields();

    /**
     * Return a list of all fields declared and the inherited ones which are not private.
     */
    public List<ResolvedFieldDeclaration> getVisibleFields();

    /**
     * Return a list of all the non static fields, either declared or inherited.
     */
    public List<ResolvedFieldDeclaration> getAllNonStaticFields();

    /**
     * Return a list of all the static fields, either declared or inherited.
     */
    public List<ResolvedFieldDeclaration> getAllStaticFields();

    /**
     * Return a list of all the fields declared in this type.
     */
    public List<ResolvedFieldDeclaration> getDeclaredFields();

    ///
    /// Methods
    ///

    /**
     * Return a list of all the methods declared in this type declaration.
     */
    Set<ResolvedMethodDeclaration> getDeclaredMethods();

    /**
     * Return a list of all the methods declared of this type declaration, either declared or inherited.
     * Note that it should not include overridden methods.
     */
    Set<MethodUsage> getAllMethods();

    ///
    /// Assignability
    ///

    /**
     * Can we assign instances of the given type to variables having the type defined
     * by this declaration?
     */
    boolean isAssignableBy(ResolvedType type);

    /**
     * Can we assign instances of the type defined by this declaration to variables having the type defined
     * by the given type?
     */
    public boolean canBeAssignedTo(ResolvedReferenceTypeDeclaration other);

    /**
     * Can we assign instances of the given type to variables having the type defined
     * by this declaration?
     */
    boolean isAssignableBy(ResolvedReferenceTypeDeclaration other);

    ///
    /// Annotations
    ///

    /**
     * Has the type at least one annotation declared having the specified qualified name?
     */
    boolean hasDirectlyAnnotation(String qualifiedName);

    /**
     * Has the type at least one annotation declared or inherited having the specified qualified name?
     */
    public boolean hasAnnotation(String qualifiedName);

    /**
     * This means that the type has a functional method. Conceptually, a functional interface has exactly one abstract method.
     * Typically these classes has the FunctionInterface annotation but this is not mandatory.
     */
    boolean isFunctionalInterface();

    ///
    /// Type parameters
    ///

    @Override
    public ResolvedTypeParameterDeclaration findTypeParameter(String name);
}
