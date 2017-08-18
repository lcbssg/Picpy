<%@ include file="../common/IncludeTop.jsp"%>

<div id="info">
	收货地址 
	<a href="${pageContext.request.contextPath}/catalog">&nbsp;&nbsp;返&nbsp;&nbsp;回</a>
	<a href="${pageContext.request.contextPath}/order/listOrders">查看订单</a>
	<a href="${pageContext.request.contextPath}/account/editAccountForm">修改密码</a>
	<a href="${pageContext.request.contextPath}/account/editAddrForm">编辑地址</a>
	<hr />
	<table>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>收货人:</td>
			<td>${address.consignee}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>所在地区:&nbsp;&nbsp;</td>
			<td>${address.area}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>详细地址:</td>
			<td>${address.location}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>联系电话:</td>
			<td>${address.phone}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td>${address.email}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>地址昵称:</td>
			<td>${address.addrnick}</td>
		</tr>
	</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
