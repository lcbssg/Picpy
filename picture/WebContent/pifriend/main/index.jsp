<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>Picpy</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
function showProductBySort(sortId) {
	document.getElementById("mainframe").src='<%=basePath%>product/productAction!findProductBySortAndPage?productSort.sortId='+ sortId;
}
function showMain() {
	document.getElementById("mainframe").src='<%=basePath%>main/mainAction!findMainContent';
}
function showUserDetail() {
	document.getElementById("mainframe").src='<%=basePath%>user/userAction!findById?findByIdResult=update&&sysUser.userId=<s:property value="#session.curUser.userId"/>';
}
function showProduct() {
	document.getElementById("mainframe").src='<%=basePath%>product/productAction!findProductByUserAndPage?sysUser.userId=<s:property value="#session.curUser.userId"/>';
}
function userManage() {
		window.mainframe.location.href="<%=basePath%>user/userAction!findByPage";
}
function mainImage() {
	window.mainframe.location.href="<%=basePath%>main/mainAction!findAll";
}
function jobManage() {
	window.mainframe.location.href="<%=basePath%>job/jobAction!findAll";
}
</script>
<body>
	<div class="menu">
		<div class="doc1180">
			<div style="float: left; width: 100px; height: 50px;">
				<a onclick="showMain()"><img style="height: 50px"
					src="<%=basePath%>common/image/logo.png"></a>
			</div>
			<div class="menuLink">
				<ul class="fn-clear">
					<li><a onclick="showMain()">首页</a></li>
					<s:if test="isLogin()">
						<s:iterator value="#session.productSorts">
							<li><a href='##'
								onclick='showProductBySort(<s:property value="sortId"/>)'> <s:property
										value="sortName" /></a></li>
						</s:iterator>
					</s:if>
					<s:else>
						<s:iterator value="#request.productSorts">
							<li><a
								onclick='showProductBySort(<s:property value="sortId"/>)'><s:property
										value="sortName" /></a></li>
						</s:iterator>
					</s:else>
					<s:if test="isAdmin()">
						<li><a href="###" onclick="userManage()">会员管理</a></li>
						<li><a href="###" onclick="mainImage()">首页设置</a></li>
						<li><a href="###" onclick="jobManage()">职位管理</a></li>
					</s:if>
					<s:elseif test="isLogin()">
						<li><a href="###" onclick="showUserDetail()">个人信息</a></li>
						<li><a href="###" onclick="showProduct()">作品发布</a></li>
					</s:elseif>
				</ul>
			</div>
			
			<div class="menuLink" style="margin-left: 300px">
				<ul class="fn-clear">
					<s:if test="isLogin()">
						<li><a href="<%=basePath %>login/loginAction!logout" >退出登陆</a></li>
					</s:if>
					<s:else>
						<li><a target="_blank"
							href="<%=basePath%>pifriend/login/login.jsp">登陆</a></li>
						<li><a target="_blank"
							href="<%=basePath%>pifriend/login/register.jsp">注册</a></li>
					</s:else>
				</ul>
			</div>
		</div>
	</div>
		<%-- <%@ include file="../main/main.jsp" %> --%>
	<%-- <jsp:include page="../main/main.jsp" flush="true"/> --%>
	<iframe height="590px"
		src="<%=basePath%>main/mainAction!findMainContent" scrolling="yes"
		id="mainframe" width="99%" name="mainframe" onchange=""></iframe>
</body>
</html>
