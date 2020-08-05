<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-4">
			<h3>모서리가 라운딩 처리된 이미지</h3>
			<img src="../resources/images/sample.jpg" alt="펭귄" width="100%" class="rounded" />
		</div>
		<div class="col-4">
			<h3>동그랗게 표시되는 이미지</h3>
			<img src="../resources/images/sample.jpg" alt="펭귄" width="100%" class="rounded-circle" />
		</div>
		<div class="col-4">
			<h3>바깥 테두리가 있는 이미지</h3>
			<img src="../resources/images/sample.jpg" alt="펭귄" width="100%" class="img-thumbnail" />
		</div>
	</div>
	<div class="row">
		<div class="col-12">
		<p>
			<img src="../resources/images/sample.jpg" alt="펭귄" width="200" class="img-thumbnail" />
			어쩌구저쩌구 블라블라어쩌구저쩌구 블라블라어쩌구저쩌구 블라블라어쩌구저쩌구 블라블라어쩌구저쩌구 블라블라어쩌구저쩌구
		</p>
		</div>
	</div>
	<div class="row text-right">
		<div class="col-12">
			<img src="../resources/images/sample.jpg" alt="펭귄" width="200" class="img-thumbnail" />
		</div>
	</div>
	<div class="row">
		<div class="col-12 text-center">
			<img src="../resources/images/sample.jpg" alt="펭귄" width="200" class="img-thumbnail" />
		</div>
	</div>
</div>
</body>
</html>