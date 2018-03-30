package com.github.javaparser.metamodel;



public class JavadocCommentMetaModel extends CommentMetaModel {

    JavadocCommentMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.comments.JavadocComment.class, "JavadocComment", "com.github.javaparser.ast.comments", false, false);
    }
}
