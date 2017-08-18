<%@ include file="../common/IncludeTop.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
        <c:if test="${sessionScope.accountBean != null }">
            <c:if test="${sessionScope.accountBean.authenticated}">
        欢迎你 ${sessionScope.accountBean.account.firstName}!
      </c:if>
        </c:if>
    </div>
</div>


<%@ include file="../common/IncludeBottom.jsp"%>