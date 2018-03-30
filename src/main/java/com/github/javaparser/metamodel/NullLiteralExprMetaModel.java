package com.github.javaparser.metamodel;



public class NullLiteralExprMetaModel extends LiteralExprMetaModel {

    NullLiteralExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.NullLiteralExpr.class, "NullLiteralExpr", "com.github.javaparser.ast.expr", false, false);
    }
}
