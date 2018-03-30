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

import com.github.javaparser.resolution.UnsolvedSymbolException;


import java.util.Set;

/**
 * A declaration of a type. It could be a primitive type, an enum, a class, an interface
 * or a type variable.
 * It cannot be an annotation or an array.
 *
 * @author Federico Tomassetti
 */
public interface ResolvedTypeDeclaration extends ResolvedDeclaration {

    ///
    /// Containment
    ///

    /**
     * Get the list of types defined inside the current type.
     */
	public Set<ResolvedReferenceTypeDeclaration> internalTypes();

    /**
     * Returns a type declaration for the internal type based on name.
     * (Does not include internal types inside internal types).
     */
	public ResolvedReferenceTypeDeclaration getInternalType(String name);

    /**
     * Does this type contain an internal type with the given name?
     * (Does not include internal types inside internal types).
     */
	public boolean hasInternalType(String name);

    /**
     * Get the ReferenceTypeDeclaration enclosing this declaration.
     *
     * @return
     */
    ResolvedReferenceTypeDeclaration containerType();

    ///
    /// Misc
    ///

    /**
     * Is this the declaration of a class?
     * Note that an Enum is not considered a Class in this case.
     */
    public boolean isClass();

    /**
     * Is this the declaration of an interface?
     */
    public boolean isInterface();

    /**
     * Is this the declaration of an enum?
     */
    public boolean isEnum();

    /**
     * Is this the declaration of a type parameter?
     */
    public boolean isTypeParameter();

    @Override
    public boolean isType();

    /**
     * Is this type declaration corresponding to an anonymous class?
     *
     * This is an example of anonymous class:
     * <pre>
     * HelloWorld frenchGreeting = new HelloWorld() {
     *     String name = "tout le monde";
     *
     *     public void greet() {
     *         greetSomeone("tout le monde");
     *     }
     *
     *     public void greetSomeone(String someone) {
     *         name = someone;
     *         System.out.println("Salut " + name);
     *     }
     * };
     * </pre>
     */
    public boolean isAnonymousClass();

    @Override
    public ResolvedTypeDeclaration asType();

    /**
     * Return this as a ClassDeclaration or throw UnsupportedOperationException.
     */
    public ResolvedClassDeclaration asClass();

    /**
     * Return this as a InterfaceDeclaration or throw UnsupportedOperationException.
     */
    public ResolvedInterfaceDeclaration asInterface();

    /**
     * Return this as a EnumDeclaration or throw UnsupportedOperationException.
     */
    public ResolvedEnumDeclaration asEnum();

    /**
     * Return this as a TypeParameterDeclaration or throw UnsupportedOperationException.
     */
    public ResolvedTypeParameterDeclaration asTypeParameter();

    public ResolvedReferenceTypeDeclaration asReferenceType();

    /**
     * The package name of the type.
     */
    String getPackageName();

    /**
     * The class(es) wrapping this type.
     */
    String getClassName();

    /**
     * The fully qualified name of the type declared.
     */
    String getQualifiedName();

    /**
     * The ID corresponds most of the type to the qualified name. It differs only for local
     * classes which do not have a qualified name but have an ID.
     */
    public String getId();

}
