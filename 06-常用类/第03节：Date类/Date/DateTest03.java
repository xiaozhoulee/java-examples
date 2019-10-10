package Date;
//Calendar,另一种日期方法
import java.util.Calendar;

public class DateTest03 {
public static void main(String[] args){
    //输出今天是这周的第几天
    Calendar c= Calendar.getInstance();
   int i = c.get(Calendar.DAY_OF_WEEK);//它会返回一个int类型的值，它返回的值是今天是这周的第几天
    System.out.println(i);//美国人把周日当成第一天，所以如果输出结果是4，那么说明今天是星期三

    //输出今天是这个月的第几天
    System.out.println(c.get(Calendar.DAY_OF_MONTH));

    //输出这周是这个月的第几周
    System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));

    //输出今天是这个年的第几天
    System.out.println(c.get(Calendar.DAY_OF_YEAR));



}
}
