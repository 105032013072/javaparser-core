package com.github.javaparser.metamodel;



public class BinaryExprMetaModel extends ExpressionMetaModel {

    BinaryExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.BinaryExpr.class, "BinaryExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel leftPropertyMetaModel;

    public PropertyMetaModel operatorPropertyMetaModel;

    public PropertyMetaModel rightPropertyMetaModel;
}
