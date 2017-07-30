package com.handao.platform.framework.biz.service;

import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;

public class AFBizServiceHandleImpl implements AFBizServiceHandle {

    private boolean transaction = false;

    public AFBizServiceHandleImpl(boolean transaction) {
        this.transaction = transaction;
    }

    public boolean process(AFRequest afReq, AFResponse afResp) {
        return true;
    }

    public boolean isTransaction() {
        return transaction;
    }

}