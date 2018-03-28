package com.github.javaparser.ast.nodeTypes.modifiers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;

import static com.github.javaparser.ast.Modifier.*;

/**
 * A node that can be public.
 */
public interface NodeWithPublicModifier<N extends Node> extends NodeWithModifiers<N> {
	public abstract boolean isPublic();

    @SuppressWarnings("unchecked")
    public abstract N setPublic(boolean set);

}
