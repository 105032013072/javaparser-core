package com.github.javaparser.metamodel;



public class FieldAccessExprMetaModel extends ExpressionMetaModel {

    FieldAccessExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.FieldAccessExpr.class, "FieldAccessExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel scopePropertyMetaModel;

    public PropertyMetaModel typeArgumentsPropertyMetaModel;

    public PropertyMetaModel usingDiamondOperatorPropertyMetaModel;
}
