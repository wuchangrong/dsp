package com.handao.platform.framework.biz.service;

import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;

public interface AFBizServiceHandle {

    public boolean process(AFRequest afReq, AFResponse afResp);

    public boolean isTransaction();
}