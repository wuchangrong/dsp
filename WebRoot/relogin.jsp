<%@page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>

<handao:iniCtx id="ctx"/>
<script language="javascript">
//����ע��
var msg="THE-NODE-OF-SESSION-TIMEOUT";
function logout()
{
    alert("�Ự�Ѿ����ڣ������µ�¼��");
    var url = "logoutHandle.jsp";
    try
    {
        parent.parent.location.href = "<%=ctx%>/" + url;
    }
    catch(e)
    {
        parent.location.href = "<%=ctx%>/" + url;
    }
}
logout();
</script>

