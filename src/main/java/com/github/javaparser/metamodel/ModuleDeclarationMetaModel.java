package com.github.javaparser.metamodel;



public class ModuleDeclarationMetaModel extends NodeMetaModel {

    ModuleDeclarationMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.modules.ModuleDeclaration.class, "ModuleDeclaration", "com.github.javaparser.ast.modules", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel isOpenPropertyMetaModel;

    public PropertyMetaModel moduleStmtsPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;
}
