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
		<h1 class="cover-heading">${message}</h1>
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />

	</div>

</body>
</html>