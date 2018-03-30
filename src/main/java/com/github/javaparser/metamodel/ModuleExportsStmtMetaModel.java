package com.github.javaparser.metamodel;



public class ModuleExportsStmtMetaModel extends ModuleStmtMetaModel {

    ModuleExportsStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleExportsStmt.class, "ModuleExportsStmt", "com.github.javaparser.ast.modules", false, false);
    }

    public PropertyMetaModel moduleNamesPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
