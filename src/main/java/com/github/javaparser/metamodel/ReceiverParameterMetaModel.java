package com.github.javaparser.metamodel;



public class ReceiverParameterMetaModel extends NodeMetaModel {

    ReceiverParameterMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.ReceiverParameter.class, "ReceiverParameter", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel typePropertyMetaModel;
}
