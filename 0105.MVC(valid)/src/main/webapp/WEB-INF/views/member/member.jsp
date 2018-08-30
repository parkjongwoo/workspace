<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
	<div  class="container">
	<h1>회원가입</h1>
	<%-- form 태그 사용하여 modelAttribute annotation 효과 --%> 
	<%-- errors 태그 사용하여 애러발생시 추가될 html 코드 작성 --%>
	<%-- errors 태그중 path는 관련 변수명, 이외는 html 태그 속성임 --%>
	<sf:form action="member" method="post" modelAttribute="member">
		<fieldset>
			<table class="table">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" value="${member.id}">
						<sf:errors path="id" id="id_error"  class="badge badge-pill badge-danger"/>
					
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td>
						<input type="text" name="password" value="${member.password}">
						<sf:errors path="password" class="badge badge-pill badge-danger"/>	
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email" value="${member.email}">
						<sf:errors path="email" class="badge badge-pill badge-danger"/>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="가입승낙"></td>
				</tr>
			</table>
		</fieldset>
	</sf:form>
	</div>
</body>
</html>