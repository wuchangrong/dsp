package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFCheckBoxTag
    extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {

	private static final long serialVersionUID = 1L;

  protected String property = null;

  protected String value = null;

  protected String name = "org.apache.struts.taglib.html.BEAN";

  protected String checkValue = "1";

  protected String unCheckValue = "0";

  protected boolean isChecked = false;

  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public void setUnCheckValue(String unCheckValue) {
    this.unCheckValue = unCheckValue;
  }

  public void setCheckValue(String checkValue) {
    this.checkValue = checkValue;
  }

  public String getValue() {
    return value;
  }

  public String getUnCheckValue() {
    return unCheckValue;
  }

  public String getCheckValue() {
    return checkValue;
  }

  public AFCheckBoxTag() {
  }

  public int doStartTag() throws JspException {
    AFTagUtils.getInstance().write(this.pageContext, this.renderInputElement());
    this.clear();
    return (EVAL_BODY_BUFFERED);
  }

  protected String renderInputElement() throws JspException {

    this.setOnclick("changeCheckboxHiddenValue(this,'" +
                    this.getCheckValue().trim() + "','"
                    + this.getUnCheckValue().trim() + "')");

    StringBuffer results = new StringBuffer("<input type=checkbox ");

    prepareAttribute(results, "name", prepareDisplayName());
    prepareAttribute(results, "accesskey", getAccesskey());
    prepareAttribute(results, "tabindex", getTabindex());
    prepareDisplayValue(results);
    results.append(this.prepareEventHandlers());
    results.append(this.prepareStyles());
    if (isChecked == true) {
      results.append(" checked ");
    }
    prepareOtherAttributes(results);
    results.append(this.getElementClose());

    results.append("<input ");
    prepareAttribute(results, "name", prepareName());
    results.append(
        " onpropertychange=Checkbox_OnPropertyChange(this,'" +
        this.getCheckValue().trim() + "','" + this.getUnCheckValue().trim() +
        "') type=hidden");
    prepareValue(results);
    results.append(this.getElementClose());
    return results.toString();
  }

  protected String prepareDisplayName() throws JspException {
    if (property == null) {
      return null;
    }
    if (indexed) {
      StringBuffer results = new StringBuffer();
      prepareIndex(results, name);
      results.append("checkbox_" + property);
      return results.toString();
    }
    return "checkbox_" + property;
  }

  protected void clear() throws JspException {
    this.value = null;

  }

  protected String prepareName() throws JspException {
    if (property == null) {
      return null;
    }
    if (indexed) {
      StringBuffer results = new StringBuffer();
      prepareIndex(results, name);
      results.append(property);
      return results.toString();
    }
    return property;

  }

  protected void prepareDisplayValue(StringBuffer results) throws JspException {

    results.append(" value=\"");
    if (value != null) {
      results.append(value);
      if (this.getCheckValue().trim().equalsIgnoreCase(value.trim())) {
        isChecked = true;
      }else {
    	isChecked = false;
    	value = this.getUnCheckValue().trim();
      }

    }
    else {
      Object value =
          AFTagUtils.getInstance().lookup(pageContext, name, property, null);
      if (null == value) {
        value = "";
      }
      if (null != value && "".equalsIgnoreCase(String.valueOf(value))) {
    	value = this.getUnCheckValue().trim();
      }
      if (this.getCheckValue().trim().equalsIgnoreCase(value.toString().trim())) {
        isChecked = true;
      }else {
    	isChecked = false;
    	this.setValue(this.getUnCheckValue().trim());
    	
      }
      results.append(value.toString());
    }

    results.append('"');

  }

  protected void prepareValue(StringBuffer results) throws JspException {

    results.append(" value=\"");
    if (value != null) {
      results.append(value);

    }
    else {
      Object value =
          AFTagUtils.getInstance().lookup(pageContext, name, property, null);
      if (null == value) {
        value = "";
      }
      results.append(value);
    }

    results.append('"');

  }

}