package com.github.javaparser.metamodel;



public class AnnotationDeclarationMetaModel extends TypeDeclarationMetaModel {

    AnnotationDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.body.AnnotationDeclaration.class, "AnnotationDeclaration", "com.github.javaparser.ast.body", false, false);
    }
}
