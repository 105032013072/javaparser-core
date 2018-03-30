package com.github.javaparser.metamodel;



public class IntersectionTypeMetaModel extends TypeMetaModel {

    IntersectionTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.IntersectionType.class, "IntersectionType", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel elementsPropertyMetaModel;
}
