package com.github.javaparser.metamodel;



public class ThisExprMetaModel extends ExpressionMetaModel {

    ThisExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.ThisExpr.class, "ThisExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel classExprPropertyMetaModel;
}
