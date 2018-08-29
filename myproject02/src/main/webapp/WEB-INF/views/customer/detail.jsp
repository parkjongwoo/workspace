<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보</h3>
	<form action="update" method="post">
		아이디<input type="text" name="id" value="${customerModel.id }"/><br>
		이름<input type="text" name="name" value="${customerModel.name }"/><br>
		<input type="submit" value="수정"/>
		<a href="delete?id=${customerModel.id}">탈퇴</a>
	</form>
</body>
</html>