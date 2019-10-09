package com.java;
//       基本类型	包装类
//        byte	Byte
//        short	Short
//        int	Integer
//        long	Long
//        float	Float
//        double	Double
//        char	Character
//        boolean	Boolean
public class IntegerTest01 {
    public static void main(String[] args){
        //Integer最大值
            System.out.println(Integer.MAX_VALUE);

        //Integer最小值
            System.out.println(Integer.MIN_VALUE);

        //给Integer赋值100
            Integer i1 = new Integer(100);
            System.out.println(i1);

        //给Integer赋值1000
        //注意：这里赋值的是字符串类型的字符串1000.也可以打印出来。但是字符串类型必须赋值的是数字类型，否则会报错。
            Integer i2 = new Integer("1000");
            System.out.println(i2);

        //可以将Integer类型转换成int类型
            int i3 = i2.intValue();

        //可以将String类型转换成int类型
            int i4 = Integer.parseInt("100");

        //可以将int类型转换成Integer类型
        Integer i5 = Integer.valueOf(8);

        //可以将10进制的int类型转换成2进制的。
        String s1=Integer.toBinaryString(6);//将6转换成2进制
                                //8进制
        String s2=Integer.toOctalString(20);//将20转换成2进制
                                //16进制
        String s3=Integer.toHexString(88);//将88转换成2进制
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
