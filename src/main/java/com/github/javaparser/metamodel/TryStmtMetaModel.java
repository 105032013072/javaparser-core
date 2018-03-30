package com.github.javaparser.metamodel;



public class TryStmtMetaModel extends StatementMetaModel {

    TryStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.TryStmt.class, "TryStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel catchClausesPropertyMetaModel;

    public PropertyMetaModel finallyBlockPropertyMetaModel;

    public PropertyMetaModel resourcesPropertyMetaModel;

    public PropertyMetaModel tryBlockPropertyMetaModel;
}
