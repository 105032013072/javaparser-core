package com.github.javaparser.metamodel;



public class ConstructorDeclarationMetaModel extends CallableDeclarationMetaModel {

    ConstructorDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.ConstructorDeclaration.class, "ConstructorDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;
}
