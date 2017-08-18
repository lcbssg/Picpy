<!DOCTYPE html>
<html>
<head>
<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/resources/css/login.css"
	type="text/css" media="screen" />
<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/resources/css/top.css"
	type="text/css" media="screen" />
<title>登录账号</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body class="log">
	<%@ include file="../common/Bar.jsp"%>
	<div class="login">
		<h2>登录账号</h2>
		<c:if test="${not empty param.error}">
			<div>
				<h4>账号或密码填写有误，请重新输入！</h4>
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/account/signon"
			method="POST">
			<input type="text" name="username" placeholder="请输入用户名"> <input
				type="password" name="password" placeholder="请输入密码"> <input
				type="submit" class="sign-in" value="登录"> <input
				type="reset" class="reset" value="重置">
		</form>
		<br /> 还没有账户？ <a
			href="${pageContext.request.contextPath}/account/newAccountForm">点击注册</a>
	</div>
</body>
</html>