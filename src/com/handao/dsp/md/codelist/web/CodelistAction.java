package com.handao.dsp.md.codelist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;

public class CodelistAction extends AFBizAction {

    /**
     * [������󷽷�ʵ��]
     * ����Service��ClassName
     * @return String
     */
    protected String getServiceName() {
        return "com.handao.dsp.md.codelist.service.CodelistService";
    }

    /**
     * [��ܵ����Զ��巽��]
     * ���ָ���ӱ�CodelistDetail������
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception
     * @return ActionForward
     */
    public ActionForward doAddCodelistDetailRow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return doAddDetailRow(mapping, form, request, response, ((CodelistForm)form).getDetailList_CodelistDetail(), CodelistDetailForm.class.getName());
    }

}