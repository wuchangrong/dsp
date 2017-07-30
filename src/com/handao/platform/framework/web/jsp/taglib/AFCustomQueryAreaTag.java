package com.handao.platform.framework.web.jsp.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.handao.platform.framework.util.config.AFConfigManager;

public class AFCustomQueryAreaTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private static String html1 = null;
    private static String html2 = null;
    private static String html3 = null;
    private static String html4 = null;
    private static String html5 = null;

    private String visible = "true";

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return this.visible;
    }

    private static final String imgPath_Show = "/push/push_up_c.gif";
    private static final String imgPath_Hidden = "/push/push_down_c.gif";
    private static final String alt_Show = "ÕÛµþ";
    private static final String alt_Hidden = "Õ¹¿ª";

    static {
        html1 = "<TABLE class=queryConTable id=AF_CustomQueryArea cellSpacing=1 cellPadding=1 width=\"98%\" align=center border=0 style=\"display:";

        html2 = "\"><TBODY>";

        html3 = "</TBODY></TABLE>";
        html3 += "<table width=\"98%\" height=\"6\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"pushTable\">";
        html3 += "<tr><td align=\"right\"><img src=\"";

        html4 = "\" showImg='" + imgPath_Show + "' hiddenImg='" + imgPath_Hidden + "' showAlt='" + alt_Show + "' hiddenAlt='" + alt_Hidden + "' alt=\"";
        html5 = "\" width=\"8\" height=\"4\" onClick=\"_tag_SetCustomQueryAreaVisible('AF_CustomQueryArea', this)\" onMouseOver=\"this.style.cursor='hand'\"></td></tr></table>";
    }

    public int doStartTag() throws JspException {
        try {
            JspWriter jw = pageContext.getOut();
            jw.print(html1);
            jw.print("true".equals(this.visible)?"''":"none");
            jw.println(html2);
        }
        catch (IOException ex) {
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        try {
            JspWriter jw = pageContext.getOut();
            jw.print(html3);
            jw.print(((HttpServletRequest)pageContext.getRequest()).getContextPath());
            jw.print(AFConfigManager.getInstance().getStyleConfig().getFullImgPath());
            jw.print("true".equals(this.visible)?imgPath_Show:imgPath_Hidden);
            jw.print(html4);
            jw.print("true".equals(this.visible)?alt_Show:alt_Hidden);
            jw.println(html5);
        }
        catch (IOException ex) {
        }
        return EVAL_PAGE;
    }

}