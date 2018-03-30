package com.github.javaparser.metamodel;



public class LongLiteralExprMetaModel extends LiteralStringValueExprMetaModel {

    LongLiteralExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.LongLiteralExpr.class, "LongLiteralExpr", "com.github.javaparser.ast.expr", false, false);
    }
}
