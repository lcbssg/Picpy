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
<title>用户列表</title>

<link href="<%=basePath%>common/css/base.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>common/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>common/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>common/easyUI/demo/demo.css">
<script type="text/javascript"
	src="<%=basePath%>common/easyUI/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
	function init() {
		var message = "";
<%if (request.getAttribute("message") != null) {%>
	message = '<s:property value ="#request.message"/>';
<%}%>
	if (message != "") {
			alert(message);
		}
	}
	function showImageDiv() {
		$("#imageDiv")[0].style.display = "";
	}
	function checkImage() {
		if (!confirm("请确认用户其他信息是否已经保存")) {
			return false;
		}
		if ($("#image").val() == "") {
			alert("请选择文件");
			return false;
		}
		return true;
	}
	function checkInfor() {
		var userName = $("#userName").val().trim();
		var email = $("#email").val().trim();
		var phoneNum = $("#phoneNum").val().trim();
		var birthday = $('#dd').datebox('getValue');
		;
		if (!f_check_ZhOrNumOrLett(userName)) {
			alert("用户名由汉字、字母、数字、_、-组成，请重新输入");
			$("#userName")[0].select();
			$("#userName")[0].focus();
			return false;
		}
		if (!f_check_length(userName, 1, 21)) {
			alert("用户名不能为空，汉字不得多于8个，字母不得多于21个，请重新输入");
			$("#userName")[0].select();
			$("#userName")[0].focus();
			return false;
		}
		if (!f_check_email(email)) {
			alert("请输入正确的邮箱");
			$("#email")[0].select();
			$("#email")[0].focus();
			return false;
		}
		if (!(f_check_length(phoneNum, 1, 15) && f_check_number(phoneNum))) {
			alert("输入的电话号码格式错误");
			$("#phoneNum")[0].select();
			$("#phoneNum")[0].focus();
			return false;
		}
		if (birthday == '') {
			alert("请输入出生日期");

			return false;
		}
		return true;
	}
</script>
<body onload="init()">
	<div align="center" style="text-align: center;">
		<a href="#" style="font-size: 24">个人信息</a>
	</div>
	<s:form method="post" namespace="/user" action="userAction" enctype="multipart/form-data"
		onsubmit="return checkInfor()">
		<div style="margin-top: 30px; float:left;margin-left:250px ">
			<s:if test="sysUser.imageUrl==null">
				<img src="<%=basePath%>common/image/touxiang.gif" height="80px">
				<br>
                  		您还没有上传图像&nbsp;&nbsp; &nbsp;&nbsp;<a
					onclick="showImageDiv()" href="##"><font color="red">上传图像</font></a>
			</s:if>
			<s:else>
				<img src='<%=basePath%><s:property value="sysUser.imageUrl"/>'
					height="80px">
				<br>
                  		您已经上传了图像&nbsp;&nbsp; &nbsp;&nbsp;<a
					onclick="showImageDiv()" href="##"><font color="red">重新上传</font></a>
			</s:else>
			<div style="margin-top: 50px; display: none" id="imageDiv">
					<input type="file" name="image" id="image">
					<br>
					<s:hidden name="sysUser.userId"></s:hidden>
					<font size="3" color="red">图片建议大小150pxX150px<br>建议大小小于2M<br/>建议格式jpg、png
					</font>
					<br>
			</div>
			<div style="margin-top: 50px">
				<a
					href='<%=basePath%>product/productAction!findProductByUserAndPage?sysUser.userId=<s:property value="sysUser.userId"/>'
					style="font-size: 24px; color: red"> 查看作品</a> <br /> <br /> <a
					href='<%=basePath%>pifriend/user/userPassword.jsp'
					style="font-size: 24px; color: blue">密码修改</a>
			</div>
		</div>
		<div align="center" style="margin-top: 30px; margin-left:50px; float:left;">
			<table>
				<tr>
					<td style="font-size: 16px; padding: 20px 0;">用户名</td>
					<td><s:textfield name="sysUser.userName" id="userName"
							cssClass="userCenter_input"></s:textfield> <font color="red"
						size="5">*</font></td>
				</tr>

				<tr>
					<td style="font-size: 16px; padding: 20px 0;">性别</td>
					<td><s:radio list="#{'男':true,'女':false}"
							name="sysUser.isMale" listKey="value" listValue="key"
							value="sysUser.isMale"></s:radio></td>
				</tr>
				<tr>
					<td style="font-size: 16px; padding: 20px 0;">职业</td>
					<td><s:select list="#request.sysJobs"
							name="sysUser.sysJob.jobId" listValue="jobName" listKey="jobId"></s:select>
					</td>
				</tr>
				<tr>
					<td style="font-size: 16px; padding: 20px 0;">邮箱</td>
					<td><s:textfield name="sysUser.email"
							cssClass="userCenter_input" id="email"></s:textfield><font
						color="red" size="5">*</font></td>
				</tr>
				<tr>
					<td style="font-size: 16px; padding: 20px 0;">电话</td>
					<td><s:textfield name="sysUser.phoneNum"
							cssClass="userCenter_input" id="phoneNum" /><font color="red"
						size="5">*</font></td>
				</tr>
				<tr>
					<td style="font-size: 16px; padding: 20px 0;">出生日期</td>
					<td><s:textfield name="sysUser.birthday"
							cssClass="easyui-datebox" id="dd"
							value="%{sysUser.getBirthdayString()}" /> <font color="red"
						size="5">*</font></td>
				</tr>
				<tr>
					<td colspan="2" style="font-size: 16px; padding: 20px 0;"><font
						color="red" size="3">*为必输项 </font></td>
				</tr>
				<tr>
					<td><s:submit value="提交" method="updateInfor"
							cssStyle="height:30px;width:60px"></s:submit></td>
				</tr>
			</table>
		</div>
	</s:form>
</body>
</html>
