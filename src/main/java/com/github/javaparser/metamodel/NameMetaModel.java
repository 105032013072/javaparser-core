package com.github.javaparser.metamodel;



public class NameMetaModel extends NodeMetaModel {

    NameMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.Name.class, "Name", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel identifierPropertyMetaModel;

    public PropertyMetaModel qualifierPropertyMetaModel;
}
