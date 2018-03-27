package com.github.javaparser.ast.validator;

import com.github.javaparser.Predicate;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.modules.ModuleDeclaration;
import com.github.javaparser.ast.nodeTypes.NodeWithTokenRange;
import com.github.javaparser.ast.nodeTypes.NodeWithTypeArguments;
import com.github.javaparser.ast.nodeTypes.NodeWithTypeParameters;
import com.github.javaparser.ast.stmt.AssertStmt;
import com.github.javaparser.ast.stmt.ForeachStmt;
import com.github.javaparser.ast.stmt.SwitchEntryStmt;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.type.UnionType;
import com.github.javaparser.ast.validator.chunks.CommonValidators;
import com.github.javaparser.ast.validator.chunks.ModifierValidator;
import com.github.javaparser.ast.validator.chunks.NoBinaryIntegerLiteralsValidator;
import com.github.javaparser.ast.validator.chunks.NoUnderscoresInIntegerLiteralsValidator;

/**
 * This validator validates according to Java 1.0 syntax rules.
 */
public class Java1_0Validator extends Validators {
    protected final Validator modifiersWithoutStrictfpAndDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods
            = new ModifierValidator(false, false, false);
   /* protected final Validator noAssertKeyword = new SimpleValidator<>(AssertStmt.class,
             n->true,
            (n, reporter) -> reporter.report(n, "'assert' keyword is not supported.")
    );*/
    
    protected final Validator noAssertKeyword = createNoAssertKeyword();
    protected final Validator noInnerClasses=createNoInnerClasses();
    protected final Validator noReflection=createNoReflection();
    protected final Validator noGenerics =createNoGenerics();
    protected final SingleNodeTypeValidator<TryStmt> tryWithoutResources=createTryWithoutResources();
    
   /*
   
  
    protected final SingleNodeTypeValidator<TryStmt> tryWithoutResources = new SingleNodeTypeValidator<>(TryStmt.class, (n, reporter) -> {
        if (n.getCatchClauses().isEmpty() && !n.getFinallyBlock().isPresent()) {
            reporter.report(n, "Try has no finally and no catch.");
        }
        if (n.getResources().isNonEmpty()) {
            reporter.report(n, "Catch with resource is not supported.");
        }
    });
    protected final Validator noAnnotations = new TreeVisitorValidator((node, reporter) -> {
        if (node instanceof AnnotationExpr || node instanceof AnnotationDeclaration) {
            reporter.report(node, "Annotations are not supported.");
        }
    });
    protected final Validator noEnums = new SimpleValidator<>(EnumDeclaration.class,
            n -> true,
            (n, reporter) -> reporter.report(n, "Enumerations are not supported.")
    );
    protected final Validator noVarargs = new SimpleValidator<>(Parameter.class,
            Parameter::isVarArgs,
            (n, reporter) -> reporter.report(n, "Varargs are not supported.")
    );
    protected final Validator noForEach = new SimpleValidator<>(ForeachStmt.class,
            n -> true,
            (n, reporter) -> reporter.report(n, "For-each loops are not supported.")
    );
    protected final Validator noStaticImports = new SimpleValidator<>(ImportDeclaration.class,
            ImportDeclaration::isStatic,
            (n, reporter) -> reporter.report(n, "Static imports are not supported.")
    );
    protected final Validator noStringsInSwitch = new SimpleValidator<>(SwitchEntryStmt.class,
            n -> n.getLabel().map(l -> l instanceof StringLiteralExpr).orElse(false),
            (n, reporter) -> reporter.report(n.getLabel().get(), "Strings in switch statements are not supported.")
    );
    protected final Validator noBinaryIntegerLiterals = new NoBinaryIntegerLiteralsValidator();
    protected final Validator noUnderscoresInIntegerLiterals = new NoUnderscoresInIntegerLiteralsValidator();
    protected final Validator noMultiCatch = new SimpleValidator<>(UnionType.class,
            n -> true,
            (n, reporter) -> reporter.report(n, "Multi-catch is not supported.")
    );
    protected final Validator noLambdas = new SimpleValidator<>(LambdaExpr.class,
            n -> true,
            (n, reporter) -> reporter.report(n, "Lambdas are not supported.")
    );
    protected final Validator noModules = new SimpleValidator<>(ModuleDeclaration.class,
            n -> true,
            (n, reporter) -> reporter.report(n, "Modules are not supported.")
    );*/

    public Java1_0Validator() {
        /*super(new CommonValidators());
        add(modifiersWithoutStrictfpAndDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods);
        add(noAssertKeyword);
        add(noInnerClasses);
        add(noReflection);
        add(noGenerics);
        add(tryWithoutResources);
        add(noAnnotations);
        add(noEnums);
        add(noVarargs);
        add(noForEach);
        add(noStaticImports);
        add(noStringsInSwitch);
        add(noBinaryIntegerLiterals);
        add(noUnderscoresInIntegerLiterals);
        add(noMultiCatch);
        add(noLambdas);
        add(noModules);*/
    }


	private SingleNodeTypeValidator<TryStmt> createTryWithoutResources() {
		
		
		
		new SingleNodeTypeValidator<>(TryStmt.class, (n, reporter) -> {
	        if (n.getCatchClauses().isEmpty() && !n.getFinallyBlock().isPresent()) {
	            reporter.report(n, "Try has no finally and no catch.");
	        }
	        if (n.getResources().isNonEmpty()) {
	            reporter.report(n, "Catch with resource is not supported.");
	        }
	    });
	}


	private Validator createNoGenerics() {
		
		Validator validator=new Validator() {
			
			@Override
			public void accept(Node node, ProblemReporter problemReporter) {
				if (node instanceof NodeWithTypeArguments) {
		            if (((NodeWithTypeArguments<? extends Node>) node).getTypeArguments()!=null) {
		            	problemReporter.report(node, "Generics are not supported.");
		            }
		        }
		        if (node instanceof NodeWithTypeParameters) {
		            if (((NodeWithTypeParameters<? extends Node>) node).getTypeParameters().isNonEmpty()) {
		            	problemReporter.report(node, "Generics are not supported.");
		            }
		        }
				
			}
		};
		return new TreeVisitorValidator(validator);
	}


	private Validator createNoReflection() {
		
		Predicate predicate=new Predicate<ClassExpr>() {
			@Override
			public Boolean test(ClassExpr t) {
				return true;
			}
		};
		
		BiConsumer<ClassExpr, ProblemReporter> biConsumer=new BiConsumer<ClassExpr, ProblemReporter>() {

			@Override
			public void accept(ClassExpr n, ProblemReporter reporter) {
				reporter.report(n, "Reflection is not supported.");
			}
		};
		return new SimpleValidator<>(ClassExpr.class,predicate,biConsumer);
	}


	private Validator createNoInnerClasses() {
		
		Predicate predicate=new Predicate<ClassOrInterfaceDeclaration>() {
			@Override
			public Boolean test(ClassOrInterfaceDeclaration t) {
				return !t.isTopLevelType();
			}
		};
		
		BiConsumer<ClassOrInterfaceDeclaration, ProblemReporter> biConsumer=new BiConsumer<ClassOrInterfaceDeclaration, ProblemReporter>() {

			@Override
			public void accept(ClassOrInterfaceDeclaration n, ProblemReporter reporter) {
				reporter.report(n, "inner classes or interfaces are not supported.");
			}
		};
		
		
		return new SimpleValidator<>(ClassOrInterfaceDeclaration.class, predicate,biConsumer);
	}


	private Validator createNoAssertKeyword() {
		Predicate predicate=new Predicate<AssertStmt>() {
			@Override
			public Boolean test(AssertStmt t) {
				return true;
			}
		};
		
		BiConsumer<AssertStmt, ProblemReporter> biConsumer=new BiConsumer<AssertStmt, ProblemReporter>() {

			@Override
			public void accept(AssertStmt n, ProblemReporter reporter) {
				reporter.report(n, "'assert' keyword is not supported.");
			}
		};
		
	return new SimpleValidator<AssertStmt>(AssertStmt.class,predicate,biConsumer);
	}
}
