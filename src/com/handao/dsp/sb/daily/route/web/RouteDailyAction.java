package com.handao.dsp.sb.daily.route.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class RouteDailyAction extends AFBizAction{
	
    /**
     * [父类抽象方法实现]
     * 返回Service的ClassName
     * @return String
     */	
	  protected String getServiceName(){
        return "com.handao.dsp.sb.daily.route.service.RouteDailyService";
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
    public ActionForward doAddRouteDailyDetailRow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return doAddDetailRow(mapping, form, request, response, ((RouteDailyForm)form).getDetailList_RouteDailyDetail(), RouteDailyDetailForm.class.getName());
    }
}