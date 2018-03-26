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
import com.github.javaparser.ast.expr.*;

import java.lang.annotation.Annotation;

import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;

/**
 * A node that can be annotated.
 *
 * @author Federico Tomassetti
 * @since July 2014
 */
public interface NodeWithAnnotations<N extends Node> {
    NodeList<AnnotationExpr> getAnnotations();

    N setAnnotations(NodeList<AnnotationExpr> annotations);

    void tryAddImportToParentCompilationUnit(Class<?> clazz);

    public abstract AnnotationExpr getAnnotation(int i);

    @SuppressWarnings("unchecked")
    public abstract N setAnnotation(int i, AnnotationExpr element);

    @SuppressWarnings("unchecked")
    public abstract N addAnnotation(AnnotationExpr element);

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public abstract N addAnnotation(String name);

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    @SuppressWarnings("unchecked")
    public abstract NormalAnnotationExpr addAndGetAnnotation(String name);

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public abstract N addAnnotation(Class<? extends Annotation> clazz);

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    public abstract NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz);

    /**
     * Annotates this with a marker annotation
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public abstract N addMarkerAnnotation(String name);

    /**
     * Annotates this with a marker annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public abstract N addMarkerAnnotation(Class<? extends Annotation> clazz);

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param expression the part between ()
     * @return this
     */
    @SuppressWarnings("unchecked")
    public abstract N addSingleMemberAnnotation(String name, Expression expression);

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public abstract N addSingleMemberAnnotation(String name, String value);

    /**
     * Annotates this with a single member annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public abstract N addSingleMemberAnnotation(Class<? extends Annotation> clazz,
                                        String value);

    /**
     * Check whether an annotation with this name is present on this element
     *
     * @param annotationName the name of the annotation
     * @return true if found, false if not
     */
    public abstract boolean isAnnotationPresent(String annotationName);

    /**
     * Check whether an annotation with this class is present on this element
     *
     * @param annotationClass the class of the annotation
     * @return true if found, false if not
     */
    public abstract boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);

    /**
     * Try to find an annotation by its name
     *
     * @param annotationName the name of the annotation
     */
    public abstract AnnotationExpr getOptionalAnnotationByName(String annotationName);
    
    public abstract AnnotationExpr getAnnotationByName(String annotationName);

    /**
     * Try to find an annotation by its class
     *
     * @param annotationClass the class of the annotation
     */
    public abstract AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass);
    
    public abstract AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass);
}
