<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화 구매 목록</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<link href="/bookshop/resources/css/cover.css" rel="stylesheet">
</head>
<body>
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	
	<main role="main" class="inner cover">
	<h2 class="cover-heading">책 검색</h2>	
		<form action="/bookshop/bookShopping/searchBook" method="get" class="form-inline">
			<div class="form-group">
				<label>
				<input type="text" name="bookName"  class="form-control ml-1 col-md-6" placeholder="책제목검색.">
				</label>			
				<label>
				<input type="text" name="publisher"  class="form-control ml-1 col-md-6" placeholder="출판사검색.">
				</label>			
				<label>
				<input type="text" name="priceMin"  class="form-control ml-1 col-md-6" placeholder="최저가검색.">
				</label>
				-		
				<label>
				<input type="text" name="priceMax"  class="form-control ml-1 col-md-6" placeholder="최고가검색.">
				</label>			
				<input type="submit"  class="btn btn-primary ml-1 col-md-2" value="검색">
				
			</div>
		</form>
		<form action="/bookshop/customer/phone" method="post" >
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">책이름</th>
					<th scope="col">출판사</th>
					<th scope="col">가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${phoneItems}" varStatus="s">
					<tr>
						<td scope="row"><input type="text" name="phones[${s.index}].id" value="${item.id}"/></td>
						<td scope="row"><input type="text" name="phones[${s.index}].name" value="${item.name}"/></td>
						<td scope="row"><input type="text" name="phones[${s.index}].quantity" value="${item.quantity}"/></td>						
					</tr>
				</c:forEach>
				<c:if test="${empty phoneItems}">
					<tr>
						<td colspan="3">검색결과가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<input type="submit"  class="btn btn-primary ml-1 col-md-2" value="주문">
		</form>
		
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>