package com.handao.platform.framework.service;

import java.io.Serializable;

import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.util.exception.AFServiceException;

public interface AFService extends Serializable {

    public void doService(AFRequest eapReq, AFResponse eapResp) throws AFServiceException;

}