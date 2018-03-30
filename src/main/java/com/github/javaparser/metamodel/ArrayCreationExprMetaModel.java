package com.github.javaparser.metamodel;



public class ArrayCreationExprMetaModel extends ExpressionMetaModel {

    ArrayCreationExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.ArrayCreationExpr.class, "ArrayCreationExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel elementTypePropertyMetaModel;

    public PropertyMetaModel initializerPropertyMetaModel;

    public PropertyMetaModel levelsPropertyMetaModel;
}
