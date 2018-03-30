package com.github.javaparser.metamodel;



public class VoidTypeMetaModel extends TypeMetaModel {

    VoidTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.VoidType.class, "VoidType", "com.github.javaparser.ast.type", false, false);
    }
}
