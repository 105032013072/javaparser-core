package com.github.javaparser.metamodel;



public class BooleanLiteralExprMetaModel extends LiteralExprMetaModel {

    BooleanLiteralExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.BooleanLiteralExpr.class, "BooleanLiteralExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel valuePropertyMetaModel;
}
