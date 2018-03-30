package com.github.javaparser.metamodel;



public class EnumConstantDeclarationMetaModel extends BodyDeclarationMetaModel {

    EnumConstantDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.EnumConstantDeclaration.class, "EnumConstantDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel argumentsPropertyMetaModel;

    public PropertyMetaModel classBodyPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
