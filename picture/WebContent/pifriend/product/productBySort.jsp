<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>Picpy</title>
	<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/globle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
	function nextPage(sortId) {
		var pageCount = <s:property value="#request.pageCount"/>;
		var curPage = <s:property value="page"/>
		if (curPage == pageCount) {
			alert("已经是最后一页了");
			return;
		}
		window.location.href='<%=basePath%>product/productAction!findProductBySortAndPage?productSort.sortId='+sortId+'&&page=' + (curPage + 1);
	}
	function lastPage(sortId) {
		var curPage = <s:property value="page"/>
		if (curPage == 1) {
			alert("已经是第一页了");
			return;
		}
		window.location.href='<%=basePath%>product/productAction!findProductBySortAndPage?productSort.sortId='+sortId+'&&page=' + (curPage - 1);
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
	var i = '<s:property value="isLogin()"/>';
	if (i == 'true') {//已经登陆
		window.location.href = "<%=basePath%>product/productAction!findProductBySortAndPage?productSort.sortId=" + sortId;
	} else {
		alert("您还没有登陆，登陆后才能查看详细信息");
	}
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
<body >
<div class="doc1180 paddingT20 fn-clear">
	<!--页面左侧内容-->
    <div class="doc850 fn-left">
        <div class="toefl_tuijian">
            <div class="toefl_dl">
            	<s:iterator value="#request.products">
	            	<div style="float:left;margin-left: 3px">
								<a onclick='showProductDetail(<s:property value = "productId"/>)' href='javascript:void(0);'>
									<img src='<%=basePath%><s:property value="imageUrl"/>'
									width="280px" height="165px"> </a>
								<div class="camLiDes">
									<b> <a onclick='showProductDetail(<s:property value = "productId"/>)' href='javascript:void(0);'
										style='color:#a6ce38;'> <s:property value="productName" />
									</a>
									</b> - <a style='color:#ff0084;' onclick='showSort(<s:property value="productSort.sortId"/>)'
										href="javascript:void(0);">
										<s:property value="productSort.sortName" /> </a><br />
									<s:property value="getUploadDateString()" />
									上传<br /> 作者:<a  onclick="showUser(<s:property value="sysUser.userId"/>)"
										href='javascript:void(0);'
										style='color:#a6ce38;'> <s:property
											value="sysUser.userName" /> </a>
								</div>
					</div>
            	</s:iterator>
            	<div style="clear:both"></div>	
            </div>
                       <!-- 最新作品结束 -->
				<div class="pageList">
					<s:form action="productAction!findProductBySortAndPage" namespace="/product" method="post">
					<ul>
						<li><a href='<%=basePath%>product/productAction!
						findProductBySortAndPage?
						productSort.sortId=<s:property value="productSort.sortId"/>
						&&
						page=1'
							class="pret">首页</a>
						</li>
						<li><a href="###" onclick="lastPage(<s:property value="productSort.sortId"/>)" class="pret">上一页</a>
						</li>
						<li><a href="###" onclick="nextPage(<s:property value="productSort.sortId"/>)" class="next">下一页</a>
						</li>
						<li><a
							href='<%=basePath%>product/productAction!
							findProductBySortAndPage?
							productSort.sortId=<s:property value="productSort.sortId"/>
							&&
							page=<s:property value="#request.pageCount"/>'
							class="pret">末页</a>
						</li>
						<%-- <li>当前第<input type="text" value='<s:property value="page"/>'
							name="page" style="height: 30px;width: 30px" disabled="disabled" />页</li>
						<li>共<s:property value="#request.pageCount" />页</li> --%>
						<s:hidden name="productSort.sortId"></s:hidden>
						<li>当前第<s:textfield 
							name="page" style="height: 30px;width: 30px" />页</li>
						<li>共<s:property value="#request.pageCount" />页</li>
					</ul>
					</s:form>
				</div>
			</div>
</div>
				<!--页面左侧内容 end-->
</div>
<!-- 代码结束 -->
</body>
</html>