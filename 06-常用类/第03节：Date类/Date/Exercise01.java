package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//练习：算一下你来到这个世界多少天?
//分析：获取出生日期和当前日期的Date类型，然后将两个日期的毫秒值做减法，之后用这个毫秒值除以1000,再除以60,再除以60,再除以24得到天
public class Exercise01 {
    public static void main(String[] args) throws ParseException {
        //生日
        String birthday = "2016年06月15日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //将生日字符串转换成日期对象
        Date d1 = sdf.parse(birthday);
        Date d2 = new Date();
        //将两个日期的毫秒值做减法
        long time = d2.getTime() - d1.getTime();
        //除以1000,再除以60,再除以60,再除以24得到天
        System.out.println(time / 1000 / 60 / 60 / 24 );
    }
}
