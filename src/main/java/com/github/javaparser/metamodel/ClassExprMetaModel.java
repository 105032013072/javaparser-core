package com.github.javaparser.metamodel;



public class ClassExprMetaModel extends ExpressionMetaModel {

    ClassExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.ClassExpr.class, "ClassExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel typePropertyMetaModel;
}
