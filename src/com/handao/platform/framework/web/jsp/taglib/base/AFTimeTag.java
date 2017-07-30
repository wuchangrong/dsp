package com.handao.platform.framework.web.jsp.taglib.base;

import java.util.Calendar;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFTimeTag
    extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {

	private static final long serialVersionUID = 1L;

	private static AFLogger logger = AFLogger.getLogger(AFTimeTag.class);

  protected String property = null;

  protected String value = null;

  protected String layOut = "popdown";

  protected String name = "org.apache.struts.taglib.html.BEAN";

  protected String strYear = "";

  protected String strMonth = "";

  protected String strDay = "";

  protected String strHms = "";

  protected String strCurrentDate = "";

  protected boolean isTime = true;

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

  public AFTimeTag() {
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
    results.append(prepareDateName());
    results.append("','" + this.strYear);
    results.append("','" + this.strMonth);
    results.append("','" + this.strDay);
    results.append("','" + this.getLayOut());
    results.append("'," + this.isTime);
    results.append(");");
    results.append("\n</SCRIPT>\n");

    results.append(
        "<INPUT class=HmsFrame onblur=validTime(this) style=\"IME-MODE: disabled\" ");
    results.append("name=\"" + prepareHmsName() + "\" ");
    if ("".equalsIgnoreCase(this.strHms)) {
      this.strCurrentDate = getCurrentTime();
      this.strHms = strCurrentDate.substring(strCurrentDate.indexOf(" ") + 1);
    }
    results.append("maxLength=8 size=8 value=\"" + this.strHms + "\" >");

    results.append("<INPUT type=hidden name=\"" + prepareName() + "\" ");
    prepareHiddenValue();
    results.append("value=\""+this.value+"\">");

    return results.toString();
  }

  protected void prepareHiddenValue() throws JspException {
    if (value != null) {
      if ("".equalsIgnoreCase(this.value)) {
        this.value =  this.strCurrentDate;
      }
    }
    else {
      Object value1 =
          AFTagUtils.getInstance().lookup(pageContext, name, property, null);
      if (null == value1) {
        value1 = "";
      }
      if ("".equalsIgnoreCase(value1.toString())) {
        this.value =  this.strCurrentDate;
      }
    }
  }

  protected void prepareValue() throws JspException {
    if (value != null) {
      splitTimeValue(value);
    }
    else {
      Object value =
          AFTagUtils.getInstance().lookup(pageContext, name, property, null);
      if (null == value) {
        value = "";
      }
      splitTimeValue(value.toString());
    }
  }

  protected void splitTimeValue(String strValue) {
    if ("".equalsIgnoreCase(strValue)) {
      this.strYear = "";
      this.strMonth = "";
      this.strDay = "";
      this.strHms = "";
      return;
    }
    try {
      String[] strSplitWholeValues = strValue.split(" ");
      String[] strSplitValues = strSplitWholeValues[0].split("-");
      this.strYear = strSplitValues[0];
      this.strMonth = strSplitValues[1];
      this.strDay = strSplitValues[2];
      this.strHms = strSplitWholeValues[1];
    }
    catch (Exception e) {
      e.printStackTrace();
      logger.logError("split time value error!!!");
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

  protected String prepareDateName() throws JspException {
    if (property == null) {
      return null;
    }
    if (indexed) {
      StringBuffer results = new StringBuffer();
      prepareIndex(results, name);
      results.append(property + "_date");
      return results.toString();
    }
    return property + "_date";
  }

  protected String prepareHmsName() throws JspException {
    if (property == null) {
      return null;
    }
    if (indexed) {
      StringBuffer results = new StringBuffer();
      prepareIndex(results, name);
      results.append(property + "_hms");
      return results.toString();
    }
    return property + "_hms";
  }

  private String getCurrentTime() {
    String outTime = "";
    String sHour = "";
    String sMinute = "";
    String sSecond = "";
    
    Calendar cal = Calendar.getInstance();    
    int tYear = cal.get(Calendar.YEAR);
    int tMonth = cal.get(Calendar.MONTH);
    int tDate = cal.get(Calendar.DATE);
    int tHour = cal.get(Calendar.HOUR_OF_DAY);
    int tMinute = cal.get(Calendar.MINUTE);
	    
    if (tHour < 10) {
      sHour = "0" + String.valueOf(tHour);
    }
    else {
      sHour = String.valueOf(tHour);
    }
    if (tMinute < 10) {
      sMinute = "0" + String.valueOf(tMinute);
    }
    else {
      sMinute = String.valueOf(tMinute);
    }
    int tSecond = cal.get(Calendar.SECOND);
    if (tSecond < 10) {
      sSecond = "0" + String.valueOf(tSecond);
    }
    else {
      sSecond = String.valueOf(tSecond);
    }

    outTime = String.valueOf(tYear) + "-" + String.valueOf(tMonth + 1) +
        "-" + String.valueOf(tDate) + " " + sHour + ":" + sMinute + ":" +
        sSecond;
    return outTime;
  }
}