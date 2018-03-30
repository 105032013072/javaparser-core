package com.github.javaparser.metamodel;



public class BlockStmtMetaModel extends StatementMetaModel {

    BlockStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.BlockStmt.class, "BlockStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel statementsPropertyMetaModel;
}
