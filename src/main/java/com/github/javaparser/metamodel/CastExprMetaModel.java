package com.github.javaparser.metamodel;



public class CastExprMetaModel extends ExpressionMetaModel {

    CastExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.CastExpr.class, "CastExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel expressionPropertyMetaModel;

    public PropertyMetaModel typePropertyMetaModel;
}
