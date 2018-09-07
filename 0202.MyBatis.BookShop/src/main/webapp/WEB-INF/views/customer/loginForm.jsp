<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="/WEB-INF/views/include/header_head.jsp" />
<link href="/bookshop/resources/css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<main role="main" class="inner cover">
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
    </main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />

	</div>
</body>
</html>