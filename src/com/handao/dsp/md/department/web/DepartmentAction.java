package com.handao.dsp.md.department.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;
import com.handao.platform.framework.biz.web.AFBizActionHandleImpl;
import com.handao.platform.framework.biz.web.AFBizRequestEvent;
import com.handao.platform.framework.biz.web.AFBizResponseEvent;
import com.handao.platform.framework.web.AFSearchOperation;

public class DepartmentAction extends AFBizAction {

	/**
	 * [父类抽象方法实现]
	 * 返回Service的ClassName
	 * @return String
	 */
	protected String getServiceName() {
		return "com.handao.dsp.md.department.service.DepartmentService";
	}

	public ActionForward doNothing(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		super.saveToken(request);
		return mapping.findForward("mainPage");
	}

	public ActionForward doSearch(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response, getServiceName(), "doSearch", new AFBizActionHandleImpl() 
		{
			public boolean assembleRequest(AFBizRequestEvent reqEvent)
			{
				DepartmentSearchForm sf = (DepartmentSearchForm)((AFSearchOperation)reqEvent.getForm()).getSearchForm();
				String parent_dept = reqEvent.getHttpRequest().getParameter("DEPT_PARENT_DEPT");
				sf.setDEPT_PARENT_DEPT(parent_dept);

				assembleRequestSearchCondition(reqEvent.getHttpRequest(), (AFSearchOperation)reqEvent.getForm(), reqEvent.getAFRequest());

				return true;
			}	        

			public ActionForward assembleResponse(AFBizResponseEvent respEvent)
			{
				assembleResponseSearchCondition(respEvent.getHttpRequest(), (AFSearchOperation)respEvent.getForm(), respEvent.getAFResponse());
				return respEvent.getMapping().findForward("list");
			}


		});
	}

}