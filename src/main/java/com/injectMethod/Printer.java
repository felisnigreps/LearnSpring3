package com.injectMethod;

/**
 * Created by xugenli on 2016/12/27.
 */
public class Printer {

    private int count = 0;

    public void print(String type) {
        System.out.println(type + "-------- " + count++);

    }


}
