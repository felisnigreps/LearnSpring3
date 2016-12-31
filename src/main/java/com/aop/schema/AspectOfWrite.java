package com.aop.schema;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by xugenli on 2016/12/29.
 */
public class AspectOfWrite {
    public void before() {
        System.out.println("----before without args----");
    }

    public void afterFinally() {
        System.out.println("----after without args----");
    }

    //这个参数不是target的参数，是aspect中method的参数
    public void beforeWithArgs(String args) {
        System.out.println("---before args---" + args);
    }

    public void afterWithArgs(String args) {
        System.out.println("---after args---" + args);

    }

    public void afterThrowing(String args) {
        System.out.println("---afterThrowing---" + args);
        throw new IndexOutOfBoundsException();
    }

    public String afterReturning() {
        System.out.println("---after returning---");
        return "I like meat";
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---around before---");

        // Object retVal = joinPoint.proceed(new Object[]{"around"});
        Object retVal = joinPoint.proceed();

        System.out.println("---around after---");

        return retVal;

    }
}
