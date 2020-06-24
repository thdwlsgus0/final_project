<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>달달한 민족</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- 배달의 민족 주아체 -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/recipe/css/style.css" rel="stylesheet" />
<link href="/recipe/css/jinhyun.css" rel="stylesheet" />
<link href="/recipe/css/index.css" rel="stylesheet" />
</head>
<body id="page-top">


	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg">
		<div class="container nav_container">
			<a class="navbar-brand js-scroll-trigger" href="/recipe/member/index.do"><img
				src="/recipe/img/logo.png" id="img_size"></a>
			<!-- 검색창 부분 -->
			<div class="search-box">
				<input type="text" placeholder="검색어 입력">
				<button>검색</button>
			</div>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<c:choose>
						<c:when test="${sessionId != null}">
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="profile.do">'${sessionId}'</a></li>
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="/recipe/logout.do">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="/recipe/loginForm.do">로그인</a></li>
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="/recipe/member/signup.do">회원가입</a></li>
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="/recipe/member/contact.do">관리자에게 문의</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<header class="menu">
		<div>
			<ul class="nav_list">
				<li class="text-center"><a href="#" class="active li_font">홈</a></li>
				<li class="text-center"><a href="#" class="li_font">레시피</a></li>
				<li class="text-center"><a href="#" class="li_font">쉐프</a></li>
			</ul>
		</div>
	</header>
	<div class="main_body_color">
		<div class="container">
			<div class="text-center">시간 출력</div>
		</div>
		<section class="container section_container">
			<dl>
				<h3>베스트레시피</h3>
				<div class="btn btn-success btn-more">더보기</div>
			</dl>
			<dd>
				<ul>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="/recipe/img/logo.png" id="img_data">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="/recipe/img/GoogleLogin.png" id="img_data">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>

					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="/recipe/img/NaverLogin.png" id="img_data">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>

					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>

				</ul>
			</dd>
		</section>
		<section class="container section_container">
			<dl>
				<h3>쉐프</h3>
				<div class="btn btn-success btn-more">더보기</div>
			</dl>
			<dd>
				<ul>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>

					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>

					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>

							</div>
					</a></li>

				</ul>
			</dd>
		</section>
	</div>
	<!-- Footer-->
	<footer class="footer text-center footer_container">
		<div class="container">
			<div class="row">
				<img src="/recipe/img/logo.png" id="footer_logo_img">
			    <ul class="footer_ul">
			      <li>
			       <span></span>
			       <span></span>
			       <span></span>
			      </li>
			      <li>
			       <span></span>
			       </li>
			      <li></li>
 			    </ul>
			</div>
		</div>
	</footer>
	<!-- Copyright Section-->
	<div class="copyright py-4 text-center text-black">
		<div class="container">
			<small>Copyright © 달달하조 2020</small>
		</div>
	</div>
	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
	<div class="scroll-to-top d-lg-none position-fixed">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"><i class="fa fa-chevron-up"></i></a>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="assets/mail/jqBootstrapValidation.js"></script>
	<script src="assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="../script/script.js"></script>
</body>
</html>
