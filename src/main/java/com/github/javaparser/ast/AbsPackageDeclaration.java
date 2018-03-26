package com.github.javaparser.ast;

import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;

import java.lang.annotation.Annotation;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithName;


public abstract class AbsPackageDeclaration extends Node implements NodeWithAnnotations<PackageDeclaration>, NodeWithName<PackageDeclaration>{

	protected AbsPackageDeclaration(TokenRange tokenRange) {
		super(tokenRange);

	}

	 public  AnnotationExpr getAnnotation(int i) {
	        return getAnnotations().get(i);
	    }

	    
	    public  PackageDeclaration setAnnotation(int i, AnnotationExpr element) {
	        getAnnotations().set(i, element);
	        return (PackageDeclaration) this;
	    }

	   
	    public  PackageDeclaration addAnnotation(AnnotationExpr element) {
	        getAnnotations().add(element);
	        return (PackageDeclaration) this;
	    }

	   
	    @SuppressWarnings("unchecked")
	    public PackageDeclaration addAnnotation(String name) {
	        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
	                parseName(name), new NodeList<>());
	        getAnnotations().add(annotation);
	        return (PackageDeclaration) this;
	    }

	    
	    @SuppressWarnings("unchecked")
	    public NormalAnnotationExpr addAndGetAnnotation(String name) {
	        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
	                parseName(name), new NodeList<>());
	        getAnnotations().add(annotation);
	        return annotation;
	    }

	   
	    public PackageDeclaration addAnnotation(Class<? extends Annotation> clazz) {
	        tryAddImportToParentCompilationUnit(clazz);
	        return addAnnotation(clazz.getSimpleName());
	    }

	   
	    public NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
	        tryAddImportToParentCompilationUnit(clazz);
	        return addAndGetAnnotation(clazz.getSimpleName());
	    }

	    
	    public PackageDeclaration addMarkerAnnotation(String name) {
	        MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
	                parseName(name));
	        getAnnotations().add(markerAnnotationExpr);
	        return (PackageDeclaration) this;
	    }

	    
	    public PackageDeclaration addMarkerAnnotation(Class<? extends Annotation> clazz) {
	        tryAddImportToParentCompilationUnit(clazz);
	        return addMarkerAnnotation(clazz.getSimpleName());
	    }

	   
	    @SuppressWarnings("unchecked")
	    public PackageDeclaration addSingleMemberAnnotation(String name, Expression expression) {
	        SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
	                parseName(name), expression);
	        getAnnotations().add(singleMemberAnnotationExpr);
	        return (PackageDeclaration) this;
	    }

	   
	    public PackageDeclaration addSingleMemberAnnotation(String name, String value) {
	        return addSingleMemberAnnotation(name, parseExpression(value));
	    }

	    
	    public PackageDeclaration addSingleMemberAnnotation(Class<? extends Annotation> clazz,
	                                        String value) {
	        tryAddImportToParentCompilationUnit(clazz);
	        return addSingleMemberAnnotation(clazz.getSimpleName(), value);
	    }

	    
	    public boolean isAnnotationPresent(String annotationName) {
	        //return getAnnotations().stream().anyMatch(a -> a.getName().getIdentifier().equals(annotationName));
	    	NodeList<AnnotationExpr> list= getAnnotations();
	    	for (AnnotationExpr annotationExpr : list) {
				if( annotationExpr.getName().getIdentifier().equals(annotationName)) return true;
			}
	    	return false;
	    }

	   
	    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
	        return isAnnotationPresent(annotationClass.getSimpleName());
	    }

	    public AnnotationExpr getOptionalAnnotationByName(String annotationName) {
	        //return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
	    	NodeList<AnnotationExpr> list= getAnnotations();
	    	for (AnnotationExpr annotationExpr : list) {
				if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
			}
	    	return null;
	    }
	    
	    public AnnotationExpr getAnnotationByName(String annotationName){
	    	NodeList<AnnotationExpr> annotationList =getAnnotations();
	    	for (AnnotationExpr annotationExpr : annotationList) {
				if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
			}
	    	return null;
	    }

	    
	    public AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
	        return getOptionalAnnotationByName(annotationClass.getSimpleName());
	    }
	    
	    public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
	    	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
	    	if(optional!=null) return optional;
	    	else return null;
	    }
	    
	   
	    public PackageDeclaration setName(String name) {
	       if(name!=null &&!"".equals(name)){
	    	   return setName(parseName(name));
	       }else return null;
	        
	    }

	    public String getNameAsString() {
	        return getName().asString();
	    }
}
