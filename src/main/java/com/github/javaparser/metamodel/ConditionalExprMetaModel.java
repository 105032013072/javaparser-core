package com.github.javaparser.metamodel;



public class ConditionalExprMetaModel extends ExpressionMetaModel {

    ConditionalExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.ConditionalExpr.class, "ConditionalExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel conditionPropertyMetaModel;

    public PropertyMetaModel elseExprPropertyMetaModel;

    public PropertyMetaModel thenExprPropertyMetaModel;
}
