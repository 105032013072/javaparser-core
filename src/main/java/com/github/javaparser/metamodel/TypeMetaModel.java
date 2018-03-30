package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class TypeMetaModel extends NodeMetaModel {

    TypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.Type.class, "Type", "com.github.javaparser.ast.type", true, false);
    }

    protected TypeMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;
}
