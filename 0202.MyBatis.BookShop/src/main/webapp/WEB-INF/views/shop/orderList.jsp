<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 책 등록</title>
<jsp:include page="/WEB-INF/views/include/header_head.jsp" />
</head>
<body>
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	
	<main role="main" class="inner cover">
	<h2 class="cover-heading">내 주문 검색</h2>	
		<form action="/bookshop/shop/searchBook" method="get" modelAttribute="bookCondition" class="form-inline">
			<div class="form-row align-items-center">
				<div class="col-auto my-1"><button type="button" class="btn btn-primary">6개월</button></div>			
				<div class="col-auto my-1"><button type="button" class="btn btn-primary">3개월</button></div>			
			</div>
		</form>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">주문번호</th>
					<th scope="col">주문일자</th>
					<th scope="col">결제금액</th>
					<th scope="col">결제수단</th>
					<th scope="col">배송여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${orderList}" varStatus="s">
					<tr>
						<td scope="row">${item.orderid}</td>
						<td scope="row">${item.orderDate}</td>
						<td scope="row">${item.amount}</td>										
						<td scope="row">${item.payOption}</td>										
						<td scope="row">${item.sendYN}</td>										
					</tr>
				</c:forEach>
				<c:if test="${empty orderList}">
					<tr>
						<td colspan="5">검색결과가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>