package Date;


// * 获取从 1970年1月1日 00时00分00秒 000毫秒 到当前的毫秒数
 //* 输出String和StringBuffer分别进行字符串拼接所需要的毫秒数

public class DateTest01 {

    public static void main(String[] args) {
        //System.currentTimeMillis()会返回long类型值，这段代码会获取从 1970年1月1日 00时00分00秒 000毫秒 到当前的毫秒数
        long sj = System.currentTimeMillis();
        System.out.println(sj);

        String s = "";
        StringBuffer s2 = new StringBuffer();

        //获取拼接前的毫秒数,也就是当前时间
        long before = System.currentTimeMillis();
        for(int i=0; i<=100; i++){
             s += i;//拼接String
//             s2.append(i);//拼接StringBuffer
        }
        //拼接后的毫秒数
        long after = System.currentTimeMillis();
        //会打印出拼接需要的总时间
        System.out.println(after - before);
    }

}