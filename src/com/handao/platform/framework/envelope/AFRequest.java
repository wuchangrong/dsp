package com.handao.platform.framework.envelope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AFRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_DATA = "DEFAULT_DATA";

    private String serviceName = null;

    private String methodName = null;

    private AFUserToken userToken = null;

    private AFSearchCondition searchCondition = null;

    private Map dataMap = null;

    private AFPage searchPage = null;

    public AFRequest() {
        dataMap = new HashMap();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public AFUserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(AFUserToken userToken) {
        this.userToken = userToken;
    }

    public AFSearchCondition getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(AFSearchCondition searchCondition) {
        this.searchCondition = searchCondition;
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

    public AFPage getSearchPage() {
        return searchPage;
    }

    public void setSearchPage(AFPage searchPage) {
        this.searchPage = searchPage;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}