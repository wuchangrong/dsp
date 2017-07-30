package com.handao.dsp.sb.visit.visitrecord.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.dsp.sb.visit.visitrecord.bo.VisitRecordBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitRecordService extends AFBizService {

   private VisitRecordBO bo_VisitRecord = (VisitRecordBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.sb.visit.visitrecord.bo.VisitRecordBO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO(){
        return bo_VisitRecord;
    }
    
    public void doUpdateStatusByVO(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest afReq, AFResponse afResp) {

                boolean result = bo_VisitRecord.doUpdateStatusByVO(afReq.getUserToken(), (AFValueObject)afReq.getDefaultData());
                AFResult afResult = afResp.getResult();
                afResult.setBooleanValue(result);
                afResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }    
	
}