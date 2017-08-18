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
<link href="<%=basePath%>common/css/globle.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/easyUI/demo/demo.css">
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
	function check() {
		var productName = $("#productName").val().trim();
		var productDesc = $("#productDesc").val().trim();
		var image = $("#image").val().trim();
		var createDate = $('#createDate').datebox('getValue'); ;
		if (!(f_check_length(productName,1,50))) {
			alert("请输入作品名");
			$("#productName")[0].select();
			$("#productName")[0].focus();
			return false;
		}
		if (!(f_check_length(productDesc,10,2000))) {
			alert("作品描述不能太少，也不能大于2000个汉字");
			$("#productDesc")[0].select();
			$("#productDesc")[0].focus();
			return false;
		}
		if (image==""&& ($("#replaceSpan").css("display")=="")) {
			alert("请选择作品图片");
			return false;
		}
		if (createDate=="") {
			alert("请选择作品创作日期");
			return false;
		}
		return true;
	
	}
	function replaceImage() {
		$("#replaceSpan").css("display","none");
		$("#unReplaceSpan").css("display","");
		$("#fileTd").css("display","");
	}
	function unReplaceImage() {
		$("#replaceSpan").css("display","");
		$("#unReplaceSpan").css("display","none");
		$("#fileTd").css("display","none");
		//取消文本内容
		$("#image")[0].outerHTML = $("#image")[0].outerHTML;
	}
</script>
<body>
<div class="longbox w1003">
<div class="camTitle">
</div>
	<div class="longConCam">
		<div class="longTop">请确认您拥有该作品的版权！带有 <span class="cf30">*</span> 的项目是必填的。</div>
	    <div class="camZp">
	    <s:form action="productAction" namespace="/product" method="post" enctype="multipart/form-data" onsubmit="return check()">
	    	<s:hidden name="product.productId"></s:hidden>
	    	<table width="100%" cellpadding="0" cellspacing="0" class="norTable register" >
	    		<tr>
                	<td colspan="2">
                	<div class="wsContent" >
									<img style="width: 900px" src="<%=basePath%><s:property value="product.imageUrl"/>" />
	                </div> <br>
                   </td>
                </tr>
                <tr>
                	<th width="100">
                	<span onclick="replaceImage()" id="replaceSpan"> <font size="30" color="red">替换图片</font></span>
                	<span onclick="unReplaceImage()" style="display:none" id="unReplaceSpan"><font size="30" color="red">取消替换图片</font></span>
                	</th>
	                <td style="display:none" id="fileTd">
							<div id="images"><input type="file" name="image" id="image"></div> <s:fielderror></s:fielderror>
	                </td>
                </tr>
	    		<tr>
                	<th width="100">作品名称<span class="cf30">*</span></th>
                    <td><s:textfield maxlength="50" id="productName" cssClass="newTxt w640" name="product.productName"/><span class="ml10 c999 pt5 f12">可以输入<b class="cf30 abc">50</b> 字符/汉字</span>
                    </td>
                </tr>
				<tr>
                	<th width="100">作品分类<span class="cf30">*</span></th>
                    <td>
                    	<span class="selectBox">
                    	<s:select list="#session.productSorts" name="product.productSort.sortId"  listKey="sortId" listValue="sortName"/>
                    	</span>
                    </td>
                </tr>
                <tr>
                	<th width="100">作品说明<span class="cf30">*</span></th>
                    <td><s:textarea id="productDesc" cssClass="newArea at_input w810 h140" name="product.productDesc"></s:textarea> 
                    <p class="c999 pt5 f12">可以输入 <b class="cf30 abc">2000</b> 字符/汉字</p></td>
                </tr>
				<tr>
                	<th width="100" class="c999">创作时间<span class="cf30">*</span><br/><span class="infor" popId="time_pops"></span></th>
                    <td>
                    <s:textfield name="product.createDate" value="%{product.getCreateDateString()}"  cssClass="easyui-datebox" id="createDate"/> 
                    </td>
                </tr>
	            <tr class="last">
                	<th></th>
                    <td>
                    <s:submit type="submit" value="确定" cssClass="lBtn" method="updateProduct"></s:submit>
                    </td>
                </tr>
	        </table>
		    </s:form>
	    </div>
	</div>
</div><!--logbox-->
</body>
</html>
