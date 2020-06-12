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
			<a class="navbar-brand js-scroll-trigger" href="#page-top">�޴�����</a>
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
						href="../loginForm.do">�α���</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="signup.do">ȸ������</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="contact.do">�����ڿ��� ����</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="signup_body">
		<div class="container">
			<form method="post">
				<h1 class="signup_h1">ȸ������</h1>
				<div class="row">
					<input type="text" name="Mem_ID" id="Mem_ID" placeholder="���̵� �Է�" />
					<!-- ���̵� �ߺ�üũ�� �ʿ��� �� -->
					<button class="btn btn-sm btn-primary" onclick="">�ߺ�üũ</button>
				</div>
				<!-- ��й�ȣ Ȯ�� �ʿ��� ��-->
				<div class="row">
					<input type="text" name="Mem_password" id="Mem_password"
						placeholder="��й�ȣ �Է�" />
				</div>
				<div class="row">
					<input type="text" name="Mem_password2" id="Mem_password1"
						placeholder="Ȯ�� ��й�ȣ �Է�" />
				</div>
				<!-- �̸��� ���� �����ϴ°� ���� �ʿ��� �� -->
				<div class="row">
					<input type="text" name="Mem_email" id="Mem_email"
						placeholder="�̸���" />
					<form action="../email/auth.do">
						<button type="submit" class="btn btn-sm btn-success">����</button>
					</form>
				</div>

				<div class="row">
					<input type="text" name="Mem_age" id="Mem_age" placeholder="����" />
				</div>
				<div class="row">
					<span class="ps_box"> <input type="text" name="Mem_birth_yy"
						id="Mem_birth_yy" placeholder="��" />
					</span> 
					<span class="ps_box">
					<input type="text" name="Mem_birth_mm" id="Mem_birth_mm" placeholder="��"/>
					<!-- <select id="Mem_birth_mm" aria-label="��">
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
					</select> -->
					</span>
					<span class="ps_box">
					  <input type="text" name="Mem_birth_dd" id="Mem_birth_dd" placeholder="��"/>
					</span>
				</div>
				<div class="row">
					<input type="text" name="Mem_favor" id="Mem_favor" placeholder="����" />
				</div>
				<div class="row input-group">
					<button type="button" class="btn btn-sm btn-success" id="btn-gen-male">����</button>
					<button type="button" class="btn btn-sm btn-default" id="btn-gen-female"">����</button>
					<input type="hidden" id="Mem_gender">
				</div>
				<div class="row">
				   <input type="text" name="Mem_phone" placeholder="��ȭ��ȣ�� �Է��ϼ��� ex) 01011112222">
				</div>
				<div class="row">
				  <button class="btn btn-success btn-lg" type="submit" onclick="signup_check();">ȸ������ �Ϸ�</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../template/script.jsp"%>
	<script src="../script/mem_regi.js"></script> <!-- ȸ������ -->
</body>
</html>