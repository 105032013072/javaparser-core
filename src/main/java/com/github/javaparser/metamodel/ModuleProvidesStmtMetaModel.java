package com.github.javaparser.metamodel;



public class ModuleProvidesStmtMetaModel extends ModuleStmtMetaModel {

    ModuleProvidesStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleProvidesStmt.class, "ModuleProvidesStmt", "com.github.javaparser.ast.modules", false, false);
    }

    public PropertyMetaModel typePropertyMetaModel;

    public PropertyMetaModel withTypesPropertyMetaModel;
}
