package com.github.javaparser.ast.nodeTypes.modifiers;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;

import static com.github.javaparser.ast.Modifier.STRICTFP;

/**
 * A node that can be strictfp.
 */
public interface NodeWithStrictfpModifier<N extends Node> extends NodeWithModifiers<N> {
	public abstract boolean isStrictfp();

    @SuppressWarnings("unchecked")
    public abstract N setStrictfp(boolean set);
}
