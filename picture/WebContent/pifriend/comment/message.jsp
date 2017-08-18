<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Picpy</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/globle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>

</head>
<script type="text/javascript">
	function init() {
		var message = "";
		<%if (request.getAttribute("message") != null) {%>
			message = '<s:property value ="#request.message"/>'
		<%}%>
		if (message != "") {
			$("#content")[0].innerHTML = message;
		}
	}

</script>

<body onload="init()">
	<div class="longbox w1003">
    <div class="camTitle">
    	<div id="content" style="text-align: center;color: red;font-size: 24px">
    	</div>
    	<div id="content1" style="text-align: center;color: red;font-size: 24px">
    		<a href='<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?product.productId=<s:property value="#request.productId"/>'>返回评论页 </a>
    	</div>
    </div>
</div>
</body>
</html>