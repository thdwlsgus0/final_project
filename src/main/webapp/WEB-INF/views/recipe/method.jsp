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
<link href="../css/style.css" rel="stylesheet" />
<link href="../css/jinhyun.css" rel="stylesheet" />
<link href="../css/index.css" rel="stylesheet" />
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/footer.css" rel="stylesheet" />
<link href="../css/chef.css" rel="stylesheet" />
<link href="../css/method.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="../template/nav.jsp"%>
	<div class="main_content">
		<div class="container">
		
			<div class="method_item">
				<div class="cate_arrow" id="left_arrow">
					<button onclick="efg_prev();" style="background-color: #fff;" >
						<img src="../img/left_arrow.png">
					</button>
				</div>
				<div class="ingre_img">
					<ul>
						<li class="display_block"><img src="../img/beef.png"
							class="beef_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=쇠고기">쇠고기</a>
							</p></li>
						<li class="display_block"><img src="../img/radish.png"
							class="radish_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=무">무</a>
							</p></li>
						<li class="display_block"><img src="../img/tofu.png"
							class="tofu_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=두부">두부</a>
							</p></li>
						<li class="display_block"><img src="../img/rice.png"
							class="rice_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=밥">밥</a>
							</p></li>
						<li class="display_block"><img src="../img/squid.png"
							class="squid_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=오징어">오징어</a>
							</p></li>
						<li class="display_block"><img src="../img/pork.png"
							class="pork_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=돼지고기">돼지고기</a>
							</p></li>
						<li class="display_block"><img src="../img/mushroom.png"
							class="mushroom_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=버섯">버섯</a>
							</p></li>
						<li class="display_none"><img src="../img/flour.png"
							class="beef_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=밀가루">밀가루</a>
							</p></li>
						<li class="display_none"><img src="../img/콩나물.png"
							class="radish_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=콩나물">콩나물</a>
							</p></li>
						<li class="display_none"><img src="../img/onion.png"
							class="tofu_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=양파">양파</a>
							</p></li>
						<li class="display_none"><img src="../img/cucumber.png"
							class="rice_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=오이">오이</a>
							</p></li>
						<li class="display_none"><img src="../img/shrimp.png"
							class="squid_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=새우">새우</a>
							</p></li>
						<li class="display_none"><img src="../img/egg.png"
							class="pork_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=계란">계란</a>
							</p></li>
						<li class="display_none"><img src="../img/potato.png"
							class="mushroom_size">
							<p class="text-center">
								<a class="text-center" href="../method.do?food=김치">김치</a>
							</p></li>
					</ul>
				</div>
				<div class="cate_arrow" id="right_arrow">
					<a href="javascript:void(0);" onclick="efg_next();"> <img src="../img/right_arrow.png">
					</a>
				</div>
			</div>
			<!-- 컨테이너 영역 : 쉐프 상세 영역 -->
			<!-- 컨테이너 기본 틀 -->
			<div class="container_frame">
				<div>
					총 <b class="method_num">${food_cnt}</b>개의 ${food_name} 레시피가 있습니다.
				</div>
				<!-- 쉐프의 레시피 게시물 표시 -->
				<div class="content_list">
					<ul>
						<c:forEach var="recipeDTO" items="${list }">
							<li><a href="#"> <img src="${recipeDTO.img_url }">
									<div class="recipe_subject">
										<h3>${recipeDTO.recipe_nm_ko }</h3>
										<p>by ${recipeDTO.mem_id }</p>
									</div>
							</a></li>
						</c:forEach>
					</ul>
					<!-- .content_list ul -->

				</div>
				<!-- content_list -->

				<!-- 게시물 페이징 영역 -->
				<div class="paging">
					<ul>
						<c:if test="${startPage > 5}">
							<li><a class="turnPaging"
								href="method.do?pg=${startPage - 1}&food=${keyword }">이전</a></li>
						</c:if>

						<c:forEach var="i" begin="${startPage }" end="${endPage }"
							step="1">
							<c:choose>
								<c:when test="${pg==i }">
									<li><a class="currentPaging" href="chef.do?pg=${i }"
										&keyword=${keyword }>${i }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="method.do?pg=${i }&food=${keyword }">${i }</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${endPage < totalP}">
							<li><a class="turnPaging"
								href="method.do?pg=${endPage + 1}&food=${keyword }">다음</a></li>
						</c:if>
					</ul>
				</div>
				<!-- paging -->
			</div>
		</div>
	</div>
	<%@ include file="../template/footer.jsp"%>
	<script src="../script/index.js"></script>
</body>
</html>