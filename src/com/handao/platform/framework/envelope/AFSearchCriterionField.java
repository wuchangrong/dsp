package com.handao.platform.framework.envelope;

import java.io.Serializable;

public class AFSearchCriterionField implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
    private String value;
    private String logic;
    private String type;
    private String relation;
    public AFSearchCriterionField() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}