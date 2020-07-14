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
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/footer.css" rel="stylesheet" />
<link href="../css/chefList.css" rel="stylesheet" />
</head>

<body>
	<%@ include file="../template/nav.jsp"%>


	<!-- 컨테이너 영역 : 쉐프 상세 영역 -->
	<div class="container">
		<!-- 컨테이너 기본 틀 -->
		<div class="container_frame">
			<!-- 서브 탭 영역 -->
			<div class="sub_tabs">
				<ul>
					<li><a href="chefList.do">🏆셰프 랭킹</a></li>
					<li><a href="chefRecent.do">👨‍🍳최근 활동 셰프</a></li>
					<li><a href="chefRank.do">👩‍🍳뉴 셰프</a></li>
				</ul>
			</div>
			<!-- sub_tabs -->
			<div class="sub_search"></div>
			<!-- 쉐프의 레시피 게시물 표시 -->
			<div class="content_list">
				<ul>
					<c:forEach var="item" items="${list }">
						<li>
							<div class="recipe_subject">
								<c:choose>
									<c:when test="${item.mem_profile eq null}">
										<img class="mem_profile"
											src="https://mblogthumb-phinf.pstatic.net/20150122_124/zikil337_1421903667127Oa4u7_JPEG/1406712927919_1406709122135-1.jpg?type=w800">
									</c:when>
									<c:otherwise>
										<img class="mem_profile" alt="" src="${item.mem_profile }">
									</c:otherwise>
								</c:choose>
								<!-- 프로필 사진 -->
								<div class="mem_id">${item.mem_id }</div>
								<!-- 멤버 이름 -->
								<div class="total_recipe">🍖${item.total_recipe }</div>
								<!-- 레시피수 -->
								<div class="total_hit">🚪${item.total_hit }</div>
								<!--방문자수  -->
								<div class="total_good">👍${item.total_good }</div>
								<!-- 추천수 -->
								<div class="visit_button">
									<a
										href="../cook/chef.do?mem_id=${item.mem_id }">방문하기</a>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<!-- .content_list ul -->

			</div>
			<!-- content_list -->

		</div>
		<!-- container -->
	</div>
	<!-- container_wrap -->
	<%@ include file="../template/footer.jsp"%>
</body>