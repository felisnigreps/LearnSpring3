package com.injectMethod;

/**
 * Created by xugenli on 2016/12/27.
 */
public abstract class TargetObject {

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    //引入实例
    private Printer printer;


    public abstract Printer createSingletonPrinter();


    public Printer createPrototypePrinter(){
        System.out.println("这个类被代理了，你不应该看到这个输出 笑~");
        return printer;
    }


    public void sayHello(){
        printer.print("printer");
        createPrototypePrinter().print("这个是prototype方法");
        createSingletonPrinter().print("这个是singleton方法");
    }



}
