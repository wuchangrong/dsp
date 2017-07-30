package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

public class AFIntegerTag extends org.apache.struts.taglib.html.TextTag {

	private static final long serialVersionUID = 1L;

    protected String validate = "false";

    protected String min = null;

    protected String minexp = ">";

    protected String max = null;

    protected String maxexp = "<";

    protected String onkeypressextend = "";

    protected String onblurextend = "";

    protected String styleextend = "";


    public String getMax() {
        return max;
    }

    public String getMaxexp() {
        return maxexp;
    }

    public String getValidate() {
        return validate;
    }

    public String getMin() {
        return min;
    }

    public void setMinexp(String minexp) {
        this.minexp = minexp;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public void setMaxexp(String maxexp) {
        this.maxexp = maxexp;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setStyleextend(String styleextend) {
        this.styleextend = styleextend;
    }

    public void setOnkeypressextend(String onkeypressextend) {
        this.onkeypressextend = onkeypressextend;
    }

    public void setOnblurextend(String onblurextend) {
        this.onblurextend = onblurextend;
    }

    public String getMinexp() {
        return minexp;
    }

    public String getStyleextend() {
        return styleextend;
    }

    public String getOnkeypressextend() {
        return onkeypressextend;
    }

    public String getOnblurextend() {
        return onblurextend;
    }

    public AFIntegerTag() {

    }

    public int doStartTag() throws JspException {

        StringBuffer objStringBuffer = new StringBuffer();
        if(null == this.validate || "false".equalsIgnoreCase(this.validate)) {
            if(!this.getOnkeypressextend().equalsIgnoreCase("")) {
                this.setOnkeypress("onlyInteger(this);" + this.getOnkeypressextend());
            } else {
                this.setOnkeypress("onlyInteger(this)");
            }

        }
        if("true".equalsIgnoreCase(this.validate)) {
            if(!this.getOnkeypressextend().equalsIgnoreCase("")) {
                this.setOnkeypress("onlyInteger(this);" + this.getOnkeypressextend());
            } else {
                this.setOnkeypress("onlyInteger(this)");
            }

            if(null != this.getMax() && null != this.getMin()) {
                objStringBuffer.append("validNumber2(this,'" + this.getMin() + "','" +
                                       this.getMinexp() + "','" + this.getMax() + "','" +
                                       this.getMaxexp() + "','true')");
            } else if(null == this.getMax() && null == this.getMin()) {
            } else if(null != this.getMax()) {
                objStringBuffer.append("validNumber2(this,'" + "NiN" + "','" + this.getMinexp() +
                                       "','" + this.getMax() + "','" + this.getMaxexp() +
                                       "','true')");
            } else if(null != this.getMin()) {
                objStringBuffer.append("validNumber2(this,'" + this.getMin() + "','" +
                                       this.getMinexp() + "','" + "NaN" + "','" +
                                       this.getMaxexp() + "','true')");
            }
            if(!this.getOnblurextend().equalsIgnoreCase("")) {
                this.setOnblur(objStringBuffer.toString() + ";" + this.getOnblurextend());
            } else {
                this.setOnblur(objStringBuffer.toString());
            }

        }
        if(!this.getStyleextend().equalsIgnoreCase("")) {
            this.setStyle("IME-MODE: disabled" + ";" + this.getStyleextend());
        } else {
            this.setStyle("IME-MODE: disabled;");
        }

        if(this.getStyleClass()==null || "".equals(this.getStyleClass()))
            this.setStyleClass("editTextLine");

        super.doStartTag();

        return(EVAL_BODY_BUFFERED);

    }

}