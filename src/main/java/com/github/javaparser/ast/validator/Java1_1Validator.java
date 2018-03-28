package com.github.javaparser.ast.validator;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.stmt.LocalClassDeclarationStmt;

/**
 * This validator validates according to Java 1.1 syntax rules.
 */
public class Java1_1Validator extends Java1_0Validator {
   /* protected final Validator innerClasses = new SingleNodeTypeValidator<>(ClassOrInterfaceDeclaration.class,
            (n, reporter) -> n.getOptionalParentNode().ifPresent(p -> {
                if (p instanceof LocalClassDeclarationStmt && n.isInterface())
                    reporter.report(n, "There is no such thing as a local interface.");
            })
    );
*/
	protected final Validator innerClasses =createInnerClasses();
	
    public Java1_1Validator() {
        super();
        replace(noInnerClasses, innerClasses);
        remove(noReflection);
    }

	private Validator createInnerClasses() {
		TypedValidator typedValidator=new TypedValidator<ClassOrInterfaceDeclaration>() {

			@Override
			public void accept(ClassOrInterfaceDeclaration node, ProblemReporter problemReporter) {
				Node pn=node.getOptionalParentNode();
				if(pn!=null){
					if (pn instanceof LocalClassDeclarationStmt && node.isInterface())
						problemReporter.report(node, "There is no such thing as a local interface.");
				}
			}
		};
		return new SingleNodeTypeValidator<>(ClassOrInterfaceDeclaration.class,typedValidator);
	}
    
    
}
