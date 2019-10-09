package com.java;

public class IntegerTest03 {
    public static void main(String[] args){
        //自动装箱：把基本类型转换为包装类类型
        Integer c1 = 10;

        //自动拆箱：把包装类类型转换为基本类型
        Integer c2 = 10;
        int c3 = c2;

        //注意：在判断两个Integer类型是否相等时，要使用equals方法，不能使用"=="。
        Integer b1 = 128;
        Integer b2 = 128;
        System.out.println(b1==b2);//false
        System.out.println(b1.equals(b2));//true
        //相当于
        Integer b3 = new Integer(128);
        Integer b4 = new Integer(128);
        System.out.println(b3==b4);//false
        System.out.println(b3.equals(b4));//true

        //如果数据是在(-128~127)之间，java中在方法区中引入了一个“整型常量池”。
        //下面程序打印的结果
        Integer i5 = 127;
        Integer i6 = 127;

        System.out.println(i5==i6); //true
        //上面程序不会在堆中创建对象，会直接从整型常量池中拿。
        //比较Integer的值是否相等时，一定要使用equals方法
    }
}
