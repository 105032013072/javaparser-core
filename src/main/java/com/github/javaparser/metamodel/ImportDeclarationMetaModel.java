package com.github.javaparser.metamodel;



public class ImportDeclarationMetaModel extends NodeMetaModel {

    ImportDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.ImportDeclaration.class, "ImportDeclaration", "com.github.javaparser.ast", false, false);
    }

    public PropertyMetaModel isAsteriskPropertyMetaModel;

    public PropertyMetaModel isStaticPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
