<%@ include file="../common/IncludeTop.jsp"%>

<div class="other">
	${flower.color}${flower.flowerName}
	<hr />
	<div id="BackLink">
		<a
			href="${pageContext.request.contextPath}/catalog/viewFlower?flowerName=${flower.flowerName}">
			返回上一级</a>
	</div>
	<table>
		<tr>
			<td><img src="../resources/images/${flower.img}"/></td>
		</tr>
		<tr>
			<td><b> ${flower.profile} </b></td>
		</tr>
		<tr>
			<td><b>${flower.flowerLang}</b></td>
		</tr>
		<c:if test="${flower.quantity <= 0}">
			<tr>
				<td>您所在地区无货</td>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${flower.listPrice}"
						pattern="#,##0.00元" /></td>
			</tr>
			<tr>
				<td>敬请期待！</td>
			</tr>
		</c:if>
		<c:if test="${flower.quantity > 0}">
			<tr>
				<td>商品库存：${flower.quantity}</td>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${flower.listPrice}"
						pattern="#,##0.00元" /></td>
			</tr>
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/cart/addFlowerToCart?flowerId=${flower.flowerId}">
						加入购物车 </a></td>
			</tr>
		</c:if>

	</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>