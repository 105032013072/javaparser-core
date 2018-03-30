package com.github.javaparser.metamodel;



public class ArrayInitializerExprMetaModel extends ExpressionMetaModel {

    ArrayInitializerExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.ArrayInitializerExpr.class, "ArrayInitializerExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel valuesPropertyMetaModel;
}
