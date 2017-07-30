package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

public class AFTextTag extends org.apache.struts.taglib.html.TextTag {

	private static final long serialVersionUID = 1L;
	
	protected String maxcharlength = null;

    public void setMaxcharlength(String maxcharlength) {
        this.maxcharlength = maxcharlength;
        if(null!=this.maxcharlength) {
            this.setOnblur("objCheckLen2(this,"+this.maxcharlength+")");
            this.setOnkeypress("objCheckLen2_onkeypress(this,"+this.maxcharlength+")");
        }
    }

    public String getMaxcharlength() {
        return maxcharlength;
    }
    
    public AFTextTag() {

    }

    public int doStartTag() throws JspException {
        if(this.getStyleClass()==null||this.getStyleClass().trim().length()==0) {
            if(this.getReadonly())
                this.setStyleClass("readonly");
            else
                this.setStyleClass("editTextLine");
        }
        return super.doStartTag();
    }

}