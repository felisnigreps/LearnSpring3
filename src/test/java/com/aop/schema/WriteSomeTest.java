package com.aop.schema;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xugenli on 2016/12/29.
 */
public class WriteSomeTest {
    @Test
    public void write() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //target一定要实现接口
        //注意后面的方法一定是接口的class
        WriteAll code = context.getBean("writeJava", WriteAll.class);
        code.write();
        code.writeSong("sentiment");
        // code.writeException("Phil");
        code.writeReturn();
        code.writeAround("oh");
        //为code对象引入新接口 com.swim.hi
    }

}