package com.handao.platform.framework.biz.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.web.AFForm;

public class AFBizResponseEvent {

    private HttpServletRequest request = null;

    private HttpServletResponse response = null;

    private ActionMapping mapping = null;

    private AFForm afForm = null;

    private AFResponse afResp = null;

    private String sourceMethod = null;

    private boolean success = false;

    public AFBizResponseEvent(boolean success, String sourceMethod, HttpServletRequest request, HttpServletResponse response, ActionMapping mapping, AFForm afForm, AFResponse afResp) {
        this.success = success;
        this.sourceMethod = sourceMethod;
        this.request = request;
        this.response = response;
        this.mapping = mapping;
        this.afForm = afForm;
        this.afResp = afResp;
    }

    public AFForm getForm() {
        return afForm;
    }
    public AFResponse getAFResponse() {
        return afResp;
    }
    public HttpServletRequest getHttpRequest() {
        return request;
    }
    public HttpServletResponse getHttpResponse() {
        return response;
    }
    public String getSourceMethod() {
        return sourceMethod;
    }
    public boolean isSuccess() {
        return success;
    }
    public ActionMapping getMapping() {
        return mapping;
    }
}