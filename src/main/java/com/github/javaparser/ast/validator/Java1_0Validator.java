package com.github.javaparser.ast.validator;

import com.github.javaparser.Predicate;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.Expression;
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
    protected final Validator noAnnotations =createNoAnnotations();
    protected final Validator noEnums=createNoEnums();
    protected final Validator noVarargs=createNoVarargs();
    protected final Validator noForEach =createNoForEach();
    protected final Validator noStaticImports = createNoStaticImports();
    protected final Validator noStringsInSwitch = createNoStringsInSwitch();
    protected final Validator noBinaryIntegerLiterals = new NoBinaryIntegerLiteralsValidator();
    protected final Validator noUnderscoresInIntegerLiterals = new NoUnderscoresInIntegerLiteralsValidator();
    protected final Validator noMultiCatch =createNoMultiCatch();
    protected final Validator noLambdas=createNoLambdas();
    protected final Validator noModules=createNoModules();
    
    
  
    public Java1_0Validator() {
       super(new CommonValidators());
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
        add(noModules);
    }


	private Validator createNoModules() {
		Predicate predicate=new Predicate<ModuleDeclaration>() {
			@Override
			public Boolean test(ModuleDeclaration t) {
				return true;
			}
		};
		
		BiConsumer<ModuleDeclaration, ProblemReporter> biConsumer=new BiConsumer<ModuleDeclaration, ProblemReporter>() {

			@Override
			public void accept(ModuleDeclaration n, ProblemReporter reporter) {
				reporter.report(n, "Modules are not supported.");
			}
		};
	  return new SimpleValidator<>(ModuleDeclaration.class,predicate,biConsumer);
	}


	private Validator createNoLambdas() {
		Predicate predicate=new Predicate<LambdaExpr>() {
			@Override
			public Boolean test(LambdaExpr t) {
				return true;
			}
		};
		
		BiConsumer<LambdaExpr, ProblemReporter> biConsumer=new BiConsumer<LambdaExpr, ProblemReporter>() {

			@Override
			public void accept(LambdaExpr n, ProblemReporter reporter) {
				reporter.report(n, "Lambdas are not supported.");
			}
		};
		return new SimpleValidator<>(LambdaExpr.class,predicate,biConsumer);
	}


	private Validator createNoMultiCatch() {
		Predicate predicate=new Predicate<UnionType>() {
			@Override
			public Boolean test(UnionType t) {
				return true;
			}
		};
		
		BiConsumer<UnionType, ProblemReporter> biConsumer=new BiConsumer<UnionType, ProblemReporter>() {

			@Override
			public void accept(UnionType n, ProblemReporter reporter) {
				reporter.report(n, "Multi-catch is not supported.");
			}
		};
		return new SimpleValidator<>(UnionType.class,predicate,biConsumer);
	}


	private Validator createNoStringsInSwitch() {
		Predicate predicate=new Predicate<SwitchEntryStmt>() {
			@Override
			public Boolean test(SwitchEntryStmt t) {
				Expression exp=t.getLabel();
				if(exp!=null){
					return exp instanceof StringLiteralExpr;
				}else return false;
			}
		};
		
		BiConsumer<SwitchEntryStmt, ProblemReporter> biConsumer=new BiConsumer<SwitchEntryStmt, ProblemReporter>() {

			@Override
			public void accept(SwitchEntryStmt n, ProblemReporter reporter) {
				reporter.report(n.getLabel(), "Strings in switch statements are not supported.");
			}
		};
		return  new SimpleValidator<>(SwitchEntryStmt.class,predicate,biConsumer);
	}


	private Validator createNoStaticImports() {
		Predicate predicate=new Predicate<ImportDeclaration>() {
			@Override
			public Boolean test(ImportDeclaration t) {
				return t.isStatic();
			}
		};
		
		BiConsumer<ImportDeclaration, ProblemReporter> biConsumer=new BiConsumer<ImportDeclaration, ProblemReporter>() {

			@Override
			public void accept(ImportDeclaration n, ProblemReporter reporter) {
				reporter.report(n, "Static imports are not supported.");
			}
		};
		return new SimpleValidator<>(ImportDeclaration.class,predicate,biConsumer);
	}


	private Validator createNoForEach() {
		Predicate predicate=new Predicate<ForeachStmt>() {
			@Override
			public Boolean test(ForeachStmt t) {
				return true;
			}
		};
		
		BiConsumer<ForeachStmt, ProblemReporter> biConsumer=new BiConsumer<ForeachStmt, ProblemReporter>() {

			@Override
			public void accept(ForeachStmt n, ProblemReporter reporter) {
				reporter.report(n, "For-each loops are not supported.");
			}
		};
		return new SimpleValidator<>(ForeachStmt.class,predicate,biConsumer);
	}


	private Validator createNoVarargs() {
		Predicate predicate=new Predicate<Parameter>() {
			@Override
			public Boolean test(Parameter t) {
				return t.isVarArgs();
			}
		};
		
		BiConsumer<Parameter, ProblemReporter> biConsumer=new BiConsumer<Parameter, ProblemReporter>() {

			@Override
			public void accept(Parameter n, ProblemReporter reporter) {
				reporter.report(n, "Varargs are not supported.");
			}
		};
		return new SimpleValidator<>(Parameter.class,predicate,biConsumer);
	}


	private Validator createNoEnums() {
		
		Predicate predicate=new Predicate<EnumDeclaration>() {
			@Override
			public Boolean test(EnumDeclaration t) {
				return true;
			}
		};
		
		BiConsumer<EnumDeclaration, ProblemReporter> biConsumer=new BiConsumer<EnumDeclaration, ProblemReporter>() {

			@Override
			public void accept(EnumDeclaration n, ProblemReporter reporter) {
				reporter.report(n, "Enumerations are not supported.");
			}
		};
	
		return new SimpleValidator<>(EnumDeclaration.class,predicate,biConsumer);
	}


	private Validator createNoAnnotations() {
		Validator validator=new Validator() {
			
			@Override
			public void accept(Node node, ProblemReporter problemReporter) {
				if (node instanceof AnnotationExpr || node instanceof AnnotationDeclaration) {
					problemReporter.report(node, "Annotations are not supported.");
		        }
			}
		};

       return new TreeVisitorValidator(validator);
	}


	private SingleNodeTypeValidator<TryStmt> createTryWithoutResources() {
		
		TypedValidator typedValidator=new TypedValidator<TryStmt>() {

			@Override
			public void accept(TryStmt node, ProblemReporter problemReporter) {
				if (node.getCatchClauses().isEmpty() && node.getFinallyBlock()==null) {
					problemReporter.report(node, "Try has no finally and no catch.");
		        }
		        if (node.getResources().isNonEmpty()) {
		        	problemReporter.report(node, "Catch with resource is not supported.");
		        }
			}
		};
		
		return new SingleNodeTypeValidator<>(TryStmt.class, typedValidator);
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
