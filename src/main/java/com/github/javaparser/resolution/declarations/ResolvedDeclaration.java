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

/**
 * A generic declaration.
 *
 * @author Federico Tomassetti
 */
public interface ResolvedDeclaration {

    /**
     * Anonymous classes do not have a name, for example.
     */
	public boolean hasName();

    /**
     * Should return the name or throw a RuntimeException if the name is not available.
     */
    String getName();

    /**
     * Does this declaration represents a class field?
     */
    public boolean isField();

    /**
     * Does this declaration represents a method parameter?
     */
    public boolean isParameter();

    /**
     * Does this declaration represents a type?
     */
    public boolean isType();

    /**
     * Does this declaration represents a method?
     */
    public boolean isMethod();

    /**
     * Return this as a FieldDeclaration or throw an UnsupportedOperationException
     */
    public ResolvedFieldDeclaration asField();

    /**
     * Return this as a ParameterDeclaration or throw an UnsupportedOperationException
     */
    public ResolvedParameterDeclaration asParameter();

    /**
     * Return this as a TypeDeclaration or throw an UnsupportedOperationException
     */
    public ResolvedTypeDeclaration asType();

    /**
     * Return this as a MethodDeclaration or throw an UnsupportedOperationException
     */
    public ResolvedMethodDeclaration asMethod();
}
