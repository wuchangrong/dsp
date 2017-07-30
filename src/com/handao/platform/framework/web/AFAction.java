package com.handao.platform.framework.web;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFSearchCriterionField;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.service.AFService;
import com.handao.platform.framework.service.AFServiceManager;
import com.handao.platform.framework.util.AFConstants;
import com.handao.platform.framework.util.exception.AFSysException;
import com.handao.platform.framework.vo.AFValueObject;

public class AFAction extends DispatchAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //clear=true¥¶¿Ì
        if(form != null && form instanceof AFSearchOperation){
            String clearParam = request.getParameter("clear");
            if(clearParam != null && "true".equalsIgnoreCase(clearParam.trim())){
            	((AFSearchOperation)form).initSearchForm();
            }
        }
    	return super.execute(mapping, form, request, response);
    }

    protected ActionForward dispatchMethod(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
        if(name==null || name.trim().length()==0) {
            name = "unspecified";
        }
        return super.dispatchMethod(mapping, form, request, response, name);
    }

    protected AFResponse invoke(HttpServletRequest request, AFRequest afReq) {
        AFResponse afResp = new AFResponse();
        AFResult result = new AFResult();
        afResp.setResult(result);
        AFService service = null;
        try {
            service = AFServiceManager.getService(afReq.getServiceName(), request);
            service.doService(afReq, afResp);
        } catch(Exception ex) {
            ex.printStackTrace();
            result.setBooleanValue(false);
            if(result.getResultMessageKey() == null)
                result.setResultMessageKey("af.operation.common.faile");
            if(ex instanceof AFSysException)
                result.setException(((AFSysException)ex).getChainedException());
            else
                result.setException(ex);
        }
        return afResp;
    }

    protected void assembleRequestSearchCondition(HttpServletRequest request, AFSearchOperation so, AFRequest afReq) {
        if(so != null) {
            AFSearchForm searchForm = so.getSearchForm();
            AFPage page = this.getPage(searchForm);
            AFSearchCondition sc = this.getSearchCondition(searchForm);
            afReq.setSearchPage(page);
            afReq.setSearchCondition(sc);
        }
    }

    protected void assembleRequestCheckList(HttpServletRequest request, AFForm form, AFRequest afReq) {
        String[] chkList = form.getChk();
        long[] idList = null;
        if(chkList != null && chkList.length != 0) {
            idList = new long[chkList.length];
            for(int i = 0; i < chkList.length; i++) {
                idList[i] = Long.parseLong(chkList[i]);
            }
        }
        afReq.setDefaultData(idList);
    }

    protected void assembleResponseSearchCondition(HttpServletRequest request, AFSearchOperation so, AFResponse afResp) {
        AFPage page = afResp.getSearchResultPage();
        if(so != null) {
            AFSearchForm sf = so.getSearchForm();
            this.setPageInfo(sf, page);
        }
        request.setAttribute(AFConstants.KEY_SEARCH_RESULT_PAGE, page);
    }

    protected void assembleRequestValueObject(HttpServletRequest request, AFForm form, AFRequest afReq) {
        AFValueObject vo = form.transform();
        afReq.setDefaultData(vo);
    }

    protected void assembleResponseForm(HttpServletRequest request, AFForm form, AFResponse afResp) {
        AFValueObject vo = (AFValueObject)afResp.getDefaultData();
        form.transform(vo);
        request.setAttribute(form.getFormName(), form);
    }

    protected void assembleResponseResult(HttpServletRequest request, AFResult result) {
        if(result != null) {
            request.setAttribute(AFConstants.KEY_RESULT_BOOLEAN_VALUE, String.valueOf(result.getBooleanValue()));
            request.setAttribute(AFConstants.KEY_RESULT_INT_VALUE, String.valueOf(result.getIntValue()));
            request.setAttribute(AFConstants.KEY_RESULT_MESSAGE_KEY, result.getResultMessageKey());
            request.setAttribute(AFConstants.KEY_RESULT_EXCEPTION, result.getExceptionMessage());
        }
    }

    protected void assembleResponseResult(HttpServletRequest request, AFResponse afResp) {
        AFResult result = afResp.getResult();
        assembleResponseResult(request, result);
    }



    protected void cleanForm(AFForm form) {
        form.initialize();
        if(form instanceof AFCompositeForm)
            ((AFCompositeForm)form).cleanDetailList();

    }

    protected AFRequest initialize(String serviceName, String methodName, HttpServletRequest request, AFForm form) {
        AFRequest afReq = new AFRequest();
        afReq.setServiceName(serviceName);
        afReq.setMethodName(methodName == null ? form.getMethod() : methodName);
        afReq.setUserToken((AFUserToken)request.getSession().getAttribute("userToken"));
        return afReq;
    }

    protected AFRequest initialize(String serviceName, HttpServletRequest request, AFForm form) {
        return initialize(serviceName, null, request, form);
    }

    protected AFPage getPage(AFSearchForm form) {
        AFPage page = new AFPage();
        if(form != null) {
            page.setCurrentPageNo(Integer.parseInt(form.getCurrentPageNo()));
            page.setPageSize(Integer.parseInt(form.getPageSize()));
            page.setSortField(form.getSortField());
            page.setSortType(form.getSortType());
            if(page.getCurrentPageNo() <= 0) {
                page.setCurrentPageNo(1);
            }
        }
        return page;
    }

    protected void setPageInfo(AFSearchForm form, AFPage page) {
        if(page != null) {
            form.setPageSize(String.valueOf(page.getPageSize()));
            form.setCurrentPageNo(String.valueOf(page.getCurrentPageNo()));
            form.setTotalPageNum(String.valueOf(page.getTotalPageNum()));
            form.setSortField(page.getSortField());
            form.setSortType(page.getSortType());
        }
    }

    protected AFSearchCondition getSearchCondition(AFSearchForm form) {
        AFSearchCondition sc = new AFSearchCondition();
        if(form != null) {
            sc.setCustomerCondition(form.getCustomCondition());
            //////////////////////////start criterion field//////////////////////
            List list = form.getCriterionFieldList();
            if(list!=null && list.size()!=0) {
                sc.initialize();
                for(int i = 0; i < list.size(); i++) {
                    AFSearchCriterionFieldForm scff = (AFSearchCriterionFieldForm)list.get(i);
                    AFSearchCriterionField scf = new AFSearchCriterionField();
                    scf.setName(scff.getName());
                    scf.setValue(scff.getValue());
                    scf.setType(scff.getType());
                    scf.setLogic(scff.getLogic());
                    scf.setRelation(scff.getRelation());
                    sc.addCriterionField(scf);
                }
            }
        }
        return sc;
    }

    public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletOutputStream sos = response.getOutputStream();
        sos.println("The page you requested invalid, please verify!");
        sos.println("URL:" + request.getRequestURL());
        sos.println("method:" + request.getParameter("method"));
        return null;
    }

}