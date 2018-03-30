package com.github.javaparser.metamodel;



public class IfStmtMetaModel extends StatementMetaModel {

    IfStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.IfStmt.class, "IfStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel conditionPropertyMetaModel;

    public PropertyMetaModel elseStmtPropertyMetaModel;

    public PropertyMetaModel thenStmtPropertyMetaModel;

    public PropertyMetaModel cascadingIfStmtPropertyMetaModel;

    public PropertyMetaModel elseBlockPropertyMetaModel;

    public PropertyMetaModel elseBranchPropertyMetaModel;

    public PropertyMetaModel thenBlockPropertyMetaModel;
}
