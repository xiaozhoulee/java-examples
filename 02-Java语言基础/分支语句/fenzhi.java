package com.xiaozhoubg;

public class fenzhi {
    public static void main(String[] args) {
//        第一题
        int x=60;//定义分数为60分

        if (x >= 90 && x <= 100) {
            System.out.println("A");
        }else if (x >= 80 && x <= 89 ) {
            System.out.println("B");
        }else if (x >= 60 && x <= 79 ) {
            System.out.println("C");
        }else if (x >= 0 && x <= 59 ) {
            System.out.println("D");
        }else {
            System.out.println("成绩格式错误!");
        }

//        第二题
        int month = 3;//定义月份为三月
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println(month + "月是春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(month + "月是夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(month + "月是秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println(month + "月是冬季");
                break;
            default:
                System.out.println("对不起没有对应的季节");
                break;
        }
    }
}
