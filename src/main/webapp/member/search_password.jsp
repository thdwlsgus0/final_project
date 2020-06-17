<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<%@ include file="../template/header.jsp"%>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="index.do">달달하조</a>
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
	<div class="container">
		<div class="signup_body">
			<form method="post" action="#" id="signup_form">
				<h4 class="text-center sign_up">비밀번호 찾기</h4>
				<div class="row">
					<input type="text" class="form-control" name="Mem_ID" id="Mem_ID"
						placeholder="아이디 입력" />
					<!-- <button class="btn btn-primary emailcheck" onclick="">중복체크</button> -->
				</div>
				<div class="row">
					<input type="text" class="form-control" name="Mem_email"
						id="Mem_email" placeholder="이메일" />
					<form action="../email/auth.do">
						<button type="submit" class="btn btn-success authbtn">인증</button>
					</form>
				</div>
				<div class="row">
					<button class="btn btn-success signbtn" type="submit"
						id="btn-register">비밀번호 찾기</button>
					<!-- onclick="signup_check();" -->
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../template/script.jsp"%>
	<script src="../script/mem_regi.js" charset="UTF-8"></script>
	<script src="../script/signup.js" charset="UTF-8"></script>
	<!-- 회원가입 -->
</body>
</html>