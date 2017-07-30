<%@ page pageEncoding="GBK" import="com.handao.platform.framework.envelope.AFPage,
                 java.util.ArrayList,
                 com.handao.platform.framework.web.jsp.AFField,
                 com.handao.platform.framework.vo.AFValueObject,
                 com.handao.platform.framework.web.jsp.AFSearchUtil,
                 com.handao.platform.framework.util.AFAdvancedString,
                 com.handao.platform.framework.util.AFStringUtil"%>

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
                  <bean:message key="<%=fieldBean.getKey()%>" bundle="<%=bundleKey%>"/>
               </td>
            </logic:equal>
			<logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_SEPDOUBLE)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">
                  <bean:message key="<%=fieldBean.getKey()%>" bundle="<%=bundleKey%>"/>
               </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_HREF)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">
                  <bean:message key="<%=fieldBean.getKey()%>" bundle="<%=bundleKey%>"/>
              </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_CHECKBOX)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">
                  <input type="checkbox" name="chkAll" value="checkbox" class="check" onclick="selectAll('chk');">
              </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_OPRATION)%>">
               <td class=tableTitleTD width="<bean:write name="fieldBean" property="width"/>">        </td>
            </logic:equal>            
            
        </logic:iterate>
    </tr>

    <logic:iterate id="bean" name="searchResultPage" property="list" type="com.handao.platform.framework.vo.AFValueObject" indexId="idx">
    <%
        String trClass="listTableOdd";
        if(r%2==0)
           trClass="listTableOdd";
        else
           trClass="listTableEven";
    %>
    <tr class="<%=trClass%>" onmouseout="this.style.backgroundColor='';"onmouseover="this.style.backgroundColor='#F1F1F1';">
    <% String val0=""; int c=0; %>
        <logic:iterate id="fieldBean" name="fieldList" type="com.handao.platform.framework.web.jsp.AFField" indexId="i">
            <%String val = searchUtil.getValueFromBean(bean,fieldBean.getName(),fieldBean.getValueProcess()); if (c==0) val0 = val; c++;%>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_LABEL)%>">                
                <td align="<bean:write name="fieldBean" property="align" />"  class="ellipsisNowrapText" title="<%=val%>"><%=val%></td>
            </logic:equal>            
             <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_SEPDOUBLE)%>">
                <%val = AFStringUtil.formatSepDouble(val);%>
                <td align="<bean:write name="fieldBean" property="align" />"  class="ellipsisNowrapText" title="<%=val%>"><%=val%></td>
            </logic:equal>       
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_HREF)%>">
                <td align="<bean:write name="fieldBean" property="align"/>"> <p style="cursor:hand;" onClick="<%= fieldBean.getFunctionName()%>(this,'<%=val0%>')"><font color="#0000A0"><%=val%></font> </p></td>
            </logic:equal>                                 
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_CHECKBOX)%>">
                <td align="<bean:write name="fieldBean" property="align"/>">
                    <input type="checkbox" name="chk" value="<%=val%>" class="check" >
                </td>
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_HIDDENINPUT)%>">
                <input type="hidden" name=<%=fieldBean.getName()%> value="<%=val%>">
            </logic:equal>
            <logic:equal name="fieldBean" property="showType" value="<%=String.valueOf(AFField.SHOW_TYPE_OPRATION)%>">
              <td align="<bean:write name="fieldBean" property="align"/>">
                  <%String[] oprationBtns = fieldBean.getOprationBtn().split(",");
                    for (int k=0; k<oprationBtns.length;k++) {
                	String oprationBtn = oprationBtns[k];
                  %>
                   &nbsp;<img id="<%=oprationBtn%>Btn" value="" src="<%=ctx%>/images/button/b_<%=oprationBtn%>.gif"   width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt="<%=oprationBtn%>" onclick="<%=oprationBtn%>ById(<%=val%>)" > 
                    <% }%>
                    </td>
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
