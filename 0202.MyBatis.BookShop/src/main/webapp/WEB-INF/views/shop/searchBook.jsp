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
	<h2 class="cover-heading">책 검색</h2>	
		<form action="/bookshop/shop/searchBook" method="get" modelAttribute="bookCondition" class="form-inline">
			<div class="form-group">
				<label>
				<input type="text" name="bookName" value="${bookCondition.bookName}" class="form-control ml-1 col-md-6" placeholder="책제목검색.">
				</label>			
				<label>
				<input type="text" name="publisher" value="${bookCondition.publisher}" class="form-control ml-1 col-md-6" placeholder="출판사검색.">
				</label>			
				<label>
				<input type="text" name="priceMin" value="${bookCondition.priceMin}" class="form-control ml-1 col-md-6" placeholder="최저가검색.">
				</label>
				-		
				<label>
				<input type="text" name="priceMax" value="${bookCondition.priceMax}" class="form-control ml-1 col-md-6" placeholder="최고가검색.">
				</label>			
				<input type="submit"  class="btn btn-primary ml-1 col-md-2" value="검색">
				
			</div>
		</form>
		<form action="/bookshop/shop/insertOrder" method="post" modelAttribute="order">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">책이름</th>
					<th scope="col">출판사</th>
					<th scope="col">가격</th>
					<th scope="col">수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${bookList}" varStatus="s">
					<tr>
						<td scope="row">${item.bookName}</td>
						<td scope="row">${item.publisher}</td>
						<td scope="row">${item.price}</td>						
						<td scope="row">
							<input type="text" name="orderItemList[${s.index}].quantity" value="0">
							<input type="hidden" name="orderItemList[${s.index}].book.bookid" value="${item.bookid}">
							<input type="hidden" name="orderItemList[${s.index}].book.bookName" value="${item.bookName}">
							<input type="hidden" name="orderItemList[${s.index}].book.price" value="${item.price}">
						</td>						
					</tr>
				</c:forEach>
				<c:if test="${empty bookList}">
					<tr>
						<td colspan="3">검색결과가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<input type="submit"  class="btn btn-primary ml-1 col-md-2" value="검색">
		</form>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>