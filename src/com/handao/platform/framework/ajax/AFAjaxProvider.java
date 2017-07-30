package com.handao.platform.framework.ajax;

import java.util.HashMap;

import com.handao.platform.framework.util.AFInstanceFactory;

public class AFAjaxProvider {


    private static HashMap map = new HashMap();

    public static AFAjax getAjax(String key) {
        AFAjax ajax = (AFAjax)map.get(key);
        if(ajax == null) {
            synchronized(map) {
                ajax = (AFAjax)AFInstanceFactory.createInstance(key);
                map.put(key, ajax);
            }
        }
        return ajax;
    }
}