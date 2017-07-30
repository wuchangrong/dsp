package com.handao.platform.framework.web.jsp.taglib.base;

import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.ResponseUtils;

public class AFDoubleTag extends org.apache.struts.taglib.html.TextTag {

	private static final long serialVersionUID = 1L;

	protected String validate = "false";

    protected String min = null;

    protected String minexp = ">";

    protected String max = null;

    protected String maxexp = "<";

    protected String precision = null;

    protected String colSize = "";

    protected String colPrecision = "";

    protected String onkeypressextend = "";

    protected String onblurextend = "";

    protected String styleextend = "";

    public String getMax() {
        return max;
    }

    public String getMaxexp() {
        return maxexp;
    }

    public String getValidate() {
        return validate;
    }

    public String getMin() {
        return min;
    }

    public void setMinexp(String minexp) {
        this.minexp = minexp;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public void setMaxexp(String maxexp) {
        this.maxexp = maxexp;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
        int i = precision.indexOf(",");
        this.colSize = precision.substring(1, i);
        this.colPrecision = precision.substring(i + 1, precision.length() - 1);
    }

    public void setOnkeypressextend(String onkeypressextend) {
        this.onkeypressextend = onkeypressextend;
    }

    public void setStyleextend(String styleextend) {
        this.styleextend = styleextend;
    }

    public void setOnblurextend(String onblurextend) {
        this.onblurextend = onblurextend;
    }

    public String getMinexp() {
        return minexp;
    }

    public String getPrecision() {
        return precision;
    }

    public String getOnkeypressextend() {
        return onkeypressextend;
    }

    public String getStyleextend() {
        return styleextend;
    }

    public String getOnblurextend() {
        return onblurextend;
    }

    public AFDoubleTag() {

    }

    public int doStartTag() throws JspException {
    	
        StringBuffer objStringBuffer = new StringBuffer();
        if(null == this.validate || "false".equalsIgnoreCase(this.validate)) {
            if(!this.getOnkeypressextend().equalsIgnoreCase("")) {
                this.setOnkeypress("onlyDouble(this);" + this.getOnkeypressextend());
            } else {
                this.setOnkeypress("onlyDouble(this)");
            }

        }
        //进行精度校验
        if(null != this.getPrecision() && !"".equalsIgnoreCase(this.getPrecision())) {
            objStringBuffer.append("validNumber(this,'" + this.colSize + "','" +
                                   this.colPrecision + "');");
        }
        //进行区间校验,最大最小值校验
        if("true".equalsIgnoreCase(this.validate)) {
            if(this.getOnkeypressextend().equalsIgnoreCase("")) {
                this.setOnkeypress("onlyDouble(this);" + this.getOnkeypressextend());
            } else {
                this.setOnkeypress("onlyDouble(this)");
            }

            if(null != this.getMax() && null != this.getMin()) {
                objStringBuffer.append("validNumber2(this,'" + this.getMin() + "','" +
                                       this.getMinexp() + "','" + this.getMax() + "','" +
                                       this.getMaxexp() + "','true')");
            } else if(null == this.getMax() && null == this.getMin()) {
            } else if(null != this.getMax()) {
                objStringBuffer.append("validNumber2(this,'" + "NiN" + "','" +
                                       this.getMinexp() + "','" + this.getMax() + "','" +
                                       this.getMaxexp() + "','true')");
            } else if(null != this.getMin()) {
                objStringBuffer.append("validNumber2(this,'" + this.getMin() + "','" +
                                       this.getMinexp() + "','" + "NaN" + "','" +
                                       this.getMaxexp() + "','true')");
            }
            if(!this.getOnblurextend().equalsIgnoreCase("")) {
                this.setOnblur(objStringBuffer.toString() + ";" + this.getOnblurextend());
            } else {
                this.setOnblur(objStringBuffer.toString());
            }
        }
        if(!this.getStyleextend().equalsIgnoreCase("")) {
            this.setStyle("IME-MODE: disabled" + ";" + this.getStyleextend());
        } else {
            this.setStyle("IME-MODE: disabled;");
        }

        if(this.getStyleClass()==null || "".equals(this.getStyleClass()))
            this.setStyleClass("editTextLine");

        this.doSuperStartTag();

        return(EVAL_BODY_BUFFERED);

    }
    
    
    public int doSuperStartTag() throws JspException {

        // Create an appropriate "input" element based on our parameters
        StringBuffer results = new StringBuffer("<input type=\"");
        results.append(type);
        results.append("\" name=\"");
        // * @since Struts 1.1
        if (indexed)
            prepareIndex(results, name);
        results.append(property);
        results.append("\"");
        if (accesskey != null) {
            results.append(" accesskey=\"");
            results.append(accesskey);
            results.append("\"");
        }
        if (accept != null) {
            results.append(" accept=\"");
            results.append(accept);
            results.append("\"");
        }
        if (maxlength != null) {
            results.append(" maxlength=\"");
            results.append(maxlength);
            results.append("\"");
        }
        if (cols != null) {
            results.append(" size=\"");
            results.append(cols);
            results.append("\"");
        }
        if (tabindex != null) {
            results.append(" tabindex=\"");
            results.append(tabindex);
            results.append("\"");
        }
        results.append(" value=\"");
        
        DecimalFormat df = new DecimalFormat("#####################.###############");
        
        if (value != null) {
        //	value = df.format(Double.parseDouble(value.toString()));
            results.append(ResponseUtils.filter(value));
        } else if (redisplay || !"password".equals(type)) {
            Object value = TagUtils.getInstance().lookup(pageContext, name, property, null);
           
            if (value == null)
                value = "";
            
            int index = -1;
            if(!"".equalsIgnoreCase(value.toString())) {
            	 index = value.toString().indexOf("E");
            }
            if( index > 0) {
    			value = df.format(Double.parseDouble(value.toString()));
    		}
            
        	
            results.append(ResponseUtils.filter(value.toString()));
        }
        results.append("\"");
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        results.append(getElementClose());

        TagUtils.getInstance().write(pageContext, results.toString());
        return (EVAL_BODY_BUFFERED);
    }

}