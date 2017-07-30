package com.handao.platform.framework.biz.web;

import org.apache.struts.action.ActionForward;

public interface AFBizActionHandle {
    public boolean assembleRequest(AFBizRequestEvent reqEvent);
    public ActionForward assembleResponse(AFBizResponseEvent respEvent);
}