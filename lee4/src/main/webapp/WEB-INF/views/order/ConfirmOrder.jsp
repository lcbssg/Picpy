<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="${pageContext.request.contextPath}/catalog">返回主菜单</a>
</div>

<div id="Catalog">
    	请确认下方信息，然后点击continue...
    <form:form modelAttribute="orderForm"
        action="${pageContext.request.contextPath}/order/newOrder">
        <table>
            <tr>
                <th align="center" colspan="2"><font size="4"><b>订单</b></font>
                    <br /> <font size="3"><b> <fmt:formatDate
                                value="${order.orderDate}"
                                pattern="yyyy/MM/dd hh:mm:ss" /></b></font></th>
            </tr>
            <tr>
                <th colspan="2">收货地址</th>
            </tr>
			<tr>
				<td>收货人:</td>
				<td>${orderForm.consignee}<form:hidden
                        path="consignee" /></td>
			</tr>
			<tr>
				<td>所在地区:&nbsp;&nbsp;</td>
				<td>${orderForm.area}<form:hidden
                        path="area" /></td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td>${orderForm.location}<form:hidden
                        path="location" /></td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td>${orderForm.phone}<form:hidden
                        path="phone" /></td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>${orderForm.email}<form:hidden
                        path="email" /></td>
			</tr>
			<tr>
				<td>地址昵称:</td>
				<td>${orderForm.addrnick}<form:hidden
                        path="addrnick" /></td>
			</tr>
			<tr>
				<td>快递公司:</td>
				<td>${orderForm.courier}<form:hidden
                        path="courier" /></td>
			</tr>

        </table>
        <input type="hidden" name="confirmed" value="true" />
        <input type="submit" value="Confirm">
    </form:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>