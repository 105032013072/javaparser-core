package com.github.javaparser.metamodel;



public class AssertStmtMetaModel extends StatementMetaModel {

    AssertStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.AssertStmt.class, "AssertStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel checkPropertyMetaModel;

    public PropertyMetaModel messagePropertyMetaModel;
}
