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

<script >
function check() {
	var commentContent = $('#commentContent').val();
	if (!(f_check_length(commentContent,10,2000))) {
			alert("作品描述不能太少，也不能大于2000个汉字");
			$("#commentContent")[0].select();
			$("#commentContent")[0].focus();
			return false;
	}
}
</script>
</head>
<body>
	<div class="longbox w1003">
    <div class="camTitle">
    	<div style="text-align: center;color: red;font-size: 24px">
	    	请输入评论内容
    	</div>
    </div>
    <div class="longConCam">
    	<s:form namespace="/comment" action="commentAction" method="post" onsubmit="return check()">
    	<s:hidden name="productComment.commentId"></s:hidden>
    	<div class="inputLong">
			<s:textarea cssClass="normalArea at_input" name="productComment.commentContent" id="commentContent"></s:textarea>
            <div class="vm commentFunc pt5 layout">
            	<div class="fRight right">
            		<span>可以输入 <span class="cf30  abc">2000</span> 个字符</span>
            		<s:submit type="button" value="提交评论" cssClass="yellowBtn mt10" method="update"></s:submit>
            		<a href="<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?product.productId=<s:property value="productComment.product.productId"/>" class="c009cff">取消评论</a>
            	</div>
            </div>
        </div>
        </s:form>
    </div>
</div>
</body>
</html>