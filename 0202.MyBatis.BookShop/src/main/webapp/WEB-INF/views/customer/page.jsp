<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>방명록</title>
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
</head>
<body>
	<div class="container">
		<h2>방명록 목록</h2>
		<form action="customer/search" method="get">
			<div class="form-group">
				<div class="form-row">
				<select name="type" class="form-control col-md-3">
					<option value="이름">이름</option>
					<option value="아이디">아이디</option>
				</select>
				<input type="text" name="searchWord"  class="form-control ml-1 col-md-6" placeholder="검색어를 입력하세요.">
				<input type="submit"  class="btn btn-primary ml-1 col-md-2" value="검색">
				</div>
			</div>
		</form>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">아이디</th>
					<th scope="col">이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${customers}">
					<tr>
						<th scope="row">${item.id}</th>
						<td><a href="customer/detail?customerid=${item.customerid}">${item.name}</a></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination  justify-content-center">				
				<li class="page-item <c:if test="${selectPage<=1}">disabled</c:if>">
			    	<a class="page-link" href="customer/page?selectPage=${selectPage-1}" aria-label="Previous">
			        	<span aria-hidden="true">&laquo;</span>
			        	<span class="sr-only">Previous</span>
			      	</a>
			    </li>				
				<c:forEach varStatus="idx" begin="${firstPageNum}" end="${lastPageNum}">
					<li class="page-item <c:if test="${selectPage== idx.current}">active</c:if>"><a class="page-link" href="customer/page?selectPage=${idx.current}">${idx.current}</a></li>
				</c:forEach>				
				<li class="page-item <c:if test="${selectPage>=pageCount}">disabled</c:if>">
			      	<a class="page-link" href="page?selectPage=${selectPage+1}" aria-label="Next">
			        	<span aria-hidden="true">&raquo;</span>
			        	<span class="sr-only">Next</span>
			      	</a>
			    </li>				
			</ul>
		</nav>
		<a href="customer/customer_save">가입하기</a>		
	</div>
</body>
</html>