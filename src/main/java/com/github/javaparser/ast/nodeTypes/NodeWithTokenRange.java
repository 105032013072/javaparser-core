package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.TokenRange;

/**
 * A node that has a Range, which is every Node.
 * 
 */
public interface NodeWithTokenRange<N> {
    TokenRange getTokenRange();

    N setTokenRange(TokenRange range);
}
