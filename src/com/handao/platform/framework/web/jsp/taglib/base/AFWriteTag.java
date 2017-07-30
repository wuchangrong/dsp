package com.handao.platform.framework.web.jsp.taglib.base;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.bean.WriteTag;

import com.handao.platform.framework.web.jsp.AFValueProcess;
import com.handao.platform.framework.web.jsp.AFValueProcessImpl;

public class AFWriteTag extends WriteTag{

	private static final long serialVersionUID = 1L;
	
	private String listCode;
	private String sqlId;
	private String sql;
	
	private AFValueProcess valueProcess;
	
	public String getListCode() {
		return listCode;
	}
	public void setListCode(String listCode) {
		this.listCode = listCode;
		//
		if(listCode != null && !"".equals(listCode)){
			this.valueProcess = AFValueProcessImpl.createByListCode(listCode);
		}
	}
	public String getSqlId() {
		return sqlId;
	}
	
	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
		//
		if(sqlId != null && !"".equals(sqlId)){
			this.valueProcess = AFValueProcessImpl.createBySqlId(sqlId);
		}		
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
		//
		if(sql != null && !"".equals(sql)){
			this.valueProcess = AFValueProcessImpl.createBySql(sql);
		}		
	}
	
    protected String formatValue(Object valueToFormat) throws JspException{
    	if(this.valueProcess != null && valueToFormat != null)
    		return valueProcess.process(valueToFormat.toString());
    	return super.formatValue(valueToFormat);
    }
}