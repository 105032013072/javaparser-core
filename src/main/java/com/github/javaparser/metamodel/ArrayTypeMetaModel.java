package com.github.javaparser.metamodel;



public class ArrayTypeMetaModel extends ReferenceTypeMetaModel {

    ArrayTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.ArrayType.class, "ArrayType", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel componentTypePropertyMetaModel;

    public PropertyMetaModel originPropertyMetaModel;
}
