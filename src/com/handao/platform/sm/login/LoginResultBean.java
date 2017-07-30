package com.handao.platform.sm.login;

public class LoginResultBean
{
    private String resultCode;                           //登陆结果代码
    private String resultDescribe;                       //登陆结果信息

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescribe() {
        return resultDescribe;
    }

    public void setResultDescribe(String resultDescribe) {
        this.resultDescribe = resultDescribe;
    }
}