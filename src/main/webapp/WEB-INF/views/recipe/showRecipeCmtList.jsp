<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<input type="hidden" id="get_seq" value="${seq}">
<input type="hidden" id="get_mem_id" value="${mem_id}">
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
