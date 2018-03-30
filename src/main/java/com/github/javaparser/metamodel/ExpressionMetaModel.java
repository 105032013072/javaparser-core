package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class ExpressionMetaModel extends NodeMetaModel {

    ExpressionMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.Expression.class, "Expression", "com.github.javaparser.ast.expr", true, false);
    }

    protected ExpressionMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }
}
