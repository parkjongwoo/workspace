<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 아이템 검색</title>
</head>
<body>
	<h3></h3>
	<form action="searchOrderItem" method="post">
		<input type="text" name="orderitemid"> <input type="submit"	value="검색">
	</form>
	<c:choose>
		<c:when test="${empty orderItem}">
			검색된 아이템이 없습니다.
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>책이름</th>
					<th>책가격</th>
					<th>주문수량</th>
				</tr>
				<tr>
					<td>${orderItem.book.bookName}</td>
					<td>${orderItem.book.price}</td>
					<td>${orderItem.quantity}</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>