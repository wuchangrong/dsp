package com.handao.platform.framework.util;

import java.text.DecimalFormat;

import org.apache.struts.util.ResponseUtils;

public class AFStringUtil {
	
	
 public static DecimalFormat df = new DecimalFormat("###,###.00##");

    public static boolean isValidDouble(String str, boolean isNegative) {
        double dblString;

        if(str==null) {
            return false;
        }
        try {
            dblString = Double.valueOf(str.trim()).doubleValue();
        } catch(Exception exc) {
            return false;
        }

        if((!isNegative)&&dblString<0) {
            return false;
        }

        return true;

    }

    public static boolean isEmpty(String str) {
        return str==null || str.trim().length()==0;
    }

    public static boolean isNumeric(String str) {
        int strLen;
        int i;

        if(str==null) {
            return false;
        }

        strLen = str.length();

        if(strLen<1) {
            return true;
        }

        for(i = 0; i<strLen; i++) {
            if(!Character.isDigit(str.charAt(i))&&!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAlphabet(String str) {
        int strLen;
        int i;

        if(str==null) {
            return false;
        }

        strLen = str.length();

        if(strLen<1) {
            return true;
        }

        for(i = 0; i<strLen; i++) {
            if(!Character.isLetter(str.charAt(i))&&!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkStringFormat(String str, String format) {
        boolean result = true;
        char thisChar;
        char formatChar;

        if(str.length()!=format.length()) {
            return false;
        }

        for(int i = 0; i<str.length(); i++) {
            formatChar = format.charAt(i);
            thisChar = str.charAt(i);
            switch(formatChar) {
                case 'A':
                    if(!((thisChar>='A'&&thisChar<='Z')||(thisChar>='a'&&thisChar<='z'))) {
                        result = false;
                    }
                    break;
                case '9':
                    if(!(thisChar>='0'&&thisChar<='9')) {
                        result = false;
                    }
                    break;
                case '$':
                    if(((thisChar>='A'&&thisChar<='Z')||(thisChar>='a'&&thisChar<='z'))
                        ||(thisChar>='0'&&thisChar<='9')) {
                        result = false;
                    }
                    break;
                default:
                    result = false;
            }
        }
        return result;
    }

    public static boolean isAlphabet(char c) {
        if(getASCIICode(c)>=97&&getASCIICode(c)<=122) {
            return true;
        }
        if(getASCIICode(c)>=65&&getASCIICode(c)<=90) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(char c) {
        if(getASCIICode(c)>=48&&getASCIICode(c)<=57) {
            return true;
        }
        return false;
    }

    public static int getASCIICode(char c) {
        return(int)c;
    }

    public static int getIntValue(char c) {
        String s = String.valueOf(c);
        return Integer.parseInt(s);
    }

    public static boolean checkEmail(String strMailAddress) {
        boolean result = true;
        if(strMailAddress==null) {
            return false;
        }
        if(strMailAddress.equals("")) {
            return true;
        }
        if(strMailAddress.indexOf("@")<0||strMailAddress.indexOf(".")<0) {
            return false;
        }
        for(int i = 0; i<strMailAddress.length(); i++) {
            if(!Character.isWhitespace(strMailAddress.charAt(i))
                &&!Character.isLetterOrDigit(strMailAddress.charAt(i))&&
                !(strMailAddress.charAt(i)=='@')&&!(strMailAddress.charAt(i)=='.')
                &&!(strMailAddress.charAt(i)=='_')) {
                result = false;
            }
        }
        return result;
    }

    public static boolean checkTelNumber(String strTelNumber) {
        boolean result = true;
        if(strTelNumber==null) {
            return false;
        }
        if(strTelNumber.equals("")) {
            return true;
        }
        for(int i = 0; i<strTelNumber.length(); i++) {
            if(!Character.isDigit(strTelNumber.charAt(i))&&
                !(strTelNumber.charAt(i)=='-')&&!(strTelNumber.charAt(i)=='(')
                &&!(strTelNumber.charAt(i)==')')) {
                result = false;
            }
        }
        return result;
    }

    public static String replaceQuotationMarks(String str) {
        if(str==null) {
            return str;
        }
        StringBuffer strBuf = new StringBuffer("");
        for(int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c=='\'') {
                strBuf.append('\'');
                strBuf.append('\'');
            } else {
                strBuf.append(c);
            }
        }
        return strBuf.toString();
    }

    public static String parseHtml(String str)
    {
      return ResponseUtils.filter(str);

    }

    public static String parseQuoter(String str) {
        return str.replaceAll("\'", "\'\'");
    }

    public static String getIdxValue(String srcStr, String dividStr, int idx) {
        int i = 0;
        String result = "";
        while(i<=idx) {
            int idx1 = srcStr.indexOf(dividStr);
            if(idx1==-1) {
                result = srcStr;
                break;
            }
            result = srcStr.substring(0, idx1);
            srcStr = srcStr.substring(idx1+1, srcStr.length());
            i = i+1;
        }
        return result;

    }

    public static String[] getIdxVString(String srcStr, String dividStr) {
        int num = 1;
        int i = 0;
        while(i<srcStr.length()) {
            if(srcStr.substring(i, i+1).indexOf(dividStr)!=-1) {
                num++;
            }
            i = i+1;
        }
        String[] result = new String[num];
        for(int j = 0; j<num; j++) {
            result[j] = getIdxValue(srcStr, dividStr, j);
        }
        return result;
    }

    public static int parseInt(String str) {
        if(isEmpty(str)) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }

    public static double parseDouble(String str) {
        if(isEmpty(str)) {
            return 0;
        } else {
            return Double.parseDouble(str);
        }
    }
    
    
    public static String parseObject(Object obj) {
    	if(obj == null) {
    	  return "";
    	}
    	return obj.toString();
//     	return JavaScriptUtils.javaScriptEscape(obj.toString());
    }

    
    
    
    public static String formatSepDouble(String str) {
    	String strFormat = "";
    	if(null== str || "".equalsIgnoreCase(str)) {
    		return strFormat; 		
    	}	
    	strFormat = df.format(Double.parseDouble(str));
    	return strFormat;
    }
}