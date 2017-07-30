package com.handao.platform.framework.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AFDateUtil {	
	private static SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat defaultTimeFormat = new SimpleDateFormat("HH:mm:ss");	
	private static SimpleDateFormat defaultDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getDateString(Date date){
		return defaultDateFormat.format(date);
	}
	public static String getTimeString(Date date){
		return defaultTimeFormat.format(date);
	}
	public static String getDateTimeString(Date date){
		return defaultDateTimeFormat.format(date);
	}
    //获取两个日期之间的时间差，返回的格式为: "D天 H小时 M分钟 S秒"
    public static String getBetweenTime(Date firstDate,Date secondDate)
    {
        String returnStr = "1秒";
        long bMicroSeconds = secondDate.getTime() - firstDate.getTime();
        //在一分钟之内
        if(bMicroSeconds>1000&&bMicroSeconds<60*1000)                  //以秒计算
        {
            returnStr = bMicroSeconds/1000 + "秒";
        }
        else if(bMicroSeconds>60*1000&&bMicroSeconds<60*60*1000L)      //以分钟计算
        {
            long minute = bMicroSeconds/(60*1000);         //计算分钟数
            long sencond = (bMicroSeconds - minute*60*1000)/1000;       //计算秒数
            returnStr = minute+"分钟 "+sencond+"秒";
        }
        else if(bMicroSeconds>60*60*1000L&&bMicroSeconds<24*60*60*1000L)      //以小时计算
        {
            long hour = bMicroSeconds/(60*60*1000);        //计算小时
            long minute = (bMicroSeconds-hour*60*60*1000L)/(60*1000);         //计算分钟数
            long sencond = (bMicroSeconds - hour*60*60*1000L-minute*60*1000)/1000;       //计算秒数
            returnStr = hour+"小时 "+minute+"分钟 "+sencond+"秒";
        }
        else if(bMicroSeconds>24*60*60*1000L)
        {
            int day = (int)(bMicroSeconds / 0x5265c00L);
            long hour = (bMicroSeconds - day*0x5265c00L)/(60*60*1000);        //计算小时
            long minute = (bMicroSeconds - day*0x5265c00L - hour*60*60*1000L)/(60*1000);         //计算分钟数
            long sencond = (bMicroSeconds - day*0x5265c00L - hour*60*60*1000L - minute*60*1000)/1000;       //计算秒数
            returnStr = day+"天 "+hour+"小时 "+minute+"分钟 "+sencond+"秒";
        }
        return returnStr;
    }
    
    public static Date getSystemDate() {
        Calendar now = Calendar.getInstance();
        return new Date((now.getTime()).getTime());
    }
    public static boolean isValidDate(String strDate) {
        int day, month, year;

        if(strDate==null||strDate.length()>10) {
            return false;
        }

        try {
            int sym1, sym2;
            sym1 = strDate.indexOf("/");
            sym2 = strDate.indexOf("/", sym1+1);
            year = Integer.parseInt(strDate.substring(0, sym1));
            month = Integer.parseInt(strDate.substring(sym1+1, sym2));
            day = Integer.parseInt(strDate.substring(sym2+1));
        } catch(Exception nfe) {
            return false;
        }

        if(day<=0||month<=0||year<=0) {
            return false;
        }
        if(month>12) {
            return false;
        }

        int modulo4 = year%4;
        int modulo100 = year%100;
        int modulo400 = year%400;
        boolean leapYear = false;

        if(modulo4==0) {
            if(modulo400==0&&modulo100==0) {
                leapYear = true;
            } else if(modulo100!=0) {
                leapYear = true;
            }
        }

        if((month==1)||(month==3)||(month==5)||(month==7)||
            (month==8)||(month==10)||(month==12)) {
            if(day>31) {
                return false;
            }
        } else if((month==4)||(month==6)||(month==9)||(month==11)) {
            if(day>30) {
                return false;
            }
        } else {
            if(leapYear) {
                if(day>29) {
                    return false;
                }
            } else {
                if(day>28) {
                    return false;
                }
            }
        }
        return true;
    }
}