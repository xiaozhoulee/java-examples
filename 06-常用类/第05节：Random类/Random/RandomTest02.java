package Random;

import java.util.Random;
//循环生成5个随机数
public class RandomTest02 {
   public static void main(String[] args){
       Random r= new Random();
       for(int i=0;i<5;i++){
           System.out.println(r.nextInt(11));
           //随机循环5个0-10之间的属
       }
   }
}
