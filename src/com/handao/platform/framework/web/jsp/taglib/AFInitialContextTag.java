package com.handao.platform.framework.web.jsp.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import com.handao.platform.framework.util.config.AFConfigManager;

public class AFInitialContextTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	protected String id = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public int doStartTag() throws JspException {
        String sTmp = ((HttpServletRequest)pageContext.getRequest()).getContextPath();
        pageContext.setAttribute(id, sTmp);
        pageContext.setAttribute("_sys_imgpath", sTmp + AFConfigManager.getInstance().getStyleConfig().getFullImgPath());
        return EVAL_BODY_INCLUDE;
    }
}