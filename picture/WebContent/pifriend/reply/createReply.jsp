<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String commentId = request.getParameter("commentId");
String productId = request.getParameter("productId");
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
	var commentReply = $('#commentReply').val();
	if (!(f_check_length(commentContent,10,2000))) {
			alert("作品回复不能太少，也不能大于2000个汉字");
			$("#commentReply")[0].select();
			$("#commentReply")[0].focus();
			return false;
	}
	return true;
}
</script>
</head>
<body>
	<div class="longbox w1003">
    <div class="camTitle">
    	<div style="text-align: center;color: red;font-size: 24px">
	    	请输入回复内容
    	</div>
    </div>
    <div class="longConCam">
    	<s:form namespace="/reply" action="replyAction" method="post" onsubmit="return check()">
    	<input type="hidden" name="commentReply.productComment.commentId" value="<%=commentId%>">
    	<div class="inputLong">
			<s:textarea cssClass="normalArea at_input" name="commentReply.replyContent" id="commentReply"></s:textarea>
            <div class="vm commentFunc pt5 layout">
            	<div class="fRight right">
            		<span>可以输入 <span class="cf30  abc">2000</span> 个字符</span>
            		<s:submit type="button" value="提交回复" cssClass="yellowBtn mt10" method="save"></s:submit>
            		<a href="<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?product.productId=<%=productId%>" class="c009cff">取消回复</a>
            	</div>
            </div>
        </div>
        </s:form>
    </div>
</div>
</body>
</html>