package com.handao.platform.framework.web.jsp.taglib;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;

public class AFHeadButtonTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String id = null;
    private String name = "";
    private String accesskey = "";
    private String onClick = "";

    public int doEndTag() throws JspException {
        ((AFHeadLinkTag)this.getParent()).addButton(new AFHeadButton(id, name, accesskey, onClick));
        return EVAL_PAGE;
    }
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}    
	
    public String getName() {
      return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccesskey() {
        return accesskey;
    }
    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }
    public String getOnClick() {
        return onClick;
    }
    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

}