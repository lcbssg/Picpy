<!DOCTYPE html>
<html>
<head>
<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/resources/css/register.css"
	type="text/css" media="screen" />
<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/resources/css/top.css"
	type="text/css" media="screen" />
<title>注册账号</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body class="reg">
	<%@ include file="../common/Bar.jsp"%>
	<div class="register">
		<h2>注册账号</h2>
		<form:form modelAttribute="accountForm"
			action="${pageContext.request.contextPath}/account/newAccount">
			<input type="text" name="username" placeholder="请输入用户名">
			<br />
			<form:errors path="username" />
			<br />
			<input type="password" name="password" placeholder="请输入密码">
			<br />
			<form:errors path="password" />
			<br />
			<input type="password" name="repeatedPassword" placeholder="请重复输入密码">
			<br />
			<form:errors path="repeatedPassword" />
			<br />
			<input type="submit" class="sign-up" name="newAccount" value="注册">

		</form:form>
	</div>
</body>
</html>