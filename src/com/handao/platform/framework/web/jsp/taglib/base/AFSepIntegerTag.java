package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFSepIntegerTag extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {
	private static final long serialVersionUID = 1L;

    protected String property = null;

    protected String value = null;

    protected String name = "org.apache.struts.taglib.html.BEAN";

    protected String cols = null;

    protected String onpropertychange = null;

    protected String validate = "false";

    protected String min = null;

    protected String minexp = ">";

    protected String max = null;

    protected String maxexp = "<";

    protected String onkeypressextend = "";

    protected String onblurextend = "";

    protected String styleextend = "";

    protected String onkeydownextend = "";

    protected String onfocusextend = "";

    public String getName() {
        return(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCols() {
        return(this.cols);
    }

    public void setCols(String cols) {
        this.cols = cols;
    }
    public String getSize() {
        return(getCols());
    }
    public void setSize(String size) {
        setCols(size);
    }

    public String getProperty() {
        return(this.property);
    }

    public String getOnpropertychange() {
        return onpropertychange;
    }
    public void setProperty(String property) {
        this.property = property;
    }

    public void setOnpropertychange(String onpropertychange) {
        this.onpropertychange = onpropertychange;
    }

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

    public void setValue(String value) {
        this.value = value;
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

    public void setOnkeydownextend(String onkeydownextend) {
        this.onkeydownextend = onkeydownextend;
    }

    public void setOnfocusextend(String onfocusextend) {
        this.onfocusextend = onfocusextend;
    }

    public String getMinexp() {
        return minexp;
    }

    public String getValue() {
        return value;
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

    public String getOnkeydownextend() {
        return onkeydownextend;
    }

    public String getOnfocusextend() {
        return onfocusextend;
    }

    public AFSepIntegerTag() {
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
                objStringBuffer.append("validNumber3(this,'" + this.getMin() + "','" +
                                       this.getMinexp() + "','" + this.getMax() + "','" +
                                       this.getMaxexp() + "','true')");
            } else if(null == this.getMax() && null == this.getMin()) {
            } else if(null != this.getMax()) {
                objStringBuffer.append("validNumber3(this,'" + "NiN" + "','" + this.getMinexp() +
                                       "','" + this.getMax() + "','" + this.getMaxexp() +
                                       "','true')");
            } else if(null != this.getMin()) {
                objStringBuffer.append("validNumber3(this,'" + this.getMin() + "','" +
                                       this.getMinexp() + "','" + "NaN" + "','" +
                                       this.getMaxexp() + "','true')");
            }
            if(!this.getOnblurextend().equalsIgnoreCase("")) {
                this.setOnblur("formatIntegerToSepInteger(this);" + objStringBuffer.toString() + ";" + this.getOnblurextend());
            } else {
                this.setOnblur("formatIntegerToSepInteger(this);" + objStringBuffer.toString());
            }

        }

        if(this.getStyleClass()==null || "".equals(this.getStyleClass()))
            this.setStyleClass("editTextLine");

        AFTagUtils.getInstance().write(this.pageContext, this.renderInputElement());

        return(EVAL_BODY_BUFFERED);

    }
    protected String renderInputElement() throws JspException {

        //set event handler
        if(!this.getOnfocusextend().equalsIgnoreCase("")) {
            this.setOnfocus("formatSepIntegerToInteger(this);this.select()" + ";" + this.getOnfocusextend());
        } else {
            this.setOnfocus("formatSepIntegerToInteger(this);this.select();");
        }

        if(!this.getStyleextend().equalsIgnoreCase("")) {
            this.setStyle("IME-MODE: disabled" + ";" + this.getStyleextend());
        } else {
            this.setStyle("IME-MODE: disabled;");
        }

        StringBuffer results = new StringBuffer("<input");

        prepareAttribute(results, "name", prepareDisplayName());
        prepareAttribute(results, "accesskey", getAccesskey());
        prepareAttribute(results, "size", getCols());
        prepareAttribute(results, "tabindex", getTabindex());
        prepareDisplayValue(results);
        results.append(this.prepareEventHandlers());
        results.append(this.prepareStyles());
        prepareOtherAttributes(results);
        results.append(this.getElementClose());

        //output this tag:hidden input
        results.append("<input ");
        prepareAttribute(results, "name", prepareName());
        results.append(
            " onpropertychange=IntegerToSepInteger_OnPropertyChange(this) type=hidden ");
        prepareValue(results);
        results.append(this.getElementClose());
        return results.toString();
    }

    protected String prepareName() throws JspException {
        if(property == null) {
            return null;
        }
        if(indexed) {
            StringBuffer results = new StringBuffer();
            prepareIndex(results, name);
            results.append(property);
            return results.toString();
        }
        return property;

    }

    protected String prepareDisplayName() throws JspException {
        if(property == null) {
            return null;
        }
        if(indexed) {
            StringBuffer results = new StringBuffer();
            prepareIndex(results, name);
            results.append("money_" + property);
            return results.toString();
        }
        return "money_" + property;
    }

    protected void prepareValue(StringBuffer results) throws JspException {
        results.append(" value=\"");
        if(value != null) {
            results.append(value);

        } else {
            Object value =
                AFTagUtils.getInstance().lookup(pageContext, name, property, null);
            if(null == value) {
                value = "";
            }
            results.append(value);
        }
        results.append('"');
    }

    protected void prepareDisplayValue(StringBuffer results) throws JspException {
        results.append(" value=\"");
        if(value != null) {
            results.append(AFTagUtils.getInstance().format(value));
        } else {
            Object value =
                AFTagUtils.getInstance().lookup(pageContext, name, property, null);
            if(null == value) {
                value = "";
            }
            results.append(AFTagUtils.getInstance().format(value.toString()));
        }
        results.append('"');
    }
}