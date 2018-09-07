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
<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${not empty msg}">
			alert("${msg}");
		</c:if>
		$("#reset_btn").click(function(){
			$( "form input:text" ).val("");
		});
		
	});
</script>
</head>
<body>
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	
	<main role="main" class="inner cover">
	<h2 class="cover-heading">새 책 등록</h2>	
		<sf:form action="/bookshop/shop/insertBook" method="post" modelAttribute="book">
			<div class="mb-3 form-row">
				<div class="col-12">
					<input type="text" name="bookName" id="bookName" class="form-control" value="${book.bookName}" placeholder="책제목을 입력하세요.">					
					<sf:errors path="bookName" id="bookname_error" class="badge badge-pill badge-danger"/>
				</div>				
			</div>
			
			<div class="mb-3 form-row">
				<div class="col-12">
					<input type="text" name="publisher" id="publisher" class="form-control" value="${book.publisher}" placeholder="저자를 입력하세요.">
					<sf:errors path="publisher" id="publisher_error" class="badge badge-pill badge-danger"/>
				</div>				
			</div>
			
			<div class="mb-3 form-row">
				<div class="col-12">
					<input type="text" name="price" id="price" class="form-control" value="${book.price}" placeholder="가격을 입력하세요.">
					<sf:errors path="price" id="price_error" class="badge badge-pill badge-danger"/>
				</div>				
			</div>
			
			<div class="mb-3 form-row">
				<div class="col-12">
					<textarea type="text" name="description" id="description" class="form-control" value="${book.description}" placeholder="설명을 입력하세요."></textarea>
					<sf:errors path="description" id="description_error" class="badge badge-pill badge-danger"/>
				</div>				
			</div>	
			
			<div class="form-row">
				<div class="col-md-6 mb-sm-3 mb-sm-3 mb-3"><input type="submit" class="form-control btn btn-primary" value="입력하기"></div>
				<div class="col-md-6"><input id="reset_btn" type="button" class="form-control btn btn-secondary" value="초기화"></div>
			</div>		
		</sf:form>
		
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>