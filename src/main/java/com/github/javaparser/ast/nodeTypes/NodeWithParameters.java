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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.type.Type;

import java.util.Set;


import static com.github.javaparser.JavaParser.parseType;

import java.util.Arrays;
import java.util.HashSet;

public interface NodeWithParameters<N extends Node> {
    NodeList<Parameter> getParameters();

    public abstract Parameter getParameter(int i);

    void tryAddImportToParentCompilationUnit(Class<?> clazz);

    @SuppressWarnings("unchecked")
    public abstract N setParameter(int i, Parameter parameter);

    N setParameters(NodeList<Parameter> parameters);

    public abstract N addParameter(Type type, String name);

    public abstract N addParameter(Class<?> paramClass, String name);

    /**
     * Remember to import the class in the compilation unit yourself
     *
     * @param className the name of the class, ex : org.test.Foo or Foo if you added manually the import
     * @param name the name of the parameter
     */
    public abstract N addParameter(String className, String name);

    @SuppressWarnings("unchecked")
    public abstract N addParameter(Parameter parameter);

    public abstract Parameter addAndGetParameter(Type type, String name);

    public abstract Parameter addAndGetParameter(Class<?> paramClass, String name);

    /**
     * Remember to import the class in the compilation unit yourself
     *
     * @param className the name of the class, ex : org.test.Foo or Foo if you added manually the import
     * @param name the name of the parameter
     * @return the {@link Parameter} created
     */
    public abstract Parameter addAndGetParameter(String className, String name);

    public abstract Parameter addAndGetParameter(Parameter parameter);

    /**
     * Try to find a {@link Parameter} by its name
     *
     * @param name the name of the param
     * @return null if not found, the param found otherwise
     */
    public abstract Parameter getParameterByName(String name);

    /**
     * Try to find a {@link Parameter} by its type
     *
     * @param type the type of the param
     * @return null if not found, the param found otherwise
     */
    public abstract Parameter getParameterByType(String type);

    /**
     * Try to find a {@link Parameter} by its type
     *
     * @param type the type of the param <b>take care about generics, it wont work</b>
     * @return null if not found, the param found otherwise
     */
    public abstract Parameter getParameterByType(Class<?> type);

    /**
     * Check if the parameters have certain types.
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return true if all parameters match
     */
    public abstract boolean hasParametersOfType(String... paramTypes);

    /**
     * Check if the parameters have certain types. Note that this is a match in SimpleName, so "java.awt.List" and
     * "java.util.List" are identical to this algorithm.
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return true if all parameters match
     */
    public abstract boolean hasParametersOfType(Class<?>... paramTypes);
}
