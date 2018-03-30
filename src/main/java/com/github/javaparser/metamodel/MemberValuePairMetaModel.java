package com.github.javaparser.metamodel;



public class MemberValuePairMetaModel extends NodeMetaModel {

    MemberValuePairMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.MemberValuePair.class, "MemberValuePair", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel valuePropertyMetaModel;
}
