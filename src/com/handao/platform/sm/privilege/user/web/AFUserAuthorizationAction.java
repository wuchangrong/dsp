package com.handao.platform.sm.privilege.user.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;
import com.handao.platform.framework.biz.web.AFBizActionHandleImpl;
import com.handao.platform.framework.biz.web.AFBizRequestEvent;
import com.handao.platform.framework.biz.web.AFBizResponseEvent;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.web.AFForm;

public class AFUserAuthorizationAction extends AFBizAction {
    /**
     * [父类抽象方法实现]
     * 返回Service的ClassName
     * @return String
     */
    protected String getServiceName() {
        return "com.handao.platform.sm.privilege.user.service.AFUserAuthorizationService";
    }
    
	public ActionForward doAssignRoleIni(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doAssignRoleIni",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
                assembleRequestRoleList(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseForm(respEvent.getHttpRequest(), respEvent.getForm(), respEvent.getAFResponse());
                return respEvent.getMapping().findForward("assignRoleInit");
            }
        });
    }
	protected void assembleRequestRoleList(HttpServletRequest request, AFForm form, AFRequest eapReq) {
		Map map = new HashMap();
		UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
		
		String[] chkList = form.getChk();
        long[] idList = null;
        if(chkList != null && chkList.length != 0) {
            idList = new long[chkList.length];
            for(int i = 0; i < chkList.length; i++) {
                idList[i] = Long.parseLong(chkList[i]);
            }
        }
        map.put("userToken", userToken);
        map.put("idList", idList);
        eapReq.setDefaultData(map);
    }
	
	public ActionForward doAssignRole(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doAssignRole",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
                assembleRequestDoAssignRole(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseDoAssignUser(respEvent.getHttpRequest(), respEvent.getAFResponse());
                return respEvent.getMapping().findForward(respEvent.isSuccess() ? "list.do" : "assignRoleInit");
            }
        });

    }
	
	protected void assembleRequestDoAssignRole(HttpServletRequest request, AFForm form, AFRequest eapReq) {
		String userId = request.getParameter("user_id");
        String roleString = request.getParameter("role_string");
        
        //获得当前的user token
        UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
        
		Map map = new HashMap();
        map.put("user_id", new Long(userId));
        map.put("role_string", roleString);
        map.put("userToken", userToken);
        eapReq.setDefaultData(map);
    }
	protected void assembleResponseDoAssignUser(HttpServletRequest request, AFResponse eapResp) {
        AFResult result = eapResp.getResult();
        assembleResponseResult(request, result);
    }
}