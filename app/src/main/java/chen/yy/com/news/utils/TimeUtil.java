package chen.yy.com.news.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/11
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class TimeUtil {

      public static  String parseString(String time){
            int i = Integer.parseInt(time);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
            String format = simpleDateFormat.format(new Date(i));
            return format;
      }
      public static  String parseTime(String time){
            String parse="";
            int i = Integer.parseInt(time);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
            String format = simpleDateFormat.format(new Date(i));
            String[] dividerTime=format.split(":");
            int i1 = Integer.parseInt(dividerTime[0]);
            int i2 = Integer.parseInt(dividerTime[1]);
            int i3 = Integer.parseInt(dividerTime[2]);

            if((i1>0)&&(i2>30)){
                  parse=++i1+"小时前";
            }else if (i1>=0&&i2<30){
                  parse=i1+"大约小时前";
            }else if (i1==0&&i2==60){
                  parse=1+"小时前";
            }
            else if (i1==0&&i2<60){
                  parse=i2+"分钟前";
            }
           else   if((i1==0)&&(i2==0)&&(i3<=30)){
                  parse="刚刚";
            }

            return parse;
      }
}
