package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFDateTag extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {

	private static final long serialVersionUID = 1L;

	private static AFLogger logger = AFLogger.getLogger(AFDateTag.class);

	protected String property = null;

	protected String value = null;

	protected String layOut = "popdown";

	protected String name = "org.apache.struts.taglib.html.BEAN";

	protected String strYear = "";

	protected String strMonth = "";

	protected String strDay = "";
  
  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public void setLayOut(String layOut) {
    this.layOut = layOut;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getLayOut() {
    return layOut;
  }

  public String getValue() {
    return value;
  }

  public AFDateTag() {
  }

  public int doStartTag() throws JspException {

    prepareValue();

    AFTagUtils.getInstance().write(this.pageContext,
                                 this.renderDateElement());

    return (EVAL_BODY_BUFFERED);

  }

  protected String renderDateElement() throws JspException {

    StringBuffer results = new StringBuffer("<SCRIPT language=JavaScript>\n");
    results.append(" var date =createDatePicker(");
    results.append("'");
    results.append(prepareName());
    results.append("','"+this.strYear);
    results.append("','"+this.strMonth);
    results.append("','"+this.strDay);
    results.append("','"+this.getLayOut());
    results.append("');");
    results.append("\n</SCRIPT>");

    return results.toString();
  }

  protected void prepareValue() throws JspException {

    if (value != null) {
      splitDateValue(value);
    }
    else {
      Object value =
          AFTagUtils.getInstance().lookup(pageContext, name, property, null);
      if (null == value) {
        value = "";
      }
      splitDateValue(value.toString());
    }

  }

  protected void splitDateValue(String strValue) {
    if ("".equalsIgnoreCase(strValue)) {
      this.strYear = "";
      this.strMonth = "";
      this.strDay = "";
      return ;
    }
    try {
      String[] strSplitValues = strValue.split("-");
      this.strYear = strSplitValues[0];
      this.strMonth = strSplitValues[1];
      this.strDay = strSplitValues[2];
    }
    catch (Exception e) {
      e.printStackTrace();
      logger.logError("split date value error!!!");
    }

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
}