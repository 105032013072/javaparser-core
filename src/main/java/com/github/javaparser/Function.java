package com.github.javaparser;

public interface Function<T,R> {
  public <R> R  apply(T t);
}
