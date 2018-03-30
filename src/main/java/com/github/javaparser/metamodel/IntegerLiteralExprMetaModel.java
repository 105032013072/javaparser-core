package com.github.javaparser.metamodel;



public class IntegerLiteralExprMetaModel extends LiteralStringValueExprMetaModel {

    IntegerLiteralExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.IntegerLiteralExpr.class, "IntegerLiteralExpr", "com.github.javaparser.ast.expr", false, false);
    }
}
