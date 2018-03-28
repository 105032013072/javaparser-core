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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;


/**
 * A Node with Modifiers.
 * Note that not all modifiers may be valid for this node.
 */
public interface NodeWithModifiers<N extends Node> {
    /**
     * Return the modifiers of this variable declaration.
     * Warning: modifying the returned set will not trigger observers,
     * you have to use setModifiers for that.
     *
     * @return modifiers
     * @see Modifier
     */
    EnumSet<Modifier> getModifiers();

    N setModifiers(EnumSet<Modifier> modifiers);

    @SuppressWarnings("unchecked")
    public abstract N addModifier(Modifier... modifiers);

    @SuppressWarnings("unchecked")
    public abstract N removeModifier(Modifier... m);
    public abstract N setModifier(Modifier m, boolean set);

}