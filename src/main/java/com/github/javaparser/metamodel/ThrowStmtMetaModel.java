package com.github.javaparser.metamodel;



public class ThrowStmtMetaModel extends StatementMetaModel {

    ThrowStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.ThrowStmt.class, "ThrowStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel expressionPropertyMetaModel;
}
