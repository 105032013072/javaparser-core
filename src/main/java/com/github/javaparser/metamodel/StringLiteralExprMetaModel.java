package com.github.javaparser.metamodel;



public class StringLiteralExprMetaModel extends LiteralStringValueExprMetaModel {

    StringLiteralExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.StringLiteralExpr.class, "StringLiteralExpr", "com.github.javaparser.ast.expr", false, false);
    }
}
