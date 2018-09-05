<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/include/header_head.jsp" />
</head>
<body>
	<!-- 	<a href="bookShopping/searchOrderItem">ì£¼ë¬¸ìíëª©ë¡</a> -->
	<!-- 	<a href="bookShopping/searchOrder">ì£¼ë¬¸ëª©ë¡</a> -->
	<!-- <a href="customer/beforeSession">ë¡ê·¸ì¸ì </a> -->
	<!-- <a href="customer/afterSession">ë¡ê·¸ì¸í</a> -->
	<!-- <a href="customer/removeSession">ì¸ìì ë³´ì­ì </a> -->

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<main role="main" class="inner cover">
		<h1 class="cover-heading">재미로 만드는 온라인 서점</h1>
		<p class="lead">연습을 위해 만들었으므로 부족한 점이 많은 쇼핑몰 입니다.</p>
		<p class="lead">
			<a href="#" class="btn btn-lg btn-secondary">Learn more</a>
		</p>
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />

	</div>

</body>
</html>