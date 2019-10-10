package Math;

public class MathTest01 {
    public static void main(String args[]){
        //圆周率
        System.out.println(Math.PI);
        //取绝对值
        System.out.println(Math.abs(-10));

        //ceil天花板，会向上取值，结果是double
        System.out.println(Math.ceil(12.3));
        System.out.println(Math.ceil(12.99));

        System.out.println("-----------");
        //floor地板，会向下取整,结果是double
        System.out.println(Math.floor(12.3));
        System.out.println(Math.floor(12.99));

        //获取两个值中的最大值
        System.out.println(Math.max(20, 30));

        //前面的数是底数,后面的数是指数，即2的3次方
        System.out.println(Math.pow(2, 3));

        //生成0.0到1.0之间的随机小数,包括0.0,不包括1.0
        System.out.println(Math.random());
        //生成0到100之间的随机整数,包括0,不包括100
        System.out.println(Math.floor(Math.random()*100));


        //四舍五入
        System.out.println(Math.round(12.3f));
        System.out.println(Math.round(12.9f));

        //开平方
        System.out.println(Math.sqrt(16));
    }

}
