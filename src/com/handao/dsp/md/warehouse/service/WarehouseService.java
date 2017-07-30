package com.handao.dsp.md.warehouse.service;

import java.util.HashMap;
import java.util.List;

import com.handao.dsp.md.warehouse.bo.WarehouseBO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.util.exception.AFServiceException;


public class WarehouseService extends AFBizService {

	private WarehouseBO bo_Warehouse = (WarehouseBO)AFBOProvider.getBOByClass("com.handao.dsp.md.warehouse.bo.WarehouseBO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_Warehouse;
    }
    
    public void doReturnMsg(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
            	List result = bo_Warehouse.doReturnMsg(eapReq.getUserToken(), (HashMap)eapReq.getData("map"));
            	eapResp.setDefaultData(result);
                
                return true;
            }
        });
    }

}