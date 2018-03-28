package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;


import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;


public interface NodeWithConstructors<N extends Node> extends NodeWithSimpleName<N>, NodeWithMembers<N> {
    /**
     * Try to find a {@link ConstructorDeclaration} with no parameters by its name
     *
     * @return the constructors found (multiple in case of polymorphism)
     */
    public abstract ConstructorDeclaration getDefaultConstructor();

    /**
     * Adds a constructor to this
     *
     * @param modifiers the modifiers like {@link Modifier#PUBLIC}
     * @return the created constructor
     */
    public abstract ConstructorDeclaration addConstructor(Modifier... modifiers);

    /**
     * Find all constructors for this class.
     *
     * @return the constructors found. This list is immutable.
     */
    public abstract List<ConstructorDeclaration> getConstructors();

    /**
     * Try to find a {@link ConstructorDeclaration} by its parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the constructor found (multiple in case of overloading)
     */
    public abstract ConstructorDeclaration getConstructorByParameterTypes(String... paramTypes);

    /**
     * Try to find a {@link ConstructorDeclaration} by its parameters types
     *
     * @param paramTypes the types of parameters like "Map&lt;Integer,String&gt;","int" to match<br> void
     * foo(Map&lt;Integer,String&gt; myMap,int number)
     * @return the constructors found (multiple in case of overloading)
     */
    public abstract ConstructorDeclaration getConstructorByParameterTypes(Class<?>... paramTypes);

}
