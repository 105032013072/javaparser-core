package com.github.javaparser.metamodel;



public class ReturnStmtMetaModel extends StatementMetaModel {

    ReturnStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.ReturnStmt.class, "ReturnStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel expressionPropertyMetaModel;
}
