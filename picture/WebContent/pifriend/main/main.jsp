<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>common/css/globle.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/lrtk.js"></script>

</head>
<script type="text/javascript">
function init() {
	showBigPicture();
}
function showProductDetail(proId) {
	var i = '<s:property value="isLogin()"/>';
	if (i == 'true') {//已经登陆
		window.open("<%=basePath%>product/productAction!findProductDetailById?product.productId=" + proId);
	} else {
		alert("您还没有登陆，登陆后才能查看详细信息");
	}
}
function showSort(sortId) {
	window.location.href = "<%=basePath%>product/productAction!findProductBySortAndPage?productSort.sortId=" + sortId;
}
function showUser(userId) {
	var i = '<s:property value="isLogin()"/>';
	if (i == 'true') {//已经登陆
		window.open("<%=basePath%>user/userAction!findById?findByIdResult=query&&sysUser.userId=" + userId);
	} else {
		alert("您还没有登陆，登陆后才能查看详细信息");
	}
}
</script>

<body onload="init()">

	<div class="doc1180 paddingT20 fn-clear">
		<!--页面左侧内容-->
		<div class="doc850 fn-left">
			<div class="ppt">
				<!-- 代码 开始 -->
				<div id="playBox">
					<div class="pre"></div>
					<div class="next"></div>
					<div class="smalltitle">
						<ul>
							<li class="thistitle"></li>
							<s:if test="#request.sysMains.size()!=0">
								<s:iterator begin="1" value="#request.sysMains">
									<li></li>
								</s:iterator>
							</s:if>
						</ul>
					</div>
					<ul class="oUlplay">
						<s:if test="#request.sysMains.size()==0">
							<li><a href="###" target="_blank"><img
									src="<%=basePath%>common/image/888.jpg"></a></li>
						</s:if>
						<s:else>
							<s:iterator value="#request.sysMains">
								<li><a href="###" target="_blank"><img
										src='<%=basePath%><s:property value="imageUrl"/>'></a></li>
							</s:iterator>
						</s:else>
					</ul>
				</div>
				<!-- 代码 结束 -->

			</div>
			<div class="toefl_tuijian">
				<!-- 最新作品开始 -->
				<s:iterator value="#request.productSorts">
					<div>
						<div class="toefl_h3" style="float: right">
							<a onclick="showSort(<s:property value="key.sortId"/>)"
								href="javascript:void(0);">更多<s:property
									value="key.sortName" /></a>
						</div>
						<div style="clear: both"></div>
					</div>
					<div class="toefl_dl">
						<s:iterator value="value">
							<div style="float: left; margin-left: 3px">
								<a
									onclick='showProductDetail(<s:property value = "productId"/>)'
									href='javascript:void(0);'> <img
									src='<%=basePath%><s:property value="imageUrl"/>' width="280px"
									height="165px">
								</a>
								<div class="camLiDes">
									<b> <a
										onclick='showProductDetail(<s:property value = "productId"/>)'
										href='javascript:void(0);' style='color: #a6ce38;'> <s:property
												value="productName" />
									</a>
									</b> - <a style='color: #ff0084;'
										onclick='showSort(<s:property value="productSort.sortId"/>)'
										href="javascript:void(0);"> <s:property
											value="productSort.sortName" />
									</a><br />
									<s:property value="getUploadDateString()" />
									上传<br /> 作者:<a
										onclick="showUser(<s:property value="sysUser.userId"/>)"
										href='javascript:void(0);' style='color: #a6ce38;'> <s:property
											value="sysUser.userName" />
									</a>
								</div>
							</div>
						</s:iterator>
						<div style="clear: both"></div>
					</div>
				</s:iterator>
			</div>
		</div>
		<!--页面左侧内容 end-->
		<!--页面右侧内容-->
		<div class="doc280 fn-right">
			<div class="toefl_indexSign">
				<div class="toefl_SignNum">
					<p>
						今日已经有
						<s:property value="#request.loginCount" />
						人
					</p>
					<p>访问本站</p>
				</div>
			</div>
			<!--热门小组-->
			<div class="index_itemR">
				<div class="index_itemRtitle">
					<h3>热门设计师</h3>
				</div>
				<div class="index_itemRHot">
					<s:iterator value="#request.sysUsers">
						<dl>
							<dt>
								<s:if test="imageUrl==null">
									<a onclick="showUser(<s:property value="userId"/>)"><img
										src="<%=basePath%>common/image/touxiang.gif" width="48"
										height="48"></a>
								</s:if>
								<s:else>
									<a onclick="showUser(<s:property value="userId"/>)"><img
										src="<%=basePath%><s:property value="imageUrl"/>" width="48"
										height="48"> </a>
								</s:else>

							</dt>
							<dd>
								<div class="fn-clear">
									<span class="index_itemRHotName"><a onclick="showUser(<s:property value="userId"/>)"><s:property value="userName"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
									<span class="index_itemRHotNum"><s:property value="sysJob.jobName" /></span> 
									<br> 
									<span class="index_itemRHotNum">注册时间：<s:property value="getRegisterTimeString()" /></span>
								</div>
							</dd>
						</dl>
					</s:iterator>
				</div>

			</div>
			<!--最新评论-->
			<div class="index_itemR">
				<div class="index_itemRtitle">
					<h3>最新评论</h3>
				</div>
				<div class="index_itemROpen">
					<s:iterator value="#request.comments" var="comment">
						<dl>
							<dt class="now">
								<a onclick="showUser(<s:property value="sysUser.userId"/>)"><img
									src="<%=basePath%><s:property value="sysUser.imageUrl"/>"
									width="48" height="48"> </a>
							</dt>
							<dd>
								<div class="index_itemROpenTitle">
									<a onclick="showProductDetail(<s:property value = "product.productId"/>)"> <s:if test="commentContent.length()>32">
											<s:property value="commentContent.substring(0, 32)" />....
										</s:if> <s:else>
											<s:property value="commentContent" />
										</s:else>
									</a>
								</div>
								<div class="index_itemROpenText">
									<span><a onclick="showUser(<s:property value="sysUser.userId"/>)"><s:property value="sysUser.userName" /></a></span><span><s:property
											value="getCommentTimeString()" /></span>
								</div>
							</dd>
						</dl>
					</s:iterator>
				</div>
			</div>
		</div>
		<!--页面右侧内容 end-->
	</div>
	<!-- 代码结束 -->
</body>
</html>
