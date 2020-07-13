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
<!-- jQuery 참조 -->
<script type="text/javascript" src="../script/jquery-3.5.1.min.js"></script>
<!-- 배달의 민족 주아체 -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<!-- 이지원 추가 : 댓글 기능 -->
<script type="text/javascript" src="../script..Cmt.js"></script>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../css/style.css" rel="stylesheet" />
<link href="../css/jinhyun.css" rel="stylesheet" />
<link href="../css/index.css" rel="stylesheet" />
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/footer.css" rel="stylesheet" />
<link href="../css..Detail.css" rel="stylesheet" />
<link href="../css..Cmt.css" rel="stylesheet" />

<!-- 동영상 불러오기 -->
<script>
	var tag = document.createElement('script');

	tag.src = "https://www.youtube.com/iframe_api";
	var firstScriptTag = document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
	var player;
	function onYouTubeIframeAPIReady() {
		player = new YT.Player('player', {
			height : '360',
			width : '640',
			videoId : '${dto.video_id}', //이 비디오 아이디를 토대로 검색을 따오면 될것 같습니다.
			events : {
				'onReady' : onPlayerReady,
				'onStateChange' : onPlayerStateChange
			}
		});
	}

	function onPlayerReady(event) {
		event.target.playVideo();
	}

	var done = false;
	function onPlayerStateChange(event) {
		if (event.data == YT.PlayerState.PLAYING && !done) {
			setTimeout(stopVideo, 6000);
			done = true;
		}
	}
	function stopVideo() {
		player.stopVideo();
	}
</script>

</head>

<body>
	<%@ include file="../template/nav.jsp"%>

	<!-- 컨테이너 영역 : 쉐프 상세 영역 -->
	<div class="container">

		<!-- 컨테이너 기본 틀 -->
		<div class="container_frame">

			<!-- 메인 정보 탭 영역 -->

			<div class="sub_tabs">

				<!-- 쉐프의 레시피 게시물 표시 -->
				<div class="content_list">
					<ul>
						<li>
							<div class="recipe_subject">
								<!-- 음식 사진 -->
								<img class="food_img" alt="이 음식의 사진은 없습니다." src="${dto.img_url}">
								<!-- 프로필 사진 -->
								<img class="profile_img" alt="이 회원의 프로필 사진은 없습니다. "
									src="${profile.mem_profile}">
								<!-- 멤버 아이디 -->
								<div class="mem_id">${dto.mem_id}</div>
								<!-- 요리 제목 -->
								<div class="recipe_nm_ko">제목: ${dto.recipe_nm_ko}</div>
								<!-- 요리 요약 -->
								<div class="sumry">제목: ${dto.sumry}</div>
								<div class="cooktime_comment">
									<!-- 요리 시간 ,칼로리이동-->
									<a>⏰${dto.cooking_time} 이내 🍟${dto.calorie}</a>
								</div>
								<div class="recife_video">
									<div id="player"></div>
								</div>
							</div>
						</li>
					</ul>
					<!-- .content_list ul -->
				</div>
				<!-- content_list -->
				<!-- 재료 영역 -->
				<div class="material">재료</div>
				<div class="material_container">
					<ul class="main_material">
						<p class="main_material">[주재료]</p>
						<c:forEach var="item" items="${list_1 }">
							<li>
								<div class="">${item.irdnt_nm }</div>
							</li>
						</c:forEach>
					</ul>
					<ul class="sub_material">
						<p class="sub_material">[부재료]</p>
						<c:forEach var="item" items="${list_2 }">
							<li>
								<div class="">${item.irdnt_nm }</div>
							</li>
						</c:forEach>
					</ul>
					<ul class="seasoning">
						<p class="seasoning">[양념]</p>
						<c:forEach var="item" items="${list_3 }">
							<li>
								<div class="">${item.irdnt_nm }</div>
							</li>
						</c:forEach>
					</ul>
				</div>

				<!-- material_container -->
				<div class="cook_seq_container">
					<!--재료 순서 영역  -->
					<div class="sequence">재료 순서</div>
					<ul>
						<c:forEach var="item" items="${list_4 }">
							<li>
								<div class="cook_make">
									<!-- 요리 순서 -->
									<p class="cook_seq">${item.recipe_sequence }</p>
									<!-- 조리 설명 -->
									<p class="cook_explain">${item.recipe_comment }</p>
									<!--음식 사진 -->
									<img class="cook_img" alt="" src="${item.recipe_image_url }">
								</div>
							</li>
						</c:forEach>
					</ul>


				</div>
				<!-- cook_seq_container 재료 순서 영역 -->

			</div>
			<!-- 메인 정보 탭 영역 -->
		</div>
		<!-- 컨테이너 기본 틀 -->
	</div>
	<!-- 컨테이너 영역 : 쉐프 상세 영역 -->

	<div id="setRecipeOnTheCmt">
		<!-- 댓글 표시 -->
		<input type="hidden" id="get_seq" value="${seq}">
		<!-- <input type="hidden" id="get_mem_id" value="${mem_id}"> -->
		<input type="hidden" id="get_mem_id" value="2g1">
		<!-- 컨테이너 영역 : 댓글 영역 -->
		<div class="container">
			<div class="container_frame">
				<!-- 상세 레시피 댓글들 표시 -->
				<div class="content_cmt">
					<p class="cmt_head">
						댓글&nbsp;<span class="set_totalC">${totalC}</span>
					</p>
					<hr>
					
					<div class="write_cmtToRecipe">
						<textarea name="write_cmt" placeholder="무엇이 궁금하신가요? 댓글을 남겨주세요."></textarea>
						<span class="write_btn">
							<button type="button" onclick="
								writeCmtToRecipe(${seq});
							">등록</button>
						</span>
					</div>
					
					<!-- 댓글 리스트 출력 영역 -->
					
				</div>
				<!-- content_cmt -->
			</div>
			<!-- container_frame -->
		</div>
		<!-- container -->
	</div>
	
	<%@ include file="../template/footer.jsp"%>
</body>