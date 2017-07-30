package com.handao.dsp.md.directory.direaut.web;

import java.util.HashMap;

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
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class DireautAction extends AFBizAction{
	
    /**
     * [父类抽象方法实现]
     * 返回Service的ClassName
     * @return String
     */	
	  protected String getServiceName(){
        return "com.handao.dsp.md.directory.direaut.service.DireautService";
    }
	
	
    /**
     * [框架调用自定义方法]
     * 添加指定从表InvoicenoticDetail的行数
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    public ActionForward doAddDireautDetailRow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return doAddDetailRow(mapping, form, request, response, ((DireautForm)form).getDetailList_DireautDetail(), DireautDetailForm.class.getName());
    }
    
    //设置Service层处理必须的参数（指定的目录ID，是否包括子目录标志，选中的角色ID）
	public ActionForward doEdit(ActionMapping mapping, ActionForm form,
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
				getServiceName(), "doUpdate", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestValueObject(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						reqEvent.getAFRequest().setData("isSubdir", reqEvent.getHttpRequest().getParameter("isSubdir"));
						reqEvent.getAFRequest().setData("currentDirID", reqEvent.getHttpRequest().getParameter("currentDirID"));
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward("editIni.do");
					}

				});
	}
}