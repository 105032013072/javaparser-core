package com.github.javaparser.metamodel;



public class ModuleRequiresStmtMetaModel extends ModuleStmtMetaModel {

    ModuleRequiresStmtMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleRequiresStmt.class, "ModuleRequiresStmt", "com.github.javaparser.ast.modules", false, false);
    }

    public PropertyMetaModel modifiersPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
