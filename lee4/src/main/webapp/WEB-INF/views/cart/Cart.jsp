<%@ include file="../common/IncludeTop.jsp"%>

<div class="other">
	购物车
	<hr />
	<div id="BackLink">
		<a
			href="${pageContext.request.contextPath}/catalog">
			返回主菜单 </a>
	</div>
	<form:form modelAttribute="cartForm"
		action="${pageContext.request.contextPath}/cart/updateCartQuantities">
		<table>
			<tr>
				<th><b>花名</b></th>
				<th><b>花色</b></th>
				<th><b>单价</b></th>
				<th><b>数量</b></th>
				<th><b>小计</b></th>
				<th><b>操作</b></th>
				<th>&nbsp;</th>
			</tr>

			<c:if test="${cart.numberOfItems == 0}">
				<tr>
					<td colspan="8"><b>您的购物车是空的</b></td>
				</tr>
			</c:if>

			<c:forEach var="cartItem" items="${cart.cartItems}">
				<tr>
					<td>${cartItem.flower.flowerName}</td>
					<td><a
					href="${pageContext.request.contextPath}/catalog/viewDetail?flowerName=${cartItem.flower.flowerName}&color=${cartItem.flower.color}">
							${cartItem.flower.color}</a></td>
					<td><fmt:formatNumber value="${cartItem.flower.listPrice}"
							pattern="#,##0.00元" /></td>
					<td><form:input path="quantity[${cartItem.flower.flowerId}]"
							size="3" value="${cartItem.quantity}" /></td>
					<td><fmt:formatNumber value="${cartItem.total}"
							pattern="#,##0.00元" /></td>
					<td><a
						href="${pageContext.request.contextPath}/cart/removeFlowerFromCart?flowerId=${cartItem.flower.flowerId}">
							移出</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">总价: <fmt:formatNumber value="${cart.subTotal}"
						pattern="#,##0.00元" /> <input type="submit" value="更新购物车" /></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form:form>
	<c:if test="${cart.numberOfItems > 0}">
		<a href="${pageContext.request.contextPath}/order/newOrderForm">结算账单</a>
	</c:if>
</div>


<%@ include file="../common/IncludeBottom.jsp"%>