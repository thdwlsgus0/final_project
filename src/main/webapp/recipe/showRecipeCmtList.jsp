<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=0.25" />
<title>달달한 민족</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
<!-- jQuery 참조 -->
<script type="text/javascript" src="../script/jquery-3.5.1.min.js"></script>
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

<script type="text/javascript" src="../script/recipeCmt.js"></script>
</head>
<body>
	<%@ include file="../template/nav.jsp"%>
	<input type="hidden" id="get_recipe_seq" value="${recipe_seq}">
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
							writeCmtToRecipe(${recipe_seq});
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
   
	<%@ include file="../template/footer.jsp"%>
</body>
