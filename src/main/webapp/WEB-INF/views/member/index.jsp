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
<link href="../css/style.css" rel="stylesheet" />
<link href="../css/jinhyun.css" rel="stylesheet" />
<link href="../css/index.css" rel="stylesheet" />
<link href="../css/header.css" rel="stylesheet"/>
<link href="../css/footer.css" rel="stylesheet"/>
</head>
<body id="page-top">
	<%@ include file="../template/nav.jsp"%>
	<div class="main_body_color">
		<section class="container section_category">
			<div class="category_item">
				<div class="cate_arrow">
				    <button onclick="efg_prev();" style="background-color:#fff;" >
				       <img src="../img/left_arrow.png">
				    </button>
				</div>
				<div class="ingre_img">
					<ul>
						<li class="display_block"><img src="../img/beef.png" class="beef_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=쇠고기">쇠고기</a></p></li>
						<li class="display_block"><img src="../img/radish.png" class="radish_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=무">무</a></p></li>
						<li class="display_block"><img src="../img/tofu.png" class="tofu_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=두부">두부</a></p></li>
						<li class="display_block"><img src="../img/rice.png" class="rice_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=밥">밥</a></p></li>
						<li class="display_block"><img src="../img/squid.png" class="squid_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=오징어">오징어</a></p></li>
						<li class="display_block"><img src="../img/pork.png" class="pork_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=돼지고기">돼지고기</a></p></li>
						<li class="display_block"><img src="../img/mushroom.png" class="mushroom_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=버섯">버섯</a></p></li>
						<li class="display_none"><img src="../img/flour.png" class="beef_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=밀가루">밀가루</a></p></li>
						<li class="display_none"><img src="../img/콩나물.png" class="radish_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=콩나물">콩나물</a></p></li>
						<li class="display_none"><img src="../img/onion.png" class="tofu_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=양파">양파</a></p></li>
						<li class="display_none"><img src="../img/cucumber.png" class="rice_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=오이">오이</a></p></li>
						<li class="display_none"><img src="../img/shrimp.png" class="squid_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=새우">새우</a></p></li>
						<li class="display_none"><img src="../img/egg.png" class="pork_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=계란">계란</a></p></li>
						<li class="display_none"><img src="../img/potato.png" class="mushroom_size">
							<p class="text-center"><a class="text-center" href="../recipe/method.do?food=김치">김치</a></p></li>				
					</ul>
				</div>
				<div class="cate_arrow">
					<a href="javascript:void(0);" onclick="efg_next();"> <img
						src="../img/right_arrow.png">
					</a>
				</div>
			</div>
		</section>
		<section class="container section_container">
			<dl>
				<h3>베스트레시피</h3>
				<div class="btn btn-success btn-more"><a href="../cook/chefList.do">더보기</a></div>
			</dl>
			<dd>
				<ul>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="../img/logo.png" id="img_data">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>
							</div>
					</a></li>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="../img/GoogleLogin.png" id="img_data">
							</div>
							<div class="caption">
								<h4>[브랜드 특가]</h4>
								<span>22,000</span> <span>원</span>
							</div>
					</a></li>
					<li class="pull_left"><a href="#">
							<div class="thumbs_hb">
								<img src="../img/NaverLogin.png" id="img_data">
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
				<h3>추천 레시피</h3>
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
				<h3>쉐프</h3>
				<div class="btn btn-success btn-more"><a href="../cook/chefRecent.do">더보기</a></div>
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
    <jsp:include page="../template/footer.jsp"/>
</body>
</html>
