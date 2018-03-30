package com.github.javaparser.metamodel;



public class NormalAnnotationExprMetaModel extends AnnotationExprMetaModel {

    NormalAnnotationExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.NormalAnnotationExpr.class, "NormalAnnotationExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel pairsPropertyMetaModel;
}
