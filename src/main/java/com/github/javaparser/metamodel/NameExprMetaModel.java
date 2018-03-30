package com.github.javaparser.metamodel;



public class NameExprMetaModel extends ExpressionMetaModel {

    NameExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.NameExpr.class, "NameExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel namePropertyMetaModel;
}
