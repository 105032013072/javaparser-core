package com.github.javaparser.metamodel;



public class ForStmtMetaModel extends StatementMetaModel {

    ForStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.ForStmt.class, "ForStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel comparePropertyMetaModel;

    public PropertyMetaModel initializationPropertyMetaModel;

    public PropertyMetaModel updatePropertyMetaModel;
}
