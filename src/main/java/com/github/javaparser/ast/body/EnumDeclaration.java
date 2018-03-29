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

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithConstructors;
import com.github.javaparser.ast.nodeTypes.NodeWithImplements;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.EnumDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedEnumDeclaration;
import javax.annotation.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static com.github.javaparser.utils.Utils.assertNonEmpty;
import static com.github.javaparser.utils.Utils.assertNotNull;
import static com.github.javaparser.JavaParser.parseClassOrInterfaceType;
import static java.util.Collections.unmodifiableList;
/**
 * The declaration of an enum.<br/><code>enum X { ... }</code>
 *
 * @author Julio Vilmar Gesser
 */
public final class EnumDeclaration extends TypeDeclaration<EnumDeclaration> implements NodeWithImplements<EnumDeclaration>, NodeWithConstructors<EnumDeclaration>, Resolvable<ResolvedEnumDeclaration> {

    private NodeList<ClassOrInterfaceType> implementedTypes;

    private NodeList<EnumConstantDeclaration> entries;

    public EnumDeclaration() {
        this(null, EnumSet.noneOf(Modifier.class), new NodeList<AnnotationExpr>(), new SimpleName(), new NodeList<ClassOrInterfaceType>(), new NodeList<EnumConstantDeclaration>(), new NodeList<BodyDeclaration<?>>());
    }

    public EnumDeclaration(EnumSet<Modifier> modifiers, String name) {
        this(null, modifiers, new NodeList<AnnotationExpr>(), new SimpleName(name), new NodeList<ClassOrInterfaceType>(), new NodeList<EnumConstantDeclaration>(), new NodeList<BodyDeclaration<?>>());
    }

    @AllFieldsConstructor
    public EnumDeclaration(EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, SimpleName name, NodeList<ClassOrInterfaceType> implementedTypes, NodeList<EnumConstantDeclaration> entries, NodeList<BodyDeclaration<?>> members) {
        this(null, modifiers, annotations, name, implementedTypes, entries, members);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public EnumDeclaration(TokenRange tokenRange, EnumSet<Modifier> modifiers, NodeList<AnnotationExpr> annotations, SimpleName name, NodeList<ClassOrInterfaceType> implementedTypes, NodeList<EnumConstantDeclaration> entries, NodeList<BodyDeclaration<?>> members) {
        super(tokenRange, modifiers, annotations, name, members);
        setImplementedTypes(implementedTypes);
        setEntries(entries);
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
    public NodeList<EnumConstantDeclaration> getEntries() {
        return entries;
    }

    public EnumConstantDeclaration getEntry(int i) {
        return getEntries().get(i);
    }

    public EnumDeclaration setEntry(int i, EnumConstantDeclaration element) {
        getEntries().set(i, element);
        return this;
    }

    public EnumDeclaration addEntry(EnumConstantDeclaration element) {
        getEntries().add(element);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<ClassOrInterfaceType> getImplementedTypes() {
        return implementedTypes;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public EnumDeclaration setEntries(final NodeList<EnumConstantDeclaration> entries) {
        assertNotNull(entries);
        if (entries == this.entries) {
            return (EnumDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.ENTRIES, this.entries, entries);
        if (this.entries != null)
            this.entries.setParentNode(null);
        this.entries = entries;
        setAsParentNodeOf(entries);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public EnumDeclaration setImplementedTypes(final NodeList<ClassOrInterfaceType> implementedTypes) {
        assertNotNull(implementedTypes);
        if (implementedTypes == this.implementedTypes) {
            return (EnumDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.IMPLEMENTED_TYPES, this.implementedTypes, implementedTypes);
        if (this.implementedTypes != null)
            this.implementedTypes.setParentNode(null);
        this.implementedTypes = implementedTypes;
        setAsParentNodeOf(implementedTypes);
        return this;
    }

    public EnumConstantDeclaration addEnumConstant(String name) {
        assertNonEmpty(name);
        EnumConstantDeclaration enumConstant = new EnumConstantDeclaration(name);
        getEntries().add(enumConstant);
        return enumConstant;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i) == node) {
                entries.remove(i);
                return true;
            }
        }
        for (int i = 0; i < implementedTypes.size(); i++) {
            if (implementedTypes.get(i) == node) {
                implementedTypes.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public EnumDeclaration clone() {
        return (EnumDeclaration) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public EnumDeclarationMetaModel getMetaModel() {
        return JavaParserMetaModel.enumDeclarationMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i) == node) {
                entries.set(i, (EnumConstantDeclaration) replacementNode);
                return true;
            }
        }
        for (int i = 0; i < implementedTypes.size(); i++) {
            if (implementedTypes.get(i) == node) {
                implementedTypes.set(i, (ClassOrInterfaceType) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isEnumDeclaration() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public EnumDeclaration asEnumDeclaration() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifEnumDeclaration(Consumer<EnumDeclaration> action) {
        action.accept(this);
    }

    @Override
    public ResolvedEnumDeclaration resolve() {
        return getSymbolResolver().resolveDeclaration(this, ResolvedEnumDeclaration.class);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public EnumDeclaration toEnumDeclaration() {
        return this;
    }
    
    //for NodeWithImplements
    public  ClassOrInterfaceType getImplementedTypes(int i) {
        return getImplementedTypes().get(i);
    }

  
    @SuppressWarnings("unchecked")
	public EnumDeclaration setImplementedType(int i, ClassOrInterfaceType implement) {
        getImplementedTypes().set(i, implement);
        return (EnumDeclaration) this;
    }

    @SuppressWarnings("unchecked")
	public EnumDeclaration addImplementedType(ClassOrInterfaceType implement) {
        getImplementedTypes().add(implement);
        return (EnumDeclaration) this;
    }

    /** @deprecated use addImplementedType instead */
    public EnumDeclaration addImplements(String name) {
        return addImplementedType(name);
    }

    /** @deprecated use addImplementedType instead */
    public EnumDeclaration addImplements(Class<?> clazz) {
        return addImplementedType(clazz);
    }

    /**
     * Add an implements to this
     *
     * @param name the name of the type to extends from
     * @return this
     */
    @SuppressWarnings("unchecked")
	public EnumDeclaration addImplementedType(String name) {
        getImplementedTypes().add(parseClassOrInterfaceType(name));
        return (EnumDeclaration) this;
    }

    /**
     * Add an implements to this and automatically add the import
     *
     * @param clazz the type to implements from
     * @return this
     */
    public EnumDeclaration addImplementedType(Class<?> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addImplementedType(clazz.getSimpleName());
    }
    
    //for NodeWithConstructors
    public  ConstructorDeclaration getDefaultConstructor() {
        
     	NodeList<BodyDeclaration<?>> list= getMembers();
     	
     	for (BodyDeclaration<?> bd : list) {
 			if(bd instanceof ConstructorDeclaration){
 				ConstructorDeclaration cd=(ConstructorDeclaration) bd;
 				if(cd.getParameters().isEmpty()) return cd;
 			}
 		}
     	return null;
     }

     /**
      * Adds a constructor to this
      *
      * @param modifiers the modifiers like {@link Modifier#PUBLIC}
      * @return the created constructor
      */
     public  ConstructorDeclaration addConstructor(Modifier... modifiers) {
         ConstructorDeclaration constructorDeclaration = new ConstructorDeclaration();
        /* constructorDeclaration.setModifiers(Arrays.stream(modifiers).collect(toCollection(() -> EnumSet.noneOf(Modifier.class))));*/
        
         List<Modifier> list=new ArrayList<>(Arrays.asList(modifiers));
         EnumSet enumSet=EnumSet.noneOf(Modifier.class);
         enumSet.addAll(list);
         constructorDeclaration.setModifiers(enumSet);
         constructorDeclaration.setName(getName());
         getMembers().add(constructorDeclaration);
         return constructorDeclaration;
     }

     /**
      * Find all constructors for this class.
      *
      * @return the constructors found. This list is immutable.
      */
     public  List<ConstructorDeclaration> getConstructors() {
         /*return unmodifiableList(getMembers().stream()
         		.filter(m -> m instanceof ConstructorDeclaration)
         		.map(m -> (ConstructorDeclaration) m)
         		.collect(toList()));*/
     	
     	List<ConstructorDeclaration> result=new ArrayList<>();
     	NodeList<BodyDeclaration<?>> members=getMembers();
     	for (BodyDeclaration<?> m : members) {
 			if(m instanceof ConstructorDeclaration){
 				result.add((ConstructorDeclaration) m);
 			}
 		}
      return	unmodifiableList(result);
     }

     /**
      * Try to find a {@link ConstructorDeclaration} by its parameters types
      *
      * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
      * foo(Map&lt;Integer,String&gt; myMap,int number)
      * @return the constructor found (multiple in case of overloading)
      */
     public  ConstructorDeclaration getConstructorByParameterTypes(String... paramTypes) {
         //return getConstructors().stream().filter(m -> m.hasParametersOfType(paramTypes)).findFirst();
     	for (ConstructorDeclaration m : getConstructors()) {
 		  if(m.hasParametersOfType(paramTypes))	 return m;
 		}
     	return null;
     }

     /**
      * Try to find a {@link ConstructorDeclaration} by its parameters types
      *
      * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
      * foo(Map&lt;Integer,String&gt; myMap,int number)
      * @return the constructors found (multiple in case of overloading)
      */
     public  ConstructorDeclaration getConstructorByParameterTypes(Class<?>... paramTypes) {
        // return getConstructors().stream().filter(m -> m.hasParametersOfType(paramTypes)).findFirst();
     	for (ConstructorDeclaration m : getConstructors()) {
 			if(m.hasParametersOfType(paramTypes)) return m;
 		}
     	return null;
     }
}
