package com.handao.platform.framework.web.jsp.taglib.grid;

import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public abstract class AFGridBaseTag extends TagSupport {

    protected String datasetKey;
    protected String title;
    protected int datasetScope = AFGridConstants.DATASET_SCOPE_REQUEST;
    protected int datasetType = AFGridConstants.DATASET_TYPE_BEAN;

    protected ArrayList cellList = null;

    public void setDatasetKey(String datasetKey) {
        this.datasetKey = datasetKey;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = Integer.parseInt(datasetType);
    }


    protected abstract void addCell(AFGridCellBase cell);

    public int doStartTag() throws JspException {
        return TagSupport.EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        if(cellList != null)
            cellList.clear();
        return EVAL_PAGE;
    }

    public void release() {
        datasetKey = null;
        title = null;
        datasetScope = AFGridConstants.DATASET_SCOPE_REQUEST;
        datasetType = AFGridConstants.DATASET_TYPE_BEAN;
        if(cellList != null)
            cellList.clear();

        super.release();
    }

}