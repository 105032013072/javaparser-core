package com.github.javaparser.metamodel;



public class CatchClauseMetaModel extends NodeMetaModel {

    CatchClauseMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.CatchClause.class, "CatchClause", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel bodyPropertyMetaModel;

    public PropertyMetaModel parameterPropertyMetaModel;
}
