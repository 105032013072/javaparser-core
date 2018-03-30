package com.github.javaparser.metamodel;



public class ArrayCreationLevelMetaModel extends NodeMetaModel {

    ArrayCreationLevelMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.ArrayCreationLevel.class, "ArrayCreationLevel", "com.github.javaparser.ast", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel dimensionPropertyMetaModel;
}
