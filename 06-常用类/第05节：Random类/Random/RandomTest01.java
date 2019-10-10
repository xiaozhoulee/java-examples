package Random;

import java.util.Random;
public class RandomTest01 {
    public  static void main(String[] args){
        //创建一个Random类对象
        Random r=new Random();

        //它会生成一个int类型的随机数
        int ran =r.nextInt(101);//是输出0-100之间的随机数
        System.out.println(ran);
    }
}
