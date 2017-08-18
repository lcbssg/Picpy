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

	function lastPage(productId) {
		var curPage = <s:property value="page"/>;
		if (curPage == 1) {
			alert("已经是第一页了");
			return;
		}
		window.location.href='<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?product.productId='+productId+'&page=' + (curPage - 1);
	}
	function nextPage(productId) {
		var pageCount = <s:property value="#request.pageCount"/>;
		var curPage = <s:property value="page"/>;
		if (curPage == pageCount) {
			alert("已经是最后一页了");
			return;
		}
		window.location.href='<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?product.productId='+productId+'&page=' + (curPage + 1);
	}
</script>
</head>
<body>
	<div class="longbox w1003">
    <div class="camTitle">
    	<div class="camNavC">
	    	<a id="commentBtn" href="javascript:void(0);" class="selected">评论(<s:property value="#request.commentCount"/>)</a>
    	</div>
    </div>
    <div class="longConCam">
    	<s:form namespace="/comment" action="commentAction" method="post" onsubmit="return check()">
    	<s:hidden name="product.productId" value="%{#request.product.productId}"></s:hidden>
    	<s:if test="!isAdmin()">
    		<div class="inputLong">
			<s:textarea cssClass="normalArea at_input" value="" name="productComment.commentContent" id="commentContent"></s:textarea>
            <div class="vm commentFunc pt5 layout">
            	<div class="fRight right">
            		<span>可以输入 <span class="cf30  abc">2000</span> 个字符</span>
            		<s:submit type="button" value="提交评论" cssClass="yellowBtn mt10" method="save"></s:submit>
            	</div>
            </div>
        </div>
    	</s:if>
    	
        </s:form>
    </div>
    
</div>
	<div class="longbox w1003">
		<div class="longConCam">
			<s:if test="#request.product!=null">
				<s:iterator value="#request.productComments" >
					<div class="recListS borderTop">
						<ul>
							<li>
								<div class="layout recListLeft f14">
									<a class="fLeft" href="<%=basePath%>user/userAction!findById?sysUser.userId=<s:property value="sysUser.userId"/>&&findByIdResult=query" target="_blank">
									<img width="48" height="48" src="<%=basePath%><s:property value="sysUser.imageUrl==null?'common/image/touxiang.gif':sysUser.imageUrl"/>" width="48" /> </a>
									<div class="recDes">
										<div class="vm c999">
											<b><s:property value="sysUser.userName"/>对作品《<s:property value="#request.product.productName"/>》发表了评论： </b>
										</div>
										<p class="c999 f12"><s:property value="getCommentTimeString()"/></p>
										<p class="recBox" id="comment3960685"><s:property value="commentContent"/></p>
										<div class="mblFunc vm mt10 f12">
												<!-- 评论创建者有三个权限，系统管理员有删除权限，其余的人只有回复评论权限 -->
												<s:if test="!isAdmin()&&getCurUser().userId == sysUser.userId">
												<a href='<%=basePath%>comment/commentAction!findById?productComment.commentId=<s:property value="commentId"/>' class="c009cff">编辑评论</a>
												<a href='<%=basePath%>comment/commentAction!delete?productComment.commentId=<s:property value="commentId"/>' class="c009cff">删除评论</a>
												<a href='<%=basePath%>pifriend/reply/createReply.jsp?commentId=<s:property value="commentId"/>&&productId=<s:property value="#request.product.productId"/>' class="c009cff">回复评论</a>
												</s:if>
												<s:elseif test="isAdmin()">
												<a href='<%=basePath%>comment/commentAction!delete?productComment.commentId=<s:property value="commentId"/>' class="c009cff">删除评论</a>
												</s:elseif>
												<s:else>
												<a href='<%=basePath%>pifriend/reply/createReply.jsp?commentId=<s:property value="commentId"/>&&productId=<s:property value="#request.product.productId"/>' class="c009cff">回复评论</a>
												</s:else>
										</div>
										<s:iterator value="commentReplies">
										<s:if test="sysUser.isLock == false">
											<div class="zql_BodyT" style="margin-top: 5px">
											<a class="fLeft" href="<%=basePath%>user/userAction!findById?sysUser.userId=<s:property value="sysUser.userId"/>&&findByIdResult=query" target="_blank">
									<img width="48" height="48" src="<%=basePath%><s:property value="sysUser.imageUrl==null?'common/image/touxiang.gif':sysUser.imageUrl"/>" width="48" /> </a>
												<s:property value="sysUser.userName"/>对评论进行了回复：<span class="c999 f12"><s:property value="getReplyContentString()"/></span>
												<p><s:property value="replyContent"/></p>
											</div>
											<s:if test="!isAdmin()&&getCurUser().userId == sysUser.userId">
												<div class="mblFunc vm mt10 f12">
													<a href='<%=basePath%>reply/replyAction!findById?commentReply.replyId=<s:property value="replyId"/>'>编辑回复</a> 
													<a href='<%=basePath%>reply/replyAction!delete?commentReply.replyId=<s:property value="replyId"/>' class="c009cff">删除回复</a>
												</div>
											</s:if>
											<s:elseif test="isAdmin()">
												<div class="mblFunc vm mt10 f12">
													<a href='<%=basePath%>reply/replyAction!delete?commentReply.replyId=<s:property value="replyId"/>' class="c009cff">删除回复</a>
												</div>
											</s:elseif>
											</s:if>
										</s:iterator>
									</div>
								</div></li>
						</ul>
					</div>
				</s:iterator>
			</s:if>
			<div class="pageList">
			<s:form action="commentAction!findCommentAndReplyByProduct" namespace="/comment" method="post">
					<ul>
						<li><a href='<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?page=1&&product.productId=<s:property value="#request.product.productId"/>'
							class="pret">首页</a>
						</li>
						<li><a onclick="lastPage(<s:property value="#request.product.productId"/>)" class="pret">上一页</a>
						</li>
						<li><a onclick="nextPage(<s:property value="#request.product.productId"/>)" class="next">下一页</a>
						</li>
						<li><a
							href='<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?page=<s:property value="#request.pageCount"/>&&product.productId=<s:property value="#request.product.productId"/>'
							class="pret">末页</a>
						</li>
						<s:hidden name="product.productId"></s:hidden>
						<li>当前第<s:textfield
							name="page" style="height: 30px;width: 30px" />页</li>
						<li>共<s:property value="#request.pageCount" />页</li>
					</ul>
				</s:form>
				</div>
			</div>
		</div>
</body>
</html>