package com.handao.platform.framework.web;

import java.util.List;

import org.apache.struts.action.ActionForm;
import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFConstants;

public abstract class AFSearchForm extends ActionForm {

    private String pageSize = String.valueOf(AFConstants.DEFAULT_PAGE_SIZE);
    private String currentPageNo = "1";
    private String totalPageNum;

    private String sortField = "";
    private String sortType = "ASC";

    private List criterionFieldList = null;

    public List getCriterionFieldList() {
        return criterionFieldList;
    }

    public void setCriterionFieldList(List list) {
        this.criterionFieldList = list;
    }

    public void setCriterionField(AFSearchCriterionFieldForm fieldForm) {
        criterionFieldList.add(fieldForm);
    }

    public AFSearchCriterionFieldForm getCriterionField(int i) {
        return(AFSearchCriterionFieldForm)criterionFieldList.get(i);
    }

    public String getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(String currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
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

    public String getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(String totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    protected abstract AFSearchCustomerCondition getCustomCondition();
}