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
			<h1>ȸ������</h1>
			<p>��� �Է��� �ּ���.</p>

			<label>Name <span class="pos">�̸� �Է�</span>
			</label> <input type="text" name="name" id="name" /> <label>ID <span
				class="pos">���̵� �Է�</span>
			</label> <input type="text" name="id" id="id" /> <label>Password <span
				class="pos">�н�����</span>
			</label> <input type="text" name="password1" id="password1" /> <label>Password
				<span class="pos">�н����� Ȯ��</span>
			</label> <input type="text" name="password2" id="password2" /> <label>age
				<span class="pos">�������</span>
			</label> <input type="text" name="age" id="age" /> <label>age <span
				class="pos">����</span>
			</label> <input type="text" name="gender" id="gender" /> <label>age
				<span class="pos">�̸���</span>
			</label> <input type="text" name="email" id="email" /> <label>Phone
				<span class="pos">��ȭ��ȣ �Է�</span>
			</label> <input type="text" name="phone" id="phone" />

			<button type="submit">ȸ������ �Ϸ�</button>


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