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
		if (image=="") {
			alert("请选择作品图片");
			return false;
		}
		if (createDate=="") {
			alert("请选择作品创作日期");
			return false;
		}
		return true;
	
	}
	
</script>
<body>
<div class="longbox w1003">
<div class="camTitle">
</div>
	<div class="longConCam">
	    <div class="camZp">
	    <s:form action="productAction" namespace="/product" method="post" enctype="multipart/form-data" onsubmit="return check()">
	    	<table width="100%" cellpadding="0" cellspacing="0" class="norTable register" >
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
                	<th width="100">上传图片<span class="cf30">*</span><br/><span class="infor" popId="upload_pops"></span></th>
	                <td>
							<div id="images"><input type="file" name="image" id="image"></div> <s:fielderror></s:fielderror>
	                </td>
                </tr>
                <tr>
                	<th width="100" >图片信息说明</th>
	                <td >
							<font color="red">图片建议宽度为900像素，其他像素图片会同比例放大缩小</font>
	                </td>
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
                    <s:submit type="submit" value="确定" cssClass="lBtn" method="saveProduct"></s:submit>
                    </td>
                </tr>
	        </table>
		    </s:form>
	    </div>
	</div>
</div><!--logbox-->
</body>
</html>
