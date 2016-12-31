package com.aop.schema;

/**
 * Created by xugenli on 2016/12/29.
 */
public class WriteJava implements WriteAll {


    @Override
    public void write() {
        System.out.println("I'm a programmer, I need code, really. ");

    }

    @Override
    public void writeSong(String lyc) {
        System.out.println("this song is " + lyc);

    }

    @Override
    public void writeException(String exc) throws Exception {
        throw new Exception();
    }

    @Override
    public String writeReturn() {
        System.out.println("返回方法");
        return "返回";
    }

    @Override
    public void writeAround(String args) {
        System.out.println("--around advice--" + args);
    }
}
