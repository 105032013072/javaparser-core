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
package com.github.javaparser.ast;

import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;
import static com.github.javaparser.utils.Utils.assertNotNull;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.ArrayCreationLevelMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import javax.annotation.Generated;
import com.github.javaparser.TokenRange;
import com.github.javaparser.metamodel.OptionalProperty;

/**
 * In <code>new int[1][2];</code> there are two ArrayCreationLevel objects,
 * the first one contains the expression "1",
 * the second the expression "2".
 */
public final class ArrayCreationLevel extends Node implements NodeWithAnnotations<ArrayCreationLevel> {

    @OptionalProperty
    private Expression dimension;

    private NodeList<AnnotationExpr> annotations = new NodeList<>();

    public ArrayCreationLevel() {
        this(null, null, new NodeList<AnnotationExpr>());
    }

    public ArrayCreationLevel(int dimension) {
        this(null, new IntegerLiteralExpr("" + dimension), new NodeList<AnnotationExpr>());
    }

    public ArrayCreationLevel(Expression dimension) {
        this(null, dimension, new NodeList<AnnotationExpr>());
    }

    @AllFieldsConstructor
    public ArrayCreationLevel(Expression dimension, NodeList<AnnotationExpr> annotations) {
        this(null, dimension, annotations);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public ArrayCreationLevel(TokenRange tokenRange, Expression dimension, NodeList<AnnotationExpr> annotations) {
        super(tokenRange);
        setDimension(dimension);
        setAnnotations(annotations);
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

    /**
     * Sets the dimension
     *
     * @param dimension the dimension, can be null
     * @return this, the ArrayCreationLevel
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ArrayCreationLevel setDimension(final Expression dimension) {
        if (dimension == this.dimension) {
            return (ArrayCreationLevel) this;
        }
        notifyPropertyChange(ObservableProperty.DIMENSION, this.dimension, dimension);
        if (this.dimension != null)
            this.dimension.setParentNode(null);
        this.dimension = dimension;
        setAsParentNodeOf(dimension);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Expression getDimension() {
        return dimension;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<AnnotationExpr> getAnnotations() {
        return annotations;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ArrayCreationLevel setAnnotations(final NodeList<AnnotationExpr> annotations) {
        assertNotNull(annotations);
        if (annotations == this.annotations) {
            return (ArrayCreationLevel) this;
        }
        notifyPropertyChange(ObservableProperty.ANNOTATIONS, this.annotations, annotations);
        if (this.annotations != null)
            this.annotations.setParentNode(null);
        this.annotations = annotations;
        setAsParentNodeOf(annotations);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public ArrayCreationLevel removeDimension() {
        return setDimension((Expression) null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < annotations.size(); i++) {
            if (annotations.get(i) == node) {
                annotations.remove(i);
                return true;
            }
        }
        if (dimension != null) {
            if (node == dimension) {
                removeDimension();
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public ArrayCreationLevel clone() {
        return (ArrayCreationLevel) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public ArrayCreationLevelMetaModel getMetaModel() {
        return JavaParserMetaModel.arrayCreationLevelMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        for (int i = 0; i < annotations.size(); i++) {
            if (annotations.get(i) == node) {
                annotations.set(i, (AnnotationExpr) replacementNode);
                return true;
            }
        }
        if (dimension != null) {
            if (node == dimension) {
                setDimension((Expression) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

	@Override
	public AnnotationExpr getAnnotation(int i) {
		 return getAnnotations().get(i);
	}

	@Override
	public ArrayCreationLevel setAnnotation(int i, AnnotationExpr element) {
		 getAnnotations().set(i, element);
	        return (ArrayCreationLevel) this;
	}

	@Override
	public ArrayCreationLevel addAnnotation(AnnotationExpr element) {
		getAnnotations().add(element);
        return (ArrayCreationLevel) this;	}

	@Override
	public ArrayCreationLevel addAnnotation(String name) {
		 NormalAnnotationExpr annotation = new NormalAnnotationExpr(
	                parseName(name), new NodeList<MemberValuePair>());
	        getAnnotations().add(annotation);
	        return (ArrayCreationLevel) this;
	}

	@Override
	public NormalAnnotationExpr addAndGetAnnotation(String name) {
		 NormalAnnotationExpr annotation = new NormalAnnotationExpr(
	                parseName(name), new NodeList<MemberValuePair>());
	        getAnnotations().add(annotation);
	        return annotation;
	}

	@Override
	public ArrayCreationLevel addAnnotation(Class<? extends Annotation> clazz) {
		tryAddImportToParentCompilationUnit(clazz);
        return addAnnotation(clazz.getSimpleName());
	}

	@Override
	public NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
		tryAddImportToParentCompilationUnit(clazz);
        return addAndGetAnnotation(clazz.getSimpleName());
	}

	@Override
	public ArrayCreationLevel addMarkerAnnotation(String name) {
		MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
                parseName(name));
        getAnnotations().add(markerAnnotationExpr);
        return (ArrayCreationLevel) this;
	}

	@Override
	public ArrayCreationLevel addMarkerAnnotation(Class<? extends Annotation> clazz) {
		 tryAddImportToParentCompilationUnit(clazz);
	        return addMarkerAnnotation(clazz.getSimpleName());
	}

	@Override
	public ArrayCreationLevel addSingleMemberAnnotation(String name, Expression expression) {
		 SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
	                parseName(name), expression);
	        getAnnotations().add(singleMemberAnnotationExpr);
	        return (ArrayCreationLevel) this;
	}

	@Override
	public ArrayCreationLevel addSingleMemberAnnotation(String name, String value) {
		return addSingleMemberAnnotation(name, parseExpression(value));
	}

	@Override
	public ArrayCreationLevel addSingleMemberAnnotation(Class<? extends Annotation> clazz, String value) {
		tryAddImportToParentCompilationUnit(clazz);
        return addSingleMemberAnnotation(clazz.getSimpleName(), value);
	}

	@Override
	public boolean isAnnotationPresent(String annotationName) {
		 //return getAnnotations().stream().anyMatch(a -> a.getName().getIdentifier().equals(annotationName));
    	NodeList<AnnotationExpr> list= getAnnotations();
    	for (AnnotationExpr annotationExpr : list) {
			if( annotationExpr.getName().getIdentifier().equals(annotationName)) return true;
		}
    	return false;
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
		 return isAnnotationPresent(annotationClass.getSimpleName());
	}

	@Override
	public AnnotationExpr getOptionalAnnotationByName(String annotationName) {
		 //return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
    	NodeList<AnnotationExpr> list= getAnnotations();
    	for (AnnotationExpr annotationExpr : list) {
			if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
		}
    	return null;
	}

	@Override
	public AnnotationExpr getAnnotationByName(String annotationName) {
		NodeList<AnnotationExpr> annotationList =getAnnotations();
    	for (AnnotationExpr annotationExpr : annotationList) {
			if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
		}
    	return null;
	}

	@Override
	public AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
		return getOptionalAnnotationByName(annotationClass.getSimpleName());
	}

	@Override
	public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
		AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
    	if(optional!=null) return optional;
    	else return null;
	}

	
}
