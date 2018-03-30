package com.github.javaparser.metamodel;


public class SimpleNameMetaModel extends NodeMetaModel {

    SimpleNameMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.SimpleName.class, "SimpleName", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel identifierPropertyMetaModel;
}
