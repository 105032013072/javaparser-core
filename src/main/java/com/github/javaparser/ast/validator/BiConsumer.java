package com.github.javaparser.ast.validator;

public interface BiConsumer<T, U>{
	void accept(T t, U u);
}
