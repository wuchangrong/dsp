package com.handao.platform.framework.biz.web;

import org.apache.struts.action.ActionForward;

public class AFBizActionHandleImpl implements AFBizActionHandle{

    public boolean assembleRequest(AFBizRequestEvent reqEvent) {
        return true;
    }

    public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
        return null;
    }
}