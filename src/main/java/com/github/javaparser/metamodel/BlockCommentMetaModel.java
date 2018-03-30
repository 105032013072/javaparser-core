package com.github.javaparser.metamodel;



public class BlockCommentMetaModel extends CommentMetaModel {

    BlockCommentMetaModel(BaseNodeMetaModel superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.comments.BlockComment.class, "BlockComment", "com.github.javaparser.ast.comments", false, false);
    }
}
