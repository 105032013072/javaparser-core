package com.github.javaparser.ast.nodeTypes.modifiers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;

import static com.github.javaparser.ast.Modifier.ABSTRACT;

/**
 * A node that can be abstract.
 */
public interface NodeWithAbstractModifier<N extends Node> extends NodeWithModifiers<N> {
	public abstract boolean isAbstract();

    @SuppressWarnings("unchecked")
    public abstract N setAbstract(boolean set);
}
