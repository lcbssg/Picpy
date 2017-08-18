<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>首页图片设置</title>
	<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/lrtk.js"></script>
</head>
<script type="text/javascript">
function check() {
	if ($("#image").val() == "" ) {
		alert("请选择文件");
		return false;
	}
	return true;
}
</script>

<body onload="showBigPicture()">
<div class="castleInfo_title" style="text-align: center;">主页图片阅览</div>
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
    		<li><a href="###" target="_blank"><img src="<%=basePath%>common/image/888.jpg"></a></li>
    	</s:if>
    	<s:else>
    		<s:iterator value="#request.sysMains">
    			<li><a href="###" target="_blank"><img src='<%=basePath%><s:property value="imageUrl"/>'></a></li>
    		</s:iterator>
    	</s:else>
    </ul>
  </div>
  </div>
  	<div class="castleInfo_title" style="text-align: center;">主页图片维护</div>
  	<s:iterator value="#request.sysMains">
  		<div>
  		<img src='<%=basePath%><s:property value="imageUrl"/>' style="height:400px;width: 700px"> 
  		<a href="<%=basePath%>main/mainAction!delete?sysMain.mainId=<s:property value="mainId"/>" class="classInfo_ljbm">删除</a>
    	</div>
    </s:iterator>
  	<div style="margin-top: 100px">
  		<s:form action="mainAction" namespace="/main" enctype="multipart/form-data" onsubmit="return check()">
  			图片上传：<input type="file" name="image" id="image">
  			<s:submit method="save" value="提交"></s:submit>
  		</s:form>
  		<font size="3" color="red"><s:fielderror></s:fielderror></font>
  	</div>
  	<div style="margin-top: 100px"><font size="3" color="red">主页图片建议大小为850px X 330px，大小不能超过2m、图片格式为jpg、png格式</font></div>
<!-- 代码 结束 -->
  </div>
  </div>
<!-- 代码结束 -->
</body>
</html>
