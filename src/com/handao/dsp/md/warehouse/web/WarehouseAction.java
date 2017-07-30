package com.handao.dsp.md.warehouse.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.handao.platform.framework.biz.web.AFBizAction;
import com.handao.platform.framework.biz.web.AFBizActionHandleImpl;
import com.handao.platform.framework.biz.web.AFBizRequestEvent;
import com.handao.platform.framework.biz.web.AFBizResponseEvent;

public class WarehouseAction extends AFBizAction
{

	/**
	 * [父类抽象方法实现] 返回Service的ClassName
	 * 
	 * @return String
	 */
	protected String getServiceName()
	{
		return "com.handao.dsp.md.warehouse.service.WarehouseService";
	}

	public ActionForward doReturnMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		return this.commonBizInvoke(mapping, form, request, response, this
				.getServiceName(), "doReturnMsg", new AFBizActionHandleImpl()
		{
			
			public boolean assembleRequest(AFBizRequestEvent reqEvent) 
			{
				HashMap map = new HashMap();
				HttpServletRequest req = reqEvent.getHttpRequest();

				map.put("table", req.getParameter("table"));
				req.getParameter("paraTerm");

				try
				{
					
					map.put("paraTerm", new String(req.getParameter("paraTerm").getBytes("GBK"),"UTF-8"));
				} catch (UnsupportedEncodingException e)
				{
					e.printStackTrace();
				}

				map.put("paraResult", req.getParameter("paraResult"));
				map.put("sqlname", req.getParameter("sqlname"));
				reqEvent.getAFRequest().setData("map", map);

				assembleRequestCheckList(reqEvent.getHttpRequest(), reqEvent
						.getForm(), reqEvent.getAFRequest());
				return true;
			}

			public ActionForward assembleResponse(AFBizResponseEvent respEvent)
			{

				List resultList = (List) respEvent.getAFResponse()
						.getDefaultData();

				try
				{
					respEvent.getHttpResponse().setCharacterEncoding("GBK");
					StringBuffer buf = new StringBuffer();
					HashMap map = new HashMap();
					String temp = new String();
					if (resultList != null&&resultList.size()!=0)
					{
						
						for(int i=0;i<resultList.size();i++){
							map = (HashMap)resultList.get(i);
							Set kys = map.keySet();
							Iterator it = kys.iterator();
							while(it.hasNext())
							{
								if(i!=0){
									buf.append(",");
								}
								temp = (String)it.next();
								buf.append(temp).append(":");
								buf.append(map.get(temp));
								
							}
						}
						respEvent.getHttpResponse().getWriter().write(buf.toString());
					} 
				} catch (IOException e)
				{
					e.printStackTrace();
				}

				return null;
			}
		});
	}
}