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
package com.github.javaparser.ast.type;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.metamodel.WildcardTypeMetaModel;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.resolution.types.ResolvedUnionType;
import com.github.javaparser.resolution.types.ResolvedWildcard;
import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;

/**
 * A wildcard type argument.
 * <br/><code>void printCollection(Collection&lt;<b>?</b>> c) { ... }</code>
 * <br/><code>boolean addAll(Collection&lt;<b>? extends E</b>> c)</code>
 * <br/><code>Reference(T referent, ReferenceQueue&lt;<b>? super T</b>> queue)</code>
 *
 * @author Julio Vilmar Gesser
 */
public final class WildcardType extends Type implements NodeWithAnnotations<WildcardType> {

    @OptionalProperty
    private ReferenceType extendedType;

    @OptionalProperty
    private ReferenceType superType;

    public WildcardType() {
        this(null, null, null, new NodeList<AnnotationExpr>());
    }

    public WildcardType(final ReferenceType extendedType) {
        this(null, extendedType, null, new NodeList<AnnotationExpr>());
    }

    @AllFieldsConstructor
    public WildcardType(final ReferenceType extendedType, final ReferenceType superType, final NodeList<AnnotationExpr> annotations) {
        this(null, extendedType, superType, annotations);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public WildcardType(TokenRange tokenRange, ReferenceType extendedType, ReferenceType superType, NodeList<AnnotationExpr> annotations) {
        super(tokenRange, annotations);
        setExtendedType(extendedType);
        setSuperType(superType);
        customInitialization();
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

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ReferenceType getExtendedType() {
        return extendedType;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ReferenceType getSuperType() {
        return superType;
    }

    @Deprecated
    public ReferenceType getExtendedTypes() {
        return getExtendedType();
    }

    @Deprecated
    public ReferenceType getSuperTypes() {
        return getSuperType();
    }

    /**
     * Sets the extended type
     *
     * @param extendedType the extends, can be null
     * @return this, the WildcardType
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public WildcardType setExtendedType(final ReferenceType extendedType) {
        if (extendedType == this.extendedType) {
            return (WildcardType) this;
        }
        notifyPropertyChange(ObservableProperty.EXTENDED_TYPE, this.extendedType, extendedType);
        if (this.extendedType != null)
            this.extendedType.setParentNode(null);
        this.extendedType = extendedType;
        setAsParentNodeOf(extendedType);
        return this;
    }

    /**
     * Sets the extended type
     *
     * @param extendedType the extends, can be null
     * @return this, the WildcardType
     * @deprecated use setExtendedType instead,
     */
    @Deprecated
    public WildcardType setExtendedTypes(final ReferenceType extendedType) {
        return setExtendedType(extendedType);
    }

    /**
     * Sets the supertype
     *
     * @param superType the super, can be null
     * @return this, the WildcardType
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public WildcardType setSuperType(final ReferenceType superType) {
        if (superType == this.superType) {
            return (WildcardType) this;
        }
        notifyPropertyChange(ObservableProperty.SUPER_TYPE, this.superType, superType);
        if (this.superType != null)
            this.superType.setParentNode(null);
        this.superType = superType;
        setAsParentNodeOf(superType);
        return this;
    }

    /**
     * Sets the supertype
     *
     * @param superType the super, can be null
     * @return this, the WildcardType
     * @deprecated use setSuperType instead
     */
    @Deprecated
    public WildcardType setSuperTypes(final ReferenceType superType) {
        return setSuperType(superType);
    }

    @Override
    public WildcardType setAnnotations(NodeList<AnnotationExpr> annotations) {
        return (WildcardType) super.setAnnotations(annotations);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        if (extendedType != null) {
            if (node == extendedType) {
                removeExtendedType();
                return true;
            }
        }
        if (superType != null) {
            if (node == superType) {
                removeSuperType();
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    public String asString() {
        StringBuilder str = new StringBuilder("?");
        /*getExtendedType().ifPresent(t -> str.append(" extends ").append(t.asString()));
        getSuperType().ifPresent(t -> str.append(" super ").append(t.asString()));*/
        if(getExtendedType()!=null){
        	str.append(" extends ").append(getExtendedType().asString());
        }
        if(getSuperType()!=null){
        	str.append(" super ").append(getSuperType().asString());
        }
        return str.toString();
    }

    @Deprecated
    public WildcardType removeExtendedTypes() {
        return removeExtendedType();
    }

    @Deprecated
    public WildcardType removeSuperTypes() {
        return removeSuperType();
    }

    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public WildcardType removeExtendedType() {
        return setExtendedType((ReferenceType) null);
    }

    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public WildcardType removeSuperType() {
        return setSuperType((ReferenceType) null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public WildcardType clone() {
        return (WildcardType) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public WildcardTypeMetaModel getMetaModel() {
        return JavaParserMetaModel.wildcardTypeMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (extendedType != null) {
            if (node == extendedType) {
                setExtendedType((ReferenceType) replacementNode);
                return true;
            }
        }
        if (superType != null) {
            if (node == superType) {
                setSuperType((ReferenceType) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public WildcardType(TokenRange tokenRange, ReferenceType extendedType, ReferenceType superType) {
        super(tokenRange);
        setExtendedType(extendedType);
        setSuperType(superType);
        customInitialization();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isWildcardType() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public WildcardType asWildcardType() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifWildcardType(Consumer<WildcardType> action) {
        action.accept(this);
    }

    @Override
    public ResolvedWildcard resolve() {
        return getSymbolResolver().toResolvedType(this, ResolvedWildcard.class);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public WildcardType toWildcardType() {
        return this;
    }
    // for NodeWithAnnotations
    public AnnotationExpr getAnnotation(int i) {
        return getAnnotations().get(i);
    }

    @SuppressWarnings("unchecked")
    public WildcardType setAnnotation(int i, AnnotationExpr element) {
        getAnnotations().set(i, element);
        return (WildcardType) this;
    }

    @SuppressWarnings("unchecked")
    public WildcardType addAnnotation(AnnotationExpr element) {
        getAnnotations().add(element);
        return (WildcardType) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public WildcardType addAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return (WildcardType) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    @SuppressWarnings("unchecked")
    public NormalAnnotationExpr addAndGetAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public WildcardType addAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    public NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAndGetAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this with a marker annotation
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public WildcardType addMarkerAnnotation(String name) {
        MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
                parseName(name));
        getAnnotations().add(markerAnnotationExpr);
        return (WildcardType) this;
    }

    /**
     * Annotates this with a marker annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public WildcardType addMarkerAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addMarkerAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param expression the part between ()
     * @return this
     */
    @SuppressWarnings("unchecked")
    public WildcardType addSingleMemberAnnotation(String name, Expression expression) {
        SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
                parseName(name), expression);
        getAnnotations().add(singleMemberAnnotationExpr);
        return (WildcardType) this;
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public WildcardType addSingleMemberAnnotation(String name, String value) {
        return addSingleMemberAnnotation(name, parseExpression(value));
    }

    /**
     * Annotates this with a single member annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public WildcardType addSingleMemberAnnotation(Class<? extends Annotation> clazz,
                                        String value) {
        tryAddImportToParentCompilationUnit(clazz);
        return addSingleMemberAnnotation(clazz.getSimpleName(), value);
    }

    /**
     * Check whether an annotation with this name is present on this element
     *
     * @param annotationName the name of the annotation
     * @return true if found, false if not
     */
    public boolean isAnnotationPresent(String annotationName) {
       // return getAnnotations().stream().anyMatch(a -> a.getName().getIdentifier().equals(annotationName));
    	for (AnnotationExpr a : getAnnotations()) {
			if(a.getName().getIdentifier().equals(annotationName)) return true;
		}
    	return false;
    }

    /**
     * Check whether an annotation with this class is present on this element
     *
     * @param annotationClass the class of the annotation
     * @return true if found, false if not
     */
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return isAnnotationPresent(annotationClass.getSimpleName());
    }

    /**
     * Try to find an annotation by its name
     *
     * @param annotationName the name of the annotation
     */
    public AnnotationExpr getOptionalAnnotationByName(String annotationName) {
       // return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
    	for (AnnotationExpr a : getAnnotations()) {
		   if(a.getName().getIdentifier().equals(annotationName))	return a;
		}
    	return null;
    }
    
    public AnnotationExpr getAnnotationByName(String annotationName){
    	NodeList<AnnotationExpr> annotationList =getAnnotations();
    	for (AnnotationExpr annotationExpr : annotationList) {
			if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
		}
    	return null;
    }

    /**
     * Try to find an annotation by its class
     *
     * @param annotationClass the class of the annotation
     */
    public  AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
        return getOptionalAnnotationByName(annotationClass.getSimpleName());
    }
    
    public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
    	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
    	if(optional!=null) return optional;
    	else return null;
    }
}
