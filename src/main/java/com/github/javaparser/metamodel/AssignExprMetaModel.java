package com.github.javaparser.metamodel;



public class AssignExprMetaModel extends ExpressionMetaModel {

    AssignExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.AssignExpr.class, "AssignExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel operatorPropertyMetaModel;

    public PropertyMetaModel targetPropertyMetaModel;

    public PropertyMetaModel valuePropertyMetaModel;
}
