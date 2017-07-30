package com.handao.platform.framework.web.jsp.taglib.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.util.AFCodeListCache;
import com.handao.platform.framework.vo.AFSelectListVO;
import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFCheckBoxGroupTag extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {

	private static final long serialVersionUID = 1L;

	protected String property = null;
	protected String initValue = null;
	protected String value = null;
	protected String displayName = "";
	protected String name = "org.apache.struts.taglib.html.BEAN";

	protected String lovCode;//lov表对应的code
	protected String sqlId; //ibatis配置的SQL Statement
	protected String sql; //SQL语句

	private List objSelectList = new ArrayList();

	public String getInitValue() {
		return initValue;
	}

	public String getName() {
		return name;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public AFCheckBoxGroupTag() {
	}

	public int doStartTag() throws JspException {
		if (lovCode != null && !"".equals(lovCode))
			objSelectList = AFCodeListCache.getSelectListByListCode(lovCode);
		else if (sql != null && !"".equals(sql))
			objSelectList = AFCodeListCache.getSelectListBySql(sql);
		else if (sqlId != null && !"".equals(sqlId))
			objSelectList = AFCodeListCache.getSelectListBySqlId(sqlId);
		else {
			throw new RuntimeException("单选按钮组标签框配置错误!");
		}
		AFTagUtils.getInstance().write(this.pageContext,this.renderRadioGroupStartElement());
		return (EVAL_BODY_BUFFERED);
	}

	protected String renderRadioGroupStartElement() throws JspException {
		prepareValue();
		StringBuffer results = new StringBuffer("");

		this.setOnclick("checkboxTocheckboxInput(this)");
		Iterator iter = objSelectList.iterator();
		AFSelectListVO selectVO = null;

		String[] strValues = this.value.split(",");
		while (iter.hasNext()) {
			selectVO = (AFSelectListVO) iter.next();
			renderOptionElement(results, selectVO, strValues);
		}
		results.append("<INPUT type=hidden onpropertychange=checkboxInputTocheckbox(this) ");
		prepareAttribute(results, "value", this.value);
		prepareAttribute(results, "name", prepareName());
		results.append(">");
		if (this.displayName.equalsIgnoreCase("")) {
		} else {
			this.displayName = this.displayName.substring(1);
		}

		results.append("<INPUT type=hidden");
		prepareAttribute(results, "value", this.displayName);
		prepareAttribute(results, "name", prepareDisName());
		results.append(">");

		return results.toString();
	}

	protected void renderOptionElement(StringBuffer handlers,
			AFSelectListVO selectVO, String[] strValues) throws JspException {
		handlers.append("<input type=checkbox value=\"");
		handlers.append(selectVO.getCode());
		handlers.append("\" ");
		prepareAttribute(handlers, "name", prepareRadioName());
		prepareAttribute(handlers, "accesskey", getAccesskey());
		prepareAttribute(handlers, "tabindex", getTabindex());
		for (int i = 0; i < strValues.length; i++) {
			if (strValues[i].trim().equalsIgnoreCase(selectVO.getCode().trim())) {
				this.displayName = this.displayName + ","
						+ selectVO.getName().trim();
				handlers.append(" checked=\"checked\" ");
			}
		}
		handlers.append(prepareEventHandlers());
		handlers.append(prepareStyles());
		prepareOtherAttributes(handlers);
		handlers.append(">");

		handlers.append("<span ");
		prepareAttribute(handlers, "id", prepareSpanName());
		handlers.append(">");
		handlers.append(selectVO.getName());
		handlers.append("</span>");

	}

	protected String prepareName() throws JspException {
		if (property == null) {
			return null;
		}
		if (indexed) {
			StringBuffer results = new StringBuffer();
			prepareIndex(results, name);
			results.append(property);
			return results.toString();
		}
		return property;

	}

	protected String prepareRadioName() throws JspException {
		if (property == null) {
			return null;
		}
		if (indexed) {
			StringBuffer results = new StringBuffer();
			prepareIndex(results, name);
			results.append("checkbox_" + property);
			return results.toString();
		}
		return "checkbox_" + property;

	}

	protected String prepareDisName() throws JspException {
		if (property == null) {
			return null;
		}
		if (indexed) {
			StringBuffer results = new StringBuffer();
			prepareIndex(results, name);
			results.append("dis_" + property);
			return results.toString();
		}
		return "dis_" + property;

	}

	protected String prepareSpanName() throws JspException {
		if (property == null) {
			return null;
		}
		if (indexed) {
			StringBuffer results = new StringBuffer();
			prepareIndex(results, name);
			results.append("span_checkbox_" + property);
			return results.toString();
		}
		return "span_checkbox_" + property;

	}

	protected void prepareValue() throws JspException {

		if (this.getInitValue() != null) {
			this.value = this.getInitValue();
			return;
		} else {
			Object value1 = AFTagUtils.getInstance().lookup(pageContext, name,
					property, null);
			if (null == value1) {
				value1 = "";
			}
			this.value = value1.toString();
			return;
		}
	}

	public String getLovCode() {
		return lovCode;
	}

	public void setLovCode(String lovCode) {
		this.lovCode = lovCode;
	}

	public String getSqlId() {
		return sqlId;
	}

	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}