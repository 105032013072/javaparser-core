package com.github.javaparser.metamodel;



public class LocalClassDeclarationStmtMetaModel extends StatementMetaModel {

    LocalClassDeclarationStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.LocalClassDeclarationStmt.class, "LocalClassDeclarationStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel classDeclarationPropertyMetaModel;
}
