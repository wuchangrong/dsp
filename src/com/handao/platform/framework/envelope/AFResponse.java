package com.handao.platform.framework.envelope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AFResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private AFResult result = null;

    private Map dataMap = null;

    private static final String DEFAULT_DATA = "DEFAULT_DATA";

    private AFPage searchResultPage = null;

    public AFResponse() {
        dataMap = new HashMap();
    }

    public AFResult getResult() {
        return result;
    }

    public void setResult(AFResult result) {
        this.result = result;
    }

    public Object getDefaultData() {
        return dataMap.get(DEFAULT_DATA);
    }

    public void setDefaultData(Object data) {
        dataMap.put(DEFAULT_DATA, data);
    }

    public Object getData(String key) {
        return dataMap.get(key);
    }

    public void setData(String key, Object data) {
        dataMap.put(key, data);
    }

    public AFPage getSearchResultPage() {
        return searchResultPage;
    }

    public void setSearchResultPage(AFPage searchResultPage) {
        this.searchResultPage = searchResultPage;
    }

}