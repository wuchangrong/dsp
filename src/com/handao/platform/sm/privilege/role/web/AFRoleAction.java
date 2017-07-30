package com.handao.platform.sm.privilege.role.web;

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
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.AFConstants;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class AFRoleAction extends AFBizAction {

	protected String getServiceName() {
		return "com.handao.platform.sm.privilege.role.service.AFRoleService";
	}

	protected void assembleRequestSearchCondition(HttpServletRequest request, AFSearchOperation so, AFRequest eapReq) {
		//获得当前的user token
		UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
		
		eapReq.setDefaultData(userToken);
		if(so != null) {
            AFSearchForm searchForm = so.getSearchForm();
            AFPage page = this.getPage(searchForm);
            AFSearchCondition sc = this.getSearchCondition(searchForm);
            eapReq.setSearchPage(page);
            eapReq.setSearchCondition(sc);
        }
    }
	
	protected void assembleResponseSearchCondition(HttpServletRequest request, AFSearchOperation so, AFResponse eapResp) {
        AFPage page = eapResp.getSearchResultPage();
        if(so != null) {
            AFSearchForm sf = so.getSearchForm();
            this.setPageInfo(sf, page);
        }
        request.setAttribute(AFConstants.KEY_SEARCH_RESULT_PAGE, page);
    }

	public ActionForward doAssignProgramIni(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doFind",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
                assembleRequestCheckList(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseForm(respEvent.getHttpRequest(), respEvent.getForm(), respEvent.getAFResponse());
                return respEvent.getMapping().findForward("assignProgramInit");
            }
        });
    }

	public ActionForward doAssignProgram(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doAssignProgram",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
                assembleRequestDoAssignProgram(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseDoAssignProgram(respEvent.getHttpRequest(), respEvent.getAFResponse());
                //AFCacheProgramData.clear();
                return respEvent.getMapping().findForward(respEvent.isSuccess() ? "list.do" : "assignProgramInit");
            }
        });

    }
	
	protected void assembleRequestDoAssignProgram(HttpServletRequest request, AFForm form, AFRequest eapReq) {
		String roleId = request.getParameter("role_id");
        String moduleString = request.getParameter("module_string");

        UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
        
		Map map = new HashMap();
        map.put("role_id", new Long(roleId));
        map.put("module_string", moduleString);
        map.put("userToken", userToken);
        eapReq.setDefaultData(map);
    }
	
	protected void assembleResponseDoAssignProgram(HttpServletRequest request, AFResponse eapResp) {
        AFResult result = eapResp.getResult();
        assembleResponseResult(request, result);
    }

	public ActionForward doAssignUserIni(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doFind",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
                assembleRequestCheckList(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseForm(respEvent.getHttpRequest(), respEvent.getForm(), respEvent.getAFResponse());
                return respEvent.getMapping().findForward("assignUserInit");
            }
        });
    }

	protected void assembleRequestCheckList(HttpServletRequest request, AFForm form, AFRequest eapReq) {
		Map map = new HashMap();
		//获得当前的user token
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

	public ActionForward doAssignUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doAssignUser",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
                assembleRequestDoAssignUser(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseDoAssignUser(respEvent.getHttpRequest(), respEvent.getAFResponse());
//                AFCacheProgramData.clear();
                return respEvent.getMapping().findForward(respEvent.isSuccess() ? "list.do" : "assignUserInit");
            }
        });

    }
	
	protected void assembleRequestDoAssignUser(HttpServletRequest request, AFForm form, AFRequest eapReq) {
        //获得前台传过来的数据
		String roleId = request.getParameter("role_id");
        String userString = request.getParameter("user_string");

        //获得当前的user token
        UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
        
		Map map = new HashMap();
        map.put("role_id", new Long(roleId));
        map.put("user_string", userString);
        map.put("userToken", userToken);
        eapReq.setDefaultData(map);
    }
	
	protected void assembleResponseDoAssignUser(HttpServletRequest request, AFResponse eapResp) {
        AFResult result = eapResp.getResult();
        assembleResponseResult(request, result);
    }
}