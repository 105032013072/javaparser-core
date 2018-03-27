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

package com.github.javaparser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;

/**
 * The start production for JavaParser.
 * Tells JavaParser what piece of Java code it can expect.
 * For example,
 * COMPILATION_UNIT indicates a complete Java file,
 * and CLASS_BODY would indicate the part of a class that is within { and }.
 *
 * @see JavaParser#parse(ParseStart, Provider)
 */

public interface ParseStart<R> {
    /*ParseStart<CompilationUnit> COMPILATION_UNIT = GeneratedJavaParser::CompilationUnit;
    ParseStart<BlockStmt> BLOCK = GeneratedJavaParser::BlockParseStart;
    ParseStart<Statement> STATEMENT = GeneratedJavaParser::BlockStatementParseStart;
    ParseStart<ImportDeclaration> IMPORT_DECLARATION = GeneratedJavaParser::ImportDeclarationParseStart;
    ParseStart<Expression> EXPRESSION = GeneratedJavaParser::ExpressionParseStart;
    ParseStart<AnnotationExpr> ANNOTATION = GeneratedJavaParser::AnnotationParseStart;
    ParseStart<BodyDeclaration<?>> ANNOTATION_BODY = GeneratedJavaParser::AnnotationBodyDeclarationParseStart;
    ParseStart<BodyDeclaration<?>> CLASS_BODY = GeneratedJavaParser::ClassOrInterfaceBodyDeclarationParseStart;
    ParseStart<ClassOrInterfaceType> CLASS_OR_INTERFACE_TYPE = GeneratedJavaParser::ClassOrInterfaceTypeParseStart;
    ParseStart<Type> TYPE = GeneratedJavaParser::ResultTypeParseStart;
    ParseStart<VariableDeclarationExpr> VARIABLE_DECLARATION_EXPR = GeneratedJavaParser::VariableDeclarationExpressionParseStart;
    ParseStart<ExplicitConstructorInvocationStmt> EXPLICIT_CONSTRUCTOR_INVOCATION_STMT = GeneratedJavaParser::ExplicitConstructorInvocationParseStart;
    ParseStart<Name> NAME = GeneratedJavaParser::NameParseStart;
    ParseStart<SimpleName> SIMPLE_NAME = GeneratedJavaParser::SimpleNameParseStart;
    ParseStart<Parameter> PARAMETER = GeneratedJavaParser::ParameterParseStart;
    ParseStart<PackageDeclaration> PACKAGE_DECLARATION = GeneratedJavaParser::PackageDeclarationParseStart;*/
	ParseStart<CompilationUnit> COMPILATION_UNIT =new ParseStart<CompilationUnit>() {
		@Override
		public CompilationUnit parse(GeneratedJavaParser parser) throws ParseException {
			return parser.CompilationUnit();
		}
	};
	
	
	ParseStart<BlockStmt> BLOCK =new ParseStart<BlockStmt>() {
		@Override
		public BlockStmt parse(GeneratedJavaParser parser) throws ParseException {
			return parser.BlockParseStart();
		}
	} ;
	
    ParseStart<Statement> STATEMENT = new ParseStart<Statement>() {

		@Override
		public Statement parse(GeneratedJavaParser parser) throws ParseException {
		
			return parser.BlockStatementParseStart();
		}
	};
    
    ParseStart<ImportDeclaration> IMPORT_DECLARATION =new  ParseStart<ImportDeclaration>() {
		@Override
		public ImportDeclaration parse(GeneratedJavaParser parser) throws ParseException {

			return parser.ImportDeclarationParseStart();
		}
    	
	};
    
    ParseStart<Expression> EXPRESSION = new ParseStart<Expression>() {
		@Override
		public Expression parse(GeneratedJavaParser parser) throws ParseException {
			return parser.ExpressionParseStart();
		}
	};
    
    ParseStart<AnnotationExpr> ANNOTATION =new  ParseStart<AnnotationExpr>() {

		@Override
		public AnnotationExpr parse(GeneratedJavaParser parser) throws ParseException {
			return parser.AnnotationParseStart();
		}
	};
    
    ParseStart<BodyDeclaration<?>> ANNOTATION_BODY =new ParseStart<BodyDeclaration<?>>() {

		@Override
		public BodyDeclaration<?> parse(GeneratedJavaParser parser) throws ParseException {
			
			return parser.AnnotationBodyDeclarationParseStart();
		}
	};
    
    ParseStart<BodyDeclaration<?>> CLASS_BODY =new ParseStart<BodyDeclaration<?>>() {

		@Override
		public BodyDeclaration<?> parse(GeneratedJavaParser parser) throws ParseException {
			
			return parser.ClassOrInterfaceBodyDeclarationParseStart();
		}
	};
    
    ParseStart<ClassOrInterfaceType> CLASS_OR_INTERFACE_TYPE =new ParseStart<ClassOrInterfaceType>() {

		@Override
		public ClassOrInterfaceType parse(GeneratedJavaParser parser) throws ParseException {
			
			return parser.ClassOrInterfaceTypeParseStart();
		}
	}; 
    
    ParseStart<Type> TYPE =new ParseStart<Type>() {

		@Override
		public Type parse(GeneratedJavaParser parser) throws ParseException {
			
			return parser.ResultTypeParseStart();
		}
	}; 
    
    ParseStart<VariableDeclarationExpr> VARIABLE_DECLARATION_EXPR =new ParseStart<VariableDeclarationExpr>() {

		@Override
		public VariableDeclarationExpr parse(GeneratedJavaParser parser) throws ParseException {
			return parser.VariableDeclarationExpressionParseStart();
		}
	}; 
    
    ParseStart<ExplicitConstructorInvocationStmt> EXPLICIT_CONSTRUCTOR_INVOCATION_STMT =new ParseStart<ExplicitConstructorInvocationStmt>() {
		@Override
		public ExplicitConstructorInvocationStmt parse(GeneratedJavaParser parser) throws ParseException {
			return parser.ExplicitConstructorInvocationParseStart();
		}
	}; 
    
    ParseStart<Name> NAME =new ParseStart<Name>() {

		@Override
		public Name parse(GeneratedJavaParser parser) throws ParseException {
			
			return parser.NameParseStart();
		}
	};
    
    ParseStart<SimpleName> SIMPLE_NAME =new ParseStart<SimpleName>() {

		@Override
		public SimpleName parse(GeneratedJavaParser parser) throws ParseException {

			return parser.SimpleNameParseStart();
		}
	}; 
    
    ParseStart<Parameter> PARAMETER =new ParseStart<Parameter>() {
		@Override
		public Parameter parse(GeneratedJavaParser parser) throws ParseException {
			return parser.ParameterParseStart();
		}
	};
    
    ParseStart<PackageDeclaration> PACKAGE_DECLARATION =new  ParseStart<PackageDeclaration>() {

		@Override
		public PackageDeclaration parse(GeneratedJavaParser parser) throws ParseException {
			
			return parser.PackageDeclarationParseStart();
		}
	};
	
    R parse(GeneratedJavaParser parser) throws ParseException;
}
