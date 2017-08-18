<!DOCTYPE html>
<html>
<head>
<link rel="StyleSheet"
    href="${pageContext.request.contextPath}/resources/css/top.css"
    type="text/css" media="screen" />

<title>倾花城</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="Pragma" content="no-cache" />
</head>

<body class="common">
	<%@ include file="Bar.jsp"%>
	<!-- 提示信息 -->
    <div id="content">
        <c:if test="${!empty message}">
            <p>${message}</p>
        </c:if>
    </div>
     <div id="mainboard">
	