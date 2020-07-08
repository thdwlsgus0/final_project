<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="css/chefView.css">
</head>
<body>
	<div class="header">
	    <div class="header_main">
	    	<h1>헤더</h1>
	    </div>
	    
	    <div class="hrader_tabs">
	    	<h1>메인_탭</h1>
	    </div><!-- section_navbar -->
	</div> <!-- header -->
	
	<!-- 컨테이너 영역 : 쉐프 상세 영역 -->
	<div class="container">
		<!-- 컨테이너 기본 틀 -->
	    <div class="container_frame">
	    		<!-- 서브 탭 영역 -->
	        	<div class="sub_tabs"> 
	        		<ul>
	        			<li><a href="#">🔪레시피</a></li>
	        			<li><a href="#">💬댓글</a></li>
	        		</ul>
		        </div><!-- sub_tabs -->
		        
		        <!-- 쉐프의 레시피 검색 영역 -->
	            <div class="sub_search">
						<input type="text" name="recipe_sub_search">
																					    
						<button type="submit" onclick="doSearch()">
							<img src="img/pngwing.png">
						</button>
	            </div><!-- sub_search -->
	            
	            <!-- 쉐프의 레시피 게시물 표시 -->
	            <div class="content_list">
	            	<ul>
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo1_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo2_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo3_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo4_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo5_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo1_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo2_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo3_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo4_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            		
	            		<li>
	            			<a href="#">
	            				<img src="sample/img/photo5_thum.jpg" style="width: 100%;">
	            				<div class="recipe_subject">
	            					<h3>레시피 명 1</h3>
	            					<p>by 쉐프 명</p>
	            				</div>
	            			</a>
	            		</li>
	            	</ul><!-- .content_list ul -->
	            	
	            </div><!-- content_list -->
	            
	        <!-- 게시물 페이징 영역 -->
	        <div class="paging">
	        	<ul>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
	        	</ul>
	        </div><!-- paging -->
	        
	    </div><!-- container -->
	</div><!-- container_wrap -->

</body>
</html>
