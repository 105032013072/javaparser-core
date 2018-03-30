package com.github.javaparser.metamodel;


import com.github.javaparser.ast.Node;

public class ModuleStmtMetaModel extends NodeMetaModel {

    ModuleStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleStmt.class, "ModuleStmt", "com.github.javaparser.ast.modules", true, false);
    }

    protected ModuleStmtMetaModel(BaseNodeMetaModel superNodeMetaModel, Class<? extends Node> type, String name, String packageName, boolean isAbstract, boolean hasWildcard) {
        super(superNodeMetaModel, type, name, packageName, isAbstract, hasWildcard);
    }
}
