package com.github.javaparser.metamodel;



public class VariableDeclarationExprMetaModel extends ExpressionMetaModel {

    VariableDeclarationExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.VariableDeclarationExpr.class, "VariableDeclarationExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel modifiersPropertyMetaModel;

    public PropertyMetaModel variablesPropertyMetaModel;

    public PropertyMetaModel maximumCommonTypePropertyMetaModel;
}
