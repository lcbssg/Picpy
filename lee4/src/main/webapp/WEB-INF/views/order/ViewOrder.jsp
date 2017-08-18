<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="${pageContext.request.contextPath}/catalog">返回主菜单</a>
</div>

<div id="Catalog">
    <table>
        <tr>
            <th align="center" colspan="2">订单 #${order.orderId}
                <fmt:formatDate value="${order.orderDate}"
                    pattern="yyyy/MM/dd hh:mm:ss" />
            </th>
        </tr>
        <tr>
            <th colspan="2">收货地址</th>
        </tr>
        <tr>
            <td>收货人:</td>
            <td>${order.consignee}</td>
        </tr>
        <tr>
            <td>所在地区:</td>
            <td>${order.area}</td>
        </tr>
        <tr>
            <td>详细地址:</td>
            <td>${order.location}</td>
        </tr>
        <tr>
            <td>联系方式:</td>
            <td>${order.phone}</td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td>${order.email}</td>
        </tr>
        <tr>
            <td>地址昵称:</td>
            <td>${order.addrnick}</td>
        </tr>
        <tr>
            <td>快递公司:</td>
            <td>${order.courier}</td>
        </tr>
        <tr>
            <td colspan="2">状态: ${order.status}</td>
        </tr>
        <tr>
            <td colspan="2">
                <table>
                    <tr>
                        <th>花名</th>
                        <th>花色</th>
                        <th>数量</th>
                        <th>价格</th>
                    </tr>
                    <c:forEach var="line" items="${order.line}">
                        <tr>
                            <td>${line.flower.flowerName}</td>
                            <td><a
					href="${pageContext.request.contextPath}/catalog/viewDetail?flowerName=${line.flower.flowerName}&color=${line.flower.color}">
							${line.flower.color}</a></td>
                            <td>${line.quantity}</td>
                            <td><fmt:formatNumber
                                    value="${line.unitPrice}"
                                    pattern="#,##0.00元" /></td>
                            <td><fmt:formatNumber
                                    value="${line.total}"
                                    pattern="#,##0.00元" /></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th colspan="5">总计: <fmt:formatNumber
                                value="${order.totalPrice}"
                                pattern="#,##0.00元" /></th>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
