package com.github.javaparser.metamodel;



public class VariableDeclaratorMetaModel extends NodeMetaModel {

    VariableDeclaratorMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.VariableDeclarator.class, "VariableDeclarator", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel initializerPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel typePropertyMetaModel;
}
