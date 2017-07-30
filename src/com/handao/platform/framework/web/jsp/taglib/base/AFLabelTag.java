package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFLabelTag extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {

	private static final long serialVersionUID = 1L;

    protected String id = null;

    protected String type = "normal";

    protected String text = "";

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public AFLabelTag() {
    }

    public int doStartTag() throws JspException {
        return(EVAL_BODY_BUFFERED);
    }

    public int doAfterBody() throws JspException {
        if(bodyContent != null) {
            String value1 = bodyContent.getString().trim();
            if(value1.length() > 0) {
                this.text = value1;
            }
        }
        return(SKIP_BODY);
    }

    public int doEndTag() throws JspException {

        StringBuffer results = new StringBuffer();
        if(null == this.getStyleClass()) {
            if("normal".equalsIgnoreCase(this.type)) {
                this.setStyleClass("labelNormal");
            } else if("readonly".equalsIgnoreCase(this.type)) {
                this.setStyleClass("lableReadonly");
            }
        }
        results.append(getElementOpen());
        prepareAttribute(results, "id", this.getId());
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        results.append(">");
        results.append(this.text);
        results.append("</label>");
        AFTagUtils.getInstance().write(pageContext, results.toString());
        return(EVAL_PAGE);

    }

    protected String getElementOpen() {
        return "<label ";
    }

}