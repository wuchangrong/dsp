package com.handao.platform.sm.privilege.role.service;

import java.util.Map;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.privilege.role.bo.AFRoleBO;

public class AFRoleService extends AFBizService {

	private static final long serialVersionUID = 1L;
	
	private AFRoleBO bo_AFRole = (AFRoleBO)AFBOProvider.getBOByClass("com.handao.platform.sm.privilege.role.bo.AFRoleBO");
	
	protected AFBizBO getActiveBO() {
		return bo_AFRole;
	}

	public void doSearch(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(false) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                AFPage page = null;
                AFBizBO bo = getActiveBO();
                UserToken userToken = (UserToken)eapReq.getDefaultData();
                if(bo != null)
                    page = bo.doSearchPage(userToken, eapReq.getSearchCondition(), eapReq.getSearchPage());
                eapResp.setSearchResultPage(page);
                return true;
            }
        });
    }

	public void doAssignProgram(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                boolean result = false;
                Map map = (Map)eapReq.getDefaultData();
                long roleId = ((Long)map.get("role_id")).longValue();
                String moduleString = (String)map.get("module_string");
                UserToken userToken = (UserToken)map.get("userToken");
                
                String[] ids = moduleString.split(",");
                if(ids != null && ids.length > 0){
                	long[] moduleIds = new long[ids.length];
                	for(int i = 0; i < ids.length; i++){
                		moduleIds[i] = new Long(ids[i]).longValue();
                	}
                	
                	AFRoleBO bo = (AFRoleBO) getActiveBO();
                	if(bo != null)
                		result = bo.doAssignProgram(userToken, roleId, moduleIds);
                }
              
                AFResult eapResult = eapResp.getResult();
                eapResult.setBooleanValue(result);
                eapResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }

	public void doFind(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(false) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                Map map = (Map)eapReq.getDefaultData();
            	long[] idList = (long[])map.get("idList");
            	UserToken userToken = (UserToken)map.get("userToken");
                AFValueObject vo = null;
                AFBizBO bo = getActiveBO();
                if(bo!=null && idList!=null)
                    vo = bo.doFind(userToken, idList[0]);
                eapResp.setDefaultData(vo);
                return true;
            }
        });
    }

	public void doAssignUser(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                boolean result = false;
                Map map = (Map)eapReq.getDefaultData();
                long roleId = ((Long)map.get("role_id")).longValue();
                String userString = (String)map.get("user_string");
                UserToken userToken = (UserToken)map.get("userToken");
                
                String[] ids = userString.split(",");
                if(ids != null && ids.length > 0){
                	long[] userIds = new long[ids.length];
                	for(int i = 0; i < ids.length; i++){
                		userIds[i] = new Long(ids[i]).longValue();
                	}
                	
                	AFRoleBO bo = (AFRoleBO) getActiveBO();
                	if(bo != null)
                		result = bo.doAssignUser(userToken, roleId, userIds);
                }
              
                AFResult eapResult = eapResp.getResult();
                eapResult.setBooleanValue(result);
                eapResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }
	
	public void doDelete(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        commonBizInvoke(eapReq, eapResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest eapReq, AFResponse eapResp) {
                boolean result = false;
                Map map = (Map)eapReq.getDefaultData();
            	long[] idList = (long[])map.get("idList");
            	UserToken userToken = (UserToken)map.get("userToken");
                AFBizBO bo = getActiveBO();
                if(bo != null)
                    result = bo.doDelete(userToken, idList);
                AFResult eapResult = eapResp.getResult();
                eapResult.setBooleanValue(result);
                eapResult.setResultMessageKey(result?"af.operation.delete.success":"af.operation.delete.faile");
                return result;
            }
        });
    }
}