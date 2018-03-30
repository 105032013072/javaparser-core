package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class CallableDeclarationMetaModel extends BodyDeclarationMetaModel {

    CallableDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.CallableDeclaration.class, "CallableDeclaration", "com.github.javaparser.ast.body", true, true);
    }

    protected CallableDeclarationMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }

    public PropertyMetaModel modifiersPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel parametersPropertyMetaModel;

    public PropertyMetaModel receiverParameterPropertyMetaModel;

    public PropertyMetaModel thrownExceptionsPropertyMetaModel;

    public PropertyMetaModel typeParametersPropertyMetaModel;
}
