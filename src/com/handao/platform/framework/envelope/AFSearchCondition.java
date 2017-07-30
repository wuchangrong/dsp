package com.handao.platform.framework.envelope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AFSearchCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	private List criterionFieldList = null;

    private AFSearchCustomerCondition customerCondition = null;

    public AFSearchCondition() {

    }

    public void initialize() {
        if(criterionFieldList == null) {
            criterionFieldList = new ArrayList();
        } else {
            criterionFieldList.clear();
        }
    }

    public void addCriterionField(AFSearchCriterionField field) {
        criterionFieldList.add(field);
    }

    public AFSearchCriterionField getCriterionField(int i) {
        return(AFSearchCriterionField)criterionFieldList.get(i);
    }

    public AFSearchCustomerCondition getCustomerCondition() {
        return customerCondition;
    }

    public void setCustomerCondition(AFSearchCustomerCondition customerCondition) {
        this.customerCondition = customerCondition;
    }

}