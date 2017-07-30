package com.handao.platform.framework.web.jsp.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import com.handao.platform.framework.util.config.AFConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import com.handao.platform.framework.util.config.AFScriptConfig;


public class AFScriptTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String type = null;
    private String scope = "all";
    private static String html = null;
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

                StringBuffer sb_html = new StringBuffer();
                sb_html.append("<script>");
                sb_html.append("var _sys_ctx = \"").append(ctx).append("\";");
                sb_html.append("var _sys_imgpath = \"").append(AFConfigManager.getInstance().getStyleConfig().getFullImgPath()).append("\";");
                sb_html.append("var _sys_csspath = \"").append(AFConfigManager.getInstance().getStyleConfig().getFullCSSPath()).append("\";");
                sb_html.append("</script>");

                html = sb_html.toString();

                AFScriptConfig scriptConfig = AFConfigManager.getInstance().getJSConfig();
                Iterator allScope = scriptConfig.getAllScope();
                for(; allScope.hasNext(); ) {
                    StringBuffer sb = new StringBuffer();
                    String scope = (String)allScope.next();
                    String[][] filePathList = scriptConfig.getScriptFilePathList(scope);
                    if(filePathList != null && filePathList.length != 0) {
                        for(int i = 0; i < filePathList.length; i++) {
                            if("js".equalsIgnoreCase(filePathList[i][1]))
                                sb.append("<script language=javascript src=\"").append(ctx).append(filePathList[i][0]).append("\" ></script>").append("\n");
                            else if("vbs".equalsIgnoreCase(filePathList[i][1]))
                                sb.append("<script language=vbscript src=\"").append(ctx).append(filePathList[i][0]).append("\" ></script>").append("\n");
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
            pageContext.getOut().println(html);
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
