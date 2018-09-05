<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
<link href="/bookshop/resources/css/signin.css" rel="stylesheet">
</head>
<body>
	<form action="/bookshop/customer/login" method="post" class="form-signin">      
      <h1 class="h3 mb-3 font-weight-normal">로그인</h1>
      <label for="inputEmail" class="sr-only">아이디</label>
      <input type="text" id="id" name="id" class="form-control" placeholder="아이디" required autofocus>
      <label for="inputPassword" class="sr-only">비밀번호</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호" required>
<!--       <div class="checkbox mb-3"> -->
<!--         <label> -->
<!--           <input type="checkbox" value="remember-me"> 로그인 정보 기억하기 -->
<!--         </label> -->
<!--       </div> -->
      <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>
</body>
</html>