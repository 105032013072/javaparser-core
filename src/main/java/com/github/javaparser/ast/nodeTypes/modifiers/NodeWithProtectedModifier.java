package com.github.javaparser.ast.nodeTypes.modifiers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;

import static com.github.javaparser.ast.Modifier.*;

/**
 * A node that can be protected.
 */
public interface NodeWithProtectedModifier<N extends Node> extends NodeWithModifiers<N> {
	public abstract boolean isProtected();

    @SuppressWarnings("unchecked")
    public abstract N setProtected(boolean set);
}
