package com.xiaozhoubg;

public class xunhuan {
    public static void main(String[] args) {
//        第一题
        int sum = 0;

        for(int i=1;i<=100;i++){

            if(i%2 != 0){
                //奇数
                //追加
                sum += i;
            }

        }
        System.out.println(sum);


//       第二题
        //外层for循环控制换行，变量i是行号
        for (int i = 1; i <= 9; i++) {
            //System.out.println(i);

            // 输出规律：
            // 第1行，输出1个
            // 第2行，输出2个
            // 第3行，输出3个
            // ...
            // 第9行，输出9个
            // 第i行，输出i个

            for (int j = 1; j <= i; j++) {
                // 这里不要换行
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }

            // 注意：上面的for循环结束之后表示一行输出结束了，换行
            System.out.println();

        }
    }
}
