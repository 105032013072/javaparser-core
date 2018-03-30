package com.github.javaparser.metamodel;



public class PackageDeclarationMetaModel extends NodeMetaModel {

    PackageDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.PackageDeclaration.class, "PackageDeclaration", "com.github.javaparser.ast", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
