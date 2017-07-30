package com.handao.platform.framework.web.jsp.taglib;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.Globals;
import org.apache.struts.taglib.TagUtils;

import com.handao.platform.framework.util.config.AFConfigManager;

public class AFHeadLinkTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList buttonList = new ArrayList();
    private static String html1 = null;
    private static String html2 = null;
    private static String html3 = null;

    private static boolean initFlag = false;

    protected String localeKey = Globals.LOCALE_KEY;

    private String bundle = null;
    private String titleKey = null;
    private String title = null;

    public int doStartTag() throws JspException {
        if(!initFlag) {
            synchronized(buttonList) {
                String ctx = ((HttpServletRequest)pageContext.getRequest()).getContextPath();
                String fullImgPath = AFConfigManager.getInstance().getStyleConfig().getFullImgPath();
                StringBuffer sb = new StringBuffer();
                sb.append("<TABLE id=AF_HeadLink class=iviewsTitle cellSpacing=0 cellPadding=0 width=\"98%\" align=center>").append("\n");
                sb.append("<TBODY>").append("\n");
                sb.append("<TR>").append("\n");
                sb.append("<TD vAlign=bottom width=150>").append("\n");
                sb.append("<TABLE cellSpacing=0 cellPadding=0 width=100 align=left border=0>").append("\n");
                sb.append("<TBODY>").append("\n");
                sb.append("<TR>").append("\n");
                sb.append("<TD width=4><IMG src=\"").append(ctx).append(fullImgPath).append("/tabpage/tab_a.gif\"></TD>").append("\n");
                sb.append("<TD class=functionTitle vAlign=bottom noWrap background=\"").append(ctx).append(fullImgPath).append("/tabpage/tab_a1.gif\">");
                html1 = sb.toString();
                sb.delete(0, sb.length());
                sb.append("</TD>").append("\n").append("<TD align=left width=4><IMG src=\"").append(ctx).append(fullImgPath).append("/tabpage/tab_a2.gif\" ></TD>").append("\n");
                sb.append("</TR>").append("\n");
                sb.append("</TBODY>").append("\n");
                sb.append("</TABLE>").append("\n");
                sb.append("</TD>").append("\n");
                sb.append("<TD>").append("\n");
                sb.append("<TABLE height=20 cellSpacing=0 cellPadding=0 align=right>").append("\n");
                sb.append("<TBODY>").append("\n");
                sb.append("<TR>").append("\n");
                sb.append("<TD>").append("\n");
                html2 = sb.toString();
                
                sb.delete(0, sb.length());

                sb.append("</TD>").append("\n");
                sb.append("</TR>").append("\n");
                sb.append("</TBODY>").append("\n");
                sb.append("</TABLE>").append("\n");
                sb.append("</TD>").append("\n");
                sb.append("</TR>").append("\n");
                sb.append("</TBODY>").append("\n");
                sb.append("</TABLE>").append("\n");
                html3 = sb.toString();
                initFlag = true;
            }
        }

        try {
            pageContext.getOut().println(html1);
            if(title == null || "".equals(title)){
            	String message = TagUtils.getInstance().message(pageContext, this.bundle, this.localeKey, titleKey, null);
            	pageContext.getOut().println(message);
            }else{
            	pageContext.getOut().println(title);
            }
            pageContext.getOut().println(html2);
        } catch(Exception e) {
        }

        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        StringBuffer sb = new StringBuffer();
        if(buttonList!=null&&buttonList.size()!=0) {
            for(int i = 0; i<buttonList.size(); i++) {
                AFHeadButton button = (AFHeadButton)buttonList.get(i);
                sb.append("<input type=button class=tb_Button style=\"CURSOR: hand\"");
                sb.append(" value=\"");
                sb.append(button.getName());
                if(button.getId() != null) {
	                sb.append("\" id=\"");
	                sb.append(button.getId());
                }                
                sb.append("\" accesskey=\"");
                sb.append(button.getAccesskey());
                sb.append("\" onClick=\"");
                sb.append(button.getOnClick()).append("\">\n");
            }
            buttonList.clear();
        }

        try {
            pageContext.getOut().println(sb.toString());
            pageContext.getOut().println(html3);
        } catch(Exception e) {
        }
        return EVAL_PAGE;
    }

    public void addButton(AFHeadButton button) {
        this.buttonList.add(button);
    }

    public void release() {
        super.release();
        buttonList.clear();
        titleKey = null;
    }
    public String getTitleKey() {
        return titleKey;
    }

    public String getBundle() {
        return bundle;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

class AFHeadButton {

	private String id = null;
    private String name = "";
    private String accesskey = "";
    private String onClick = "";

    AFHeadButton(String id, String name, String accesskey, String onClick) {
    	this.id = id;
        this.name = name;
        this.accesskey = accesskey;
        this.onClick = onClick;
    }
    String getId() {
        return id;
    }
    void setId(String id) {
        this.id = id;
    }
    String getName() {
        if(!"".equals(accesskey))
            return name + "(" + accesskey + ")";
        else
            return name;
    }
    
    
    void setName(String name) {
        this.name = name;
    }
    String getAccesskey() {
        return accesskey;
    }
    void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }
    String getOnClick() {
        return onClick;
    }
    void setOnClick(String onClick) {
        this.onClick = onClick;
    }

}