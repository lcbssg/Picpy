<%@ include file="../common/IncludeTop.jsp"%>

<div class="other">
	${flowerName}
	<hr />
	<div id="BackLink">
		<a href="${pageContext.request.contextPath}/catalog"> 返回主菜单 </a>
	</div>
	<table>
		<tr>
			<th>花名</th>
			<th>花色</th>
			<th>花语</th>
			<th>单价</th>
			<th>操作</th>
		</tr>
		<c:forEach var="flower" items="${flowerList}">
			<tr>
				<td>${flower.flowerName}</td>
				<td><a
					href="${pageContext.request.contextPath}/catalog/viewDetail?flowerName=${flower.flowerName}&color=${flower.color}">
					${flower.color}</a></td>
				<td>${flower.flowerLang}</td>
				<td><fmt:formatNumber value="${flower.listPrice}"
						pattern="#,##0.00元" /></td>
				<td><a
					href="${pageContext.request.contextPath}/cart/addFlowerToCart?flowerId=${flower.flowerId}">
						加入购物车</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>