package com.github.javaparser.metamodel;



public class TypeParameterMetaModel extends ReferenceTypeMetaModel {

    TypeParameterMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.TypeParameter.class, "TypeParameter", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel typeBoundPropertyMetaModel;
}
