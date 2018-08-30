<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사용자 목록</h3>
<ul>
	<c:forEach var="item" items="${customers}">
	<li>id:${item.id }: <a href="detail?id=${item.id}">name:${item.name}</a></li>
	</c:forEach>
</ul>
</body>
</html>