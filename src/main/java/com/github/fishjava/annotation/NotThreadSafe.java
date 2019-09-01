package com.github.fishjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记线程不安全的类或者方法
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {
}
