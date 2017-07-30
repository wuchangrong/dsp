package com.handao.platform.framework.biz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.web.AFCompositeForm;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchOperation;
import com.handao.platform.framework.web.AFTokenValidAction;

public abstract class AFBizAction extends AFTokenValidAction{

	public AFBizAction()
	{
		logger = AFLogger.getLogger(getClass());
	}

	public ActionForward commonBizInvoke(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String serviceName,
			String methodName, AFBizActionHandle handle) throws Exception
	{
		AFForm afForm = (AFForm) form;
		String doWhat = afForm.getDoWhat();
		request.setAttribute("doWhat", doWhat);
		AFRequest afReq = initialize(serviceName, methodName, request,
				afForm);
		boolean flag = handle.assembleRequest(new AFBizRequestEvent(
				methodName, request, (AFForm) form, afReq));
		AFResponse afResp = null;
		if (flag)
		{
			afResp = invoke(request, afReq);
			flag = afResp.getResult().getBooleanValue();
		} else
		{
			flag = true;
		}
		return handle
				.assembleResponse(new AFBizResponseEvent(flag, methodName,
						request, response, mapping, (AFForm) form, afResp));
	}

	public ActionForward doStartProgram(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		return doSearch(mapping, form, request, response);
	}

	public ActionForward doAddIni(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doFind", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						AFForm afForm = reqEvent.getForm();
						String doWhat = afForm.getDoWhat();
						cleanForm(afForm);
						reqEvent.getHttpRequest()
								.setAttribute("doWhat", doWhat);
						return false;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						return respEvent.getMapping().findForward("addEdit");
					}

				});
	}

	public ActionForward doEditIni(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doFind", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestCheckList(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseForm(respEvent.getHttpRequest(),
								respEvent.getForm(), respEvent.getAFResponse());
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward("addEdit");
					}

				});
	}

	public ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		if (!super.isTokenValid(request, true))
		{
			super.saveToken(request);
			return doAddTokenValid(mapping, form, request, response);
		}
		super.saveToken(request);

		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doSave", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestValueObject(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward(
								respEvent.isSuccess() ? "list.do" : "addEdit");
					}

				});
	}

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
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward(
								respEvent.isSuccess() ? "list.do" : "addEdit");
					}

				});
	}

	public ActionForward doAddAndNew(ActionMapping mapping, ActionForm form,
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
				getServiceName(), "doSave", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestValueObject(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping()
								.findForward(
										respEvent.isSuccess() ? "addIni.do"
												: "addEdit");
					}

				});
	}

	public ActionForward doEditAndNew(ActionMapping mapping, ActionForm form,
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
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping()
								.findForward(
										respEvent.isSuccess() ? "addIni.do"
												: "addEdit");
					}

				});
	}

	public ActionForward doView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doFind", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestCheckList(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseForm(respEvent.getHttpRequest(),
								respEvent.getForm(), respEvent.getAFResponse());
						return respEvent.getMapping().findForward("view");
					}

				});
	}

	public ActionForward doDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		if (!super.isTokenValid(request, true))
		{
			super.saveToken(request);
			return doDeleteTokenValid(mapping, form, request, response);
		}
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doDelete", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestCheckList(reqEvent.getHttpRequest(),
								reqEvent.getForm(), reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseResult(respEvent.getHttpRequest(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward("list.do");
					}

				});
	}

	public ActionForward doSearch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		super.saveToken(request);
		return commonBizInvoke(mapping, form, request, response,
				getServiceName(), "doSearch", new AFBizActionHandleImpl()
				{

					public boolean assembleRequest(AFBizRequestEvent reqEvent)
					{
						assembleRequestSearchCondition(reqEvent
								.getHttpRequest(),
								(AFSearchOperation) reqEvent.getForm(),
								reqEvent.getAFRequest());
						return true;
					}

					public ActionForward assembleResponse(
							AFBizResponseEvent respEvent)
					{
						assembleResponseSearchCondition(respEvent
								.getHttpRequest(),
								(AFSearchOperation) respEvent.getForm(),
								respEvent.getAFResponse());
						return respEvent.getMapping().findForward("list");
					}

				});
	}

	public ActionForward doAddTokenValid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		commonTokenValid(request);
		return mapping.findForward("list.do");
	}

	public ActionForward doEditTokenValid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		commonTokenValid(request);
		return mapping.findForward("list.do");
	}

	public ActionForward doDeleteTokenValid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		commonTokenValid(request);
		return mapping.findForward("list.do");
	}

	public ActionForward doAddDetailRow(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			List detailList, String detailFormClass) throws Exception
	{
		AFCompositeForm afForm = (AFCompositeForm) form;
		int size = -1;
		try
		{
			size = Integer.parseInt(afForm.getDetailExtendSize());
		} catch (NumberFormatException ex)
		{
			size = 1;
		}
		afForm.addDetailSize(detailList, size, detailFormClass);
		request.setAttribute(afForm.getFormName(), afForm);
		return mapping.findForward("addEdit");
	}

	protected abstract String getServiceName();
	
    protected void commonTokenValid(HttpServletRequest request) throws Exception{
	}

	protected AFLogger logger;
}