<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<sf:form action="member" method="post">
		<fieldset>
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" value="${member.id}"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="text" name="password" value="${member.password}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${member.email}"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="가입승낙"></td>
				</tr>
			</table>
		</fieldset>
	</sf:form>
</body>
</html>