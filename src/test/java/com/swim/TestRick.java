package com.swim;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xugenli on 2016/12/27.
 */
public class TestRick {
    @Test
    public void testDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Hi rick = context.getBean("rick",RickHi.class);
        rick.say();
    }

}