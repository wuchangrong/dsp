package com.handao.platform.sm.userOnline.web;

import java.util.List;

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
import com.handao.platform.framework.util.AFConstants;
import com.handao.platform.sm.userOnline.UserOnlineManager;


public class UserOnlineListAction extends AFBizAction{
	
    protected String getServiceName(){
	  return "";
    }

    public ActionForward doSearch(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,getServiceName(), "doSearch", new AFBizActionHandleImpl(){

			public boolean assembleRequest(AFBizRequestEvent reqEvent){
				return false;
			}

			public ActionForward assembleResponse(AFBizResponseEvent respEvent){
				  List userOnlineList = UserOnlineManager.getInstance().getUserOnlineList();
			      
			      AFPage page = new AFPage();
			      page.setList(userOnlineList);
			      page.setCurrentPageNo(1);
			      page.setPageSize(-1);
			      page.setTotalRecordNum(userOnlineList.size()); 
			      respEvent.getHttpRequest().setAttribute(AFConstants.KEY_SEARCH_RESULT_PAGE, page);
				return respEvent.getMapping().findForward("list");
			}

		});
    }
    //Çå³ýÓÃ»§
	public ActionForward doDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		if (!super.isTokenValid(request, true)){
			super.saveToken(request);
			return doDeleteTokenValid(mapping, form, request, response);
		}
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,getServiceName(), "doDelete", new AFBizActionHandleImpl(){
					public boolean assembleRequest(AFBizRequestEvent reqEvent){
				        String[] chkList = reqEvent.getForm().getChk();
			            if(chkList!=null){
			                UserOnlineManager.getInstance().shutdownUserList(chkList);
			            }
						return false;
					}

					public ActionForward assembleResponse(AFBizResponseEvent respEvent){
						  List userOnlineList = UserOnlineManager.getInstance().getUserOnlineList();
					      
					      AFPage page = new AFPage();
					      page.setList(userOnlineList);
					      page.setCurrentPageNo(1);
					      page.setPageSize(-1);
					      page.setTotalRecordNum(userOnlineList.size()); 
					      respEvent.getHttpRequest().setAttribute(AFConstants.KEY_SEARCH_RESULT_PAGE, page);
						  return respEvent.getMapping().findForward("list");
					}

				});
	}
}