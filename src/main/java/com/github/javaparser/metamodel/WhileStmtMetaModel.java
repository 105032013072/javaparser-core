package com.github.javaparser.metamodel;



public class WhileStmtMetaModel extends StatementMetaModel {

    WhileStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.WhileStmt.class, "WhileStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel conditionPropertyMetaModel;
}
