package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class AnnotationExprMetaModel extends ExpressionMetaModel {

    AnnotationExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.AnnotationExpr.class, "AnnotationExpr", "com.github.javaparser.ast.expr", true, false);
    }

    protected AnnotationExprMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }

    public PropertyMetaModel namePropertyMetaModel;
}
