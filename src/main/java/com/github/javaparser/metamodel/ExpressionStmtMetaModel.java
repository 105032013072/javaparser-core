package com.github.javaparser.metamodel;



public class ExpressionStmtMetaModel extends StatementMetaModel {

    ExpressionStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.ExpressionStmt.class, "ExpressionStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel expressionPropertyMetaModel;
}
