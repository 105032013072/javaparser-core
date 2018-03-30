package com.github.javaparser.metamodel;



public class ClassOrInterfaceTypeMetaModel extends ReferenceTypeMetaModel {

    ClassOrInterfaceTypeMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.ClassOrInterfaceType.class, "ClassOrInterfaceType", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel scopePropertyMetaModel;

    public PropertyMetaModel typeArgumentsPropertyMetaModel;

    public PropertyMetaModel usingDiamondOperatorPropertyMetaModel;
}
