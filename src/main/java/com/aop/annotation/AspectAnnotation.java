package com.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xugenli on 2016/12/31.
 */
@Aspect
public class AspectAnnotation {
//    @Pointcut("within(com.aop..*)")
    @Pointcut("execution(* com.aop.annotation..*.say(..))")
//    @Pointcut("this(com.aop.annotation.SayAop)" )
    public void doSome() {
    }

    //切入点的参数，target和advice共有的，advice接收方法的参数，然后进行处理
    @Before(value = "doSome() && args(param)")
    public void beforeAnnotation(String param) {
        System.out.println("---before Annotation---"+param);
    }

    @Before(value = "doSome()")
    public void beforeAnnotation1() {
        System.out.println("---before Annotation11111---");
    }

    @Before(value = "doSome()")
    public void beforeAnnotation2() {
        System.out.println("---before Annotation22222---");
    }

}