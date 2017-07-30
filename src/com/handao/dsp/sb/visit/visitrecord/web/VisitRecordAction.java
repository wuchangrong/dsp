package com.handao.dsp.sb.visit.visitrecord.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;
import com.handao.platform.framework.biz.web.AFBizActionHandleImpl;
import com.handao.platform.framework.biz.web.AFBizRequestEvent;
import com.handao.platform.framework.biz.web.AFBizResponseEvent;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class VisitRecordAction extends AFBizAction{
	
	protected String getServiceName(){
        return "com.handao.dsp.sb.visit.visitrecord.service.VisitRecordService";
    }
	
	/**
	* 根据vo更新status
    * 
	* @return boolean
	*/ 	
	public ActionForward doUpdateStatusByVO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		if (!super.isTokenValid(request, true))
		{
			super.saveToken(request);
			return doEditTokenValid(mapping, form, request, response);
		}
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doUpdateStatusByVO", new AFBizActionHandleImpl(){
					public boolean assembleRequest(AFBizRequestEvent reqEvent){
						assembleRequestValueObject(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(AFBizResponseEvent respEvent)	{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward(
								respEvent.isSuccess() ? "list.do" : "addEdit");
					}

				});
	}
	
}