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
package com.github.javaparser.ast.visitor;

import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.modules.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import javax.annotation.Generated;

/**
 * A visitor that returns nothing, and has a default implementation for all its visit
 * methods that simply visit their children in an unspecified order.
 *
 * @author Julio Vilmar Gesser
 */
public abstract class VoidVisitorAdapter<A> implements VoidVisitor<A> {

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final AnnotationDeclaration n, final A arg) {
      for (BodyDeclaration<?> p : n.getMembers()) {
    	  p.accept(this, arg);
	 }
      n.getName().accept(this, arg);	
    	for (AnnotationExpr p : n.getAnnotations()) {
    		p.accept(this, arg);
		}
    	
    	Comment c=	n.getCommentOptional();
    	if(c!=null){
    		c.accept(this, arg);
    	}
    	/* n.getMembers().forEach(p -> p.accept(this, arg));
        n.getName().accept(this, arg);
        n.getAnnotations().forEach(p -> p.accept(this, arg));
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }*/
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final AnnotationMemberDeclaration n, final A arg) {
       
    	Expression ep=n.getDefaultValue();
    	if(ep!=null){
    		ep.accept(this, arg);
    	}
    	n.getName().accept(this, arg);
        n.getType().accept(this, arg);
    	
    	for (AnnotationExpr p : n.getAnnotations()) {
    		p.accept(this, arg);
		}
    	
    	Comment c=n.getCommentOptional();
    	if(c!=null){
    		c.accept(this, arg);
    	}
    	/*n.getDefaultValue().ifPresent(l -> l.accept(this, arg));
        n.getName().accept(this, arg);
        n.getType().accept(this, arg);
        n.getAnnotations().forEach(p -> p.accept(this, arg));
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }*/
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ArrayAccessExpr n, final A arg) {
        n.getIndex().accept(this, arg);
        n.getName().accept(this, arg);
      
        Comment c=  n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ArrayCreationExpr n, final A arg) {
        n.getElementType().accept(this, arg);
       
        
        if(n.getInitializer()!=null){
        	n.getInitializer().accept(this, arg);
        }
        
        for (ArrayCreationLevel a : n.getLevels()) {
        	a.accept(this, arg);
		}
        
        Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
        
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ArrayInitializerExpr n, final A arg) {
      
    	
    	for (Expression e : n.getValues()) {
    		e.accept(this, arg);
		}
    	
    	Comment c=n.getCommentOptional();
    	if(c!=null){
    		c.accept(this, arg);
    	}
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final AssertStmt n, final A arg) {
     
        
        Expression e= n.getMessage();
        if(e!=null){
        	e.accept(this, arg);
        }
        
        Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
        
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final AssignExpr n, final A arg) {
        n.getTarget().accept(this, arg);
        n.getValue().accept(this, arg);
        
        Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final BinaryExpr n, final A arg) {
        n.getLeft().accept(this, arg);
        n.getRight().accept(this, arg);
        
        Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final BlockComment n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final BlockStmt n, final A arg) {
        //n.getStatements().forEach(p -> p.accept(this, arg));
        for (Statement s : n.getStatements()) {
        	s.accept(this, arg);
		}
        
        
        Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final BooleanLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final BreakStmt n, final A arg) {
        //n.getLabel().ifPresent(l -> l.accept(this, arg));
    	SimpleName l=n.getLabel();
    	if(l!=null){
    		l.accept(this, arg);
    	}
    	
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final CastExpr n, final A arg) {
        n.getExpression().accept(this, arg);
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final CatchClause n, final A arg) {
        n.getBody().accept(this, arg);
        n.getParameter().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final CharLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ClassExpr n, final A arg) {
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ClassOrInterfaceDeclaration n, final A arg) {
       // n.getExtendedTypes().forEach(p -> p.accept(this, arg));
       for (ClassOrInterfaceType p : n.getExtendedTypes()) {
    	   p.accept(this, arg);
	}
    	
    	
    	//n.getImplementedTypes().forEach(p -> p.accept(this, arg));
       for (ClassOrInterfaceType p : n.getImplementedTypes()) {
    	   p.accept(this, arg);
	}
       
       
       // n.getTypeParameters().forEach(p -> p.accept(this, arg));
        for (TypeParameter p : n.getTypeParameters()) {
        	p.accept(this, arg);
		}
       
        //n.getMembers().forEach(p -> p.accept(this, arg));
        for (BodyDeclaration<?> p : n.getMembers()) {
        	p.accept(this, arg);
		}
       n.getName().accept(this, arg);
      
       
       // n.getAnnotations().forEach(p -> p.accept(this, arg));
       for (AnnotationExpr an : n.getAnnotations()) {
    	   an.accept(this, arg);
	}
       
       Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ClassOrInterfaceType n, final A arg) {
        n.getName().accept(this, arg);
       // n.getScope().ifPresent(l -> l.accept(this, arg));
        ClassOrInterfaceType ci= n.getScope();
        if(ci!=null){
        	ci.accept(this, arg);
        }
        
        //n.getTypeArguments().ifPresent(l -> l.forEach(v -> v.accept(this, arg)));
        NodeList<Type> list=  n.getTypeArguments();
        if(list!=null){
        	for (Type type : list) {
        		type.accept(this, arg);
			}
        }
        
        //n.getAnnotations().forEach(p -> p.accept(this, arg));
        for (AnnotationExpr an : n.getAnnotations()) {
        	an.accept(this, arg);
		}
       
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final CompilationUnit n, final A arg) {
        //n.getImports().forEach(p -> p.accept(this, arg));
        for (ImportDeclaration i : n.getImports()) {
        	i.accept(this, arg);
		}
    	
        ModuleDeclaration m= n.getModule();
        if(m!=null){
        	m.accept(this, arg);
        }
        
       // n.getPackageDeclarationOptional().ifPresent(l -> l.accept(this, arg));
        PackageDeclaration p=  n.getPackageDeclarationOptional();
        if(p!=null){
        	p.accept(this, arg);
        }
       // n.getTypes().forEach(p -> p.accept(this, arg));
        for (TypeDeclaration<?> t : n.getTypes()) {
        	t.accept(this, arg);
		}
      
        Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ConditionalExpr n, final A arg) {
        n.getCondition().accept(this, arg);
        n.getElseExpr().accept(this, arg);
        n.getThenExpr().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ConstructorDeclaration n, final A arg) {
        n.getBody().accept(this, arg);
        n.getName().accept(this, arg);
        //n.getParameters().forEach(p -> p.accept(this, arg));
       for (Parameter p : n.getParameters()) {
    	   p.accept(this, arg);
	   }
        
        //n.getReceiverParameter().ifPresent(l -> l.accept(this, arg));
       ReceiverParameter r= n.getReceiverParameter();
       if(r!=null){
    	   r.accept(this, arg);
       }
       
        //n.getThrownExceptions().forEach(p -> p.accept(this, arg));
       for (ReferenceType re : n.getThrownExceptions()) {
    	   re.accept(this, arg);
	}
       
       // n.getTypeParameters().forEach(p -> p.accept(this, arg));
       
       for (TypeParameter ty : n.getTypeParameters()) {
    	   ty.accept(this, arg);
	}
       
       // n.getAnnotations().forEach(p -> p.accept(this, arg));
       
       for (AnnotationExpr an : n.getAnnotations()) {
    	   an.accept(this, arg);
	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ContinueStmt n, final A arg) {
       // n.getLabel().ifPresent(l -> l.accept(this, arg));
    	SimpleName l=n.getLabel();
    	if(l!=null){
    		l.accept(this, arg);
    	}
    	
    	
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final DoStmt n, final A arg) {
        n.getBody().accept(this, arg);
        n.getCondition().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final DoubleLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final EmptyStmt n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final EnclosedExpr n, final A arg) {
        n.getInner().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final EnumConstantDeclaration n, final A arg) {
        //n.getArguments().forEach(p -> p.accept(this, arg));
    	for (Expression ep : n.getArguments()) {
    		ep.accept(this, arg);
		}
    	
       // n.getClassBody().forEach(p -> p.accept(this, arg));
    	for (BodyDeclaration<?> b : n.getClassBody()) {
    		b.accept(this, arg);
		}
    	
        n.getName().accept(this, arg);
        //n.getAnnotations().forEach(p -> p.accept(this, arg));
        for (AnnotationExpr an: n.getAnnotations()) {
        	an.accept(this, arg);
		}
        
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final EnumDeclaration n, final A arg) {
        //n.getEntries().forEach(p -> p.accept(this, arg));
        for (EnumConstantDeclaration en : n.getEntries()) {
        	en.accept(this, arg);
		}
    	//n.getImplementedTypes().forEach(p -> p.accept(this, arg));
        for (ClassOrInterfaceType c : n.getImplementedTypes()) {
        	c.accept(this, arg);
		}
        //n.getMembers().forEach(p -> p.accept(this, arg));
        for (BodyDeclaration<?> b : n.getMembers()) {
        	b.accept(this, arg);
		}
        n.getName().accept(this, arg);
        //n.getAnnotations().forEach(p -> p.accept(this, arg));
        for (AnnotationExpr an : n.getAnnotations()) {
        	an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ExplicitConstructorInvocationStmt n, final A arg) {
       // n.getArguments().forEach(p -> p.accept(this, arg));
    	for (Expression ep : n.getArguments()) {
    		ep.accept(this, arg);
		}
       // n.getExpression().ifPresent(l -> l.accept(this, arg));
    	if(n.getExpression()!=null){
    		n.getExpression().accept(this, arg);
    	}
    
        //n.getTypeArguments().ifPresent(l -> l.forEach(v -> v.accept(this, arg)));
    	if(n.getTypeArguments()!=null){
    		for (Type t : n.getTypeArguments()) {
    			t.accept(this, arg);
			}
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ExpressionStmt n, final A arg) {
        n.getExpression().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final FieldAccessExpr n, final A arg) {
        n.getName().accept(this, arg);
        n.getScope().accept(this, arg);
        if(n.getTypeArguments()!=null){
    		for (Type t : n.getTypeArguments()) {
    			t.accept(this, arg);
			}
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final FieldDeclaration n, final A arg) {
        //n.getVariables().forEach(p -> p.accept(this, arg));
    	for (VariableDeclarator v : n.getVariables()) {
    		v.accept(this, arg);
		}
       // n.getAnnotations().forEach(p -> p.accept(this, arg));
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ForeachStmt n, final A arg) {
        n.getBody().accept(this, arg);
        n.getIterable().accept(this, arg);
        n.getVariable().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ForStmt n, final A arg) {
        n.getBody().accept(this, arg);
       // n.getCompare().ifPresent(l -> l.accept(this, arg));
        if(n.getCompare()!=null){
        	n.getCompare().accept(this, arg);
        }
        //n.getInitialization().forEach(p -> p.accept(this, arg));
        for (Expression ep : n.getInitialization()) {
        	ep.accept(this, arg);
		}
       // n.getUpdate().forEach(p -> p.accept(this, arg));
        for (Expression ep : n.getUpdate()) {
        	ep.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final IfStmt n, final A arg) {
        n.getCondition().accept(this, arg);
        //n.getElseStmt().ifPresent(l -> l.accept(this, arg));
        if(n.getElseStmt()!=null){
        	n.getElseStmt().accept(this, arg);
        }
        n.getThenStmt().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final InitializerDeclaration n, final A arg) {
        n.getBody().accept(this, arg);
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final InstanceOfExpr n, final A arg) {
        n.getExpression().accept(this, arg);
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final IntegerLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final JavadocComment n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final LabeledStmt n, final A arg) {
        n.getLabel().accept(this, arg);
        n.getStatement().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final LineComment n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final LongLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final MarkerAnnotationExpr n, final A arg) {
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final MemberValuePair n, final A arg) {
        n.getName().accept(this, arg);
        n.getValue().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final MethodCallExpr n, final A arg) {
    	for (Expression ep : n.getArguments()) {
    		ep.accept(this, arg);
		}
        n.getName().accept(this, arg);
       // n.getScope().ifPresent(l -> l.accept(this, arg));
        if(n.getScope()!=null){
        	n.getScope().accept(this, arg);
        }
        if(n.getTypeArguments()!=null){
    		for (Type t : n.getTypeArguments()) {
    			t.accept(this, arg);
			}
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final MethodDeclaration n, final A arg) {
       // n.getOptionalBody().ifPresent(l -> l.accept(this, arg));
    	if(n.getOptionalBody()!=null){
    		n.getOptionalBody().accept(this, arg);
    	}
        n.getType().accept(this, arg);
        n.getName().accept(this, arg);
       // n.getParameters().forEach(p -> p.accept(this, arg));
        for (Parameter p : n.getParameters()) {
        	p.accept(this, arg);
		}
       // n.getReceiverParameter().ifPresent(l -> l.accept(this, arg));
        if(n.getReceiverParameter()!=null){
        	n.getReceiverParameter().accept(this, arg);
        }
       // n.getThrownExceptions().forEach(p -> p.accept(this, arg));
        for (ReferenceType rf : n.getThrownExceptions()) {
        	 rf.accept(this, arg);
		}
       // n.getTypeParameters().forEach(p -> p.accept(this, arg));
        for (TypeParameter ty : n.getTypeParameters()) {
        	ty.accept(this, arg);
		}
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final NameExpr n, final A arg) {
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final NormalAnnotationExpr n, final A arg) {
       // n.getPairs().forEach(p -> p.accept(this, arg));
    	for (MemberValuePair m : n.getPairs()) {
    		m.accept(this, arg);
		}
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final NullLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ObjectCreationExpr n, final A arg) {
       // n.getAnonymousClassBody().ifPresent(l -> l.forEach(v -> v.accept(this, arg)));
    	if(n.getAnonymousClassBody()!=null){
    		n.getAnonymousClassBody().accept(this, arg);
    	}
        for (Expression ep : n.getArguments()) {
    		ep.accept(this, arg);
		}
        //n.getScope().ifPresent(l -> l.accept(this, arg));
        if(n.getScope()!=null){
        	n.getScope().accept(this, arg);
        }
        n.getType().accept(this, arg);
        if(n.getTypeArguments()!=null){
    		for (Type t : n.getTypeArguments()) {
    			t.accept(this, arg);
			}
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final PackageDeclaration n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final Parameter n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
        n.getName().accept(this, arg);
        n.getType().accept(this, arg);
       // n.getVarArgsAnnotations().forEach(p -> p.accept(this, arg));
        for (AnnotationExpr an : n.getVarArgsAnnotations()) {
        	an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final PrimitiveType n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final Name n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
       // n.getQualifier().ifPresent(l -> l.accept(this, arg));
    	if(n.getQualifier()!=null){
    		n.getQualifier().accept(this, arg);
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final SimpleName n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ArrayType n, final A arg) {
        n.getComponentType().accept(this, arg);
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ArrayCreationLevel n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
        //n.getDimension().ifPresent(l -> l.accept(this, arg));
    	if(n.getDimension()!=null){
    		n.getDimension().accept(this, arg);
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final IntersectionType n, final A arg) {
       //n.getElements().forEach(p -> p.accept(this, arg));
    	for (ReferenceType rf : n.getElements()) {
    		rf.accept(this, arg);
		}
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final UnionType n, final A arg) {
       // n.getElements().forEach(p -> p.accept(this, arg));
    	for (ReferenceType r : n.getElements()) {
    		r.accept(this, arg);
		}
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ReturnStmt n, final A arg) {
        //n.getExpression().ifPresent(l -> l.accept(this, arg));
        if(n.getExpression()!=null){
        	n.getExpression().accept(this, arg);
        }
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final SingleMemberAnnotationExpr n, final A arg) {
        n.getMemberValue().accept(this, arg);
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final StringLiteralExpr n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final SuperExpr n, final A arg) {
        //n.getClassExpr().ifPresent(l -> l.accept(this, arg));
    	if(n.getClassExpr()!=null){
    		n.getClassExpr().accept(this, arg);
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final SwitchEntryStmt n, final A arg) {
        //n.getLabel().ifPresent(l -> l.accept(this, arg));
        for (Statement s : n.getStatements()) {
        	s.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final SwitchStmt n, final A arg) {
       // n.getEntries().forEach(p -> p.accept(this, arg));
    	for (SwitchEntryStmt s : n.getEntries()) {
    		s.accept(this, arg);
		}
        n.getSelector().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final SynchronizedStmt n, final A arg) {
        n.getBody().accept(this, arg);
        n.getExpression().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ThisExpr n, final A arg) {
       // n.getClassExpr().ifPresent(l -> l.accept(this, arg));
    	if(n.getClassExpr()!=null){
    		n.getClassExpr().accept(this, arg);
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ThrowStmt n, final A arg) {
        n.getExpression().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final TryStmt n, final A arg) {
       // n.getCatchClauses().forEach(p -> p.accept(this, arg));
    	for (CatchClause c : n.getCatchClauses()) {
    		c.accept(this, arg);
		}
        //n.getFinallyBlock().ifPresent(l -> l.accept(this, arg));
    	if(n.getFinallyBlock()!=null){
    		n.getFinallyBlock().accept(this, arg);
    	}
        //n.getResources().forEach(p -> p.accept(this, arg));
    	for (Expression ep : n.getResources()) {
    		ep.accept(this, arg);
		}
        n.getTryBlock().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final LocalClassDeclarationStmt n, final A arg) {
        n.getClassDeclaration().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final TypeParameter n, final A arg) {
        n.getName().accept(this, arg);
       // n.getTypeBound().forEach(p -> p.accept(this, arg));
        for (ClassOrInterfaceType c : n.getTypeBound()) {
        	c.accept(this, arg);
		}
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final UnaryExpr n, final A arg) {
        n.getExpression().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final UnknownType n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final VariableDeclarationExpr n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
       // n.getVariables().forEach(p -> p.accept(this, arg));
    	for (VariableDeclarator p : n.getVariables()) {
    		p.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final VariableDeclarator n, final A arg) {
       // n.getInitializer().ifPresent(l -> l.accept(this, arg));
    	if(n.getInitializer()!=null){
    		n.getInitializer().accept(this, arg);
    	}
        n.getName().accept(this, arg);
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final VoidType n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final WhileStmt n, final A arg) {
        n.getBody().accept(this, arg);
        n.getCondition().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final WildcardType n, final A arg) {
       // n.getExtendedType().ifPresent(l -> l.accept(this, arg));
    	if(n.getExtendedType()!=null){
    		n.getExtendedType().accept(this, arg);
    	}
       // n.getSuperType().ifPresent(l -> l.accept(this, arg));
    	if(n.getSuperType()!=null){
    		n.getSuperType().accept(this, arg);
    	}
        for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final LambdaExpr n, final A arg) {
        n.getBody().accept(this, arg);
        //n.getParameters().forEach(p -> p.accept(this, arg));
        for (Parameter p : n.getParameters()) {
        	p.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final MethodReferenceExpr n, final A arg) {
        n.getScope().accept(this, arg);
        if(n.getTypeArguments()!=null){
    		for (Type t : n.getTypeArguments()) {
    			t.accept(this, arg);
			}
    	}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final TypeExpr n, final A arg) {
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    public void visit(NodeList n, A arg) {
        for (Object node : n) {
            ((Node) node).accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ImportDeclaration n, final A arg) {
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ModuleDeclaration n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
       // n.getModuleStmts().forEach(p -> p.accept(this, arg));
    	for (ModuleStmt p : n.getModuleStmts()) {
    		p.accept(this, arg);
		}
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ModuleRequiresStmt n, final A arg) {
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ModuleExportsStmt n, final A arg) {
       // n.getModuleNames().forEach(p -> p.accept(this, arg));
    	for (Name p : n.getModuleNames()) {
    		p.accept(this, arg);
		}
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ModuleProvidesStmt n, final A arg) {
        n.getType().accept(this, arg);
      //  n.getWithTypes().forEach(p -> p.accept(this, arg));
        for (Type p : n.getWithTypes()) {
        	p.accept(this, arg);
		}
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ModuleUsesStmt n, final A arg) {
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ModuleOpensStmt n, final A arg) {
        //n.getModuleNames().forEach(p -> p.accept(this, arg));
    	for (Name p : n.getModuleNames()) {
    		p.accept(this, arg);
		}
        n.getName().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final UnparsableStmt n, final A arg) {
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.visitor.VoidVisitorAdapterGenerator")
    public void visit(final ReceiverParameter n, final A arg) {
    	for (AnnotationExpr an : n.getAnnotations()) {
    		an.accept(this, arg);
		}
        n.getName().accept(this, arg);
        n.getType().accept(this, arg);
         Comment c= n.getCommentOptional();
        if(c!=null){
        	c.accept(this, arg);
        }
    }
}
