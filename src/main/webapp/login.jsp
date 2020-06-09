<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 우아한민족 주아체 -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet" />
<link href="css/jinhyun.css" rel="stylesheet" />
<link href="css/login.css" rel="stylesheet"/>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">달달하조</a>
			<button
				class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="../loginForm.do">로그인</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="signup.do">회원가입</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="contact.do">관리자에게 문의</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- client_id=앱키  redirect_uri=내 uri-->
	<div class="login_body">
		<div class="container">
			<div class="row">
				<div class="login_h3">
					<h3 class="text-center">로그인</h3>
				</div>
			</div>
			<div class="row">
				<div class="text-center">
					<input type="text" size="100" placeholder="아이디를 입력하세요">
				</div>
			</div>
			<div class="row">
				<div class="text-center">
					<input type="text" size="100" placeholder="비밀번호를 입력하세요">
				</div>
			</div>
			<div class="row">
			    <div class="btn btn-success login_btn">로그인</div>
			</div>
			<div class="row">
				<div class="btn btn-default">
					<a href="http://localhost:8090/recipe/member/signup.jsp">회원가입</a>
				</div>
				<div class="btn btn-primary">
				        비밀번호찾기
				</div>
			</div>
			
			<div class="row">
				<c:if test="${userId eq null}">
					<a
						" href="https://kauth.kakao.com/oauth/authorize?client_id=1356aced5c32878850cc1596142752e4&redirect_uri=http://localhost:8090/recipe/login.do&response_type=code">
						<img src="img/KakaotalkLogin.png">
					</a>
				</c:if>
				<c:if test="${userId ne null}">
					<h1>로그인 성공입니다</h1>
				</c:if>
			</div>
			<div class="row">
				<a href=""> <img src="img/NaverLogin.png">
				</a>
			</div>

			<div class="row">
				<a href=""> <img src="img/FacebookLogin.png">
				</a>
			</div>

			<div class="row">
				<a href=""> <img src="img/GoogleLogin.png">
				</a>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
