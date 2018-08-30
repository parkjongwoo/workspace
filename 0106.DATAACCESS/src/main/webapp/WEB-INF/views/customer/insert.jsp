<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/daumAddr.js"></script>

</head>
<body>
	<div class="container">
	<h2 class="mb-3 mt-3">회원가입</h2>		
		<form action="customer_save" method="post">
			<div class="mb-3"><input type="text" name="id" class="form-control" placeholder="아이디를 입력하세요."></div>
			<div class="mb-3"><input type="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요."></div>
			<div class="mb-3"><input type="password" name="repassword" class="form-control" placeholder="비밀번호를 다시 입력하세요."></div>
			<div class="mb-3"><input type="text" name="name" class="form-control" placeholder="이름을 입력하세요."></div>
			
			<div class="row">
			
			<div class="col-md-6 mb-3"><input type="text" id="sample6_postcode" class="form-control" name="postcode" placeholder="우편번호"></div>
			<div class="col-md-6 mb-3"><input type="button" class="form-control" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></div>
			
			</div>
			<div class="mb-3"></div>
			<div class="mb-3"><input type="text" id="sample6_address" class="form-control" name="address" placeholder="주소"></div>
			<div class="mb-3"><input type="text" id="sample6_address2" class="form-control" name="address2" placeholder="상세주소"></div>
			
			<div class="mb-3"><input type="tel" name="phone" class="form-control" placeholder="전화번호를 입력하세요."></div>
			<div class="mb-3"><input type="email" name="email" class="form-control" placeholder="이메일를 입력하세요."></div>
			
			<input type="submit" class="form-control btn btn-primary" value="전송">
		</form>
		
	</div>
</body>
</html>