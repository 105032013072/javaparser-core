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

package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;

import static com.github.javaparser.JavaParser.*;

/**
 * A node that contains a list of statements.
 */
public interface NodeWithStatements<N extends Node> {
    NodeList<Statement> getStatements();

    public abstract Statement getStatement(int i);

    @SuppressWarnings("unchecked")
    public abstract N setStatement(int i, Statement statement);

    N setStatements(final NodeList<Statement> statements);

    @SuppressWarnings("unchecked")
    public abstract N addStatement(Statement statement);

    @SuppressWarnings("unchecked")
    public abstract N addStatement(int index, final Statement statement);

    public abstract N addStatement(Expression expr);

    /**
     * It will use {@link JavaParser#parseStatement(String)} inside, so it should end with a semi column
     */
    public abstract N addStatement(String statement);

    public abstract N addStatement(int index, final Expression expr);

    public abstract <A extends Statement> A addAndGetStatement(A statement);

    public abstract Statement addAndGetStatement(int index, final Statement statement);

    public abstract ExpressionStmt addAndGetStatement(Expression expr);

    public abstract ExpressionStmt addAndGetStatement(String statement);

    public abstract boolean isEmpty();

    @SuppressWarnings("unchecked")
    public abstract N copyStatements(NodeList<Statement> nodeList);

    public abstract N copyStatements(NodeWithStatements<?> other);
}
