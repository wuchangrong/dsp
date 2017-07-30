package com.handao.dsp.md.directory.direaut.service;

import com.handao.dsp.md.directory.direaut.bo.DireautBO;
import com.handao.dsp.md.directory.direaut.vo.DireautVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.exception.AFServiceException;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class DireautService extends AFBizService {

   private DireautBO bo_Direaut = (DireautBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.md.directory.direaut.bo.DireautBO");
    
    /**
     * @desc 返回当前活动BO
     * @return AFBizBO
     * @author liguozhi
     */
    protected AFBizBO getActiveBO(){
        return bo_Direaut;
    }

    //更新目录授权
    //如果要求包含更新到子目录（request中的isSubdir为1），则对各级子目录处理
    //更新逻辑是先删除目录授权，再插入新的授权（新增、删除、修改、查看、审核任何一项被选中的进行插入）
    //Jul 17,2010
    //cg
    public void doUpdate(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                boolean result = false;
                boolean isSubdir=afReq.getData("isSubdir").toString().equals("1");
                long currentDirID=Long.parseLong((String)afReq.getData("currentDirID"));
                result=bo_Direaut.updatePermisson((UserToken)afReq.getUserToken(), (DireautVO)afReq.getDefaultData(),currentDirID,isSubdir);
                AFResult afResult = afResp.getResult();
                afResult.setBooleanValue(result);
                afResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                afResp.setResult(afResult);
                return result;
            }
        });
    }

    //撤销目录授权
    //如果要求包含更新到子目录（request中的isSubdir为1），则对各级子目录处理
    //Jul 17,2010
    //cg
    public void doDelete(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                boolean result = false;
                boolean isSubdir=afReq.getData("isSubdir").toString().equals("1");
                long currentDirID=Long.parseLong(afReq.getData("chk").toString());
                AFBizBO bo = getActiveBO();
                if(bo != null)
                    result = bo.doDelete(afReq.getUserToken(), (long[])afReq.getDefaultData());
                AFResult afResult = afResp.getResult();
                afResult.setBooleanValue(result);
                afResult.setResultMessageKey(result?"af.operation.delete.success":"af.operation.delete.faile");
                return result;
            }
        });
    }
    
}