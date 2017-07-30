package com.handao.platform.framework.web.jsp;

import javax.servlet.jsp.PageContext;

public interface AFValueProcess {
    public void setPageContext(PageContext pageContext);

    public String process(String code);
}