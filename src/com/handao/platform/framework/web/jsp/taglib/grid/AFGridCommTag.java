package com.handao.platform.framework.web.jsp.taglib.grid;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.web.AFWebUtil;

public class AFGridCommTag extends AFGridBaseTag {

	private static final long serialVersionUID = 1L;

	protected void addCell(AFGridCellBase cell) {
        if(cellList == null)
            cellList = new ArrayList();
        cellList.add(cell);
    }

    public int doStartTag() throws JspException {

        return super.doStartTag();
    }

    private StringBuffer getTableHeaderHTML(AFGridCellComm cell) {
        StringBuffer sb = new StringBuffer();
        sb.append("<td class=tableTitleTD width=").append(cell.getWidth());
        sb.append(" onclick=\"");
        if(cell.isTaxisable())
            sb.append("_tag_ListTableOrder(this)");
        sb.append("\"");
        sb.append(" >").append(AFWebUtil.getResource(cell.getTitle())).append("</td>").append("\r\n");
        return sb;
    }

    private List getDataset(String datasetKey, int datasetScope) {
        Object obj = null;
        switch(datasetScope) {
            case AFGridConstants.DATASET_SCOPE_REQUEST:
                obj = pageContext.getRequest().getAttribute(datasetKey);
                break;
            case AFGridConstants.DATASET_SCOPE_SESSION:
                obj = pageContext.getSession().getAttribute(datasetKey);
                break;
            default:
                break;
        }
        if(obj != null) {
            if(obj instanceof AFPage)
                return ((AFPage)obj).getList();
            if(obj instanceof List)
                return (List)obj;
        }
        return new ArrayList();
    }

    private String getValue(Object obj, AFGridCellComm cell, int datasetType) {
        Object data = null;
        switch(datasetType) {
            case AFGridConstants.DATASET_TYPE_BEAN:
                data = getValueFromBean(obj, cell.getProperty());
                break;
            case AFGridConstants.DATASET_TYPE_FORM:
                data = getValueFromBean(obj, cell.getProperty());
                break;
            case AFGridConstants.DATASET_TYPE_MAP:
                data = ((Map)obj).get(cell.getProperty());
                break;
            default:
                break;
        }

        return data==null?"":data.toString();
    }

    private Object getValueFromBean(Object obj, String field) {
        try {
            String first = field.substring(0, 1);
            String methodName = "get" + field.replaceFirst(first, first.toUpperCase());

            Method method = obj.getClass().getMethod(methodName, null);
            return method.invoke(obj, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public int doEndTag() throws JspException {

        StringBuffer sb = new StringBuffer();
        sb.append("<div style=\"text-align:center;width:100%\">").append("\r\n");
        sb.append("<DIV align=center id=winbody name=winbody style=\"height:auto;OVERFLOW:auto;margin:0;auto;width:98%;\">").append("\r\n");
        sb.append("<TABLE class=listTable id=maintbl style=\"TABLE-LAYOUT:fixed;WORD-WRAP:break-word\" cellSpacing=1 cellPadding=1 width=100% align=center border=0 name=maintbl>").append("\r\n");
        sb.append("<tr class=listTableTitle1 align=center>").append("\r\n");
        for(int i=0; i<cellList.size(); i++) {
            sb.append(getTableHeaderHTML((AFGridCellComm)cellList.get(i)));
        }
        sb.append("</tr>").append("\r\n");

        List data = this.getDataset(this.datasetKey, this.datasetScope);
        if(data!=null && data.size()!=0) {
            for(int i=0; i<data.size(); i++) {
                Object obj = data.get(i);
                sb.append("<tr class=").append((i%2==0?"listTableOdd":"listTableEven")).append(" onmouseout=\"this.style.backgroundColor='';\" onmouseover=\"this.style.backgroundColor='#F1F1F1';\">").append("\r\n");
                for(int j=0; j<cellList.size(); j++) {
                    AFGridCellComm cell = (AFGridCellComm)cellList.get(j);
                    String value = this.getValue(obj, cell, this.datasetType);
                    sb.append("<td align=").append(cell.getAlign()).append(" class=ellipsisNowrapText>").append(value).append("</td>").append("\r\n");
                }
                sb.append("</tr>").append("\r\n");
            }
        }

        sb.append("</table></div></div>").append("\r\n");
        try {
            pageContext.getOut().println(sb.toString());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return super.doEndTag();
    }
}