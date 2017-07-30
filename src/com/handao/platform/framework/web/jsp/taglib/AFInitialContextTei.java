package com.handao.platform.framework.web.jsp.taglib;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class AFInitialContextTei extends TagExtraInfo {

    public VariableInfo[] getVariableInfo(TagData data) {
        String type = "java.lang.String";
        VariableInfo typeInfo = new VariableInfo(data.getAttributeString("id"), type, true, VariableInfo.AT_BEGIN);
        VariableInfo typeInfo1 = new VariableInfo("_sys_imgpath", type, true, VariableInfo.AT_BEGIN);
        return new VariableInfo[] {typeInfo, typeInfo1};

    }

}