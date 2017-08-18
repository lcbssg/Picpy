<%@ include file="../common/IncludeTop.jsp"%>

<div id="info">
	编辑地址 
	<a href="${pageContext.request.contextPath}/account/info">&nbsp;&nbsp;返&nbsp;&nbsp;回</a>
	<a href="${pageContext.request.contextPath}/order/listOrders">查看订单</a>
	<a href="${pageContext.request.contextPath}/account/editAccountForm">修改密码</a>
	<a href="${pageContext.request.contextPath}/account/editAddrForm">编辑地址</a>
	<hr />
	<form:form modelAttribute="addressForm"
		action="${pageContext.request.contextPath}/account/editAddr">
		<table>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>收货人:</td>
				<td><input type="text" name="consignee"
					value="${address.consignee}"></td>
				<td><form:errors path="consignee" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>所在地区:&nbsp;&nbsp;</td>
				<td><input type="text" name="area" value="${address.area}"></td>
				<td><form:errors path="area" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td><input type="text" name="location"
					value="${address.location}"></td>
				<td><form:errors path="location" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td><input type="text" name="phone"
					value="${address.phone}"></td>
				<td><form:errors path="phone" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td><input type="text" name="email"
					value="${address.email}"></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>地址昵称:</td>
				<td><input type="text" name="addrnick"
					value="${address.addrnick}"></td>
				<td><form:errors path="addrnick" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><input type="submit" name="editAddr" value="保存"></td>
			</tr>
		</table>
	</form:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
