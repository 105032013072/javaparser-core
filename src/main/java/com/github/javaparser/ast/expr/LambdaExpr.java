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
package com.github.javaparser.ast.expr;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.nodeTypes.NodeWithParameters;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;

import static com.github.javaparser.utils.Utils.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.DerivedProperty;
import com.github.javaparser.metamodel.LambdaExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import static com.github.javaparser.JavaParser.parseType;



/**
 * <h1>A lambda expression</h1>
 * <h2>Java 1-7</h2>
 * Does not exist.
 * <h2>Java 8+</h2>
 * <code>(a, b) -> a + b</code>
 * <br/><code>a -> ...</code>
 * <br/><code>(Long a) -> { println(a); }</code>
 * <p/>The parameters are on the left side of the ->.
 * If a parameter uses type inference (it has no type specified) then its type is set to <code>UnknownType</code>.
 * If they are in ( ), "isEnclosingParameters" is true.
 * <br/>The body is to the right of the ->.
 * The body is either a BlockStatement when it is in { } braces, or an ExpressionStatement when it is not in braces.
 *
 * @author Raquel Pau
 */
public final class LambdaExpr extends Expression implements NodeWithParameters<LambdaExpr> {

    private NodeList<Parameter> parameters;

    private boolean isEnclosingParameters;

    private Statement body;

    public LambdaExpr() {
        this(null, new NodeList<Parameter>(), new ReturnStmt(), false);
    }

    @AllFieldsConstructor
    public LambdaExpr(NodeList<Parameter> parameters, Statement body, boolean isEnclosingParameters) {
        this(null, parameters, body, isEnclosingParameters);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public LambdaExpr(TokenRange tokenRange, NodeList<Parameter> parameters, Statement body, boolean isEnclosingParameters) {
        super(tokenRange);
        setParameters(parameters);
        setBody(body);
        setEnclosingParameters(isEnclosingParameters);
        customInitialization();
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<Parameter> getParameters() {
        return parameters;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public LambdaExpr setParameters(final NodeList<Parameter> parameters) {
        assertNotNull(parameters);
        if (parameters == this.parameters) {
            return (LambdaExpr) this;
        }
        notifyPropertyChange(ObservableProperty.PARAMETERS, this.parameters, parameters);
        if (this.parameters != null)
            this.parameters.setParentNode(null);
        this.parameters = parameters;
        setAsParentNodeOf(parameters);
        return this;
    }

    /**
     * @return a BlockStatement or an ExpressionStatement. See class Javadoc.
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Statement getBody() {
        return body;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public LambdaExpr setBody(final Statement body) {
        assertNotNull(body);
        if (body == this.body) {
            return (LambdaExpr) this;
        }
        notifyPropertyChange(ObservableProperty.BODY, this.body, body);
        if (this.body != null)
            this.body.setParentNode(null);
        this.body = body;
        setAsParentNodeOf(body);
        return this;
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
    public boolean isEnclosingParameters() {
        return isEnclosingParameters;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public LambdaExpr setEnclosingParameters(final boolean isEnclosingParameters) {
        if (isEnclosingParameters == this.isEnclosingParameters) {
            return (LambdaExpr) this;
        }
        notifyPropertyChange(ObservableProperty.ENCLOSING_PARAMETERS, this.isEnclosingParameters, isEnclosingParameters);
        this.isEnclosingParameters = isEnclosingParameters;
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < parameters.size(); i++) {
            if (parameters.get(i) == node) {
                parameters.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    /**
     * @return if the body of this lambda is a simple expression, return that expression.
     * Otherwise (when the body is a block) return Optional.empty().
     */
    @DerivedProperty
    public Expression getExpressionBody() {
        if (body.isExpressionStmt()) {
            return body.asExpressionStmt().getExpression();
        } else {
            return null;
        }
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public LambdaExpr clone() {
        return (LambdaExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public LambdaExprMetaModel getMetaModel() {
        return JavaParserMetaModel.lambdaExprMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == body) {
            setBody((Statement) replacementNode);
            return true;
        }
        for (int i = 0; i < parameters.size(); i++) {
            if (parameters.get(i) == node) {
                parameters.set(i, (Parameter) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isLambdaExpr() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LambdaExpr asLambdaExpr() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifLambdaExpr(Consumer<LambdaExpr> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LambdaExpr toLambdaExpr() {
        return this;
    }
    
    // for NodeWithParameters
    
    public Parameter getParameter(int i) {
        return getParameters().get(i);
    }


    @SuppressWarnings("unchecked")
	public LambdaExpr setParameter(int i, Parameter parameter) {
        getParameters().set(i, parameter);
        return (LambdaExpr) this;
    }


    public  LambdaExpr addParameter(Type type, String name) {
        return addParameter(new Parameter(type, name));
    }

    public LambdaExpr addParameter(Class<?> paramClass, String name) {
        tryAddImportToParentCompilationUnit(paramClass);
        return addParameter(parseType(paramClass.getSimpleName()), name);
    }

    /**
     * Remember to import the class in the compilation unit yourself
     *
     * @param className the name of the class, ex : org.test.Foo or Foo if you added manually the import
     * @param name the name of the parameter
     */
    public LambdaExpr addParameter(String className, String name) {
        return addParameter(parseType(className), name);
    }

    @SuppressWarnings("unchecked")
	public LambdaExpr addParameter(Parameter parameter) {
        getParameters().add(parameter);
        return (LambdaExpr) this;
    }

    public Parameter addAndGetParameter(Type type, String name) {
        return addAndGetParameter(new Parameter(type, name));
    }

    public  Parameter addAndGetParameter(Class<?> paramClass, String name) {
        tryAddImportToParentCompilationUnit(paramClass);
        return addAndGetParameter(parseType(paramClass.getSimpleName()), name);
    }

    /**
     * Remember to import the class in the compilation unit yourself
     *
     * @param className the name of the class, ex : org.test.Foo or Foo if you added manually the import
     * @param name the name of the parameter
     * @return the {@link Parameter} created
     */
    public  Parameter addAndGetParameter(String className, String name) {
        return addAndGetParameter(parseType(className), name);
    }

    public  Parameter addAndGetParameter(Parameter parameter) {
        getParameters().add(parameter);
        return parameter;
    }

    /**
     * Try to find a {@link Parameter} by its name
     *
     * @param name the name of the param
     * @return null if not found, the param found otherwise
     */
    public  Parameter getParameterByName(String name) {
       /* return getParameters().stream()
                .filter(p -> p.getNameAsString().equals(name)).findFirst();*/
    	for (Parameter p : getParameters()) {
			if(p.getNameAsString().equals(name)) return p;
		}
    	
    	return null;
    }

    /**
     * Try to find a {@link Parameter} by its type
     *
     * @param type the type of the param
     * @return null if not found, the param found otherwise
     */
    public  Parameter getParameterByType(String type) {
       /* return getParameters().stream()
                .filter(p -> p.getType().toString().equals(type)).findFirst();*/
    	
    	for (Parameter p : getParameters()) {
			if( p.getType().toString().equals(type)) return p;
		}
    	return null;
    }

    /**
     * Try to find a {@link Parameter} by its type
     *
     * @param type the type of the param <b>take care about generics, it wont work</b>
     * @return null if not found, the param found otherwise
     */
    public  Parameter getParameterByType(Class<?> type) {
       
    	for (Parameter p : getParameters()) {
			if(p.getType().toString().equals(type.getSimpleName())) return p;
		}
    	return null;
    }

    /**
     * Check if the parameters have certain types.
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return true if all parameters match
     */
    public  boolean hasParametersOfType(String... paramTypes) {
      
    	
    	Set<String> sourceSet=new HashSet<>();
    	for (Parameter p : getParameters()) {
			sourceSet.add(p.getType().toString());
		}
    	
    	Set<String> targetSet= new HashSet<>(Arrays.asList(paramTypes));
    	return sourceSet.equals(targetSet);
    }

    /**
     * Check if the parameters have certain types. Note that this is a match in SimpleName, so "java.awt.List" and
     * "java.util.List" are identical to this algorithm.
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return true if all parameters match
     */
    public  boolean hasParametersOfType(Class<?>... paramTypes) {
       /* return getParameters().stream().map(p -> p.getType().toString())
                .collect(toSet())
                .equals(Stream.of(paramTypes).map(Class::getSimpleName).collect(toSet()));*/
    	Set<String> sourceSet=new HashSet<>();
    	for (Parameter p : getParameters()) {
			sourceSet.add(p.getType().toString());
		}
    	
    	Set<String> targetSet= new HashSet<>();
    	for (Class<?> c : paramTypes) {
			targetSet.add(c.getSimpleName());
		}
    	return sourceSet.equals(targetSet);
    }
}
