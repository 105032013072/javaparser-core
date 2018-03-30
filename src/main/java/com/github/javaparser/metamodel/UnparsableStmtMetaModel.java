package com.github.javaparser.metamodel;



public class UnparsableStmtMetaModel extends StatementMetaModel {

    UnparsableStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.UnparsableStmt.class, "UnparsableStmt", "com.github.javaparser.ast.stmt", false, false);
    }
}
