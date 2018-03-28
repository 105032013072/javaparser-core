package com.github.javaparser.ast.validator;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.validator.chunks.ModifierValidator;
import com.github.javaparser.ast.validator.chunks.UnderscoreKeywordValidator;

/**
 * This validator validates according to Java 9 syntax rules.
 */
public class Java9Validator extends Java8Validator {
    protected final Validator underscoreKeywordValidator = new UnderscoreKeywordValidator();
    protected final Validator modifiers = new ModifierValidator(true, true, true);
    /*protected final SingleNodeTypeValidator<TryStmt> tryWithResources = new SingleNodeTypeValidator<>(TryStmt.class, (n, reporter) -> {
        if (n.getCatchClauses().isEmpty()
                && n.getResources().isEmpty()
                && !n.getFinallyBlock().isPresent()) {
            reporter.report(n, "Try has no finally, no catch, and no resources.");
        }
    });*/

    protected final SingleNodeTypeValidator<TryStmt> tryWithResources = createtryWithResources();
    
    public Java9Validator() {
        super();
        add(underscoreKeywordValidator);
        remove(noModules);
        replace(modifiersWithoutPrivateInterfaceMethods, modifiers);
        replace(tryWithLimitedResources, tryWithResources);
    }

	private SingleNodeTypeValidator<TryStmt> createtryWithResources() {
		TypedValidator typedValidator=new TypedValidator<TryStmt>() {

			@Override
			public void accept(TryStmt n, ProblemReporter problemReporter) {
				if (n.getCatchClauses().isEmpty()
		                && n.getResources().isEmpty()
		                && n.getFinallyBlock()==null) {
					problemReporter.report(n, "Try has no finally, no catch, and no resources.");
		        }
			}
		};
		return new SingleNodeTypeValidator<>(TryStmt.class, typedValidator);
	}
}
