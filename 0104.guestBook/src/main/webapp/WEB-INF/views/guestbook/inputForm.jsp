<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>방명록</title>
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
	<div class="container">
		<h2>방명록 작성</h2>
		<form action="insert" method="post" >
			<div class="form-group">
				<label for="exampleFormControlInput1">이름입력</label> 
				<input type="text" class="form-control" id="name" name="name" >
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">제목입력</label> 
				<input type="text" class="form-control" id="subject" name="subject" >
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">내용입력</label>
				<textarea class="form-control" id="content"  name="content" rows="3"></textarea>
			</div>
			<div class="form-group">
				<input type="submit" value="입력"/>
			</div>
		</form>
	</div>
</body>
</html>