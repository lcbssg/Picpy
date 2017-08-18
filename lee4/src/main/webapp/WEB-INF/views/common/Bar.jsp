<div class="top">
	<!-- LOGO -->
	<div id="logo">
		<a href="${pageContext.request.contextPath}/catalog/"> <img
			src="${pageContext.request.contextPath}/resources/images/logo.png"
			height="45px" width="120px">
		</a>
	</div>
	<!-- 快捷菜单 -->
	<div class="bar" id="left">
		<ul>
			<li><a href="${pageContext.request.contextPath}/catalog/">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/catalog/">全部鲜花</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/catalog/viewFlower?flowerName=玫瑰">&nbsp;玫&nbsp;瑰&nbsp;</a></li>
					<li><a
						href="${pageContext.request.contextPath}/catalog/viewFlower?flowerName=康乃馨">康乃馨</a></li>
					<li><a
						href="${pageContext.request.contextPath}/catalog/viewFlower?flowerName=郁金香">郁金香</a></li>
					<li><a
						href="${pageContext.request.contextPath}/catalog/viewFlower?flowerName=满天星">满天星</a></li>
					<li><a
						href="${pageContext.request.contextPath}/catalog/viewFlower?flowerName=勿忘我">勿忘我</a></li>
				</ul></li>

		</ul>
	</div>
	<!-- 购物车用户菜单 -->
	<div class="bar" id="right">
		<ul>
			<li><a href="${pageContext.request.contextPath}/cart/viewCart">购物车</a></li>
			<sec:authorize access="!isAuthenticated()">
				<li><a
					href="${pageContext.request.contextPath}/account/signonForm">登录</a></li>
				<li><a
					href="${pageContext.request.contextPath}/account/newAccountForm">注册账户</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li><a
					href="${pageContext.request.contextPath}/account/signoff">注销</a></li>
				<li><a
					href="${pageContext.request.contextPath}/account/info">我的账户</a></li>
			</sec:authorize>
		</ul>
	</div>
	<!-- 搜索框 -->
	<div class="search">
		<form action="${pageContext.request.contextPath}/catalog/"
			method="post">
			<input type="text" name="keyword" size="14" placeholder="请输入您要搜索的内容" />
			<input type="image" name="searchFlower"
				src="${pageContext.request.contextPath}/resources/images/search.png" />
		</form>
	</div>
</div>