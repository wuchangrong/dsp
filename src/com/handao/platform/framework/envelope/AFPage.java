package com.handao.platform.framework.envelope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AFPage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List list = null;
    private int pageSize;
    private int currentPageNo = 1;
    private int totalRecordNum;

    private String sortField = "";
    private String sortType = "";

    public AFPage() {
        list = new ArrayList();
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getTotalRecordNum() {
        return totalRecordNum;
    }

    public void setTotalRecordNum(int totalRecordNum) {
        this.totalRecordNum = totalRecordNum;
    }

    public int getTotalPageNum() {
        if(totalRecordNum==0) {
            return 0;
        }
        if(pageSize<=0) {
            return 1;
        }
        int pageNo = totalRecordNum/pageSize;
        float fTmp = (float)totalRecordNum/(float)pageSize;

        if(pageNo!=fTmp) {
            pageNo++;
        }

        return pageNo;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getConditionSQL() {
    	return "";
    }
}