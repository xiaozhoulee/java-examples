package com.java;
//Integer，int，String三者之间的转换
public class IntegerTest02 {
    //int–>Integer
    Integer i1 = Integer.valueOf(10);
    //Integer–>int
    int i2 = i1.intValue();
    //String–>Integer
    Integer i3 = Integer.valueOf("10");
    //Integer–>String
    String s1 = i3.toString();
    //String–>int
    int i4 = Integer.parseInt("123");
    //int–>String
    String s2 = 10 + "";
}
