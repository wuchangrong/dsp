package com.handao.platform.sm.privilege.user.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.handao.platform.sm.privilege.user.bo.AFUserBO;

public class AFUserService extends AFBizService {

	private static final long serialVersionUID = 1L;
	
	private AFUserBO bo_User = (AFUserBO)AFBOProvider.getBOByClass("com.handao.platform.sm.privilege.user.bo.AFUserBO");
    
    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_User;
    }

    public void doUsingChange(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                boolean result = false;
                if(bo_User != null)
                    result = bo_User.doUsingChange(eapReq.getUserToken(), (long[])eapReq.getDefaultData());
                AFResult eapResult = eapResp.getResult();
                eapResult.setBooleanValue(result);
                eapResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }
}