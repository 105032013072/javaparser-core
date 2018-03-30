package com.github.javaparser.metamodel;



public class CharLiteralExprMetaModel extends LiteralStringValueExprMetaModel {

    CharLiteralExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.CharLiteralExpr.class, "CharLiteralExpr", "com.github.javaparser.ast.expr", false, false);
    }
}
