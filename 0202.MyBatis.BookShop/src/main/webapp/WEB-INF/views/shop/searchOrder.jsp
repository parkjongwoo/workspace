<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 아이템 검색</title>
<jsp:include page="/WEB-INF/views/include/header_head.jsp" />
</head>
<body>
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	
	<main role="main" class="inner cover">
	<h3>주문목록</h3>
	<form action="searchOrder" method="post">
		<input type="text" name="orderid"> <input type="submit"	value="검색">
	</form>
	<c:choose>
		<c:when test="${empty order}">
			검색된 주문이 없습니다.
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr>
					<th>주문번호</th>
					<th>주문자명</th>
					<th>주소</th>
					<th>주문일</th>
					<th>결제금액</th>
					<th>배송여부</th>
					<th>결제수단</th>
					<th>책이름</th>				
					<th>단가</th>				
					<th>수량</th>			
				</tr>
				<c:forEach var="orderItem" items="${order.orderItemList}" varStatus="s">
				<c:choose>
					<c:when test="${s.first}">
					<tr>
						<td rowspan="${order.orderItemList.size()}">${order.orderid}</td>
						<td rowspan="${order.orderItemList.size()}">${order.customer.name}</td>
						<td rowspan="${order.orderItemList.size()}">${order.customer.address}</td>
						<td rowspan="${order.orderItemList.size()}">${order.orderDate}</td>
						<td rowspan="${order.orderItemList.size()}">${order.amount}</td>
						<td rowspan="${order.orderItemList.size()}">${order.sendYN}</td>
						<td rowspan="${order.orderItemList.size()}">${order.payOption}</td>
						<td>${orderItem.book.bookName}</td>
						<td>${orderItem.book.price}</td>
						<td>${orderItem.quantity}</td>							
					</tr>
					</c:when>
					<c:otherwise>
					<tr>						
						<td>${orderItem.book.bookName}</td>
						<td>${orderItem.book.price}</td>
						<td>${orderItem.quantity}</td>							
					</tr>
					</c:otherwise>
				</c:choose>
				</c:forEach>
<%-- 				<c:forEach var="book" items="${order.orderItemList}" varStatus="s"> --%>
<!-- 				<tr> -->
<%-- 					<td>${order.customer.name}</td> --%>
<%-- 					<td>${order.customer.address}</td> --%>
<%-- 					<td>${order.orderDate}</td> --%>
<%-- 					<td>${order.amount}</td> --%>
<%-- 					<td>${order.sendYN}</td> --%>
<%-- 					<td>${order.payOption}</td> --%>
<!-- 				</tr> -->
<%-- 				</c:forEach> --%>
			</table>
		</c:otherwise>
	</c:choose>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>