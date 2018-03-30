package com.github.javaparser.metamodel;



public class TypeExprMetaModel extends ExpressionMetaModel {

    TypeExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.TypeExpr.class, "TypeExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel typePropertyMetaModel;
}
