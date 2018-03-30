package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class NodeMetaModel extends BaseNodeMetaModel {

    NodeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.Node.class, "Node", "com.github.javaparser.ast", true, false);
    }

    protected NodeMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }

    public PropertyMetaModel commentPropertyMetaModel;
}
