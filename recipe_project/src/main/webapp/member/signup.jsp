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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<link href="/recipe/css/header.css" rel="stylesheet"/>
<link href="/recipe/css/footer.css" rel="stylesheet"/>
<link href="/recipe/css/jinhyun.css" rel="stylesheet"/>
<link href="/recipe/css/style.css" rel="stylesheet"/>
<link href="/recipe/css/signup.css" rel="stylesheet"/>
<style type="text/css">input[readonly='readonly']{background-color: #b1b9bd;}</style>
</head>
<body>
	<%@ include file="../template/nav.jsp"%>
	<div class="container main_body_color">
		<div class="signup_body">
			<form action="#">
				<h4 class="text-center sign_up">회원가입</h4>
				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_ID" id="Mem_ID"
						placeholder="아이디 입력" value="${regi_name}" />
				</div>
				<div id="id_check"></div>
				<div class="row">
					<input type="password" class="signup_input signup_password form-control"
						name="Mem_password" id="Mem_password" placeholder="비밀번호 입력" />
				</div>
				<div class="row">
					<input type="password" class="signup_input signup_password form-control"
						name="Mem_password2" id="Mem_password2" placeholder="확인 비밀번호 입력" />
				</div>
				<div id="pw_check"></div>
				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_email" id="Mem_email" placeholder="이메일" value="${regi_email}" />
				</div>

				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_age" id="Mem_age"
						placeholder="나이" readonly />
				</div>
				<div id="age_check"></div>
				<div class="row">
					<input type="text" id="Mem_birth" class="signup_input form-control">
				</div>
				<div class="row">
					<input type="text" class="signup_input form-control" name="Mem_favor"
						id="Mem_favor" placeholder="취향" />
				</div>
				<div class="row input-group">
					<button type="button" class="btn btn-sm btn-success"
						id="btn-gen-male">남자</button>
					<button type="button" class="btn btn-sm btn-default"
						id="btn-gen-female">여자</button>
					<input type="hidden" id="Mem_gender" class="signup_input" value="남자">
				</div>
				<div class="row">
					<input type="text" class="form-control signup_input" name="Mem_phone"
						id="Mem_phone" placeholder="전화번호를 입력하세요 ex) 01011112222">
				</div>
				<div id="input_check"></div>
				<!-- 회원가입 버튼 크기 변경 -->
				<div class="row">
					<input type="button" class="btn btn-success signbtn" id="btn-register" value="회원가입 완료">
				</div>
				<input type="hidden" id="Mem_profile" value="${regi_profile}">
				<input type="hidden" id="Mem_auth" value="${auth}">
			</form>
		</div>
	</div>
	<%@ include file="../template/footer.jsp"%>
	<%@ include file="../template/script.jsp"%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="../script/mem_regi.js" charset="UTF-8"></script>
	<script type="text/javascript">
		$(function(){
			email = $('#Mem_email').val();
			if(!email || 0 === email.length) return;
			readonly('#Mem_email');
			readonly('#Mem_ID');
			<% session.setAttribute("regi_email", null);
			session.setAttribute("regi_name", null);
			session.setAttribute("regi_profile", null); %>
		});
		function readonly(selector){
			$(selector).attr('readonly', 'readonly');
		}
	</script>
</body>
</html>