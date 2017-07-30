package com.handao.platform.framework.util.config;

import java.util.HashMap;
import java.util.Iterator;

public class AFStyleConfig {
    private String SPLIT_FLAG = ";";

    private String[] defaultScope = {"all", "list", "addedit", "view"};

    private HashMap map = null;
    private String currentStyle = null;
    private String cssPath = null;
    private String imgPath = null;
    private String stylePath = null;
    private String fullImgPath;
    private String fullCSSPath;

    AFStyleConfig() {
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
        fullImgPath = this.stylePath + "/" + this.currentStyle + this.imgPath;
        fullCSSPath = this.stylePath + "/" + this.currentStyle + this.cssPath;

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
                if(list != null) {
                    for(int i = 0; i < list.length; i++) {
                        list[i] = fullCSSPath + list[i];
                    }
                }
                map.put(key, list);
            }
        }
    }

    public Iterator getAllScope() {
        return map.keySet().iterator();
    }

    public String[] getCSSFilePathList(String scope) {
        String[] list = (String[])map.get(scope.toUpperCase());
        if(list == null)
            list = new String[0];
        return list;
    }

    public String getCurrentStyle() {
        return currentStyle;
    }

    void setCurrentStyle(String currentStyle) {
        this.currentStyle = currentStyle;
    }

    public String getCssPath() {
        return cssPath;
    }

    void setCssPath(String cssPath) {
        this.cssPath = cssPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getStylePath() {
        return stylePath;
    }

    void setStylePath(String stylePath) {
        this.stylePath = stylePath;
    }

    public String getFullImgPath() {
        return fullImgPath;
    }

    public String getFullCSSPath() {
        return fullCSSPath;
    }

}