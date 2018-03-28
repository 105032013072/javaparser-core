package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.SimpleName;

import static com.github.javaparser.utils.Utils.assertNonEmpty;

/**
 * A node that has an optional label.
 */
public interface NodeWithOptionalLabel<T extends Node> {
    SimpleName getLabel();

    T setLabel(SimpleName label);
    
    T removeLabel();

    public abstract T setLabel(String label);

    public abstract String getLabelAsString();
}
