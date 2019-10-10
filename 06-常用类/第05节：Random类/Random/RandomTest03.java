package Random;
//问题：完成一个彩票机选号码的生成器，这里就以双色球为例，双色球每注中奖号码由6个不同
// 的红色球号码和一个蓝色球号码组成。红色球号码从1-33中选择；蓝色球号码从1-16中选择。

import java.util.Arrays;
import java.util.Random;

//分析：随机从1-33选6个不同的数字，所以需要去掉重复的数字。然后随机从1-16中选一个数字。
public class RandomTest03 {
    public static void main(String[] args) {

        //初始化双色球号码
        int[] balls = new int[33];
        for(int i=0; i<balls.length; i++){
            balls[i] = i + 1;
        }

        //创建数组用来标记红球是否重复
        boolean[] isUsed = new boolean[33];

        //创建数组用来存放6个红球
        int[] result = new int[6];
        //初始化数组下标
        int length = 0;

        Random r = new Random();
        while(true){
            //生成0~32的随机数,将随机数作为数组下标,取得红球
            int red = r.nextInt(33);
            //判断生成的红球是否重复
            if(isUsed[red] == true){
                continue;
            }

            //将选中的红球存放到结果中
            result[length++] = balls[red];
            //如果等于6则说明已经生成了6个红球了，跳出循环
            if(length == 6){
                break;
            }

            //将生成的红球所对应的数组下标标记为true
            isUsed[red] = true;

        }
        //将数组排序
        Arrays.sort(result);
        //生成0~15的随机数,将随机数作为数组下标,取得蓝球
        int blue = r.nextInt(16);

        //将红球打印
        System.out.print("红球：");
        for(int i=0; i<result.length; i++){
            if(i == result.length - 1){
                System.out.print(result[i]);
            }else{
                System.out.print(result[i] + ",");
            }
        }

        //将蓝球打印
        System.out.print(" 蓝球：" + balls[blue]);
    }
}
