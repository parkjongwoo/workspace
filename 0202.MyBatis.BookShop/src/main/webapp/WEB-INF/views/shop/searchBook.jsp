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
	<fieldset>
		<form action="/bookshop/shop/searchBook" method="get" modelAttribute="bookCondition" >
			<div class="form-row">
				<div class="form-group col-sm-6 col-md-6">
				<label for="bookName">책이름검색</label>
				<input type="text" name="bookName" id="bookName" value="${bookCondition.bookName}" class="form-control-sm col" placeholder="책제목검색.">
				</div>
				<div class="form-group col-sm-6 col-md-6">					
				<label for="publisher">출판사검색</label>
				<input type="text" name="publisher" id="publisher" value="${bookCondition.publisher}" class="form-control-sm col" placeholder="출판사검색.">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-sm-6 col-md-6">
				<label for="priceMin">최저가격</label>
				<input type="text" name="priceMin" id="priceMin" value="${bookCondition.priceMin}" class="form-control-sm col" placeholder="최저가검색.">
				</div>				
				<div class="form-group col-sm-6 col-md-6">
				<label for="priceMax">최고가격</label>
				<input type="text" name="priceMax" id="priceMax" value="${bookCondition.priceMax}" class="form-control-sm col" placeholder="최고가검색.">
				</div>					
			</div>
			<div class="form-row">
				<div class="form-group col-12">
					<input type="submit"  class="btn btn-primary form-control col-12" value="검색">
				</div>
			</div>
		</form>
	</fieldset>
		<form action="/bookshop/shop/insertOrder" method="post" modelAttribute="order">
		<table class="table table-bordered">
			<thead>
				<tr class="d-flex">
					<th scope="col" class="col-md-4">책이름</th>
					<th scope="col" class="col-md-3">출판사</th>
					<th scope="col" class="col-md-3">가격</th>
					<th scope="col" class="col-md-2">수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${bookList}" varStatus="s">
					<tr class="d-flex">
						<td scope="row" class="col-md-4">${item.bookName}</td>
						<td scope="row" class="col-md-3">${item.publisher}</td>
						<td scope="row" class="col-md-3">${item.price}</td>						
						<td scope="row" class="col-md-2">
							<input type="text" name="orderItemList[${s.index}].quantity" value="0" class="col-12">
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
		<div class="form-row">
			<div class="form-group col-12">
			<input type="submit"  class="btn btn-primary col-12" value="구매">
			</div>
		</div>
		</form>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>