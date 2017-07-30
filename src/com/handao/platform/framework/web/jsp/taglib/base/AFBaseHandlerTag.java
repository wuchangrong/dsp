package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.taglib.logic.IterateTag;

public abstract class AFBaseHandlerTag
    extends BodyTagSupport {

  private static Log log = LogFactory.getLog(AFBaseHandlerTag.class);

  protected String accesskey = null;
  protected String tabindex = null;
  protected boolean indexed = false;
  private String onclick = null;
  private String ondblclick = null;
  private String onmouseover = null;
  private String onmouseout = null;
  private String onmousemove = null;
  private String onmousedown = null;
  private String onmouseup = null;
  private String onkeydown = null;
  private String onkeyup = null;
  private String onkeypress = null;
  private String onselect = null;
  private String onchange = null;
  private String onblur = null;
  private String onfocus = null;
  private boolean disabled = false;
  protected boolean doDisabled = true;
  private boolean readonly = false;
  protected boolean doReadonly = true;
  private String style = null;
  private String styleClass = null;
  private String styleId = null;
  private String errorStyle = null;
  private String errorStyleClass = null;
  private String errorStyleId = null;
  private String alt = null;
  private String altKey = null;
  private String bundle = null;
  private String title = null;
  private String titleKey = null;

  public String getOnmousemove() {
    return onmousemove;
  }

  public String getOnmouseup() {
    return onmouseup;
  }

  public String getAltKey() {
    return altKey;
  }

  public String getOnfocus() {
    return onfocus;
  }

  public String getOnselect() {
    return onselect;
  }

  public boolean isIndexed() {
    return indexed;
  }

  public String getOnmousedown() {
    return onmousedown;
  }

  public String getOnkeydown() {
    return onkeydown;
  }

  public String getOnmouseout() {
    return onmouseout;
  }

  public String getAlt() {
    return alt;
  }

  public String getOnclick() {
    return onclick;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public String getErrorStyle() {
    return errorStyle;
  }

  public boolean isDoDisabled() {
    return doDisabled;
  }

  public String getTabindex() {
    return tabindex;
  }

  public String getOnkeyup() {
    return onkeyup;
  }

  public String getErrorStyleClass() {
    return errorStyleClass;
  }

  public String getOnblur() {
    return onblur;
  }

  public String getOnmouseover() {
    return onmouseover;
  }

  public String getBundle() {
    return bundle;
  }

  public String getStyle() {
    return style;
  }

  public String getOndblclick() {
    return ondblclick;
  }

  public String getOnkeypress() {
    return onkeypress;
  }

  public String getAccesskey() {
    return accesskey;
  }

  public String getStyleClass() {
    return styleClass;
  }

  public boolean isReadonly() {
    return readonly;
  }

  public boolean isDoReadonly() {
    return doReadonly;
  }

  public String getOnchange() {
    return onchange;
  }

  public String getStyleId() {
    return styleId;
  }

  public String getErrorStyleId() {
    return errorStyleId;
  }

  public String getTitle() {
    return title;
  }

  public String getTitleKey() {
    return titleKey;
  }

  public void setLog(Log log) {
	  AFBaseHandlerTag.log = log;
  }

  public void setOnmousemove(String onmousemove) {
    this.onmousemove = onmousemove;
  }

  public void setOnmouseup(String onmouseup) {
    this.onmouseup = onmouseup;
  }

  public void setAltKey(String altKey) {
    this.altKey = altKey;
  }

  public void setOnfocus(String onfocus) {
    this.onfocus = onfocus;
  }

  public void setOnselect(String onselect) {
    this.onselect = onselect;
  }

  public void setIndexed(boolean indexed) {
    this.indexed = indexed;
  }

  public void setOnmousedown(String onmousedown) {
    this.onmousedown = onmousedown;
  }

  public void setOnkeydown(String onkeydown) {
    this.onkeydown = onkeydown;
  }

  public void setOnmouseout(String onmouseout) {
    this.onmouseout = onmouseout;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public void setOnclick(String onclick) {
    this.onclick = onclick;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public void setErrorStyle(String errorStyle) {
    this.errorStyle = errorStyle;
  }

  public void setDoDisabled(boolean doDisabled) {
    this.doDisabled = doDisabled;
  }

  public void setTabindex(String tabindex) {
    this.tabindex = tabindex;
  }

  public void setOnkeyup(String onkeyup) {
    this.onkeyup = onkeyup;
  }

  public void setErrorStyleClass(String errorStyleClass) {
    this.errorStyleClass = errorStyleClass;
  }

  public void setOnblur(String onblur) {
    this.onblur = onblur;
  }

  public void setOnmouseover(String onmouseover) {
    this.onmouseover = onmouseover;
  }

  public void setBundle(String bundle) {
    this.bundle = bundle;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public void setOndblclick(String ondblclick) {
    this.ondblclick = ondblclick;
  }

  public void setOnkeypress(String onkeypress) {
    this.onkeypress = onkeypress;
  }

  public void setAccesskey(String accesskey) {
    this.accesskey = accesskey;
  }

  public void setStyleClass(String styleClass) {
    this.styleClass = styleClass;
  }

  public void setReadonly(boolean readonly) {
    this.readonly = readonly;
  }

  public boolean getReadonly() {
    return this.readonly;
  }

  public boolean getDisabled() {
    return this.disabled;
  }

  public void setDoReadonly(boolean doReadonly) {
    this.doReadonly = doReadonly;
  }

  public void setOnchange(String onchange) {
    this.onchange = onchange;
  }

  public void setStyleId(String styleId) {
    this.styleId = styleId;
  }

  public void setErrorStyleId(String errorStyleId) {
    this.errorStyleId = errorStyleId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTitleKey(String titleKey) {
    this.titleKey = titleKey;
  }

  public Log getLog() {
    return log;
  }

  public void release() {

    super.release();
    accesskey = null;
    alt = null;
    altKey = null;
    bundle = null;
    errorStyle = null;
    errorStyleClass = null;
    errorStyleId = null;
    indexed = false;
    onclick = null;
    ondblclick = null;
    onmouseover = null;
    onmouseout = null;
    onmousemove = null;
    onmousedown = null;
    onmouseup = null;
    onkeydown = null;
    onkeyup = null;
    onkeypress = null;
    onselect = null;
    onchange = null;
    onblur = null;
    onfocus = null;
    disabled = false;
    readonly = false;
    style = null;
    styleClass = null;
    styleId = null;
    tabindex = null;
    title = null;
    titleKey = null;

  }

  protected void prepareAttribute(StringBuffer handlers, String name,
                                  Object value) {
    if (value != null) {
      handlers.append(" ");
      handlers.append(name);
      handlers.append("=\"");
      handlers.append(value);
      handlers.append("\"");
    }
  }

  protected void prepareIndex(StringBuffer handlers, String name) throws
      JspException {

    if (name != null) {
      handlers.append(name);
    }

    handlers.append("[");
    handlers.append(getIndexValue());
    handlers.append("]");

    if (name != null) {
      handlers.append(".");
    }
  }

  protected int getIndexValue() throws JspException {
    IterateTag iterateTag =
        (IterateTag) findAncestorWithClass(this, IterateTag.class);
    if (iterateTag != null) {
      return iterateTag.getIndex();
    }

    JspException e =
        new JspException("indexed.noEnclosingIterate");
    throw e;
  }

  protected String prepareEventHandlers() {
    StringBuffer handlers = new StringBuffer();
    prepareMouseEvents(handlers);
    prepareKeyEvents(handlers);
    prepareTextEvents(handlers);
    prepareFocusEvents(handlers);
    return handlers.toString();
  }

  protected void prepareMouseEvents(StringBuffer handlers) {

    prepareAttribute(handlers, "onclick", getOnclick());
    prepareAttribute(handlers, "ondblclick", getOndblclick());
    prepareAttribute(handlers, "onmouseover", getOnmouseover());
    prepareAttribute(handlers, "onmouseout", getOnmouseout());
    prepareAttribute(handlers, "onmousemove", getOnmousemove());
    prepareAttribute(handlers, "onmousedown", getOnmousedown());
    prepareAttribute(handlers, "onmouseup", getOnmouseup());
  }

  protected void prepareKeyEvents(StringBuffer handlers) {

    prepareAttribute(handlers, "onkeydown", getOnkeydown());
    prepareAttribute(handlers, "onkeyup", getOnkeyup());
    prepareAttribute(handlers, "onkeypress", getOnkeypress());

  }

  protected void prepareTextEvents(StringBuffer handlers) {

    prepareAttribute(handlers, "onselect", getOnselect());
    prepareAttribute(handlers, "onchange", getOnchange());

  }

  protected void prepareFocusEvents(StringBuffer handlers) {

    prepareAttribute(handlers, "onblur", getOnblur());
    prepareAttribute(handlers, "onfocus", getOnfocus());

    if (doDisabled) {
      if (true == this.getDisabled()) {
        handlers.append(" disabled=\"disabled\"");
      }

    }

    if (doReadonly) {
      if (true == this.getReadonly()) {
        handlers.append(" readonly=\"readonly\"");
      }
    }

  }

  protected String prepareStyles() throws JspException {

    StringBuffer styles = new StringBuffer();

    boolean errorsExist = false;

    if (errorsExist && getErrorStyleId() != null) {
      prepareAttribute(styles, "id", getErrorStyleId());
    }
    else {
      prepareAttribute(styles, "id", getStyleId());
    }

    if (errorsExist && getErrorStyle() != null) {
      prepareAttribute(styles, "style", getErrorStyle());
    }
    else {
      prepareAttribute(styles, "style", getStyle());
    }

    if (errorsExist && getErrorStyleClass() != null) {
      prepareAttribute(styles, "class", getErrorStyleClass());
    }
    else {
      prepareAttribute(styles, "class", getStyleClass());
    }

    prepareAttribute(styles, "title", getTitle());
    prepareAttribute(styles, "alt", getAlt());

    return styles.toString();

  }

  protected void prepareOtherAttributes(StringBuffer handlers) {
  }

  protected String getElementClose() {
    return ">";
  }
}