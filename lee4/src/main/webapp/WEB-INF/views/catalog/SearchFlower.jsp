<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="${pageContext.request.contextPath}/catalog">返回主菜单</a>
</div>

<div id="Catalog">
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
                <td>${flower.color}</td>
                <td>${flower.flowerLang}</td>
                <td>${flower.listPrice}</td>
                <td><a href="${pageContext.request.contextPath}/cart/addItemToCart?workingItemId=${item.itemId}">加入购物车</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>