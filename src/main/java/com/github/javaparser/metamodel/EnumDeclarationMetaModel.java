package com.github.javaparser.metamodel;



public class EnumDeclarationMetaModel extends TypeDeclarationMetaModel {

    EnumDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.EnumDeclaration.class, "EnumDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel entriesPropertyMetaModel;

    public PropertyMetaModel implementedTypesPropertyMetaModel;
}
