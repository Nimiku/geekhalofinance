package cn.geekhalo.webtech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 审计日志的注解
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminAudit {
	String name() default "";
	String desc() default "";
	String operateLevel() default "";
	String param() default "";
	String remarkParams() default "";//
}
