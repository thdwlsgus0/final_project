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
<link href="../css/chef.css" rel="stylesheet"/>
</head>

<body>
  <%@ include file="../template/nav.jsp" %> 

	<!-- 컨테이너 영역 : 쉐프 상세 영역 -->
	<div class="container">
		<!-- 컨테이너 기본 틀 -->
	    <div class="container_frame"> <!-- limsh>>> <div class="container_frame"> -->
	    		<!-- 서브 탭 영역 -->
	        	<div class="sub_tabs"> 
	        		<ul>
	        			<li><a href="chef.do?pg=1">🔪레시피</a></li> <!-- leejiwon>>> href="chef.do?mem_id=${mem_id }" -->
	        			<li><a href="#">💬댓글</a></li>
	        		</ul>
		        </div><!-- sub_tabs -->
				
				<!-- 쉐프의 레시피 검색 영역 -->		        
		        <form action="chef.do" method="get"> <!-- leejiwon>>> action="../cook/chef.do" -->
		        	<input type="hidden" name="mem_id" value="${mem_id }">
		            <div class="sub_search">
						<input type="text" name="keyword" placeholder="레시피 또는 재료명을 입력하세요.."> <!-- limsh>>> name="recipe_sub_search" -->
																					    
						<button type="submit">
							<img src="img/pngwing.png">
						</button>
		            </div><!-- sub_search -->
	            </form>
	            
	            <!-- 쉐프의 레시피 게시물 표시 -->
	            <div class="content_list">
	            	<ul>
	            		<c:forEach var="recipeDTO" items="${list }">
	            		<li><a href="#">
	            				<img src="${recipeDTO.img_url }">
	            				<div class="recipe_subject">
	            					<h3>${recipeDTO.recipe_nm_ko }</h3>
	            					<p>by ${recipeDTO.mem_id }</p>
	            				</div>
	            		</a></li>
	            		</c:forEach>
	            	</ul><!-- .content_list ul -->
	            </div><!-- content_list -->
	            
	        <!-- 게시물 페이징 영역 -->
	        <div class="paging">
	        	<ul>
	        		<c:if test="${startPage > 5}">
	        			<li>
	        				<a class="turnPaging" href="chef.do?pg=${startPage - 1}&keyword=${keyword }">이전</a>
	        				<!-- leejiwon>>> <a class="turnPaging" href="chef.do?mem_id=${mem_id }&keyword=${keyword }&pg=${startPage - 1}">이전</a> -->
	        			</li>
	        		</c:if>
	        		
	        		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
	        			<c:choose>
	        				<c:when test="${pg==i }">
        					<li>
								<a class="currentPaging" href="chef.do?pg=${i }&keyword=${keyword }">${i }</a>
								<!-- leejiwon >>> <a class="currentPaging" href="chef.do?mem_id=${mem_id }&keyword=${keyword }&pg=${i }">${i }</a> -->
							</li>
	        				</c:when>
	        				<c:otherwise>
	        				<li>
								<a href="chef.do?pg=${i }&keyword=${keyword }">${i }</a>
								<!-- leejiwon>>> <a href="chef.do?mem_id=${mem_id }&keyword=${keyword }&pg=${i }">${i }</a> -->
							</li>
	        				</c:otherwise>
	        			</c:choose>
	        		</c:forEach>
	        		
					<c:if test="${endPage < totalP}">
	        			<li>
	        				<a class="turnPaging" href="chef.do?pg=${endPage + 1}&keyword=${keyword }">다음</a>
	        				<!-- leejiwon>>> <a class="turnPaging" href="chef.do?mem_id=${mem_id }&keyword=${keyword }&pg=${endPage + 1}">다음</a> -->
	        			</li>
	        		</c:if>
	        	</ul>
	        </div><!-- paging -->
	    </div><!-- container -->
	</div><!-- container_wrap -->
  <%@ include file="../template/footer.jsp" %>
</body>
