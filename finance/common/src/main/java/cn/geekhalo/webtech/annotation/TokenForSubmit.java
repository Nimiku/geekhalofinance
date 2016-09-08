package cn.geekhalo.webtech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenForSubmit {
	boolean create() default false;
	String errorPage() default "";
	boolean remove() default false;
}
