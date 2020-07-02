<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			ul {
				width: 700px; margin: auto; list-style: none;
			}
			
			ul li {
				float: left;
			}
			
			ul li img {
				border: 0; margin: 10px;
			}
			
			div#glayLayer {
				display: none;
				position: fixed; left: 0; top:0;
				height: 100%; width: 100%;
				background: black;
				filter: alpha(opacity=60);
				opacity: 0.60
			}
			
			div#overLayer {
				display: none;
				background:  black;
				position: fixed; top: 50%; left: 50%;
				margin-top: -244px; margin-left: -325px;
				
			}			
		</style>
		<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				// 링크를 클릭한 경우
				$("a.modal").click(function() {
					$("#glayLayer").fadeIn(300);
					$("#overLayer").fadeIn(200);
					$("#overLayer").html("<img src='"+ $(this).attr("href") + "'>");
					return false;
				});
				
				// 화면에 표시된 배경 레이어를 클랙한 경우
				$("#glayLayer, #overLayer").click(function() {
					$("#glayLayer").fadeOut(300);
					$("#overLayer").fadeOut(200);
				});
			});
		</script>
	</head>
	<body>
		<div id="glayLayer"></div>
		<div id="overLayer"></div>
		
		<ul>
			<li>
				<a href="img/photo1.jpg" class="modal">
					<img alt="" src="img/photo1_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo2.jpg" class="modal">
					<img alt="" src="img/photo2_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo3.jpg" class="modal">
					<img alt="" src="img/photo3_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo4.jpg" class="modal">
					<img alt="" src="img/photo4_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo5.jpg" class="modal">
					<img alt="" src="img/photo5_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo6.jpg" class="modal">
					<img alt="" src="img/photo6_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo7.jpg" class="modal">
					<img alt="" src="img/photo7_thum.jpg">
				</a>
			</li>
			<li>
				<a href="img/photo8.jpg" class="modal">
					<img alt="" src="img/photo8_thum.jpg">
				</a>
			</li>
		</ul>
	</body>
</html>