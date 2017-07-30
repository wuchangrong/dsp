package com.handao.platform.sm.privilege.user.service;

import java.util.Map;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.privilege.user.bo.AFUserAuthorizationBO;

public class AFUserAuthorizationService extends AFBizService {

	private static final long serialVersionUID = 1L;
	
	private AFUserAuthorizationBO bo_UserAuthorization = (AFUserAuthorizationBO)AFBOProvider.getBOByClass("com.handao.platform.sm.privilege.user.bo.AFUserAuthorizationBO");
    
    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_UserAuthorization;
    }

	public void doAssignRoleIni(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(false) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                Map map = (Map)eapReq.getDefaultData();
            	long[] idList = (long[])map.get("idList");
            	UserToken userToken = (UserToken)map.get("userToken");
                AFValueObject vo = null;
                AFUserAuthorizationBO bo = (AFUserAuthorizationBO) getActiveBO();
                if(bo!=null && idList!=null)
                    vo = bo.doFindAssignRole(userToken, idList[0]);
                eapResp.setDefaultData(vo);
                return true;
            }
        });
    }
	
	public void doAssignRole(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                boolean result = false;
                Map map = (Map)eapReq.getDefaultData();
                long userId = ((Long)map.get("user_id")).longValue();
                String roleString = (String)map.get("role_string");
                UserToken userToken = (UserToken)map.get("userToken");
                
                long[] roleIds = null;
                if(roleString != null && !"".equals(roleString)){
	                String[] ids = roleString.split(",");
	                if(ids != null && ids.length > 0){
	                	roleIds = new long[ids.length];
	                	for(int i = 0; i < ids.length; i++){
	                		roleIds[i] = new Long(ids[i]).longValue();
	                	}
	                }
                }else
                	roleIds = new long[0];
                	
            	AFUserAuthorizationBO bo = (AFUserAuthorizationBO) getActiveBO();
            	if(bo != null)
            		result = bo.doAssignRole(userToken, userId, roleIds);	
              
                AFResult eapResult = eapResp.getResult();
                eapResult.setBooleanValue(result);
                eapResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }
}