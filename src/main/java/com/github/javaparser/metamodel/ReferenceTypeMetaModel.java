package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class ReferenceTypeMetaModel extends TypeMetaModel {

    ReferenceTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.ReferenceType.class, "ReferenceType", "com.github.javaparser.ast.type", true, false);
    }

    protected ReferenceTypeMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }
}
