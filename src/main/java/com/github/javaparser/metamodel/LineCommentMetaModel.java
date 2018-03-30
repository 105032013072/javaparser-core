package com.github.javaparser.metamodel;



public class LineCommentMetaModel extends CommentMetaModel {

    LineCommentMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.comments.LineComment.class, "LineComment", "com.github.javaparser.ast.comments", false, false);
    }
}
