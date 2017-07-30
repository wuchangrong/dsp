package com.handao.platform.framework.web.jsp.taglib.tabpane;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AFTabPaneTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String width = "100%";
    private String height = "450";
    private String bodyTitle = "";
    private String bodyId = "";
    private String bodyOnclick = "";
    private String bodyTitleWidth = "";
    private String selectedId = null;

    private String SPLIT = "$";
    private String SPLIT_PLUS = "[$]";

    public int doStartTag() throws JspException {
        StringBuffer sb = new StringBuffer();
        sb.append("<table align=center border=0 cellspacing=0 cellpadding=0 width=").append(this.width).append(" id=AF_TabPane_").append(this.id).append(">").append("\n");
        sb.append("<tr id=AF_TabTitle_").append(this.id).append(" height=20 align=center> ").append("</tr>").append("</table>").append("\n");
        sb.append("<table align=center border=0 cellspacing=0 cellpadding=0 width=").append(this.width).append(" height=").append(this.height).append(" id=AF_TabBody_").append(this.id).append(" class=tag_tabpane>").append("\n");
        try {
            pageContext.getOut().print(sb.toString());
        } catch(IOException ex) {

        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        StringBuffer sb = new StringBuffer();
        sb.append("</table>").append("\n");
        sb.append("<script>").append("\n");
        sb.append("_tag_AddTabBody('").append(this.id).append("',[");
        String[] idList = bodyId.split(SPLIT_PLUS);
        String[] titleList = bodyTitle.split(SPLIT_PLUS);
        String[] onclickList = bodyOnclick.split(SPLIT_PLUS);
        String[] titleWidthList = bodyTitleWidth.split(SPLIT_PLUS);
        bodyTitle = "";
        bodyId = "";
        bodyOnclick = "";

        for(int i=0; i<idList.length; i++) {
            sb.append("['").append(idList[i]).append("','").append(titleList[i]).append("','").append(titleWidthList[i]).append("','").append(onclickList[i].trim()).append("'],");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("])").append("\n");
        if(selectedId==null||selectedId.length()==0) {
            selectedId = idList[0];
        }
        sb.append("_tag_SetTabBodyVisible('").append(this.id).append("','").append(this.selectedId).append("')").append("\n");
            //_tag_AddTabBody("Test", [a,b,c]);
        sb.append("</script>").append("\n");
        try {
            pageContext.getOut().print(sb.toString());
        } catch(IOException ex) {

        }
        return EVAL_PAGE;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void release() {
        width = "100%";
        height = "450";
        bodyTitle = "";
        bodyId = "";
        bodyOnclick = "";
        selectedId = null;
        super.release();
    }



    void addBodyTitle(String bodyTitle) {
        this.bodyTitle += bodyTitle + SPLIT;
    }

    void addBodyId(String bodyId) {
        this.bodyId += bodyId + SPLIT;
    }

    void addBodyOnclick(String bodyOnclick) {
        this.bodyOnclick += (bodyOnclick==null||bodyOnclick.length()==0?" ":bodyOnclick) + SPLIT;
    }

    void addBodyTitleWidth(String bodyTitleWidth) {
        this.bodyTitleWidth += bodyTitleWidth + SPLIT;
    }

    void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }

}