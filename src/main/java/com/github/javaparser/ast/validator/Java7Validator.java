package com.github.javaparser.ast.validator;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.type.UnionType;

/**
 * This validator validates according to Java 7 syntax rules.
 */
public class Java7Validator extends Java6Validator {
	
	protected final SingleNodeTypeValidator<TryStmt> tryWithLimitedResources =createTryWithLimitedResources();
	protected final SingleNodeTypeValidator<UnionType> multiCatch=createMultiCatch();

    public Java7Validator() {
        super();
        remove(genericsWithoutDiamondOperator);
        replace(tryWithoutResources, tryWithLimitedResources);
        remove(noStringsInSwitch);
        remove(noBinaryIntegerLiterals);
        remove(noUnderscoresInIntegerLiterals);
        replace(noMultiCatch, multiCatch);
    }


	private SingleNodeTypeValidator<UnionType> createMultiCatch() {
		TypedValidator typedValidator=new TypedValidator<UnionType>() {

			@Override
			public void accept(UnionType n, ProblemReporter problemReporter) {
				
				if (n.getElements().size() == 1) {
					problemReporter.report(n, "Union type (multi catch) must have at least two elements.");
		        }
			}
		};
		return new SingleNodeTypeValidator<>(UnionType.class,typedValidator);
	}


	private SingleNodeTypeValidator<TryStmt> createTryWithLimitedResources() {
		TypedValidator typedValidator=new TypedValidator<TryStmt>() {

			@Override
			public void accept(TryStmt n, ProblemReporter problemReporter) {
				 if (n.getCatchClauses().isEmpty()
			                && n.getResources().isEmpty()
			                && n.getFinallyBlock()==null) {
					 problemReporter.report(n, "Try has no finally, no catch, and no resources.");
			        }
			        for (Expression resource : n.getResources()) {
			            if (!resource.isVariableDeclarationExpr()) {
			            	problemReporter.report(n, "Try with resources only supports variable declarations.");
			            }
			        }
				
			}
		};
		return new SingleNodeTypeValidator<>(TryStmt.class, typedValidator);
	}
}
