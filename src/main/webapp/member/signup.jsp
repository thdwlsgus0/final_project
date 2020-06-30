<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=0.25">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href="/recipe/css/header.css" rel="stylesheet"/>
<link href="/recipe/css/footer.css" rel="stylesheet"/>
<link href="/recipe/css/jinhyun.css" rel="stylesheet"/>
<link href="/recipe/css/style.css" rel="stylesheet"/>
<link href="/recipe/css/signup.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="../template/nav.jsp"%>
	<div class="container main_body_color">
		<div class="signup_body">
			<form method="post" action="#" id="signup_form">
				<h4 class="text-center sign_up">회원가입</h4>
				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_ID" id="Mem_ID"
						placeholder="아이디 입력" />
					<!-- <button class="btn btn-primary emailcheck" onclick="">중복체크</button> -->
				</div>
				<div id="id_check"></div>
				<!-- 비밀번호 확인 필요할 듯-->
				<div class="row">
					<input type="password" class="signup_input signup_password form-control"
						name="Mem_password" id="Mem_password" placeholder="비밀번호 입력" />
				</div>
				<div class="row">
					<input type="password" class="signup_input signup_password form-control"
						name="Mem_password2" id="Mem_password2" placeholder="확인 비밀번호 입력" />
				</div>
				<div id="pw_check"></div>
				<!-- 이메일 인증 연동하는거 구현 필요할 듯 -->
				<!-- auth button 추가함 -->
				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_email"
						id="Mem_email" placeholder="이메일" />
					<form action="../email/auth.do">
						<button type="submit" class="btn btn-success authbtn">인증</button>
					</form>
				</div>

				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_age" id="Mem_age"
						placeholder="나이" readonly />
				</div>
				<div id="age_check"></div>
				<div class="row">
					<input type="text" id="Mem_birth" class="signup_input form-control">
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
					<input type="text" class="signup_input form-control" name="Mem_favor"
						id="Mem_favor" placeholder="취향" />
				</div>
				<div class="row input-group">
					<button type="button" class="btn btn-sm btn-success"
						id="btn-gen-male">남자</button>
					<button type="button" class="btn btn-sm btn-default"
						id="btn-gen-female"">여자</button>
					<input type="hidden" id="Mem_gender" class="signup_input" value="남자">
				</div>
				<div class="row">
					<input type="text" class="form-control signup_input" name="Mem_phone"
						id="Mem_phone" placeholder="전화번호를 입력하세요 ex) 01011112222">
				</div>
				<div id="input_check"></div>
				<!-- 회원가입 버튼 크기 변경 -->
				<div class="row">
					<button class="btn btn-success signbtn" type="submit"
						id="btn-register">회원가입 완료</button>
					<!-- onclick="signup_check();" -->
				
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../template/footer.jsp"%>
	<%@ include file="../template/script.jsp"%>
	<script src="../script/mem_regi.js" charset="UTF-8"></script>
	<script src="../script/signup.js" charset="UTF-8"></script>
	<!-- 회원가입 -->
</body>
</html>