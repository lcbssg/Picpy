<%@ include file="../common/IncludeTop.jsp"%>

<div id="info">
	收货地址 
	<hr />
	<form:form modelAttribute="orderForm"
		action="${pageContext.request.contextPath}/order/newOrder">
		<table>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>收货人:</td>
				<td><input type="text" name="consignee"
					value="${order.consignee}"></td>
				<td><form:errors path="consignee" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>所在地区:&nbsp;&nbsp;</td>
				<td><input type="text" name="area" value="${order.area}"></td>
				<td><form:errors path="area" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td><input type="text" name="location"
					value="${order.location}"></td>
				<td><form:errors path="location" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td><input type="text" name="phone"
					value="${order.phone}"></td>
				<td><form:errors path="phone" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td><input type="text" name="email"
					value="${order.email}"></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>地址昵称:</td>
				<td><input type="text" name="addrnick"
					value="${order.addrnick}"></td>
				<td><form:errors path="addrnick" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>快递公司:</td>
				<td><input type="text" name="courier"
					value="${order.courier}"></td>
				<td><form:errors path="courier" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><input type="submit" name="newOrder" value="继续"></td>
			</tr>
		</table>
	</form:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>