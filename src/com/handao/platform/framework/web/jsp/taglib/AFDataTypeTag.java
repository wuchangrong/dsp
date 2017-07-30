package com.handao.platform.framework.web.jsp.taglib;

import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.handao.platform.framework.util.AFConstants;

public class AFDataTypeTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String name;
    private String initValue;
    private String firstOption;
    private String otherProperty = "";

    ArrayList collList;

    public void setName(String name) {
        this.name = name;
    }

    public void setInitValue(String initValue) {
        this.initValue = initValue;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public void setOtherProperty(String otherProperty) {
        if(otherProperty!=null) {
            this.otherProperty = otherProperty;
        }
    }

    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out = pageContext.getOut();
            out.println("<select name=\""+name+"\" "+otherProperty+" >");

            if(firstOption!=null&&!firstOption.equals("")) {
                out.println("<option value=\"\">"+firstOption+"</option>");
            }

            for(int i = 0; collList!=null&&i<collList.size(); i++) {
                String type = (String)collList.get(i);

                out.println("<option value=\""+type+"\"");
                if(type.equals(initValue)) {
                    out.println(" selected ");
                }
                out.println(">"+type+"</option>");
            }

            out.println("</select>");

        } catch(Exception e) {
        }

        return EVAL_PAGE;
    }

    public int doStartTag() throws JspException {
        collList = getArrayList();
        return SKIP_BODY;
    }

    protected ArrayList getArrayList() throws JspException {
        try {
            ArrayList list = new ArrayList();
            list.add(AFConstants.DATA_TYPE_BIGINT);
            list.add(AFConstants.DATA_TYPE_BLOB);
            list.add(AFConstants.DATA_TYPE_CHAR);
            list.add(AFConstants.DATA_TYPE_CLOB);
            list.add(AFConstants.DATA_TYPE_DATE);
            list.add(AFConstants.DATA_TYPE_DBCLOB);
            list.add(AFConstants.DATA_TYPE_DECIMAL);
            list.add(AFConstants.DATA_TYPE_DOUBLE);
            list.add(AFConstants.DATA_TYPE_GRAPHIC);
            list.add(AFConstants.DATA_TYPE_INTEGER);
            list.add(AFConstants.DATA_TYPE_REAL);
            list.add(AFConstants.DATA_TYPE_SMALLINT);
            list.add(AFConstants.DATA_TYPE_TIME);
            list.add(AFConstants.DATA_TYPE_TIMESTAMP);
            list.add(AFConstants.DATA_TYPE_VARCHAR);
            list.add(AFConstants.DATA_TYPE_VARGRAPHIC);
            return list;

        } catch(Exception e) {
            return null;
        }
    }

    public void release() {
        super.release();
        collList = null;
    }
}