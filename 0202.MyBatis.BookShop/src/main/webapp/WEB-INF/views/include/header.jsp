<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="masthead mb-auto">
	<div class="inner">
		<h3 class="masthead-brand">
			<a href="/bookshop">홈</a>
		</h3>
		<nav class="nav nav-masthead justify-content-center">
			<c:choose>
				<c:when test="${empty loginInfo}">
					<a class="nav-link active" href="/bookshop/customer/loginForm">로그인</a>
					<a class="nav-link" href="/bookshop/bookShopping/bookInsertForm">책입력</a>
					<a class="nav-link" href="#">Shopping</a>
				</c:when>
				<c:otherwise>
					<a class="nav-link active" href="/bookshop/customer/logout">로그아웃</a>
					<a class="nav-link" href="/bookshop/bookShopping/bookInsertForm">책입력</a>
					<a class="nav-link" href="#">Shopping</a>
					<a class="nav-link" href="#">MyOrders</a>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>
</header>