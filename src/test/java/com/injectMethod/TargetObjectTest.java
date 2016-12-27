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
        System.out.println("==============singleton target + prototype printer");
        TargetObject target = context.getBean("singletonTarget",TargetObject.class);
        target.sayHello();
        System.out.println("==============第二次请求 singleton target + prototype printer");
        target = context.getBean("singletonTarget",TargetObject.class);
        target.sayHello();

        System.out.println("==============prototype target + prototype printer");
        TargetObject target1 = context.getBean("prototypeTarget",TargetObject.class);
        target1.sayHello();
        System.out.println("==============第二次请求prototype target + prototype printer");
        target1 = context.getBean("prototypeTarget",TargetObject.class);
        target.sayHello();

        //根据输出结果可以看出已经通过lookup成功代理。并且singleton只存在一个实例。 而prototype会每次都生成新实例
    }

}