package com.handao.platform.framework.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util{
    private static final BASE64Encoder a = new BASE64Encoder();
    private static final BASE64Decoder b = new BASE64Decoder();
    
    public Base64Util(){}

    public static String encodeStrByBASE64(String s){
        if(s == null)
            return null;
        try
        {
            return a.encode(s.getBytes("UTF-8"));
        }
        catch(Exception _ex)
        {
           _ex.printStackTrace();
           throw new RuntimeException(_ex);
        }
    }

    public static String decodeStrByBASE64(String s)
    {
        if(s == null)
            return null;
        s = s.replaceAll("~", "\\+");
		s = s.replaceAll(" ", "\\+");
        try
        {
            byte abyte0[] = b.decodeBuffer(s);
            return new String(abyte0, "UTF-8");
        }
        catch(Exception _ex)
        {
           _ex.printStackTrace();
           throw new RuntimeException(_ex);
        }
    }

    public static String encodeByBASE64(byte abyte0[])
    {
        if(abyte0 == null || abyte0.length == 0)
            return null;
        else
            return a.encode(abyte0);
    }

    public static byte[] decodeByBASE64(String s)
    {
        if(s == null)
            return null;
        try
        {
            return b.decodeBuffer(s);
        }
        catch(Exception _ex)
        {
           _ex.printStackTrace();
           throw new RuntimeException(_ex);
        }
    }
}
