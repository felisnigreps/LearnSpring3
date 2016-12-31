package com.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xugenli on 2016/12/31.
 */
@Aspect
public class AspectAnnotation {
    @Pointcut("execution(* com.aop.annotation..*.say(..))")
    public void doSome() {
    }

    @Before(value = "doSome()")
    public void beforeAnnotation() {
        System.out.println("---before Annotation---");
    }
}
