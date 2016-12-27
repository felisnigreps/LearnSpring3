package com.injectMethod;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xugenli on 2016/12/27.
 */
public class TargetObjectTest {
    @Test
    public void testLookup() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("singleton 开始");
        TargetObject target = context.getBean("singletonTarget",TargetObject.class);
        target.sayHello();
    }

}