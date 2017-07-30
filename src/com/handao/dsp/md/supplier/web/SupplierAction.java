package com.handao.dsp.md.supplier.web;

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

public class SupplierAction extends AFBizAction
{

    /**
     * [父类抽象方法实现]
     * 返回Service的ClassName
     * @return String
     */
    protected String getServiceName()
    {
        return "com.handao.dsp.md.supplier.service.SupplierService";
    }

    public ActionForward doBegin(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
    	super.saveToken(request);
        return mapping.findForward("begin");
    }

    public ActionForward doSearch(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
    	super.saveToken(request);
        return commonBizInvoke(mapping, form, request, response, getServiceName(), "doSearch",
                new AFBizActionHandleImpl()
                {

                    public boolean assembleRequest(AFBizRequestEvent reqEvent)
                    {
                        SupplierSearchForm sf = (SupplierSearchForm)((SupplierForm)reqEvent.getForm()).getSearchForm();
                        HttpServletRequest request = reqEvent.getHttpRequest();
                        String param = "";
                        String province = request.getParameter("province");
                        String area = request.getParameter("area");
                        sf.setSUP_DISTRICTID("");
                        sf.setSUP_PROVINCEID("");
                        if("-1".equals(province))
                        {
                            sf.setSUP_PROVINCEID(area);
                        }
                        else if(null != area && null != province && !"-1".equals(province) && !"-1".equals(area))
                        {
                        	sf.setSUP_PROVINCEID(province);
                            sf.setSUP_DISTRICTID(area);
                        }
                        assembleRequestSearchCondition(reqEvent.getHttpRequest(), (AFSearchOperation) reqEvent
                                .getForm(), reqEvent.getAFRequest());
                        return true;
                    }

                    public ActionForward assembleResponse(AFBizResponseEvent respEvent)
                    {
                        assembleResponseSearchCondition(respEvent.getHttpRequest(), (AFSearchOperation) respEvent
                                .getForm(), respEvent.getAFResponse());
                        return respEvent.getMapping().findForward("list");
                    }
                });
    }
}