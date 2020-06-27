<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation-->
	<nav class="navbar navbar-expand-lg">
		<div class="container nav_container">
			<a class="js-scroll-trigger" href="/recipe/member/index.do"><img
				src="/recipe/img/logo.png" id="img_size"></a>
			<!-- 검색창 부분 -->
			<div class=" search-box">
				<input type="text" placeholder="검색어 입력">
				<button>검색</button>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav">
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
	<header>
		<div class="menu">
			<ul class="nav_list">
				<li class=""><a href="#" class="active li_font">홈</a></li>
				<li class=""><a href="#" class="li_font">레시피</a></li>
				<li class=""><a href="#" class="li_font">쉐프</a></li>
			</ul>
		</div>
	</header>