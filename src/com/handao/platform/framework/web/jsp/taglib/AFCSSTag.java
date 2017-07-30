package com.handao.platform.framework.web.jsp.taglib;

import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.handao.platform.framework.util.config.AFConfigManager;
import com.handao.platform.framework.util.config.AFStyleConfig;

public class AFCSSTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String type = null;
    private String scope = "all";

    private static HashMap map = new HashMap();

    private static boolean initFlag = false;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }

    public int doStartTag() throws JspException {
        if(!initFlag) {
            synchronized(map) {
                String ctx = ((HttpServletRequest)pageContext.getRequest()).getContextPath();
                AFStyleConfig styleConfig = AFConfigManager.getInstance().getStyleConfig();
                Iterator allScope = styleConfig.getAllScope();
                for(; allScope.hasNext(); ) {
                    StringBuffer sb = new StringBuffer();
                    String scope = (String)allScope.next();
                    String[] filePathList = styleConfig.getCSSFilePathList(scope);
                    if(filePathList != null && filePathList.length != 0) {
                        for(int i = 0; i < filePathList.length; i++) {
                            sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"").append(ctx).append(filePathList[i]).append("\" />").append("\n");
                        }
                    }
                    map.put(scope, sb.toString());
                }
                initFlag = true;
            }
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().println((String)map.get(this.scope.toUpperCase()));
        } catch(Exception e) {
        }
        return EVAL_PAGE;
    }


    public void release() {
        super.release();
        type = null;
        scope = "all";
    }
}