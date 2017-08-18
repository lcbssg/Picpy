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
<link href="<%=basePath%>common/css/globle.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
	function nextPage() {
		var pageCount = <s:property value="#request.pageCount"/>;
		var curPage = <s:property value="page"/>
		if (curPage == pageCount) {
			alert("已经是最后一页了");
			return;
		}
		window.location.href='<%=basePath%>product/productAction!findProductByUserAndPage?sysUser.userId=<s:property value="sysUser.userId"/>&&page=' + (curPage + 1);
	}
	function lastPage() {
		var curPage = <s:property value="page"/>
		if (curPage == 1) {
			alert("已经是第一页了");
			return;
		}
		window.location.href='<%=basePath%>product/productAction!findProductByUserAndPage?sysUser.userId=<s:property value="sysUser.userId"/>&&page=' + (curPage - 1);
	}
</script>
<body>
	<s:if test="!isAdmin()&&#session.curUser.userId == sysUser.userId">
		<div class="openMenu">
			<div class="doc1180">
				<ul class="fn-clear">
					<li><a href="<%=basePath%>pifriend/product/productCreate.jsp">发布作品</a></li>
				</ul>
			</div>
		</div>
	</s:if>
	<div class="doc1180 paddingT20 fn-clear">
		<!--页面左侧内容-->
		<div class="doc850 fn-left">

			<div class="toefl_tuijian">

				<div class="toefl_dl">
					<s:iterator value="#request.products">
						<div style="float: left; margin-left: 3px">
							<a
								href='<%=basePath%>product/productAction!findProductDetailById?product.productId=<s:property value="productId"/>'>
								<img src='<%=basePath%><s:property value="imageUrl"/>'
								width="280px" height="165px">
							</a>
							<div class="camLiDes">
								<b> <a
									href='<%=basePath%>product/productAction!findProductDetailById?product.productId=<s:property value = "productId"/>'
									style='color: #a6ce38;'> <s:property value="productName" />
								</a></b> - <a style='color: #ff0084;'
									href="<%=basePath%>product/productAction!findProductBySortAndPage?productSort.sortId=<s:property value="productSort.sortId"/>">
									<s:property value="productSort.sortName" />
								</a><br />
								<s:property value="getUploadDateString()" />
								上传<br />
								<s:if
									test="isAdmin()||#session.curUser.userId == sysUser.userId">
									<a style='color: red'
										href='<%=basePath%>product/productAction!findProductById?product.productId=<s:property value="productId"/>'>修改</a>
									<a style='color: red'
										href="<%=basePath%>product/productAction!deleteProduct?sysUser.userId=<s:property value="sysUser.userId"/>&&product.productId=<s:property value="productId"/>">删除</a>
									<br>
								</s:if>
							</div>
						</div>
					</s:iterator>
					<div style="clear: both"></div>
				</div>
				<!-- 最新作品结束 -->
				<div class="pageList">
					<s:form action="productAction!findProductByUserAndPage" namespace="/product" method="post">
					<ul>
						<li><a
							href='<%=basePath%>product/productAction!findProductByUserAndPage?
							sysUser.userId=<s:property value="sysUser.userId"/>
							&&
							page=1'
							class="pret">首页</a></li>
						<li><a href="###" onclick="lastPage()" class="pret">上一页</a></li>
						<li><a href="###" onclick="nextPage()" class="next">下一页</a></li>
						<li><a
							href='<%=basePath%>product/productAction!findProductByUserAndPage?
							sysUser.userId=<s:property value="sysUser.userId"/>
							&&
							page=<s:property value="#request.pageCount"/>'
							class="pret">末页</a></li>
							<s:hidden name="sysUser.userId"></s:hidden>
						<li>当前第<s:textfield name="page" style="height: 30px; width: 30px"/>页</li>
						<li>共<s:property value="#request.pageCount" />页
						</li>
					</ul>
					</s:form>
				</div>
			</div>
		</div>
		<!--页面左侧内容 end-->
	</div>
</body>
</html>