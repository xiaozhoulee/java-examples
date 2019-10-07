package Extends.Private;

public class test01 {
    public static void main(String[] args){
        SubClass s =new SubClass();
        s.m1();
//        s.m2();//子类不能访问父类中private修饰的方法
        s.m3();
        s.m0();
    }
}
