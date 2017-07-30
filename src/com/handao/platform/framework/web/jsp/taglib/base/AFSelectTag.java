package com.handao.platform.framework.web.jsp.taglib.base;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import com.handao.platform.framework.util.AFCodeListCache;
import com.handao.platform.framework.vo.AFSelectListVO;
import com.handao.platform.framework.web.jsp.taglib.AFTagUtils;

public class AFSelectTag extends com.handao.platform.framework.web.jsp.taglib.base.AFBaseHandlerTag {
	private static final long serialVersionUID = 1L;

	protected String property = null;
	protected String initValue = null;
	protected String value = null;
	protected String displayName = "";
	protected String firstValue = null;
	protected String name = "org.apache.struts.taglib.html.BEAN";

	protected String lovCode;//lov表对应的code
	protected String sqlId; //ibatis配置的SQL Statement
	protected String sql; //SQL语句

	private List objSelectList = null;
	protected String size = null;

	public String getSize() {
		return (this.size);
	}

	public void setSize(String size) {
		this.size = size;
	}

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

	public AFSelectTag() {
	}

	public int doStartTag() throws JspException {
		if (lovCode != null && !"".equals(lovCode))
			objSelectList = AFCodeListCache.getSelectListByListCode(lovCode);
		else if (sql != null && !"".equals(sql))
			objSelectList = AFCodeListCache.getSelectListBySql(sql);
		else if (sqlId != null && !"".equals(sqlId))
			objSelectList = AFCodeListCache.getSelectListBySqlId(sqlId);
		else {
			throw new RuntimeException("下拉列表标签框配置错误!");
		}
		AFTagUtils.getInstance().write(this.pageContext,this.renderSelectStartElement());
		return EVAL_BODY_BUFFERED;
	}

	protected String renderSelectStartElement() throws JspException {

		prepareValue();

		StringBuffer results = new StringBuffer("<select");
		if (true == this.getReadonly()) {
			prepareAttribute(results, "name", this.prepareSelName());
			this.setDisabled(true);
		} else {
			prepareAttribute(results, "name", prepareName());
		}
		prepareAttribute(results, "accesskey", getAccesskey());
		prepareAttribute(results, "tabindex", getTabindex());
		prepareAttribute(results, "size", getSize());
		results.append(prepareEventHandlers());
		results.append(prepareStyles());
		prepareOtherAttributes(results);
		if (true == this.getReadonly()) {
			results.append(" onpropertychange=selectToInput(this) ");
		}
		results.append(">");

		Iterator iter = objSelectList.iterator();
		AFSelectListVO selectVO = new AFSelectListVO();
		selectVO.setCode("");
		if (null != this.getFirstValue()) {
			selectVO.setName(this.getFirstValue());
		} else {
			selectVO.setName("--请选择--");
		}
		renderOptionElement(results, selectVO, this.value);
		while (iter.hasNext()) {
			selectVO = (AFSelectListVO) iter.next();
			renderOptionElement(results, selectVO, this.value);
		}
		results.append("</select>");

		if (true == this.getReadonly()) {
			results
					.append("<input type=hidden onpropertychange=codeInputToSelect(this) ");
			prepareAttribute(results, "name", prepareName());
			results.append(" value=" + this.value + ">");
			results.append("<input type=hidden");
			prepareAttribute(results, "name", prepareDisName());
			results.append(" value=" + this.displayName + ">");

		}

		return results.toString();
	}

	protected void renderOptionElement(StringBuffer handlers,
			AFSelectListVO selectVO, String value) throws JspException {
		handlers.append("<option value=\"");
		handlers.append(selectVO.getCode());
		handlers.append("\"");
		if (value.trim().equalsIgnoreCase(selectVO.getCode().trim())) {
			this.displayName = selectVO.getName().trim();
			handlers.append(" selected=\"selected\"");
		}
		handlers.append(">");
		handlers.append(selectVO.getName());
		handlers.append("</option>");

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

	protected String prepareSelName() throws JspException {
		if (property == null) {
			return null;
		}
		if (indexed) {
			StringBuffer results = new StringBuffer();
			prepareIndex(results, name);
			results.append("sel_" + property);
			return results.toString();
		}
		return "sel_" + property;

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

	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
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