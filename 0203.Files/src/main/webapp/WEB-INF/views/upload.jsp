<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>파일 게시판</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>
<body>
	<div class="container">
		<h2>싱글 파일 업로드</h2>
		<form action="fileupload" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<input type="text" class="form-control input-lg" name="writer"
					placeholder="작성자를 입력하세요.">
			</div>
			<div class="form-group">
				<input type="text" class="form-control input-lg" name="title"
					placeholder="제목을 입력하세요">
			</div>
			<div class="thumbnail">
				<div class="caption">
					<input type="file" name="uploadFile" />
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg">upload</button>
			</div>
		</form>
	</div>
</body>
</html>