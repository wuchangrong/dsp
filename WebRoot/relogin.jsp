<%@page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>

<handao:iniCtx id="ctx"/>
<script language="javascript">
//单击注销
var msg="THE-NODE-OF-SESSION-TIMEOUT";
function logout()
{
    alert("会话已经过期，请重新登录！");
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

