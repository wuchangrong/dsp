package com.handao.platform.sm.privilege.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;
import com.handao.platform.framework.biz.web.AFBizActionHandleImpl;
import com.handao.platform.framework.biz.web.AFBizRequestEvent;
import com.handao.platform.framework.biz.web.AFBizResponseEvent;

public class AFUserAction extends AFBizAction {
	


    public ActionForward doUsingChange(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.commonBizInvoke(mapping, form, request, response, this.getServiceName(), "doUsingChange",
                                    new AFBizActionHandleImpl() {
            public boolean assembleRequest(AFBizRequestEvent reqEvent) {
            	assembleRequestCheckList(reqEvent.getHttpRequest(), reqEvent.getForm(), reqEvent.getAFRequest());
                return true;
            }

            public ActionForward assembleResponse(AFBizResponseEvent respEvent) {
                assembleResponseResult(respEvent.getHttpRequest(), respEvent.getAFResponse());
                return respEvent.getMapping().findForward("list.do");
            }
        });
    }
	
    
    /**
     * [父类抽象方法实现]
     * 返回Service的ClassName
     * @return String
     */
    protected String getServiceName() {
        return "com.handao.platform.sm.privilege.user.service.AFUserService";
    }

//    public void doGetParentEntityId(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
//    	String param = request.getParameter("param")==null?"":request.getParameter("param");
//    	String s = AFMenuCodeUtil.getParentByCode(param);
//    	s = AFLookupUtil.encode(s);
//    	try{            		
//    		response.getWriter().print(s);
//    		response.getWriter().flush(); 
//    		response.getWriter().close();
//    	}catch(Exception e){
//    	}
//    }
}