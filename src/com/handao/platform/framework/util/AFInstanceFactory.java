package com.handao.platform.framework.util;

public class AFInstanceFactory {

    private AFInstanceFactory() {

    }

    public static Object createInstance(String className) {
       Object obj = null;
       try {
          obj = Class.forName(className).newInstance();
       } catch(Exception e){
    	   e.printStackTrace();
       }
       return obj;
    }

}
