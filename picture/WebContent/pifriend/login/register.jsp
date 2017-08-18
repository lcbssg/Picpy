<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>注册页</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
<script type="text/javascript">
function init() {
	var message="";
	<%
		if (request.getAttribute("message") != null) {
			%>
			message = '<s:property value ="#request.message"/>'
			<%
		}
	%>
	if (message !="") {
		alert(message);
	}
}
function checkInfor() {
	var loginName = $("#loginName").val().trim();
	var password = $("#password").val().trim();
	//验证码可以在前台验证，但是验证码的目的是防止恶意破解密码，因此要放在服务器端验证
	var email = $("#email").val().trim();
	if (!(f_check_length(loginName,5,10) && f_check_NumLett(loginName))) {
		alert("用户名由5-10位数字和字母组成，并由字母开头，请重新输入");
		$("#loginName")[0].select();
		$("#loginName").focus();
		return false;
	}
	if (!(f_check_length(password,5,10) && f_check_number(password))) {
		alert("密码由5-10位数字，请重新输入");
		$("#password")[0].select();
		$("#password").focus();
		return false;
	}
	if ( !f_check_email(email)) {
		alert("请输入正确的邮箱");
		$("#email")[0].select();
		$("#email").focus();
		return false;
	}
	return true;
}
</script>
</head>
<body onload="init()">
	<div class="doc1180">
		<div class="header">
			<div class="logo">
				<a href="<%=basePath %>main/mainAction!toMain.action"><img src="<%=basePath%>common/image/logo.png"></a>
			</div>
		</div>
	</div>
	<div class="doc1180">
		<div class="login">
			<div class="login_left">
				<h3 class="login_h3">新用户注册</h3>
				<s:form target="_parent" namespace="/user" action="userAction"
					onsubmit="return checkInfor()">
					<div class="login_sr">
						账号：
						<s:textfield cssClass="login_inputYhm" name="sysUser.loginName"
							id="loginName" />
					</div>
					<div class="login_sr">
						密码：
						<s:password showPassword="true" cssClass="login_inputMm"
							name="sysUser.password" id="password" />
					</div>
					<div class="login_sr">
						邮箱：
						<s:textfield cssClass="login_inputEmail" name="sysUser.email"
							id="email" />
					</div>
					<div>
						<s:submit type="button" cssStyle="height:30px;width:50px"
							method="register" value="注册" />
					</div>

				</s:form>
			</div>
			<div class="login_right">
				<div class="login_rightH3">已经有账号了？</div>
				<div class="login_sanfang">
					<a target="_blank" href="<%=basePath %>pifriend/login/login.jsp">点击登陆</a>
				</div>
			</div>
		</div>
	</div>
	<div class="flink">
		<div class="flinkTop"></div>
		<div class="flinkBody">
			<h3>友情链接</h3>
			<ul>
				<li><a href="https://www.pixiv.net/">pixiv</a></li>
				<li><a href="https://bcy.net/start">半次元</a></li>
				<li><a href="https://www.lofter.com">乐乎</a></li>
				<li><a href="https://www.poocg.com/">涂鸦王国</a></li>
				<li><a href="http://www.zcool.com.cn/">站酷</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
