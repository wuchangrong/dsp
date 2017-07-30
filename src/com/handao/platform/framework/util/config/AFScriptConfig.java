package com.handao.platform.framework.util.config;

import java.util.HashMap;
import java.util.Iterator;

public class AFScriptConfig {

    private String SPLIT_FLAG = ";";

    private String[] defaultScope = {"all", "list", "addedit", "view"};

    private HashMap map = null;

    AFScriptConfig() {
        map = new HashMap();
        for(int i = 0; i < defaultScope.length; i++) {
            addConfig(null, defaultScope[i]);
        }
    }

    void addConfig(String src, String scope) {
        if(scope == null || scope.trim().length() == 0)
            scope = "all";

        StringBuffer sb = (StringBuffer)map.get(scope.toUpperCase());
        if(sb == null) {
            sb = new StringBuffer();
            map.put(scope.toUpperCase(), sb);
        }

        if(src != null)
            sb.append(src).append(SPLIT_FLAG);
    }

    void init() {
        StringBuffer sbAll = (StringBuffer)map.get("all".toUpperCase());
        Iterator keys = map.keySet().iterator();
        for(; keys.hasNext(); ) {
            String key = (String)keys.next();
            StringBuffer sb = (StringBuffer)map.get(key);
            if(sb == null)
                map.put(key, new String[0]);
            else {
                if(!"all".equalsIgnoreCase(key))
                    sb.append(sbAll);
                String[] list = sb.toString().split(SPLIT_FLAG);
                String[][] list_and_type = new String[list.length][];
                for(int i = 0; i < list.length; i++) {
                    String src = list[i];
                    list_and_type[i] = new String[] {src, src.substring(src.lastIndexOf(".") + 1, src.length())};
                }
                map.put(key, list_and_type);
            }
        }
    }

    public Iterator getAllScope() {
        return map.keySet().iterator();
    }

    public String[][] getScriptFilePathList(String scope) {
        String[][] list = (String[][])map.get(scope.toUpperCase());
        if(list == null)
            list = new String[0][0];
        return list;
    }

}