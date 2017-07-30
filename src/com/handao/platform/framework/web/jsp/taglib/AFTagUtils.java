package com.handao.platform.framework.web.jsp.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.beanutils.PropertyUtils;

public class AFTagUtils {

  private static final AFTagUtils instance = new AFTagUtils();
  private static final Map scopes = new HashMap();

  static {
    scopes.put("page", new Integer(PageContext.PAGE_SCOPE));
    scopes.put("request", new Integer(PageContext.REQUEST_SCOPE));
    scopes.put("session", new Integer(PageContext.SESSION_SCOPE));
    scopes.put("application", new Integer(PageContext.APPLICATION_SCOPE));
  }

  public static AFTagUtils getInstance() {
    return instance;
  }

  public AFTagUtils() {
    super();
  }

  public void write(PageContext pageContext, String text) throws JspException {
    JspWriter writer = pageContext.getOut();
    try {
      writer.print(text);

    }
    catch (IOException e) {
      throw new JspException
          ("jsp tag write.io:" + e.toString());
    }
  }

  public void writePrevious(PageContext pageContext, String text) throws
      JspException {
    JspWriter writer = pageContext.getOut();
    if (writer instanceof BodyContent) {
      writer = ( (BodyContent) writer).getEnclosingWriter();
    }
    try {
      writer.print(text);

    }
    catch (IOException e) {
      throw new JspException
          ("jsp tag write.io:" + e.toString());
    }
  }

  public Object lookup(PageContext pageContext, String name, String scopeName) throws
      JspException {

    if (scopeName == null) {
      return pageContext.findAttribute(name);
    }

    try {
      return pageContext.getAttribute(name, instance.getScope(scopeName));

    }
    catch (JspException e) {
      throw e;
    }

  }

  public int getScope(String scopeName) throws JspException {
    Integer scope = (Integer) scopes.get(scopeName.toLowerCase());

    if (scope == null) {
      throw new JspException("lookup.scope");
    }

    return scope.intValue();
  }

  public Object lookup(
      PageContext pageContext,
      String name,
      String property,
      String scope) throws JspException {

    // Look up the requested bean, and return if requested
    Object bean = lookup(pageContext, name, scope);
    if (bean == null) {
      JspException e = null;
      if (scope == null) {
        e = new JspException("lookup.bean.any" + name);
      }
      else {
        e =
            new JspException(
            "lookup.bean" + name + scope);
      }
      throw e;
    }

    if (property == null) {
      return bean;
    }

    try {
      return PropertyUtils.getProperty(bean, property);

    }
    catch (Exception e) {
      String beanName = name;
      throw new JspException(
          "lookup.method" + property + beanName);
    }

  }

  public String format(String value) {
    if ("".equalsIgnoreCase(value)) {
      return "";
    }
    String newData = "";
    boolean minusFlag = (value.indexOf("-") == 0);
    if (minusFlag) {
      value = value.substring(1, value.length());
    }
    int pointIndex = value.indexOf(".");
    String intPart = pointIndex < 0 ? value : value.substring(0, pointIndex);
    String pointPart = pointIndex < 0 ? "" :
        value.substring(pointIndex, value.length());
    if (intPart.length() <= 3) {
      return (minusFlag ? "-" : "") + value;
    }
    else {
      ArrayList newDataArray = new ArrayList();
      int ys = intPart.length() % 3;
      int dotNumber = intPart.length() / 3;

      int newArrayNumber = 0;
      String strSub = "";
      for (int i = dotNumber; i > 0; i--) {
        int start = ys + (i - 1) * 3;
        String dot = (start == 0) ? "" : ",";
        strSub = dot + intPart.substring(start, 3+start);
        newDataArray.add(strSub);
        newArrayNumber++;
      }

      newData = intPart.substring(0, ys);

      for (int i = newDataArray.size() - 1; i >= 0; i--) {
        newData = newData + newDataArray.get(i).toString();
      }
    }
    return (minusFlag ? "-" : "") + newData + pointPart;

  }
}