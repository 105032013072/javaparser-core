package com.github.javaparser.metamodel;



public class ClassOrInterfaceDeclarationMetaModel extends TypeDeclarationMetaModel {

    ClassOrInterfaceDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.ClassOrInterfaceDeclaration.class, "ClassOrInterfaceDeclaration", "com.github.javaparser.ast.body", false, false);
    }

    public PropertyMetaModel extendedTypesPropertyMetaModel;

    public PropertyMetaModel implementedTypesPropertyMetaModel;

    public PropertyMetaModel isInterfacePropertyMetaModel;

    public PropertyMetaModel typeParametersPropertyMetaModel;
}
