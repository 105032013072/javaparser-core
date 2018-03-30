package com.github.javaparser.metamodel;



public class SwitchStmtMetaModel extends StatementMetaModel {

    SwitchStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.SwitchStmt.class, "SwitchStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel entriesPropertyMetaModel;

    public PropertyMetaModel selectorPropertyMetaModel;
}
