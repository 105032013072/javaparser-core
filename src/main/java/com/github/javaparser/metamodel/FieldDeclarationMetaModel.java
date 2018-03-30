package com.github.javaparser.metamodel;



public class FieldDeclarationMetaModel extends BodyDeclarationMetaModel {

    FieldDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.FieldDeclaration.class, "FieldDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel modifiersPropertyMetaModel;

    public PropertyMetaModel variablesPropertyMetaModel;

    public PropertyMetaModel maximumCommonTypePropertyMetaModel;
}
