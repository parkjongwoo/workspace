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
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#fileupload").submit(function(event) {
			event.preventDefault();
			console.log("fileupload");
			var form = $('#fileupload')[0];
			//var form = $(event.taget)[0];
			console.log(form);
		    var data = new FormData(form);
		    $.ajax({
	            type: 'POST',
	            enctype: 'multipart/form-data',
	            url: '/file/fileupload',
	            data: data,
	            processData: false,
	            contentType: false,
	            cache: false,
	            timeout: 600000,
	            success: function (data) {

	                $("#result").text(data);
	                var imgtag = $("<img />");
	                imgtag.attr("src", data.data);
	                $("#result").append(imgtag);
	                console.log("SUCCESS : ", data);

	            },
	            error: function (e) {
	                $("#result").text(e.responseText);
	                console.log("ERROR : ", e);
	            }
	        });
			/* $.post({
				url : '/file/fileupload',
				dataType: 'multipart/form-data',
				success : function(res) {
 					console.log(JSON.stringify(res));
					
				}
			}); */
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2>싱글 파일 업로드</h2>
		<form id="fileupload" action="fileupload" method="post" enctype="multipart/form-data">
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
			<div id="result"></div>
		</form>
	</div>
</body>
</html>