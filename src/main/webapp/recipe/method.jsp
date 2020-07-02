<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
<link href="/recipe/css/header.css" rel="stylesheet" />
<link href="/recipe/css/footer.css" rel="stylesheet" />
<link href="/recipe/css/chef.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../template/nav.jsp"%>
	<div class="main_content">
		<div class="container">

			<!-- 컨테이너 영역 : 쉐프 상세 영역 -->
			<!-- 컨테이너 기본 틀 -->
			<div class="container_frame">
				<div>
					총 <b class="method_num">${food_cnt}</b>개의 ${food_name}레시피가 있습니다.
				</div>
				<!-- 쉐프의 레시피 게시물 표시 -->
				<div class="content_list">
					<ul>
						<li><a href="#"> <img src="sample/img/photo1_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo2_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo3_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo4_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo5_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo1_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo2_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo3_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo4_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>

						<li><a href="#"> <img src="sample/img/photo5_thum.jpg"
								style="width: 100%;">
								<div class="recipe_subject">
									<h3>레시피 명 1</h3>
									<p>by 쉐프 명</p>
								</div>
						</a></li>
					</ul>
					<!-- .content_list ul -->

				</div>
				<!-- content_list -->

				<!-- 게시물 페이징 영역 -->
				<div class="paging">
					<ul>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
					</ul>
				</div>
				<!-- paging -->
			</div>
		</div>
	</div>
	<%@ include file="../template/footer.jsp"%>
</body>
</html>