<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
* {
	padding: 0;
	margin:0;
}

body{
    background: white;
    /*min-width: 1240px;*/
}
.wrap{
    position: relative;
    overflow: hidden;
    /*min-width: 1100px;*/
    background: #f2f4f7;
}    
.header{
    border-bottom: 1px solid #d1d8e4;
    background: yellow;
}

div.special_bg{
    position: relative;
    height: 110px; /* 검색바 height */
    background-color: skyblue;
    border: solid black 1px;
}
	
.section_navbar{
    position: relative;
    height: 46px;
    border: solid black 1px;
    background-color: #d1d8e4;
}
.container{
    margin: 0 auto;
    width: 1230px;
    height: 920px;
}
.column_left{
    float: left;
    width: 100%;
    margin: 15px auto;
}
    #my_tabs{
        position: relative;
        height: 120px;
        border: solid black 1px;
        background-color: olive;
    }
    #news_cast{
        overflow: hidden;
        width: 100%;
    }
    .area_newstop{
        position: relative;
        height: 80px;
        border: solid black 1px;
        background-color: #f2f4f7;
    }
    .area_newstand{
        display: inline-block;
        width: 100%;
        height: 100%;
        border: solid black 1px;
        background-color: darkgreen;
    }
    	.area_newstand .content_list {
    		width: 100%;
		    margin: 0 30px;
		    list-style: none;
    	}
    		.area_newstand .content_list li {
	    		float: left;
	    		background-color: green;
	    		padding: 0;
	    		margin: 0px 15px 35px 0px;
	    		width: 280px;
	    		height: 380px;
    		}
    			.area_newstand .content_list .recipe_subject {
		    		padding: 6px 15px; 
	    		}
	    		
	    			.area_newstand .content_list .recipe_subject {
		    			margin-top: 5px;
    					margin-bottom: 5px;
	    			}




    .section_themecast{
        position: relative;
        float: left;
        width: 1080px;
        height: 45px;
        border: 1px solid black;
        background-color: lightblue;
    }
    
    .section_shoppingcast{
        position: relative;
        float: right;
        width: 330px;
        height: 882px;
        border: 1px solid black;
        background-color: maroon;
    }
    
.column_banner{
    clear: both;
    position: relative;
}

.section_footer{
    position: relative;
}
	.notice{
	    position: relative;
	    margin: 0 auto;
	    width: 1080px;
	    height: 29px;
	    border: 1px solid black;
	    background-color: greenyellow;
	}
	.aside{
	    position: relative;
	    margin: 0 auto;
	    width: 1080px;
	    height: 110px;
	    border: 1px solid black;
	    background-color: gold;
	}
	.footer{
	    position: relative;
	}
	.area_terms{
	    position: relative;
	    margin: 0 auto;
	    width: 1080px;
	    height: 132px;
	    border: 1px solid black;
	    background-color: tomato;
	}
</style>
</head>
<body>
<div class="wrap">
<div class="header">
    <div class="special_bg">
    	<div><h1>헤더</h1></div>
    </div>
    
    <!-- section_navbar -->
    <div class="section_navbar"><h1>네비게이션_탭</h1></div><!-- section_navbar -->
</div> <!-- header -->
<div class="container">

    <div class="column_left">
        <div id="my_tabs" style="padding: 21px 21px 0;"><!-- veta_top -->
        	<h1>쉐프 레시피들 + 댓글 탭</h1>
        	<ul class="" style="list-style: none;">
		        <li style="margin-right: 1px;
						    padding: 20px 50px;
						    float: left;
						    border: 1px solid black">
		        	<a href="#">
		        		<span class="glyphicon glyphicon-cutlery"></span>레시피
		        	</a>
		        </li>
		        <li class="active" style="margin: 10px; float: left;">
			        <a href="/profile/review.html?uid=27854893">
			        	<span class="glyphicon glyphicon-star"></span>댓글
			        </a>
		        </li>
	    	</ul>
        </div>
        
        <div id="news_cast"><!-- news_cast -->
            <div class="area_newstop"><!-- area_newstop -->
	            <div id="search_wrap" style="position: relative; display: table; margin: 20px auto 30px;">
					<input type="text" name="search_bar" class="search_bar" style="height: 40px; display: table-cell;">
					<span class="input-group-btn" style="display: table-cell;">
						<button type="button" class="search_btn" style="">
							<img src="pngwing.png">
						</button>
					</span>
				</div>
            </div>
            
            <div class="area_newstand"><!-- area_newstand -->
            	<ul class="content_list">
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo1_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo2_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo3_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo4_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo5_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo1_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo2_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo3_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo4_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            		<li>
            			<a href="#" class="model">
            				<img src="sample/img/photo5_thum.jpg" style="width: 100%;">
            				<div class="recipe_subject">
            					<h4 style="font-size: 15px; font-weight: bold;">레시피 명 1</h4>
            					<p style="font-size: 12px;">by 쉐프 명</p>
            				</div>
            			</a>
            		</li>
            	</ul>
            </div>
        </div>
        
        <div class="paging_area" style="position: relative;
									    border: solid black 1px;
									    background-color:lightblue;
									    text-align: center;
    									clear: both;
									    ">
        	<ul class="pagination" style="display: inline-block;
									  		padding-left: 0;
									   		margin: 30px 0;
									   		border-radius: 0;">
				<li style="display: inline;">
					<a href="#" style="position: relative;
									    float: left;
									    padding: 9px 15px;
									    margin: 0 3px;
									    line-height: 1.42857143;
									    color: 000;
									    text-decoration: none;
									    background-color: #fff;
									    border: 1px solid #e6e7e8;
									    border-radius: 0;">
						1
					</a>
				</li>
				<li style="display: inline;">
					<a href="#" style="position: relative;
									    float: left;
									    padding: 9px 15px;
									    margin: 0 3px;
									    line-height: 1.42857143;
									    color: 000;
									    text-decoration: none;
									    background-color: #fff;
									    border: 1px solid #e6e7e8;
									    border-radius: 0;">
						2
					</a>
				</li>
				<li style="display: inline;">
					<a href="#" style="position: relative;
									    float: left;
									    padding: 9px 15px;
									    margin: 0 3px;
									    line-height: 1.42857143;
									    color: 000;
									    text-decoration: none;
									    background-color: #fff;
									    border: 1px solid #e6e7e8;
									    border-radius: 0;">
						3
					</a>
				</li>
				<li style="display: inline;">
					<a href="#" style="position: relative;
									    float: left;
									    padding: 9px 15px;
									    margin: 0 3px;
									    line-height: 1.42857143;
									    color: 000;
									    text-decoration: none;
									    background-color: #fff;
									    border: 1px solid #e6e7e8;
									    border-radius: 0;">
						4
					</a>
				</li>
				<li style="display: inline;">
					<a href="#" style="position: relative;
									    float: left;
									    padding: 9px 15px;
									    margin: 0 3px;
									    line-height: 1.42857143;
									    color: 000;
									    text-decoration: none;
									    background-color: #fff;
									    border: 1px solid #e6e7e8;
									    border-radius: 0;">
						5
					</a>
				</li>
        	</ul>
        </div>
    </div><!-- column_left -->
    
</div><!-- container -->

</div><!-- wrap -->
</body>
</html>