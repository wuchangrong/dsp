package com.handao.platform.framework.biz.web;

import javax.servlet.http.HttpServletRequest;

import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.web.AFForm;

public class AFBizRequestEvent {

    private HttpServletRequest request = null;


    private AFForm afForm = null;

    private AFRequest afReq = null;

    private String sourceMethod = null;

    public AFBizRequestEvent(String sourceMethod, HttpServletRequest request, AFForm afForm, AFRequest afReq) {
        this.sourceMethod = sourceMethod;
        this.request = request;
        this.afForm = afForm;
        this.afReq = afReq;
    }

    public AFForm getForm() {
        return afForm;
    }
    public AFRequest getAFRequest() {
        return afReq;
    }
    public HttpServletRequest getHttpRequest() {
        return request;
    }

    public String getSourceMethod() {
        return sourceMethod;
    }

}