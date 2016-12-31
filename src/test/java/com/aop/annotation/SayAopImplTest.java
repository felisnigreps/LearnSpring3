package com.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xugenli on 2016/12/31.
 */
public class SayAopImplTest {
    @Test
    public void say() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SayAop sayAop = context.getBean("sayAop",SayAop.class);
        sayAop.say();
    }

}