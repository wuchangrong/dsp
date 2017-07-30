package com.handao.platform.framework.web;

import javax.servlet.http.HttpServletRequest;

import com.handao.platform.framework.envelope.AFResult;

public abstract class AFTokenValidAction extends AFAction {
    protected void commonTokenValid(HttpServletRequest request) throws Exception {
        AFResult result = new AFResult();
        result.setBooleanValue(false);
        result.setResultMessageKey("af.operation.submit.repeat");
        this.assembleResponseResult(request, result);
    }
}