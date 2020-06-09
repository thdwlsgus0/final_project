<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style type="text/css">
.recipeForm {
	margin: 10px;
	width: 400px;
	height: 500px;
	padding: 50px;
	margin: 0 auto;
}

.pos {
	display: block;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<div id="style" class="recipeForm">
		<form id="form" name="form" method="post">
			<h1>회원가입</h1>
			<p>모두 입력해 주세요.</p>

			<label>Name <span class="pos">이름 입력</span>
			</label> <input type="text" name="name" id="name" /> <label>ID <span
				class="pos">아이디 입력</span>
			</label> <input type="text" name="id" id="id" /> <label>Password <span
				class="pos">패스워드</span>
			</label> <input type="text" name="password1" id="password1" /> <label>Password
				<span class="pos">패스워드 확인</span>
			</label> <input type="text" name="password2" id="password2" /> <label>age
				<span class="pos">생년월일</span>
			</label> <input type="text" name="age" id="age" /> <label>age <span
				class="pos">성별</span>
			</label> <input type="text" name="gender" id="gender" /> <label>age
				<span class="pos">이메일</span>
			</label> <input type="text" name="email" id="email" /> <label>Phone
				<span class="pos">전화번호 입력</span>
			</label> <input type="text" name="phone" id="phone" />

			<button type="submit">회원가입 완료</button>


		</form>

		<div>
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=1356aced5c32878850cc1596142752e4&redirect_uri=http://localhost:8090/recipe/login.do&response_type=code">
				<img src="../img/KakaotalkLogin.png">
			</a>
		</div>

		<div>
			<a href="">
				<img src="../img/NaverLogin.png">
			</a>
		</div>

		<div>
			<a href="">
				<img src="../img/FacebookLogin.png">
			</a>
		</div>

		<div>
			<a href="">
				<img src="../img/GoogleLogin.png">
			</a>
		</div>

	</div>

</body>
</html>