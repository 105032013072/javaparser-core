package com.github.javaparser.metamodel;



public class EnclosedExprMetaModel extends ExpressionMetaModel {

    EnclosedExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.EnclosedExpr.class, "EnclosedExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel innerPropertyMetaModel;
}
