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
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class DireautService extends AFBizService {

   private DireautBO bo_Direaut = (DireautBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.md.directory.direaut.bo.DireautBO");
    
    /**
     * @desc ���ص�ǰ�BO
     * @return AFBizBO
     * @author liguozhi
     */
    protected AFBizBO getActiveBO(){
        return bo_Direaut;
    }

    //����Ŀ¼��Ȩ
    //���Ҫ��������µ���Ŀ¼��request�е�isSubdirΪ1������Ը�����Ŀ¼����
    //�����߼�����ɾ��Ŀ¼��Ȩ���ٲ����µ���Ȩ��������ɾ�����޸ġ��鿴������κ�һ�ѡ�еĽ��в��룩
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

    //����Ŀ¼��Ȩ
    //���Ҫ��������µ���Ŀ¼��request�е�isSubdirΪ1������Ը�����Ŀ¼����
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