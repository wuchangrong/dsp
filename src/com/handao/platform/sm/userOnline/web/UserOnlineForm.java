package com.handao.platform.sm.userOnline.web;

import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;

public class UserOnlineForm extends AFForm{
	private static final long serialVersionUID = 1L;

	protected AFValueObject transform(){
    	return null;
    }

    protected void transform(AFValueObject vo){
    }

    protected void initialize(){
    }

    public String getFormName(){
    	return "COMMON_SM_USERONLINE_FORM";
    }
}