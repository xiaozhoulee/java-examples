package com.xiaozhoubg;

public class yunsuan {
    public static void main(String[] args) {
        //第一题
        int a = 10;
        int b = 10;
        int c = 10;

        a = b++;    //此时a的值是10 ,b的值是11
        c = --a;    //a的值是9, c的值是9
        b = ++a;    //a的值是10, b的值是10
        a = c--;    //a的值是9, c的值是8

        System.out.println("a = " + a + ",b = " + b + ",c = " + c);

        //第二题
        int i = 10;
         i +=10;
         System.out.println(i);

        //第三题
        int m1 = 10;
        int m2 = 20;
        int m3 = 30;
        //先比较任意两个数的值,找出这两个数中的最大值
        int temp = (m1 > m2) ? m1 : m2;
        //用前两个数的最大值与第三个数比较,获取最大值
        int max = (temp > m3) ? temp : m3;
        System.out.println("max =" + max);
    }
}
