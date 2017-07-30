<%@ page pageEncoding="GBK" import="com.handao.platform.framework.web.jsp.AFField,
                 com.handao.platform.framework.web.jsp.AFSearchUtil"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%
    AFSearchUtil searchUtil = new AFSearchUtil(pageContext);
    int r=0;
%>
<div style="text-align:center;width:100%">

<DIV align="center" id ="winbody" name ="winbody"
			style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 98%;">

<TABLE class=listTable id=maintbl
style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1
width="100%" align=center border=0 name="maintbl">

    <tr class="listTableTitle1" align="center">
        <logic:iterate id="fieldBean" name="fieldList" type="com.handao.platform.framework.web.jsp.AFField" indexId="idx">
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_LABEL)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">
                  <bean:message key="<%=fieldBean.getKey()%>"/>
               </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_HREF)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">
                  <bean:message key="<%=fieldBean.getKey()%>"/>
              </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_CHECKBOX)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">
                  <input type="checkbox" name="chkAll" value="checkbox" class="check" onclick="selectAll('chk');">
              </td>
            </logic:equal>
        </logic:iterate>
    </tr>

    <logic:iterate id="bean" name="searchResultPage" property="list" type="com.handao.platform.framework.vo.AFValueObject" indexId="idx">
    <%
        //add by liuxiaoyan 设置奇偶行的颜色
        String trClass="listTableOdd";
        if(r%2==0)
           trClass="listTableOdd";
        else
           trClass="listTableEven";
    %>
    <tr id="AF_TD_<%=idx%>" index="<%=idx%>" class="<%=trClass%>" onmouseout="this.style.backgroundColor='';"onmouseover="this.style.backgroundColor='#F1F1F1';">
        <logic:iterate id="fieldBean" name="fieldList" type="com.handao.platform.framework.web.jsp.AFField" indexId="i">
            <%String val = searchUtil.getValueFromBean(bean,fieldBean.getName(),fieldBean.getProcessClass());%>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_LABEL)%>">
                <td align="<bean:write name="fieldBean" property="align" />"  class="ellipsisNowrapText" title="<%=val%>"><div id="AF_EDITTABLE_<%=idx%>_<%=i%>" rowIndex="<%=idx%>" colIndex="<%=i%>" style="width:100%;height:100%" value="<%=val%>" ondblclick="doOndbclick(this)"><%=val%></div></td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_CHECKBOX)%>">
                <td align="<bean:write name="fieldBean" property="align"/>">
                    <input type="checkbox" name="chk" value="<%=val%>" class="check" >
                </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_HIDDENINPUT)%>">
                <input type="hidden" name=<%=fieldBean.getName()%> value="<%=val%>">
            </logic:equal>

        </logic:iterate>
    </tr>
    <%
        r++;
    %>
    </logic:iterate>


</table>


</div>

</div>
<script>
function afterOnclick(obj) {
    var allTR = obj.parentElement.children;
    for(var i=0; i<allTR.length; i++) {
		allTR[i].style.backgroundColor = "";
    }
    obj.style.backgroundColor = "#F1F1F1";

}
function doOnblur(divObj) {
	//divObj.innerText = ;
	divObj.innerHTML = divObj.value;
}
function doOndbclick(divObj) {
    //alert(divObj.rowIndex + "," + divObj.colIndex)
    //divObj.innerText = "";
    divObj.innerHTML = "";
    var editObj=document.createElement("input");
    editObj.type = "text";
    editObj.className = "editTextLine";
    editObj.style.width = "100%";
    editObj.style.height = "100%";
    editObj.value = divObj.value;
    divObj.appendChild(editObj);
    editObj.focus();
}
</script>
