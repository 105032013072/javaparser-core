package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class StatementMetaModel extends NodeMetaModel {

    StatementMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.Statement.class, "Statement", "com.github.javaparser.ast.stmt", true, false);
    }

    protected StatementMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }
}
