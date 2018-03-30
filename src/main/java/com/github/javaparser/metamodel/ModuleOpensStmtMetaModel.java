package com.github.javaparser.metamodel;



public class ModuleOpensStmtMetaModel extends ModuleStmtMetaModel {

    ModuleOpensStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleOpensStmt.class, "ModuleOpensStmt", "com.github.javaparser.ast.modules", false, false);
    }

    public PropertyMetaModel moduleNamesPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
