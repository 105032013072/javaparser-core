package com.github.javaparser.metamodel;



public class PrimitiveTypeMetaModel extends TypeMetaModel {

    PrimitiveTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.PrimitiveType.class, "PrimitiveType", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel typePropertyMetaModel;
}
