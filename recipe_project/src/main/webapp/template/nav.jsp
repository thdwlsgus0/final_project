<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Navigation-->
	<!-- 이지원 추가 : 아해 nav 태그에 nav_div 클래스 추가 후, padding: 0; 추가 -->
	<nav class="navbar navbar-expand-lg nav_div">
		<!--이지원 추가 : header.css의 .nav_container{...} 내  margin-left: 440px; 제거하고 padding: 0;, justify-content: start !important; 적용!-->
		<div class="container nav_container">
			<a class="js-scroll-trigger" href="/recipe/member/index.do">
				<!-- 이지원 추가 : jinhyun.css 의  #img_size{...} 내 padding-bottom: 0px; margin-left: 150px; 제거할 것!-->
				<img src="/recipe/img/logo.png" id="img_size">
			</a>
			
			<!-- 검색창 부분 -->
			<form action="search_keyword.do" method="get">
				<div class=" search-box">
					<!-- 이지원 추가 -->
					<select name="options" style="float: left;
											    height: 100%;
											    border: none;">
				        <option value="all" <c:out value="${options == 'all'?'selected':''}" /> >
							전체
			            </option>
			            <option value="recipe" <c:out value="${options == 'title'?'selected':''}" /> >
							레시피
						</option>
			            <option value="ingredient" <c:out value="${options == 'content'?'selected':''}" /> >
							재료
			            </option>
			            <option value="writer" <c:out value="${option == 'writer'?'selected':''}" /> >
							작성자
			            </option>
		        </select>
		        	<!-- 이지원 추가 : jinhyun.css 의 input{...} 내  padding 속성을 제거하고, height: "100%"; 추가, font-size: 25px; 수정할 것! -->
					<input type="text" placeholder="검색어 입력">
					<button>검색</button>
				</div>
			</form>
			<!-- 이지원 추가 : .navbar-expand-lg .navbar-collapse {...}의 @media (min-width: 992px) 무효화 필요 -->
			<div class="collapse navbar-collapse">
				<!-- 이지원 추가 : 아래 태그와 header.css에 nav_ul 클래스 추가 후, min-width: 0; 추가 -->
				<ul class="navbar-nav nav_ul">
					<c:choose>
						<c:when test="${sessionId != null}">
							<!-- 이지원 추가 : 아래 태그와 header.css에 nav_ul li 클래스 추가 후, min-width: 0; 추가 -->
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
		<!-- 이지원 추가 : header.css의 background-color 속성 제거, 가운데 정렬을 위한 conyainer 클래스 명 추가 -->
		<div class="container menu">
			<ul class="nav_list">
			<!-- 이지원 추가 : header.css의 .nav_list li{...} 내 width: 370px로 변경, text-align: center; 추가, margin-left 제거  -->
				<li class=""><a href="/recipe/member/index.do" class="active li_font">홈</a></li>
				<li class=""><a href="/recipe/recipe/method.do" class="li_font">레시피</a></li>
				<li class=""><a href="/recipe/cook/chefList.do?mem_id=${mem_id }" class="li_font">쉐프</a></li>
			</ul>
		</div>
	</header>