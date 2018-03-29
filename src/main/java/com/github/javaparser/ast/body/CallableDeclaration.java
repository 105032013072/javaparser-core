/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2017 The JavaParser Team.
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

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.*;
import com.github.javaparser.ast.nodeTypes.modifiers.*;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.javadoc.Javadoc;
import com.github.javaparser.metamodel.CallableDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import javax.annotation.Generated;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.javaparser.utils.Utils.assertNotNull;
import static com.github.javaparser.ast.Modifier.*;
import static com.github.javaparser.JavaParser.parseClassOrInterfaceType;
import static com.github.javaparser.JavaParser.parseType;

/**
 * Represents a declaration which is callable eg. a method or a constructor.
 */
public abstract class CallableDeclaration<T extends CallableDeclaration<?>> extends BodyDeclaration<T>
		implements NodeWithAccessModifiers<T>, NodeWithDeclaration, NodeWithSimpleName<T>, NodeWithParameters<T>,
		NodeWithThrownExceptions<T>, NodeWithTypeParameters<T>, NodeWithJavadoc<T>, NodeWithAbstractModifier<T>,
		NodeWithStaticModifier<T>, NodeWithFinalModifier<T>, NodeWithStrictfpModifier<T> {

	private EnumSet<Modifier> modifiers;

	private NodeList<TypeParameter> typeParameters;

	private SimpleName name;

	private NodeList<Parameter> parameters;

	private NodeList<ReferenceType> thrownExceptions;

	@OptionalProperty
	private ReceiverParameter receiverParameter;

	@AllFieldsConstructor
	CallableDeclaration(EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations,
			NodeList<TypeParameter> typeParameters, SimpleName name, NodeList<Parameter> parameters,
			NodeList<ReferenceType> thrownExceptions, ReceiverParameter receiverParameter) {
		this(null, modifiers, annotations, typeParameters, name, parameters, thrownExceptions, receiverParameter);
	}

	/**
	 * This constructor is used by the parser and is considered private.
	 */
	@Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
	public CallableDeclaration(TokenRange tokenRange, EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations,
			NodeList<TypeParameter> typeParameters, SimpleName name, NodeList<Parameter> parameters,
			NodeList<ReferenceType> thrownExceptions, ReceiverParameter receiverParameter) {
		super(tokenRange, annotations);
		setModifiers(modifiers);
		setTypeParameters(typeParameters);
		setName(name);
		setParameters(parameters);
		setThrownExceptions(thrownExceptions);
		setReceiverParameter(receiverParameter);
		customInitialization();
	}

	/**
	 * Return the modifiers of this member declaration.
	 *
	 * @return modifiers
	 * @see Modifier
	 */
	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	public EnumSet<Modifier> getModifiers() {
		return modifiers;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	@SuppressWarnings("unchecked")
	public T setModifiers(final EnumSet<Modifier> modifiers) {
		assertNotNull(modifiers);
		if (modifiers == this.modifiers) {
			return (T) this;
		}
		notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
		this.modifiers = modifiers;
		return (T) this;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	public SimpleName getName() {
		return name;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	@SuppressWarnings("unchecked")
	public T setName(final SimpleName name) {
		assertNotNull(name);
		if (name == this.name) {
			return (T) this;
		}
		notifyPropertyChange(ObservableProperty.NAME, this.name, name);
		if (this.name != null)
			this.name.setParentNode(null);
		this.name = name;
		setAsParentNodeOf(name);
		return (T) this;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	public NodeList<Parameter> getParameters() {
		return parameters;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	@SuppressWarnings("unchecked")
	public T setParameters(final NodeList<Parameter> parameters) {
		assertNotNull(parameters);
		if (parameters == this.parameters) {
			return (T) this;
		}
		notifyPropertyChange(ObservableProperty.PARAMETERS, this.parameters, parameters);
		if (this.parameters != null)
			this.parameters.setParentNode(null);
		this.parameters = parameters;
		setAsParentNodeOf(parameters);
		return (T) this;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	public NodeList<ReferenceType> getThrownExceptions() {
		return thrownExceptions;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	@SuppressWarnings("unchecked")
	public T setThrownExceptions(final NodeList<ReferenceType> thrownExceptions) {
		assertNotNull(thrownExceptions);
		if (thrownExceptions == this.thrownExceptions) {
			return (T) this;
		}
		notifyPropertyChange(ObservableProperty.THROWN_EXCEPTIONS, this.thrownExceptions, thrownExceptions);
		if (this.thrownExceptions != null)
			this.thrownExceptions.setParentNode(null);
		this.thrownExceptions = thrownExceptions;
		setAsParentNodeOf(thrownExceptions);
		return (T) this;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	public NodeList<TypeParameter> getTypeParameters() {
		return typeParameters;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	@SuppressWarnings("unchecked")
	public T setTypeParameters(final NodeList<TypeParameter> typeParameters) {
		assertNotNull(typeParameters);
		if (typeParameters == this.typeParameters) {
			return (T) this;
		}
		notifyPropertyChange(ObservableProperty.TYPE_PARAMETERS, this.typeParameters, typeParameters);
		if (this.typeParameters != null)
			this.typeParameters.setParentNode(null);
		this.typeParameters = typeParameters;
		setAsParentNodeOf(typeParameters);
		return (T) this;
	}

	public String getDeclarationAsString(boolean includingModifiers, boolean includingThrows) {
		return getDeclarationAsString(includingModifiers, includingThrows, true);
	}

	public String getDeclarationAsString() {
		return getDeclarationAsString(true, true, true);
	}

	public abstract String getDeclarationAsString(boolean includingModifiers, boolean includingThrows,
			boolean includingParameterName);

	protected String appendThrowsIfRequested(boolean includingThrows) {
		StringBuilder sb = new StringBuilder();
		if (includingThrows) {
			boolean firstThrow = true;
			for (ReferenceType thr : getThrownExceptions()) {
				if (firstThrow) {
					firstThrow = false;
					sb.append(" throws ");
				} else {
					sb.append(", ");
				}
				sb.append(thr.toString(prettyPrinterNoCommentsConfiguration));
			}
		}
		return sb.toString();
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
		if (receiverParameter != null) {
			if (node == receiverParameter) {
				removeReceiverParameter();
				return true;
			}
		}
		for (int i = 0; i < thrownExceptions.size(); i++) {
			if (thrownExceptions.get(i) == node) {
				thrownExceptions.remove(i);
				return true;
			}
		}
		for (int i = 0; i < typeParameters.size(); i++) {
			if (typeParameters.get(i) == node) {
				typeParameters.remove(i);
				return true;
			}
		}
		return super.remove(node);
	}

	/**
	 * A method or constructor signature.
	 * <p/>
	 * Note that since JavaParser has no real knowledge of types - only the text
	 * found in the source file - using this will fail in some cases.
	 * (java.util.String != String for example, and generics are not taken into
	 * account.)
	 */
	public static class Signature {

		private final String name;

		private final List<Type> parameterTypes;

		private Signature(String name, List<Type> parameterTypes) {
			this.name = name;
			this.parameterTypes = parameterTypes;
		}

		public String getName() {
			return name;
		}

		public List<Type> getParameterTypes() {
			return parameterTypes;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Signature signature = (Signature) o;
			if (!name.equals(signature.name))
				return false;
			if (!parameterTypes.equals(signature.parameterTypes))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			int result = name.hashCode();
			result = 31 * result + parameterTypes.hashCode();
			return result;
		}

		public String asString() {
			//return parameterTypes.stream().map(Type::asString).collect(joining(", ", name + "(", ")"));
			String [] array=new String[parameterTypes.size()];
			for(int i=0;i<parameterTypes.size();i++){
				array[i]=parameterTypes.get(i).asString();
			}
			return name + "("+StringUtils.join(array, ",")+")";
		}

		@Override
		public String toString() {
			return asString();
		}
	}

	public Signature getSignature() {
		/*return new Signature(getName().getIdentifier(), getParameters().stream().map(this::getTypeWithVarargsAsArray)
				.map(this::stripGenerics).map(this::stripAnnotations).collect(toList()));*/
		List<Type> list=new ArrayList<>();
		for (Parameter p : getParameters()) {
			Type t=	this.getTypeWithVarargsAsArray(p);
			t=this.stripGenerics(t);
			t=this.stripAnnotations(t);
			list.add(t);
		}
		
		return new Signature(getName().getIdentifier(), list);
	}

	private Type stripAnnotations(Type type) {
		if (type instanceof NodeWithAnnotations) {
			((NodeWithAnnotations) type).setAnnotations(new NodeList<>());
		}
		return type;
	}

	private Type stripGenerics(Type type) {
		if (type instanceof NodeWithTypeArguments) {
			((NodeWithTypeArguments) type).setTypeArguments((NodeList<Type>) null);
		}
		return type;
	}

	private Type getTypeWithVarargsAsArray(Parameter p) {
		/*
		 * A signature includes the varargs ellipsis. This is a field on
		 * parameter which we lose when we only get the type, so we represent it
		 * as an additional [] on the type.
		 */
		Type t = p.getType().clone();
		if (p.isVarArgs()) {
			t = new ArrayType(t);
		}
		return t;
	}

	@Override
	@Generated("com.github.javaparser.generator.core.node.CloneGenerator")
	public CallableDeclaration<?> clone() {
		return (CallableDeclaration<?>) accept(new CloneVisitor(), null);
	}

	@Override
	@Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
	public CallableDeclarationMetaModel getMetaModel() {
		return JavaParserMetaModel.callableDeclarationMetaModel;
	}

	@Override
	@Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
	public boolean replace(Node node, Node replacementNode) {
		if (node == null)
			return false;
		if (node == name) {
			setName((SimpleName) replacementNode);
			return true;
		}
		for (int i = 0; i < parameters.size(); i++) {
			if (parameters.get(i) == node) {
				parameters.set(i, (Parameter) replacementNode);
				return true;
			}
		}
		if (receiverParameter != null) {
			if (node == receiverParameter) {
				setReceiverParameter((ReceiverParameter) replacementNode);
				return true;
			}
		}
		for (int i = 0; i < thrownExceptions.size(); i++) {
			if (thrownExceptions.get(i) == node) {
				thrownExceptions.set(i, (ReferenceType) replacementNode);
				return true;
			}
		}
		for (int i = 0; i < typeParameters.size(); i++) {
			if (typeParameters.get(i) == node) {
				typeParameters.set(i, (TypeParameter) replacementNode);
				return true;
			}
		}
		return super.replace(node, replacementNode);
	}

	@Override
	@Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
	public boolean isCallableDeclaration() {
		return true;
	}

	@Override
	@Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
	public CallableDeclaration asCallableDeclaration() {
		return this;
	}

	@Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
	public void ifCallableDeclaration(Consumer<CallableDeclaration> action) {
		action.accept(this);
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	public ReceiverParameter getReceiverParameter() {
		return receiverParameter;
	}

	@Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
	@SuppressWarnings("unchecked")
	public T setReceiverParameter(final ReceiverParameter receiverParameter) {
		if (receiverParameter == this.receiverParameter) {
			return (T) this;
		}
		notifyPropertyChange(ObservableProperty.RECEIVER_PARAMETER, this.receiverParameter, receiverParameter);
		if (this.receiverParameter != null)
			this.receiverParameter.setParentNode(null);
		this.receiverParameter = receiverParameter;
		setAsParentNodeOf(receiverParameter);
		return (T) this;
	}

	@Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
	public CallableDeclaration removeReceiverParameter() {
		return setReceiverParameter((ReceiverParameter) null);
	}

	@Override
	@Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
	public CallableDeclaration toCallableDeclaration() {
		return this;
	}

	// for NodeWithPublicModifier
	public boolean isPublic() {
		return getModifiers().contains(PUBLIC);
	}

	@SuppressWarnings("unchecked")
	public T setPublic(boolean set) {
		return setModifier(PUBLIC, set);
	}

	// for NodeWithPrivateModifier
	public boolean isPrivate() {
		return getModifiers().contains(PRIVATE);
	}

	@SuppressWarnings("unchecked")
	public T setPrivate(boolean set) {
		return setModifier(PRIVATE, set);
	}

	public boolean isProtected() {
		return getModifiers().contains(PROTECTED);
	}

	@SuppressWarnings("unchecked")
	public T setProtected(boolean set) {
		return setModifier(PROTECTED, set);
	}

	// for NodeWithSimpleName
	public T setName(String name) {
		if (name != null && "".equals(name)) {
			return setName(new SimpleName(name));
		} else
			return null;
	}

	public String getNameAsString() {
		return getName().getIdentifier();
	}

	// for NodeWithThrownExceptions
	public ReferenceType getThrownException(int i) {
		return getThrownExceptions().get(i);
	}

	/**
	 * Adds this type to the throws clause
	 *
	 * @param throwType
	 *            the exception type
	 * @return this
	 */
	@SuppressWarnings("unchecked")
	public T addThrownException(ReferenceType throwType) {
		getThrownExceptions().add(throwType);
		return (T) this;
	}

	/**
	 * Adds this class to the throws clause
	 *
	 * @param clazz
	 *            the exception class
	 * @return this
	 */
	public T addThrownException(Class<? extends Throwable> clazz) {
		tryAddImportToParentCompilationUnit(clazz);
		return addThrownException(parseClassOrInterfaceType(clazz.getSimpleName()));
	}

	/**
	 * Check whether this elements throws this exception class. Note that this
	 * is simply a text compare of the simple name of the class, no actual type
	 * resolution takes place.
	 *
	 * @param clazz
	 *            the class of the exception
	 * @return true if found in throws clause, false if not
	 */
	public boolean isThrown(Class<? extends Throwable> clazz) {
		return isThrown(clazz.getSimpleName());
	}

	/**
	 * Check whether this elements throws this exception class Note that this is
	 * simply a text compare, no actual type resolution takes place.
	 *
	 * @param throwableName
	 *            the class of the exception
	 * @return true if found in throws clause, false if not
	 */
	public boolean isThrown(String throwableName) {
		// return getThrownExceptions().stream().anyMatch(t ->
		// t.toString().equals(throwableName));
		for (ReferenceType t : getThrownExceptions()) {
			if (t.toString().equals(throwableName))
				return true;
		}
		return false;
	}

	// for NodeWithTypeParameters

	public TypeParameter getTypeParameter(int i) {
		return getTypeParameters().get(i);
	}

	@SuppressWarnings("unchecked")
	public T setTypeParameter(int i, TypeParameter typeParameter) {
		getTypeParameters().set(i, typeParameter);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T addTypeParameter(TypeParameter typeParameter) {
		getTypeParameters().add(typeParameter);
		return (T) this;
	}

	public boolean isGeneric() {
		return getTypeParameters().size() > 0;
	}

	// for NodeWithJavadoc

	public JavadocComment getJavadocComment() {

		Comment comment = getCommentOptional();
		if (comment instanceof JavadocComment) {
			return (JavadocComment) comment;
		} else
			return null;
	}

	/**
	 * Gets the Javadoc for this node. You can set the Javadoc by calling
	 * setJavadocComment passing a Javadoc.
	 *
	 * @return The Javadoc for this node wrapped in an optional as it may be
	 *         absent.
	 */
	public Javadoc getOptionalJavadoc() {
		JavadocComment javadocComment = getJavadocComment();
		if (javadocComment != null) {
			return javadocComment.parse();
		} else
			return null;

		// return getJavadocComment().map(JavadocComment::parse);
	}

	public Javadoc getJavadoc() {
		Javadoc oj = getOptionalJavadoc();
		if (oj != null)
			return oj;
		else
			return null;
	}

	/**
	 * Use this to store additional information to this node.
	 *
	 * @param comment
	 *            to be set
	 */
	@SuppressWarnings("unchecked")
	public T setJavadocComment(String comment) {
		return setJavadocComment(new JavadocComment(comment));
	}

	public T setJavadocComment(JavadocComment comment) {
		setComment(comment);
		return (T) this;
	}

	public T setJavadocComment(String indentation, Javadoc javadoc) {
		JavadocComment comment = javadoc.toComment(indentation);
		return setJavadocComment(comment);
	}

	public boolean removeJavaDocComment() {
		return hasJavaDocComment() && getCommentOptional().remove();
	}

	public boolean hasJavaDocComment() {
		return getCommentOptional() != null && getCommentOptional() instanceof JavadocComment;
	}

	// for NodeWithAbstractModifier
	public boolean isAbstract() {
		return getModifiers().contains(ABSTRACT);
	}

	@SuppressWarnings("unchecked")
	public T setAbstract(boolean set) {
		return setModifier(ABSTRACT, set);
	}

	// for NodeWithStaticModifier
	public boolean isStatic() {
		return getModifiers().contains(STATIC);
	}

	@SuppressWarnings("unchecked")
	public T setStatic(boolean set) {
		return setModifier(STATIC, set);
	}
	
	//for NodeWithFinalModifier
	 public boolean isFinal() {
	        return getModifiers().contains(FINAL);
	    }

	    @SuppressWarnings("unchecked")
		public T setFinal(boolean set) {
	        return setModifier(FINAL, set);
	    }
	    
	    
	     //for NodeWithStrictfpModifier
	    
	    public boolean isStrictfp() {
	        return getModifiers().contains(STRICTFP);
	    }

	    @SuppressWarnings("unchecked")
		public T setStrictfp(boolean set) {
	        return setModifier(STRICTFP, set);
	    }
	    
	    //for NodeWithParameters
	    public Parameter getParameter(int i) {
	        return getParameters().get(i);
	    }


	    @SuppressWarnings("unchecked")
		public T setParameter(int i, Parameter parameter) {
	        getParameters().set(i, parameter);
	        return (T) this;
	    }

	    public T addParameter(Type type, String name) {
	        return addParameter(new Parameter(type, name));
	    }

	    public  T addParameter(Class<?> paramClass, String name) {
	        tryAddImportToParentCompilationUnit(paramClass);
	        return addParameter(parseType(paramClass.getSimpleName()), name);
	    }

	    /**
	     * Remember to import the class in the compilation unit yourself
	     *
	     * @param className the name of the class, ex : org.test.Foo or Foo if you added manually the import
	     * @param name the name of the parameter
	     */
	    public T addParameter(String className, String name) {
	        return addParameter(parseType(className), name);
	    }

	    @SuppressWarnings("unchecked")
		public T addParameter(Parameter parameter) {
	        getParameters().add(parameter);
	        return (T) this;
	    }

	    public  Parameter addAndGetParameter(Type type, String name) {
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
	       /* return getParameters().stream()
	                .filter(p -> p.getType().toString().equals(type.getSimpleName())).findFirst();*/
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
	       /* return getParameters().stream()
	                .map(p -> p.getType().toString())
	                .collect(toSet())
	                .equals(Stream.of(paramTypes).collect(toSet()));*/
	    	
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
	    
	    
	    //for NodeWithModifiers
	   
	    @SuppressWarnings("unchecked")
		public T addModifier(Modifier... modifiers) {
	        EnumSet<Modifier> newModifiers = getModifiers().clone();
	        /*newModifiers.addAll(Arrays.stream(modifiers)
	                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
	        List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
	        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
	        enm.addAll(list);
	        newModifiers.addAll(enm);
	        setModifiers(newModifiers);
	        return (T) this;
	    }

	    @SuppressWarnings("unchecked")
		public T removeModifier(Modifier... m) {
	        EnumSet<Modifier> newModifiers = getModifiers().clone();
	       /* newModifiers.removeAll(Arrays.stream(m)
	                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
	        List<Modifier> list=new ArrayList<>(Arrays.asList(m));
	        EnumSet<Modifier> enm=EnumSet.noneOf(Modifier.class);
	        enm.addAll(list);
	        newModifiers.removeAll(enm);
	        
	        setModifiers(newModifiers);
	        return (T) this;
	    }
	    public  T setModifier(Modifier m, boolean set) {
	        if (set) {
	            return addModifier(m);
	        } else {
	            return removeModifier(m);
	        }
	    }

}
