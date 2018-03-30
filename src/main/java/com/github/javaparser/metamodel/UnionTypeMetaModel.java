package com.github.javaparser.metamodel;



public class UnionTypeMetaModel extends TypeMetaModel {

    UnionTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.UnionType.class, "UnionType", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel elementsPropertyMetaModel;
}
