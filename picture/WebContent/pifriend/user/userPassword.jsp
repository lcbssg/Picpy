<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>用户密码修改</title>
	<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/globle.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
	function init() {
		var message = "";
		<%if (request.getAttribute("message") != null) {%>
			message = '<s:property value ="#request.message"/>'
		<%}%>
		if (message != "") {
			alert(message);
		}
	}
	function checkInfor(){
		var oPassword = $("#oPassword").val().trim();
		var password = $("#password").val().trim();
		var cPassword = $("#cPassword").val().trim();
		if (cPassword != password) {
			alert("确认密码错误，请重新输入");
			$("#cPassword")[0].select();
			$("#cPassword").focus();
			return false;
		}
		if (!(f_check_length(oPassword,5,10) && f_check_number(oPassword))) {
			alert("旧密码由5-10位数字组成，请重新输入");
			$("#oPassword")[0].select();
			$("#oPassword").focus();
			return false;
		}
		if (!(f_check_length(password,5,10) && f_check_number(password))) {
			alert("新密码由5-10位数字组成，请重新输入");
			$("#password")[0].select();
			$("#password").focus();
			return false;
		}
		if (!(f_check_length(cPassword,5,10) && f_check_number(cPassword))) {
			alert("确认密码由5-10位数字组成，请重新输入");
			$("#cPassword")[0].select();
			$("#cPassword").focus();
			return false;
		}
		return true;
}
</script>
<body onload="init()">
        <s:form namespace="/user" action="userAction" method="post" onsubmit="return checkInfor()">
        		<div class="userCenter">
            <dl>
            	<dt>旧密码：</dt>
                <dd> <s:password name="oldPassword" id="oPassword" class="userCenter_input" showPassword="false"></s:password> </dd>
            </dl>
            <dl>
            	<dt>新密码：</dt>
                <dd><s:password name="sysUser.password" id = "password" class="userCenter_input" showPassword="false"/></dd>
            </dl>
            <dl>
            	<dt>确认新密码：</dt>
                <dd><input id="cPassword" type="password" class="userCenter_input"></dd>
            </dl>
            <dl>
            	<dt></dt>
                <dd><s:submit value="提交" method="updatePassword" cssStyle="height:30px;width:60px"></s:submit> </dd>
            </dl>
        </div>
         </s:form>
</body>
</html>