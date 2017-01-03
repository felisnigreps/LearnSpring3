package com.aop.annotation;

/**
 * Created by xugenli on 2016/12/31.
 */
public class SayAopImpl implements SayAop {
    @Override
    public void say(String param) {
        System.out.println("say annotation: "+ param);
    }
}
