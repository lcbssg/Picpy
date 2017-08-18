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
</script>
</head>
<body>
<div class="container mt20" style="margin-top: 1px">
	<div class="longConWhite">
		<div class="layout">
        	<table width="100%" class="workTopBar">
            	<tr>
                	<td>
                        <h1 class="workTitle">
                        	作品名称：<font color="red"> <s:property value="#request.product.productName"/> </font> 
                        </h1>
                        <h1 class="workTitle">
                        	系统分类：
                        	<s:property value="#request.product.productSort.sortName"/>
							
                        </h1>
                	</td>
                    <td class="leftBorder" width="210">
                   		<div class=" layout ">
                            <a  href="##" target="_blank" class="userInforHead">
                           		<img src='<%=basePath%><s:property value="#request.product.sysUser.imageUrl==null?'common/image/touxiang.gif':#request.product.sysUser.imageUrl"/>' width="64" height="64"/>
                            </a>
                        		
                            <div class="userInforCon">
                                <div class="userName vm">
                                	<a  href="<%=basePath%>user/userAction!findById?sysUser.userId=<s:property value="#request.product.sysUser.userId"/>&&findByIdResult=query" target="_blank"><s:property value="#request.product.sysUser.userName"/></a> 
                                </div>
                                <p class="c666"><s:property value="#request.product.sysUser.sysJob.jobName"/><br/>
                                <span class="c999"><s:property value="#request.product.getUploadDateString()"/>发布</span>
                                </p>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
      	</div>
        <div class="workContentWrapper borderTop" style="background:#ffffff;color:#616161;"><!--自定义颜色-->
                <div class="workInfor">
					<p>
					<s:property value="#request.product.productDesc"/>
					</p>
                </div>
	            <div class="workShow">
	                <ul>
	                    <li>
	                        <div class="wsContent">
									<img src="<%=basePath%><s:property value="#request.product.imageUrl"/>" width="900px"  />
	                        </div>
							
	                    </li>
	                </ul>
	            </div>
          </div>
        </div>
</div>
<iframe src='<%=basePath%>comment/commentAction!findCommentAndReplyByProduct?product.productId=<s:property value="#request.product.productId"/>'  width="1083" height="1500px"  scrolling="no" frameborder="0" style="display:block;margin:0">
</body>
</html>
