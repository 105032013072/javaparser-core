package com.github.javaparser.metamodel;



public class MethodDeclarationMetaModel extends CallableDeclarationMetaModel {

    MethodDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.MethodDeclaration.class, "MethodDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel typePropertyMetaModel;
}
