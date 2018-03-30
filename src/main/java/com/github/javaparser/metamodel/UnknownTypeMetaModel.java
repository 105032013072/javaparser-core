package com.github.javaparser.metamodel;



public class UnknownTypeMetaModel extends TypeMetaModel {

    UnknownTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.UnknownType.class, "UnknownType", "com.github.javaparser.ast.type", false, false);
    }
}
