package com.handao.platform.framework.web;

import org.apache.struts.util.MessageResources;

public class AFWebUtil {
    public static String getResource(String key) {
        MessageResources messages = MessageResources.getMessageResources("MessageMapping");
        String s = messages.getMessage(key);
        return s;
    }
}