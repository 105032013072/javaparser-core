package com.github.javaparser.ast.modules;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.ModuleDeclarationMetaModel;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import static com.github.javaparser.utils.Utils.assertNotNull;
import javax.annotation.Generated;
import com.github.javaparser.TokenRange;
import static com.github.javaparser.JavaParser.parseName;
import static com.github.javaparser.utils.Utils.assertNonEmpty;
import static com.github.javaparser.JavaParser.parseExpression;

/**
 * A Java 9 Jigsaw module declaration. <code>@Foo module com.github.abc { requires a.B; }</code>
 */
public final class ModuleDeclaration extends Node implements NodeWithName<ModuleDeclaration>, NodeWithAnnotations<ModuleDeclaration> {

    private Name name;

    private NodeList<AnnotationExpr> annotations;

    private boolean isOpen;

    private NodeList<ModuleStmt> moduleStmts;

    public ModuleDeclaration() {
        this(null, new NodeList<AnnotationExpr>(), new Name(), false, new NodeList<ModuleStmt>());
    }

    public ModuleDeclaration(Name name, boolean isOpen) {
        this(null, new NodeList<AnnotationExpr>(), name, isOpen, new NodeList<ModuleStmt>());
    }

    @AllFieldsConstructor
    public ModuleDeclaration(NodeList<AnnotationExpr> annotations, Name name, boolean isOpen, NodeList<ModuleStmt> moduleStmts) {
        this(null, annotations, name, isOpen, moduleStmts);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public ModuleDeclaration(TokenRange tokenRange, NodeList<AnnotationExpr> annotations, Name name, boolean isOpen, NodeList<ModuleStmt> moduleStmts) {
        super(tokenRange);
        setAnnotations(annotations);
        setName(name);
        setOpen(isOpen);
        setModuleStmts(moduleStmts);
        customInitialization();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Name getName() {
        return name;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ModuleDeclaration setName(final Name name) {
        assertNotNull(name);
        if (name == this.name) {
            return (ModuleDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.NAME, this.name, name);
        if (this.name != null)
            this.name.setParentNode(null);
        this.name = name;
        setAsParentNodeOf(name);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<AnnotationExpr> getAnnotations() {
        return annotations;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ModuleDeclaration setAnnotations(final NodeList<AnnotationExpr> annotations) {
        assertNotNull(annotations);
        if (annotations == this.annotations) {
            return (ModuleDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.ANNOTATIONS, this.annotations, annotations);
        if (this.annotations != null)
            this.annotations.setParentNode(null);
        this.annotations = annotations;
        setAsParentNodeOf(annotations);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < annotations.size(); i++) {
            if (annotations.get(i) == node) {
                annotations.remove(i);
                return true;
            }
        }
        for (int i = 0; i < moduleStmts.size(); i++) {
            if (moduleStmts.get(i) == node) {
                moduleStmts.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public boolean isOpen() {
        return isOpen;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ModuleDeclaration setOpen(final boolean isOpen) {
        if (isOpen == this.isOpen) {
            return (ModuleDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.OPEN, this.isOpen, isOpen);
        this.isOpen = isOpen;
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public NodeList<ModuleStmt> getModuleStmts() {
        return moduleStmts;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ModuleDeclaration setModuleStmts(final NodeList<ModuleStmt> moduleStmts) {
        assertNotNull(moduleStmts);
        if (moduleStmts == this.moduleStmts) {
            return (ModuleDeclaration) this;
        }
        notifyPropertyChange(ObservableProperty.MODULE_STMTS, this.moduleStmts, moduleStmts);
        if (this.moduleStmts != null)
            this.moduleStmts.setParentNode(null);
        this.moduleStmts = moduleStmts;
        setAsParentNodeOf(moduleStmts);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public ModuleDeclaration clone() {
        return (ModuleDeclaration) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public ModuleDeclarationMetaModel getMetaModel() {
        return JavaParserMetaModel.moduleDeclarationMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        for (int i = 0; i < annotations.size(); i++) {
            if (annotations.get(i) == node) {
                annotations.set(i, (AnnotationExpr) replacementNode);
                return true;
            }
        }
        for (int i = 0; i < moduleStmts.size(); i++) {
            if (moduleStmts.get(i) == node) {
                moduleStmts.set(i, (ModuleStmt) replacementNode);
                return true;
            }
        }
        if (node == name) {
            setName((Name) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }
    
    //for NodeWithName
    @SuppressWarnings("unchecked")
    public  ModuleDeclaration setName(String name){
    	assertNonEmpty(name);
        return setName(parseName(name));
    	}

    public  String getNameAsString(){
    	return getName().asString();
    	}
    
    //for NodeWithAnnotations
    public AnnotationExpr getAnnotation(int i) {
        return getAnnotations().get(i);
    }

    @SuppressWarnings("unchecked")
    public ModuleDeclaration setAnnotation(int i, AnnotationExpr element) {
        getAnnotations().set(i, element);
        return (ModuleDeclaration) this;
    }

    @SuppressWarnings("unchecked")
    public ModuleDeclaration addAnnotation(AnnotationExpr element) {
        getAnnotations().add(element);
        return (ModuleDeclaration) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public ModuleDeclaration addAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return (ModuleDeclaration) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    @SuppressWarnings("unchecked")
    public NormalAnnotationExpr addAndGetAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public ModuleDeclaration addAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    public NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAndGetAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this with a marker annotation
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public ModuleDeclaration addMarkerAnnotation(String name) {
        MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
                parseName(name));
        getAnnotations().add(markerAnnotationExpr);
        return (ModuleDeclaration) this;
    }

    /**
     * Annotates this with a marker annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public ModuleDeclaration  addMarkerAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addMarkerAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param expression the part between ()
     * @return this
     */
    @SuppressWarnings("unchecked")
    public ModuleDeclaration addSingleMemberAnnotation(String name, Expression expression) {
        SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
                parseName(name), expression);
        getAnnotations().add(singleMemberAnnotationExpr);
        return (ModuleDeclaration) this;
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public ModuleDeclaration addSingleMemberAnnotation(String name, String value) {
        return addSingleMemberAnnotation(name, parseExpression(value));
    }

    /**
     * Annotates this with a single member annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public ModuleDeclaration addSingleMemberAnnotation(Class<? extends Annotation> clazz,
                                        String value) {
        tryAddImportToParentCompilationUnit(clazz);
        return addSingleMemberAnnotation(clazz.getSimpleName(), value);
    }

    /**
     * Check whether an annotation with this name is present on this element
     *
     * @param annotationName the name of the annotation
     * @return true if found, false if not
     */
    public boolean isAnnotationPresent(String annotationName) {
       // return getAnnotations().stream().anyMatch(a -> a.getName().getIdentifier().equals(annotationName));
    	for (AnnotationExpr a : getAnnotations()) {
			if(a.getName().getIdentifier().equals(annotationName)) return true;
		}
    	return false;
    }

    /**
     * Check whether an annotation with this class is present on this element
     *
     * @param annotationClass the class of the annotation
     * @return true if found, false if not
     */
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return isAnnotationPresent(annotationClass.getSimpleName());
    }

    /**
     * Try to find an annotation by its name
     *
     * @param annotationName the name of the annotation
     */
    public AnnotationExpr getOptionalAnnotationByName(String annotationName) {
       // return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
    	for (AnnotationExpr a : getAnnotations()) {
		   if(a.getName().getIdentifier().equals(annotationName))	return a;
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

    /**
     * Try to find an annotation by its class
     *
     * @param annotationClass the class of the annotation
     */
    public AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
        return getOptionalAnnotationByName(annotationClass.getSimpleName());
    }
    
    public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
    	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
    	if(optional!=null) return optional;
    	else return null;
    }
}
