package com.github.javaparser.ast.validator.chunks;

import com.github.javaparser.Predicate;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.InitializerDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.validator.BiConsumer;
import com.github.javaparser.ast.validator.ProblemReporter;
import com.github.javaparser.ast.validator.SimpleValidator;
import com.github.javaparser.ast.validator.SingleNodeTypeValidator;
import com.github.javaparser.ast.validator.TreeVisitorValidator;
import com.github.javaparser.ast.validator.TypedValidator;
import com.github.javaparser.ast.validator.Validator;
import com.github.javaparser.ast.validator.Validators;
import com.github.javaparser.metamodel.NodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;


/**
 * Contains validations that are valid for every Java version.
 */
public class CommonValidators extends Validators {
    public CommonValidators() {
        /*super(
                new SimpleValidator<>(ClassOrInterfaceDeclaration.class,
                        n -> !n.isInterface() && n.getExtendedTypes().size() > 1,
                        (n, reporter) -> reporter.report(n.getExtendedTypes(1), "A class cannot extend more than one other class.")
                ),
                new SimpleValidator<>(ClassOrInterfaceDeclaration.class,
                        n -> n.isInterface() && !n.getImplementedTypes().isEmpty(),
                        (n, reporter) -> reporter.report(n.getImplementedTypes(0), "An interface cannot implement other interfaces.")
                ),
                new SingleNodeTypeValidator<>(ClassOrInterfaceDeclaration.class, (n, reporter) -> {
                    if (n.isInterface()) {
                        n.getMembers().forEach(mem -> {
                            if (mem instanceof InitializerDeclaration) {
                                reporter.report(mem, "An interface cannot have initializers.");
                            }
                        });
                    }
                }
                ),
                new SingleNodeTypeValidator<>(AssignExpr.class, (n, reporter) -> {
                    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.26
                    Expression target = n.getTarget();
                    while (target instanceof EnclosedExpr) {
                        target = ((EnclosedExpr) target).getInner();
                    }
                    if (target instanceof NameExpr
                            || target instanceof ArrayAccessExpr
                            || target instanceof FieldAccessExpr) {
                        return;
                    }
                    reporter.report(n.getTarget(), "Illegal left hand side of an assignment.");
                }
                ),
                new TreeVisitorValidator((node, problemReporter) -> {
                    NodeMetaModel mm = node.getMetaModel();
                    for (PropertyMetaModel ppm : mm.getAllPropertyMetaModels()) {
                        if (ppm.isNonEmpty()) {
                            if (ppm.isNodeList()) {
                                NodeList value = (NodeList) ppm.getValue(node);
                                if (value.isEmpty()) {
                                    problemReporter.report(node, "%s.%s can not be empty.", mm.getTypeName(), ppm.getName());
                                }
                            }
                            // No need to check empty strings, it should be impossible to set them to ""
                        }
                    }
                })
        );*/
    	super(
                new SimpleValidator<>(ClassOrInterfaceDeclaration.class,
                       new Predicate<ClassOrInterfaceDeclaration>() {

						@Override
						public Boolean test(ClassOrInterfaceDeclaration t) {
							
							return !t.isInterface() && t.getExtendedTypes().size() > 1;
						}
					},new BiConsumer<ClassOrInterfaceDeclaration, ProblemReporter>() {

						@Override
						public void accept(ClassOrInterfaceDeclaration t, ProblemReporter reporter) {
							reporter.report(t.getExtendedTypes(1), "A class cannot extend more than one other class.");
						}
					}),
                
                
                
                
                
                new SimpleValidator<>(ClassOrInterfaceDeclaration.class,
                		 new Predicate<ClassOrInterfaceDeclaration>() {

					@Override
					public Boolean test(ClassOrInterfaceDeclaration t) {
						
						return t.isInterface() && !t.getImplementedTypes().isEmpty();
					}
				},new BiConsumer<ClassOrInterfaceDeclaration, ProblemReporter>() {

					@Override
					public void accept(ClassOrInterfaceDeclaration n, ProblemReporter reporter) {
						reporter.report(n.getImplementedTypes(0), "An interface cannot implement other interfaces.");
					}
				}),
                
                
                new SingleNodeTypeValidator<>(ClassOrInterfaceDeclaration.class, new TypedValidator<ClassOrInterfaceDeclaration>() {

					@Override
					public void accept(ClassOrInterfaceDeclaration n, ProblemReporter problemReporter) {
						if (n.isInterface()) {
							for (BodyDeclaration<?>  mem: n.getMembers()) {
								if (mem instanceof InitializerDeclaration) {
									problemReporter.report(mem, "An interface cannot have initializers.");
	                            }
							}
	                    }
						
					}}),
                
                
                new SingleNodeTypeValidator<>(AssignExpr.class, new TypedValidator<AssignExpr>() {

					@Override
					public void accept(AssignExpr n, ProblemReporter problemReporter) {
						Expression target = n.getTarget();
	                    while (target instanceof EnclosedExpr) {
	                        target = ((EnclosedExpr) target).getInner();
	                    }
	                    if (target instanceof NameExpr
	                            || target instanceof ArrayAccessExpr
	                            || target instanceof FieldAccessExpr) {
	                        return;
	                    }
	                    problemReporter.report(n.getTarget(), "Illegal left hand side of an assignment.");
						
					}
				}),
                
                
                new TreeVisitorValidator(new Validator() {
					
					@Override
					public void accept(Node node, ProblemReporter problemReporter) {
						
						NodeMetaModel mm = node.getMetaModel();
	                    for (PropertyMetaModel ppm : mm.getAllPropertyMetaModels()) {
	                        if (ppm.isNonEmpty()) {
	                            if (ppm.isNodeList()) {
	                                NodeList value = (NodeList) ppm.getValue(node);
	                                if (value.isEmpty()) {
	                                    problemReporter.report(node, "%s.%s can not be empty.", mm.getTypeName(), ppm.getName());
	                                }
	                            }
	                            // No need to check empty strings, it should be impossible to set them to ""
	                        }
	                    }
					}
				})
        );
    }
}
