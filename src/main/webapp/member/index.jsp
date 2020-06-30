<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=0.25" />
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
<link href="/recipe/css/header.css" rel="stylesheet"/>
<link href="/recipe/css/footer.css" rel="stylesheet"/>
</head>
<body id="page-top">
	<%@ include file="../template/nav.jsp"%>
	<div class="main_body_color">
		<section class="container section_category">
			<div class="category_item">
				<div class="cate_arrow">
				    <button onclick="efg_prev();" style="background-color:#fff;" >
				       <img src="/recipe/img/left_arrow.png">
				    </button>
				</div>
				<div class="ingre_img">
					<ul>
						<li class="display_block"><img src="/recipe/img/beef.png" class="beef_size">
							<p class="text-center">쇠고기</p></li>
						<li class="display_block"><img src="/recipe/img/radish.png" class="radish_size">
							<p class="text-center">무</p></li>
						<li class="display_block"><img src="/recipe/img/tofu.png" class="tofu_size">
							<p class="text-center">두부</p></li>
						<li class="display_block"><img src="/recipe/img/rice.png" class="rice_size">
							<p class="text-center">밥</p></li>
						<li class="display_block"><img src="/recipe/img/squid.png" class="squid_size">
							<p class="text-center">오징어</p></li>
						<li class="display_block"><img src="/recipe/img/pork.png" class="pork_size">
							<p class="text-center">돼지고기</p></li>
						<li class="display_block"><img src="/recipe/img/mushroom.png" class="mushroom_size">
							<p class="text-center">표고버섯</p></li>
						<li class="display_none"><img src="/recipe/img/flour.png" class="beef_size">
							<p class="text-center">밀가루</p></li>
						<li class="display_none"><img src="/recipe/img/콩나물.png" class="radish_size">
							<p class="text-center">콩나물</p></li>
						<li class="display_none"><img src="/recipe/img/onion.png" class="tofu_size">
							<p class="text-center">양파</p></li>
						<li class="display_none"><img src="/recipe/img/cucumber.png" class="rice_size">
							<p class="text-center">오이</p></li>
						<li class="display_none"><img src="/recipe/img/shrimp.png" class="squid_size">
							<p class="text-center">새우</p></li>
						<li class="display_none"><img src="/recipe/img/egg.png" class="pork_size">
							<p class="text-center">계란</p></li>
						<li class="display_none"><img src="/recipe/img/potato.png" class="mushroom_size">
							<p class="text-center">감자</p></li>					
					</ul>
				</div>
				<div class="cate_arrow">
					<a href="javascript:void(0);" onclick="efg_next();"> <img
						src="/recipe/img/right_arrow.png">
					</a>
				</div>
			</div>
		</section>
		<section class="container section_container">
			<dl>
				<a href=""><h3>베스트레시피</h3></a>
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
				<a href=""><h3>추천 레시피</h3></a>
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

							</div></li>
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
		<section class="container section_container">
			<dl>
				<a href=""><h3>쉐프</h3></a>
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
	<script src="../script/index.js"></script>

	<%@ include file="../template/footer.jsp"%>
</body>
</html>
