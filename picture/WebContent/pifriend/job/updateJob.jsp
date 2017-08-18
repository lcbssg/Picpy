<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>

<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
	
	function init() {
		var message = "";
		<%if (request.getAttribute("message") != null) {%>
			message = '<s:property value ="#request.message"/>'
		<%}%>
	if (message != "") {
			alert(message);
		}
	}

	function check() {
		var jobName = $("#jobName").val().trim();
		var jobDesc = $("#jobDesc").val().trim();
		if (!(f_check_length(jobName,5,20) && f_check_ZhOrNumOrLett(jobName))) {
			alert("职位名由3-10位汉字、字母、数字，_，-组成，请重新输入");
			$("#jobName")[0].select();
			$("#jobName").focus();
			return false;
		}
		if (!(f_check_length(jobDesc,10,200))) {
			alert("职位描述由5-100字符组成，请重新输入");
			$("#jobDesc")[0].select();
			$("#jobDesc").focus();
			return false;
		}
		return true;
	
	}
</script>
<body onload="init()">
	<div  align="center" style="text-align: center;">
        	<a href="###" style="font-size:24">职业信息</a>
                
            
        </div>

	<s:form method="post" namespace="/job" action="jobAction"  onsubmit="return check()">
		<div align="center" style="margin-top: 30px">
			<s:hidden name="sysJob.jobId"></s:hidden>
			<table>
				<tr>
					<td>职位名称：</td>
					<td> <s:textfield name="sysJob.jobName" id="jobName"></s:textfield> <font color="red" size="5">*</font></td>
				</tr>
				<tr>
					<td>职位描述：</td>
					<td> <s:textarea cols="50" rows="10" name="sysJob.jobDesc" id = "jobDesc"></s:textarea> <font color="red" size="5">*</font></td>
				</tr>
				<tr>
					<td colspan="2"><font color="red" size="3">*为必输项 </font></td>
				</tr>
				<tr>
					<td> <s:submit value="提交" cssStyle="height:30px;width:60px" method="update"></s:submit> </td>
					<td><s:reset value="重置" cssStyle="height:30px;width:60px"></s:reset>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </td>
				</tr>
			</table>
			
		</div>
	</s:form>
</body>

</html>
