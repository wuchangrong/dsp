package com.handao.platform.framework.util;

import java.text.DecimalFormat;

public class AFAdvancedString {

    public AFAdvancedString() {
        super();
    }

    public final static String getStr(String str) {
        if(str!=null) {
            try {
                String temp_p = str;
                byte[] temp_t = temp_p.getBytes("ISO8859-1");
                String temp = new String(temp_t);
                return temp;
            } catch(Exception e) {

            }
            return "";
        } else {
            return "";
        }

    }

    /**
     * 在给定的字符串前填充指定个数个空格
     */
    public final static String fillSpace(String oldString, int length) {
        return fillString(oldString, length, ' ');
    }

    /**
     * 在指定的字符串前填充给定个字符。
     */
    public final static String fillString(String oldString, int length, char fillWith) {
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i<length; i++) {
            buf.append(fillWith);
        }
        buf.append(oldString);
        return buf.toString();
    }

    /**
     * 在指定的字符串前填充字符串
     */
    public final static int getNum(String[] namelist, String name) {
        int i = 0;
        if(namelist==null) {
            return-1;
        }
        int n = namelist.length;
        for(i = 0; i<n; i++) {

            if(namelist[i].equalsIgnoreCase(name)) {
                return i;
            }

        }
        return-1;
    }

    /**
     * 将浮点数格式化成指定为数的浮点数
     */
    public final static String format(double number, int suffix) {
        StringBuffer pattern = new StringBuffer("###,###,###,###,###,##0");
        if(suffix>0) {
            pattern.append(".");
            for(int i = 0; i<suffix; i++) {
                pattern.append("0");
            }
        }
        DecimalFormat format = new DecimalFormat(pattern.toString());
        return format.format(number);
    }

    /**
     * Insert the method's description here.
     */
    public final static String format(int number) {
        return format(number, 0);
    }

    /**
     * Insert the method's description here.
     */
    public final static String format(long number) {
        return format(number, 0);
    }

    /**
     * 判断字符串是否为null或为空
     */
    public final static boolean isEmpty(String inStr) {
        if(inStr==null||inStr.trim().length()==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将一个对象转换成可以在浏览器中显示的HTML格式
     */

    public final static String str2HTML(Object obj) {

        if(obj==null) {
            return "<span>&nbsp;</span>";
        }
        String str = obj.toString();
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            switch(tmp) {
                case '"': {
                    buf.append("&quot;");
                    break;
                }
                case '<': {
                    buf.append("&lt;");
                    break;
                }
                case '>': {
                    buf.append("&gt;");
                    break;
                }
                case '&': {
                    buf.append("&amp;");
                    break;
                }
                case '\r': {
                    buf.append("<br>");
                    break;
                }
                default: {
                    buf.append(tmp);
                }
            }
        }

        return buf.toString();
    }

    /**
     * 将一个字符串转换成可以在浏览器中显示的HTML格式
     */
    public final static String str2HTML(String str) {
        if(isEmpty(str)) {
            return "<span>&nbsp;</span>";
        }

        StringBuffer buf = new StringBuffer();
        for(int i = 0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            switch(tmp) {
                case '"': {
                    buf.append("&quot;");
                    break;
                }
                case '<': {
                    buf.append("&lt;");
                    break;
                }
                case '>': {
                    buf.append("&gt;");
                    break;
                }
                case '&': {
                    buf.append("&amp;");
                    break;
                }
                case '\r': {
                    buf.append("<br>");
                    break;
                }
                default: {
                    buf.append(tmp);
                }
            }
        }
        return buf.toString();
    }

    /**
     * 将字符串转换成小写字母
     */
    public final static String toLowerCase(String inStr) {
        if(isEmpty(inStr)) { //如果字符串为空或null
            return "";
        } else {
            return inStr.toLowerCase();
        }
    }

    /**
     * 将字符串转换成大写字母
     */
    public final static String toUpperCase(String inStr) {
        if(isEmpty(inStr)) { //如果字符串为空或null
            return "";
        } else {
            return inStr.toUpperCase();
        }
    }

    /**
     * 去掉两边的空格
     */
    public final static String trim(String inStr) {
        if(inStr == null) {
            return "";
        } else {
            return inStr.trim();
        }
    }

    /**
     * 将一个对象转换成可以作为值传递的字符串
     */
    public final static String str2Value(Object obj) {
        if(obj==null) {
            return "";
        } else {
            if(obj instanceof String) {
                return str2Value((String)obj);
            }
        }
        return obj.toString();
    }

    /**
     * 将一个字符串转换成可以作为值传递的字符串
     */
    public final static String str2Value(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 去掉两边的空格。
     */
    public final static String trim(Object inStr) {
        if(inStr==null) {
            return "";
        }
        return trim(inStr.toString());
    }

    public final static String parseNull(int k, String str) {
        if(k==0) { //处理数值型
            if((str==null)||(str.equals(""))) {
                return "null";
            } else {
                return str;
            }
        } else { //处理字符型
            if(str==null) {
                return "null";
            } else {
                return("'"+str+"'");
            }
        }
    }
}