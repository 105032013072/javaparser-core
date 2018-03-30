package com.github.javaparser.metamodel;



public class EmptyStmtMetaModel extends StatementMetaModel {

    EmptyStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.EmptyStmt.class, "EmptyStmt", "com.github.javaparser.ast.stmt", false, false);
    }
}
