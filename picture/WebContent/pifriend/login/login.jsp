<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>系统登录</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>

<script type="text/javascript">
var basePath="";
function init() {
	basePath = "<%=basePath%>";
		changeCode();
		var state = "4";
<%if (request.getAttribute("state") != null) {%>
	state = '<s:property value="#request.state"/>';
<%}%>
	if (state == "0") {
			alert("用户名输入错误");
			$("#loginName").select();
			$("#loginName").focus();
		}
		if (state == "1") {
			alert("密码输入错误");
			$("#password").select();
			$("#password").focus();
		}
		if (state == "2") {
			alert("验证码输入错误");
			$("#validateCode").select();
			$("#validateCode").focus();
		}
		if (state == "3") {
			alert("用户被锁定,无法登录，请联系管理员，解锁当前用户");
		}
	}

	function changeCode() {
		//相同的图片路径会导致浏览器不刷新图片，更换访问路径。
		$("#validateImage")[0].src = basePath
				+ "login/loginAction!findValidateCode?date"
				+ new Date().getTime();
	}
	function selectText(text) {
		text.select();
		text.focus();
	}
	function checkInfor() {
		var loginName = $("#loginName").val().trim();
		var password = $("#password").val().trim();
		//验证码可以在前台验证，但是验证码的目的是防止恶意破解密码，因此要放在服务器端验证
		var validateCode = $("#validateCode").val().trim();
		if (!(f_check_length(loginName, 5, 10) && f_check_NumLett(loginName))) {
			alert("用户名由5-10位数字和字母组成，并由字母开头，请重新输入");
			$("#loginName")[0].select();
			$("#loginName").focus();
			return false;
		}
		if (!(f_check_length(password, 5, 10) && f_check_number(password))) {
			alert("密码由5-10位数字，请重新输入");
			$("#password")[0].select();
			$("#password").focus();
			return false;
		}
		if (!(f_check_length(validateCode, 4, 4) && f_check_NumOrLett(validateCode))) {
			alert("验证码由4位数字和字母组成，请重新输入");
			$("#validateCode")[0].select();
			$("#validateCode").focus();
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
			<s:form method="post" target="_parent" namespace="/login"
				action="loginAction" onsubmit="return checkInfor()">
				<div class="login_left">
					<h3 class="login_h3">欢迎登录</h3>
					<div class="login_sr">
						用户名：
						<s:textfield cssClass="login_inputYhm" id="loginName"
							name="loginName" onfocus="selectText(this)" />
					</div>
					<div class="login_sr">
						密码： &nbsp;&nbsp;&nbsp;
						<s:password showPassword="true" cssClass="login_inputMm"
							name="password" id="password" onfocus="selectText(this)" />
					</div>
					<div class="login_sr">
						<div style="float: left">验证码：&nbsp;&nbsp;</div>
						<s:textfield maxLength="4" cssClass="login_inputYzm"
							style="float:left;" name="validateCode" id="validateCode"
							onfocus="selectText(this)" />
						<div class="login_inputYzmPic" style="float: left">
							<img
								src="<%=basePath%>pifriend/login/loginAction!findValidateCode"
								id="validateImage" onclick="changeCode()">
						</div>
						<span class="login_inputYzmH" onclick="changeCode()">换一张</span>
					</div>
					<div>
						<s:submit type="button" cssStyle="height:30px;width:50px"
							method="login" value="登录"></s:submit>
					</div>
				</div>
			</s:form>
			<div class="login_right">
				<div class="login_rightH3">还没有账户？</div>
				<div class="login_sanfang">
					<a target="_blank" href="<%=basePath %>pifriend/login/register.jsp" >点击注册</a>
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