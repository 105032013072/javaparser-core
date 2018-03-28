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
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.javadoc.Javadoc;


/**
 * A node that can be documented with a Javadoc comment.
 */
public interface NodeWithJavadoc<N extends Node> {
    Comment getCommentOptional();

    Node setComment(Comment comment);

    /**
     * Gets the JavadocComment for this node. You can set the JavadocComment by calling setJavadocComment passing a
     * JavadocComment.
     *
     * @return The JavadocComment for this node wrapped in an optional as it may be absent.
     */
    public abstract JavadocComment getJavadocComment();

    /**
     * Gets the Javadoc for this node. You can set the Javadoc by calling setJavadocComment passing a Javadoc.
     *
     * @return The Javadoc for this node wrapped in an optional as it may be absent.
     */
    public abstract  Javadoc getOptionalJavadoc();
    
    public abstract Javadoc getJavadoc();

    /**
     * Use this to store additional information to this node.
     *
     * @param comment to be set
     */
    @SuppressWarnings("unchecked")
    public abstract N setJavadocComment(String comment);

    public abstract N setJavadocComment(JavadocComment comment);

    public abstract N setJavadocComment(String indentation, Javadoc javadoc);

    public abstract boolean removeJavaDocComment();

    public abstract boolean hasJavaDocComment();

}
