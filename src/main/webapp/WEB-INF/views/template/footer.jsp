<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Footer-->
<footer class="footer text-center footer_container">
	<div class="container">
		<div class="row">
			<img src="../img/logo.png" id="footer_logo_img">
			<ul class="footer_ul">
				<li><img src="../img/kitchen.png">
					<div>총 쉐프수</div> <b id="chef_cnt">${chef_cnt}</b></li>
				<li><img src="../img/food-and-restaurant.png">
					<div>총 레시피수</div> <b id="recipe_cnt">${recipe_cnt}</b></li>
				<li><img src="../img/printer.png">
					<div>총 레시피 조회수</div> <b id="total_recipe_cnt">${total_recipe_cnt}</b></li>
			</ul>
		</div>
	</div>
</footer>
<!-- Copyright Section-->
<div class="py-4 text-center">
	<div class="container">
		<small>Copyright © 달달하조 2020 </small>

	</div>
</div>
<script type="text/javascript" src="../script/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "get",
			url : "../template/footer.do",
			dataType : 'json'
		}).done(function(json) {
			alert("성공");
			$('#chef_cnt').html(json.chef_cnt);
			$('#recipe_cnt').html(json.recipe_cnt);
			$('#total_recipe_cnt').html(json.total_recipe_cnt);
		}).fail(function(json) {

		});
	});
</script>