package com.handao.platform.framework.web;

import org.apache.struts.action.ActionForm;

import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFForm extends ActionForm {

    protected String method = null;

    protected String doWhat = null;

    protected String doWhatPlus = null;

    protected String doFocus = "";

    protected String[] chk = null;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getChk() {
        return chk;
    }

    public void setChk(String[] chk) {
        this.chk = chk;
    }

    public String getDoWhat() {
        return doWhat;
    }

    public void setDoWhat(String doWhat) {
        this.doWhat = doWhat;
    }

    public String getDoFocus() {
        return doFocus;
    }

    public void setDoFocus(String doFocus) {
        this.doFocus = doFocus;
    }

    public String getDoWhatPlus() {
        return doWhatPlus;
    }
    public void setDoWhatPlus(String doWhatPlus) {
        this.doWhatPlus = doWhatPlus;
    }

    public boolean isValidate() {
        return true;
    }

    protected abstract AFValueObject transform();

    protected abstract void transform(AFValueObject vo);

    protected abstract void initialize();

    public abstract String getFormName();
}