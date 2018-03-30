package com.github.javaparser.metamodel;



public class SynchronizedStmtMetaModel extends StatementMetaModel {

    SynchronizedStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.SynchronizedStmt.class, "SynchronizedStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel expressionPropertyMetaModel;
}
