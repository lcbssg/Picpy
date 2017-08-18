<%@ include file="../common/IncludeTop.jsp"%>

<div id="info">
	我的订单 
	<a href="${pageContext.request.contextPath}/account/info">&nbsp;&nbsp;返&nbsp;&nbsp;回</a>
	<a href="${pageContext.request.contextPath}/order/listOrders">查看订单</a>
	<a href="${pageContext.request.contextPath}/account/editAccountForm">修改密码</a>
	<a href="${pageContext.request.contextPath}/account/editAddrForm">编辑地址</a>
	<hr />
</div>

<div id="listOrder">
	<table>
		<tr>
			<th>订单编号</th>
			<th>交易时间</th>
			<th>总价</th>
		</tr>
		
		<c:forEach var="order" items="${orderList}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/order/viewOrder?orderId=${order.orderId}">${order.orderId}</a></td>
				<td><fmt:formatDate value="${order.orderDate}"
						pattern="yyyy/MM/dd hh:mm:ss" /></td>
				<td><fmt:formatNumber value="${order.totalPrice}"
						pattern="#,##0.00元" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>