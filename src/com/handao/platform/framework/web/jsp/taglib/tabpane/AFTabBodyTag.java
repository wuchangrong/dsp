package com.handao.platform.framework.web.jsp.taglib.tabpane;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.handao.platform.framework.util.AFDataFormat;

public class AFTabBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String title = null;
    private String onclick = null;
    private String titleWidth = null;
    private String selected;

    public int doStartTag() throws JspException {
        AFTabPaneTag parent = (AFTabPaneTag)this.getParent();
        parent.addBodyId(this.id);
        parent.addBodyTitle(this.title);
        if(titleWidth==null || titleWidth.length()==0)
            titleWidth = String.valueOf(10 + AFDataFormat.getStringRealLength(title)*7 + 10);
        parent.addBodyTitleWidth(this.titleWidth);
        titleWidth = null;
        parent.addBodyOnclick(this.onclick);

        if("true".equalsIgnoreCase(this.selected))
            parent.setSelectedId(this.id);

        String parentId = parent.getId();

        try {
            pageContext.getOut().println("<tbody id=AF_TabBody_" + parentId + "." + this.id + " style=\"display:none;\"><tr><td align=left vAlign=top>");
        } catch(IOException ex) {

        }
        return EVAL_BODY_INCLUDE;
    }

   public int doEndTag() throws JspException {
       try {
           pageContext.getOut().println("</td></tr></tbody>");
       }
       catch (IOException ex) {

       }
       return EVAL_PAGE;
   }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getOnclick() {
        return onclick;
    }
    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    public String getSelected() {
        return selected;
    }
    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getTitleWidth() {
        return titleWidth;
    }

    public void setTitleWidth(String titleWidth) {
        this.titleWidth = titleWidth;
    }

    public void release() {
        title = null;
        onclick = null;
        titleWidth = null;
        super.release();
    }
}