<%@ include file="../common/IncludeTop.jsp"%>

<div id="info">
	修改密码 
	<a href="${pageContext.request.contextPath}/account/info">&nbsp;&nbsp;返&nbsp;&nbsp;回</a>
	<a href="${pageContext.request.contextPath}/order/listOrders">查看订单</a> 
	<a href="${pageContext.request.contextPath}/account/editAccountForm">修改密码</a> 
	<a href="${pageContext.request.contextPath}/account/editAddrForm">编辑地址</a>
	<hr />
	<form:form modelAttribute="editPswForm"
			action="${pageContext.request.contextPath}/account/editAccount">
		<table>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>旧密码:</td>
				<td><input type="password" name="oldpassword" placeholder="请输入旧密码"></td><td><form:errors path="oldPassword" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>新密码:</td>
				<td><input type="password" name="password" placeholder="请输入新密码"></td><td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>重复新密码:</td>
				<td><input type="password" name="repeatedPassword" placeholder="请重复输入新密码"></td><td><form:errors path="repeatedPassword" /></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><input type="submit" name="editAccount" value="保存"></td>
			</tr>
		</table>
	</form:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
