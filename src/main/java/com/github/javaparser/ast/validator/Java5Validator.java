package com.github.javaparser.ast.validator;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.nodeTypes.NodeWithTypeArguments;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;

/**
 * This validator validates according to Java 5 syntax rules.
 */
public class Java5Validator extends Java1_4Validator {
    /*
   
    */
    
    Validator genericsWithoutDiamondOperator=createGenericsWithoutDiamondOperator();
    protected Validator noPrimitiveGenericArguments = createNoPrimitiveGenericArguments();
    
    
    
    
    

    protected final Validator enumNotAllowed = new ReservedKeywordValidator("enum");

    public Java5Validator() {
        super();
        replace(noGenerics, genericsWithoutDiamondOperator);
        add(noPrimitiveGenericArguments);
        add(enumNotAllowed);
        
        // TODO validate annotations on classes, fields and methods but nowhere else
        // The following is probably too simple.
        remove(noAnnotations);

        remove(noEnums);
        remove(noVarargs);
        remove(noForEach);
        remove(noStaticImports);
    }

	private Validator createNoPrimitiveGenericArguments() {
		Validator validator=new Validator() {
			
			@Override
			public void accept(Node node, ProblemReporter problemReporter) {
				if(node instanceof NodeWithTypeArguments){
					 NodeList<Type> typeArguments = ((NodeWithTypeArguments<? extends Node>) node).getTypeArguments();
				     if(typeArguments!=null){
				    	 for (Type type : typeArguments) {
				    		 if (type instanceof PrimitiveType) {
				    			 problemReporter.report(node, "Type arguments may not be primitive.");
				                }
						}
				     }
				}
				
			}
		};
		return new TreeVisitorValidator(validator);
	}

	private Validator createGenericsWithoutDiamondOperator() {
		Validator validator=new Validator() {
			
			@Override
			public void accept(Node node, ProblemReporter problemReporter) {
				if (node instanceof NodeWithTypeArguments){
					NodeList<Type> typeArguments = ((NodeWithTypeArguments<? extends Node>) node).getTypeArguments();
					if (typeArguments!=null && typeArguments.isEmpty()) {
						problemReporter.report(node, "The diamond operator is not supported.");
		            }
				}
			}
		};
		return new TreeVisitorValidator(validator);
	}
}
