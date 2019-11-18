package com.xiaozhoubg;

public class on_Cat {
    public static void main(String[] args) {
            Cat cat1 = new Cat();
            Cat cat2 = cat1;
            cat1.name = "Lily";
            System.out.println(cat2.name);

            int num1 = 100;
            int num2 = num1;
            num1 = 200;
            System.out.println(num2);
    }
}
