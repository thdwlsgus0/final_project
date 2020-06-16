<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@ include file="../template/header.jsp"%>
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
	<div class="signup_body">
		<div class="container">
			<form method="post" action="#" id="signup_form">
				<h1 class="signup_h1">회원가입</h1>
				<div class="row">
					<input type="text" name="Mem_ID" id="Mem_ID" placeholder="아이디 입력" />
					<!-- <button class="btn btn-primary emailcheck" onclick="">중복체크</button> -->
				</div>
				<div id="id_check"></div>
				<!-- 비밀번호 확인 필요할 듯-->
				<div class="row">
					<input type="text" name="Mem_password" id="Mem_password"
						placeholder="비밀번호 입력" />
				</div>
				<div class="row">
					<input type="text" name="Mem_password2" id="Mem_password2"
						placeholder="확인 비밀번호 입력" />
				</div>
				<div id="pw_check"></div>
				<!-- 이메일 인증 연동하는거 구현 필요할 듯 -->
				<!-- auth button 추가함 -->
				<div class="row">
					<input type="text" name="Mem_email" id="Mem_email"
						placeholder="이메일" />
					<form action="../email/auth.do">
						<button type="submit" class="btn btn-success authbtn">인증</button>
					</form>
				</div>

				<div class="row">
					<input type="text" name="Mem_age" id="Mem_age" placeholder="나이" />
				</div>
				<div id="age_check"></div>
				<div class="row">
					<input type="date" id="Mem_birth">
					<!-- <span class="ps_box">
						<input type="text" name="Mem_birth_yy" id="Mem_birth_yy" placeholder="연" />
					</span>
					<span class="ps_box"> 
						<input type="text" name="Mem_birth_mm" id="Mem_birth_mm" placeholder="월" /> 
						<select id="Mem_birth_mm" aria-label="월">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
					</span>
					<span class="ps_box">
						<input type="text" name="Mem_birth_dd" id="Mem_birth_dd" placeholder="일" />
					</span> -->
				</div>
				<div class="row">
					<input type="text" name="Mem_favor" id="Mem_favor" placeholder="취향" />
				</div>
				<div class="row input-group">
					<button type="button" class="btn btn-sm btn-success"
						id="btn-gen-male">남자</button>
					<button type="button" class="btn btn-sm btn-default"
						id="btn-gen-female"">여자</button>
					<input type="hidden" id="Mem_gender" value="남자">
				</div>
				<div class="row">
					<input type="text" name="Mem_phone" id="Mem_phone"
						placeholder="전화번호를 입력하세요 ex) 01011112222">
				</div>
				<div id="input_check"></div>
				<!-- 회원가입 버튼 크기 변경 -->
				<div class="row">
					<button class="btn btn-success signbtn" type="submit" id="btn-register">회원가입 완료</button>
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