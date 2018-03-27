package com.github.javaparser.ast.validator;

import com.github.javaparser.Predicate;
import com.github.javaparser.ast.Node;


/**
 * Runs a validator on all nodes of a certain type,
 * and adds a problem for all nodes that pass a condition.
 */
public class SimpleValidator<N extends Node> extends SingleNodeTypeValidator<N> {
    public SimpleValidator(Class<N> type, final Predicate<N> condition, final BiConsumer<N, ProblemReporter> problemSupplier) {
        /*super(type, (node, problemReporter) -> {
            if (condition.test(node)) {
                problemSupplier.accept(node, problemReporter);
            }
        });*/
    	super(type, new TypedValidator<N>() {

			public void accept(N node, ProblemReporter problemReporter) {
				if (condition.test(node)) {
	                problemSupplier.accept(node, problemReporter);
	            }
			}
		});
    }
}
