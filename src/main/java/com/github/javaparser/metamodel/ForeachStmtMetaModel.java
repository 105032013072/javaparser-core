package com.github.javaparser.metamodel;


public class ForeachStmtMetaModel extends StatementMetaModel {

    ForeachStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.ForeachStmt.class, "ForeachStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel iterablePropertyMetaModel;

    public PropertyMetaModel variablePropertyMetaModel;
}
