package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFButtonTag
    extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {

  private static final long serialVersionUID = 1L;

  protected String id = null;
  protected String name = null;
  protected String value = null;
  
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public int doStartTag() throws JspException {
    return (EVAL_BODY_BUFFERED);
  }

  public int doAfterBody() throws JspException {

    if (bodyContent != null) {
      String value1 = bodyContent.getString().trim();
      if (value1.length() > 0) {
        this.setValue(value1);
      }
    }
    return (SKIP_BODY);
  }

  public int doEndTag() throws JspException {
    StringBuffer results = new StringBuffer();
    results.append(getElementOpen());
    prepareAttribute(results, "id", this.getId());
    prepareAttribute(results, "name", this.getName());
    prepareButtonAttributes(results);
    prepareAttribute(results, "value", this.getValue());
    results.append(prepareEventHandlers());
    results.append(prepareStyles());
    prepareOtherAttributes(results);
    results.append(getElementClose());
    AFTagUtils.getInstance().write(pageContext, results.toString());
    return (EVAL_PAGE);

  }

  protected String getElementOpen() {
    return "<input type=\"button\"";
  }

  protected void prepareButtonAttributes(StringBuffer results) throws
      JspException {
    prepareAttribute(results, "accesskey", getAccesskey());
    prepareAttribute(results, "tabindex", getTabindex());
  }

  public AFButtonTag() {
  }
}