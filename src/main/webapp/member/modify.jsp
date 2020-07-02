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
<style type="text/css">
input[readonly='readonly']{background-color: #b1b9bd;}
input[type='text']{
	outline: 0;
	margin: 0;
	box-sizing: border-box;
}
label[for]{
	line-height: 1.5;
	font-size: 14px;
	padding: 0;
	box-sizing: border-box;
	cursor: pointer;
	font-weight: normal;
	display: block;
	margin: 0 0 0 -10px;
	letter-spacing: 0.5px;
	color: #9b9dad;
	vertical-align: bottom;
}
#pw_check{
	font-size: 16px;
	font-weight: normal;
	margin-left: 30px;
}

</style>
</head>
<body>
	<%@ include file="../template/nav.jsp"%>
	<div class="container main_body_color">
		<div class="signup_body">
			<form id="mem_modify" action="/recipe/member/modify.do" method="post" enctype="multipart/form-data">
				<h4 class="text-center sign_up">회원정보 수정</h4>
				<div class="row"> <input id="mem_id" placeholder="${mem_id}"  type="text" class="signup_input form-control" readonly="readonly" />
					<input type="hidden" name="id" value="${mem_id}"> </div>
				<label for="mem_id">아이디</label>
				
				<div class="row"> <input id="mem_pw" name="pw" type="password" class="signup_input signup_password form-control" /> </div>
				<div class="row"> <input id="mem_pwr" type="password" class="signup_input signup_password form-control" /> </div>
				<label for="mem_pw">비밀번호               <font id="check"></font></label>
				
				<div class="row"> <input id="mem_favor" name="favor" value="${mem_favor}" type="text" class="signup_input form-control" /> </div>
				<label for="mem_favor">취향</label>
				
				<div class="row"> <input id="mem_phone" name="phone" value="${mem_phone}" type="text" class="form-control signup_input" > </div>
				<label for="mem_phone">전화번호</label>
				
				<div class="row"> <img id="mem_profile" alt="프로필 사진" src="${mem_profile}" width="128px" height="128px" style="margin: 20px; border: 2px solid #53f594;">
					<input name="file" type="file" style="margin: 10px;"> </div>
				
				<div class="row" style="height: 120%;"> <input type="submit" class="btn btn-success signbtn" id="btn-register" value="수정"> </div>
			</form>
		</div>
	</div>
	<%@ include file="../template/footer.jsp"%>
	<%@ include file="../template/script.jsp"%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/recipe/script/mem_modi.js"></script>
</body>
</html>