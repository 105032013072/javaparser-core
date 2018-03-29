/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.javaparser.ast.body;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.nodeTypes.NodeWithBlockStmt;
import com.github.javaparser.ast.nodeTypes.NodeWithJavadoc;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.javadoc.Javadoc;

import java.util.Arrays;
import java.util.List;
import static com.github.javaparser.utils.Utils.assertNotNull;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.InitializerDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;


/**
 * A (possibly static) initializer body. "static { a=3; }" in this example: <code>class X { static { a=3; }  } </code>
 *
 * @author Julio Vilmar Gesser
 */
public final class InitializerDeclaration extends BodyDeclaration<InitializerDeclaration> implements NodeWithJavadoc<InitializerDeclaration>, NodeWithBlockStmt<InitializerDeclaration> {

    private boolean isStatic;

    private BlockStmt body;

    public InitializerDeclaration() {
        this(null, false, new BlockStmt());
    }

    @AllFieldsConstructor
    public InitializerDeclaration(boolean isStatic, BlockStmt body) {
        this(null, isStatic, body);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public InitializerDeclaration(TokenRange tokenRange, boolean isStatic, BlockStmt body) {
        super(tokenRange);
        setStatic(isStatic);
        setBody(body);
        customInitialization();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public BlockStmt getBody() {
        return body;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public boolean isStatic() {
        return isStatic;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public InitializerDeclaration setBody(final BlockStmt body) {
        assertNotNull(body);
        if (body == this.body) {
            return (InitializerDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.BODY, this.body, body);
        if (this.body != null)
            this.body.setParentNode(null);
        this.body = body;
        setAsParentNodeOf(body);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public InitializerDeclaration setStatic(final boolean isStatic) {
        if (isStatic == this.isStatic) {
            return (InitializerDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.STATIC, this.isStatic, isStatic);
        this.isStatic = isStatic;
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public InitializerDeclaration clone() {
        return (InitializerDeclaration) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public InitializerDeclarationMetaModel getMetaModel() {
        return JavaParserMetaModel.initializerDeclarationMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == body) {
            setBody((BlockStmt) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isInitializerDeclaration() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public InitializerDeclaration asInitializerDeclaration() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifInitializerDeclaration(Consumer<InitializerDeclaration> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public InitializerDeclaration toInitializerDeclaration() {
        return this;
    }
    
    
   //for  NodeWithJavadoc
 public  JavadocComment getJavadocComment() {
    	
    	Comment comment= getCommentOptional();
    	if(comment instanceof JavadocComment){
    		return (JavadocComment) comment;
    	}else return null;
    }

    /**
     * Gets the Javadoc for this node. You can set the Javadoc by calling setJavadocComment passing a Javadoc.
     *
     * @return The Javadoc for this node wrapped in an optional as it may be absent.
     */
    public   Javadoc getOptionalJavadoc() {
    	JavadocComment javadocComment=getJavadocComment();
    	if(javadocComment!=null){
    		return javadocComment.parse();
    	}else return null;
    	
    	//return getJavadocComment().map(JavadocComment::parse);
    }
    
    public  Javadoc getJavadoc() {
    	Javadoc oj=getOptionalJavadoc();
    	if(oj!=null) return oj;
    	else return null;
    }

    /**
     * Use this to store additional information to this node.
     *
     * @param comment to be set
     */
    @SuppressWarnings("unchecked")
    public  InitializerDeclaration setJavadocComment(String comment) {
        return setJavadocComment(new JavadocComment(comment));
    }

    public  InitializerDeclaration setJavadocComment(JavadocComment comment) {
        setComment(comment);
        return (InitializerDeclaration) this;
    }

    public  InitializerDeclaration setJavadocComment(String indentation, Javadoc javadoc) {
        JavadocComment comment = javadoc.toComment(indentation);
        return setJavadocComment(comment);
    }

    public  boolean removeJavaDocComment() {
        return hasJavaDocComment() && getCommentOptional().remove();
    }

    public  boolean hasJavaDocComment() {
        return getCommentOptional()!=null && getCommentOptional() instanceof JavadocComment;
    }
    
    //for NodeWithBlockStmt
    public  BlockStmt createBody() {
        BlockStmt block = new BlockStmt();
        setBody(block);
        return block;
    }
}
