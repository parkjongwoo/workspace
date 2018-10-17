<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<title>파일게시판</title>

</head>
<body>
	<div class="container">
		<h2>파일게시판목록</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>파일이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="file" items="${uploadFiles}">
					<tr>
						<td id="fileid">${file.id}</td>
						<td>${file.writer }</td>
						<td>${file.title}</td>
						<td>${file.originalFileName}
						<a href="filedownload?id=${file.id}"><i class="fas fa-download"></i></a>
						<a href="filedelete?id=${file.id}"><i class="fas fa-trash-alt"></i></a>
						<img alt="이미지" src="filedownload?id=${file.id}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="form-group">
			<a href="/file/fileForm">파일업로드하러가기</a>
		</div>
		<br />

	</div>
</html>