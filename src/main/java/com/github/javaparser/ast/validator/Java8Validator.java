package com.github.javaparser.ast.validator;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.validator.chunks.ModifierValidator;

/**
 * This validator validates according to Java 7 syntax rules.
 */
public class Java8Validator extends Java7Validator {
    protected final Validator modifiersWithoutPrivateInterfaceMethods = new ModifierValidator(true, true, false);
    /*protected final Validator defaultMethodsInInterface 
*/
    
    protected final Validator defaultMethodsInInterface =create();
    public Java8Validator() {
        super();
        replace(modifiersWithoutDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods, modifiersWithoutPrivateInterfaceMethods);
        add(defaultMethodsInInterface);
        remove(noLambdas);

        // TODO validate more annotation locations http://openjdk.java.net/jeps/104
        // TODO validate repeating annotations http://openjdk.java.net/jeps/120
    }
	private Validator create() {
		TypedValidator typedValidator=new TypedValidator<ClassOrInterfaceDeclaration>() {

			@Override
			public void accept(ClassOrInterfaceDeclaration n, ProblemReporter problemReporter) {
				if(n.isInterface()){
					for (MethodDeclaration m : n.getMethods()) {
						if (m.isDefault() && m.getOptionalBody()==null) {
							problemReporter.report(m, "'default' methods must have a body.");
                        }
					}
				}
				
			}
		};
		
		return  new SingleNodeTypeValidator<>(ClassOrInterfaceDeclaration.class,typedValidator);
	}
}
