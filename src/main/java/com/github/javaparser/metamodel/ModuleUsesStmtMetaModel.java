package com.github.javaparser.metamodel;



public class ModuleUsesStmtMetaModel extends ModuleStmtMetaModel {

    ModuleUsesStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleUsesStmt.class, "ModuleUsesStmt", "com.github.javaparser.ast.modules", false, false);
    }

    public PropertyMetaModel typePropertyMetaModel;
}
