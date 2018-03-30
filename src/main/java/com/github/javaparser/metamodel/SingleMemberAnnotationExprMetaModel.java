package com.github.javaparser.metamodel;



public class SingleMemberAnnotationExprMetaModel extends AnnotationExprMetaModel {

    SingleMemberAnnotationExprMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.SingleMemberAnnotationExpr.class, "SingleMemberAnnotationExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel memberValuePropertyMetaModel;
}
