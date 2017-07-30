package com.handao.platform.framework.web.jsp.taglib.base;

public class AFTextareaTag
    extends org.apache.struts.taglib.html.TextareaTag {

	private static final long serialVersionUID = 1L;

  protected String maxcharlength = null;

  public void setMaxcharlength(String maxcharlength) {
    this.maxcharlength = maxcharlength;
    if (null != this.maxcharlength) {
      this.setOnblur("objCheckLen2(this,"+this.maxcharlength+")");
      this.setOnkeypress("objCheckLen2_onkeypress(this,"+this.maxcharlength+")");
    }
  }

  public String getMaxcharlength() {
    return maxcharlength;
  }
  public AFTextareaTag() {}
}