package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest02 {
    public static void main(String[] args){
        //输出当前日期
        Date d = new Date();
        System.out.println(d);

        //打印结果是1970年1月1日08:00:00
        Date d2 = new Date(0L);//参数填写Lang类型，0L
        System.out.println(d2);

        // SimpleDateFormat关键字可以让日期打印出想要的格式
        //y是年，大写的M是月，d是日，h是时，小写的m是分，小写的s是秒，大写的S是毫秒。
        SimpleDateFormat a =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        String date = a.format(d);//利用format关键字将信息传给String类型中
        System.out.println(date);

    }
}
