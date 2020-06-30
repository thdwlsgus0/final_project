<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=0.25" />
<title>Insert title here</title>
<!-- 우아한민족 주아체 -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet" />
<link href="css/jinhyun.css" rel="stylesheet" />
<link href="css/login.css" rel="stylesheet" />
<link href="css/header.css" rel="stylesheet" />
<link href="css/footer.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="template/nav.jsp"%>
	<!-- client_id=앱키  redirect_uri=내 uri-->
	<div class="main_body_color container">
		<div class="main_content">
			<div class="row">
				<div class="login_h3">
					<h3 class="text-center">로그인</h3>
				</div>
			</div>
			<form action="">
				<div class="row">
					<div class="text-center">
						<input type="text" size="200" class="login_input" id="mem_id"
							placeholder="아이디를 입력하세요">
					</div>
				</div>
				<div class="row">
					<div class="text-center">
						<input type="text" size="200" class="login_input" id="mem_pw"
							placeholder="비밀번호를 입력하세요">
					</div>
				</div>
				<div class="row">
					<input class="btn btn-success login_btn" type="button" onclick="normal_login();" value="로그인">
				</div>
			</form>


			<div class="row">
				<div class="btn btn-dark">
					<a href="member/signup.do">회원가입</a>
				</div>
				<div class="btn btn-danger">
					<a href="member/search_password.do">비밀번호찾기</a>
				</div>
			</div>

			<div class="row">
				<a href="${url}"> <img src="img/NaverLogin.png">
				</a>
			</div>

			<div class="row">
				<a href="#" onclick="google_login(true);"> <img src="img/GoogleLogin.png">
				</a>
			</div>
		</div>
	</div>
	<%@ include file="template/footer.jsp"%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="/recipe/script/google_sign.js"></script>
	<script src="https://apis.google.com/js/platform.js?onload=google_init" async defer></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
