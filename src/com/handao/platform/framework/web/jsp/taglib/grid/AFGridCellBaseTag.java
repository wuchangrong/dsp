package com.handao.platform.framework.web.jsp.taglib.grid;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

public abstract class AFGridCellBaseTag extends TagSupport {



    protected abstract AFGridCellBase getCell();

    public int doStartTag() throws JspException {
        return TagSupport.SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        Tag tag = this.getParent();
        if(tag instanceof AFGridBaseTag)
            ((AFGridBaseTag)tag).addCell(this.getCell());
        return EVAL_PAGE;
    }
}
abstract class AFGridCellBase {

}