package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class BodyDeclarationMetaModel extends NodeMetaModel {

    BodyDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.BodyDeclaration.class, "BodyDeclaration", "com.github.javaparser.ast.body", true, true);
    }

    protected BodyDeclarationMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;
}
