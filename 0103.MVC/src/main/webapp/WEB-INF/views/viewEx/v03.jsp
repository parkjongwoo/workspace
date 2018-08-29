<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<p>호출된 controller name 은 ${requestMethodName} 입니다.</p>
<ul>
	<c:forEach var="item" items="${custommerList}">
		<li>이름:${item.name}, 주소:${item.addr}</li>
	</c:forEach>
</ul>

</body>
</html>