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
     * �ڸ������ַ���ǰ���ָ���������ո�
     */
    public final static String fillSpace(String oldString, int length) {
        return fillString(oldString, length, ' ');
    }

    /**
     * ��ָ�����ַ���ǰ���������ַ���
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
     * ��ָ�����ַ���ǰ����ַ���
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
     * ����������ʽ����ָ��Ϊ���ĸ�����
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
     * �ж��ַ����Ƿ�Ϊnull��Ϊ��
     */
    public final static boolean isEmpty(String inStr) {
        if(inStr==null||inStr.trim().length()==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ��һ������ת���ɿ��������������ʾ��HTML��ʽ
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
     * ��һ���ַ���ת���ɿ��������������ʾ��HTML��ʽ
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
     * ���ַ���ת����Сд��ĸ
     */
    public final static String toLowerCase(String inStr) {
        if(isEmpty(inStr)) { //����ַ���Ϊ�ջ�null
            return "";
        } else {
            return inStr.toLowerCase();
        }
    }

    /**
     * ���ַ���ת���ɴ�д��ĸ
     */
    public final static String toUpperCase(String inStr) {
        if(isEmpty(inStr)) { //����ַ���Ϊ�ջ�null
            return "";
        } else {
            return inStr.toUpperCase();
        }
    }

    /**
     * ȥ�����ߵĿո�
     */
    public final static String trim(String inStr) {
        if(inStr == null) {
            return "";
        } else {
            return inStr.trim();
        }
    }

    /**
     * ��һ������ת���ɿ�����Ϊֵ���ݵ��ַ���
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
     * ��һ���ַ���ת���ɿ�����Ϊֵ���ݵ��ַ���
     */
    public final static String str2Value(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * ȥ�����ߵĿո�
     */
    public final static String trim(Object inStr) {
        if(inStr==null) {
            return "";
        }
        return trim(inStr.toString());
    }

    public final static String parseNull(int k, String str) {
        if(k==0) { //������ֵ��
            if((str==null)||(str.equals(""))) {
                return "null";
            } else {
                return str;
            }
        } else { //�����ַ���
            if(str==null) {
                return "null";
            } else {
                return("'"+str+"'");
            }
        }
    }
}