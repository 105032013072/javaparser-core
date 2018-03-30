package com.github.javaparser.metamodel;



public class UnaryExprMetaModel extends ExpressionMetaModel {

    UnaryExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.UnaryExpr.class, "UnaryExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel expressionPropertyMetaModel;

    public PropertyMetaModel operatorPropertyMetaModel;

    public PropertyMetaModel postfixPropertyMetaModel;

    public PropertyMetaModel prefixPropertyMetaModel;
}
