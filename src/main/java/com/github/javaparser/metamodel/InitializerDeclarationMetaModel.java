package com.github.javaparser.metamodel;



public class InitializerDeclarationMetaModel extends BodyDeclarationMetaModel {

    InitializerDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.InitializerDeclaration.class, "InitializerDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel isStaticPropertyMetaModel;
}
