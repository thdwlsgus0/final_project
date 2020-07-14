<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="false" %>

<c:if test="${!empty list}">
	<input type="hidden" id="get_totalC" value="${totalC}">
</c:if>
<c:forEach var="cmtDTO" items="${list}">
	<div id="cmt_body${cmtDTO.cmt_seq}" class="cmt_body" style="padding-left: ${40*cmtDTO.lvl}px;">

		<h4 class="cmt_text">
			<c:if test="${!empty cmtDTO.parent_id}"><b>↳</b></c:if>
			<b class="info_id">
				<c:choose>
					<c:when test="${!empty cmtDTO.mem_profile}">
						<img class="mem_profile" alt="" src="${cmtDTO.mem_profile}">
					</c:when>
					<c:otherwise>
						<img class="mem_profile" alt="default" src="../img/egg.png">
					</c:otherwise>
				</c:choose>
				${cmtDTO.mem_id}
			</b>
			<b class="info_reg">
				${cmtDTO.regdate}
			</b><span class="fix${cmtDTO.cmt_seq}">|</span>
			<!-- 댓글 삭제 시 삭제 해야할 태그 1 -->
			<c:if test="${cmtDTO.mem_id eq mem_id and not empty realId}">
				<c:if test="${!empty cmtDTO.cmt}">
					<a id="modify_cmtBtn${cmtDTO.cmt_seq}" class="modify_myCmt" href="#">
						수정
					</a><span class="sepa">|</span>
					
					<a id="delete_cmtBtn${cmtDTO.cmt_seq}" class="delete_myCmt" href="#">
						삭제
					</a><span class="sepa">|</span>
				</c:if>
			</c:if>
			<c:if test="${not empty realId}">
				<!-- 댓글 삭제 시 삭제 해야할 태그 1 /-->
				<a id="write_cmtToCmt${cmtDTO.cmt_seq}" class="write_cmtToCmt" href="#">
					답글
				</a>
			</c:if>
			<span class="fix${cmtDTO.cmt_seq}">|</span>
			<input type="hidden" class="get_cmt_seq" value="${cmtDTO.cmt_seq}">
			<input type="hidden" class="get_parent_id" value="${cmtDTO.parent_id}">
			<br>
		</h4>
		
	</div>
	
	
	<c:if test="${!empty cmtDTO.parent_id}">
	<b id="info_parent_id${cmtDTO.cmt_seq}" class="info_parent_id" style="padding-left: ${40*cmtDTO.lvl}px;">
		${cmtDTO.parent_id}
		<!-- 게시물에 대한 댓글과 대댓글 구분하기 위한 조건문 -->
	</b>
	</c:if>
	
	<c:choose>
		<c:when test="${!empty cmtDTO.cmt}">
		<b id="output_cmt${cmtDTO.cmt_seq}" class="output_cmt">
			${cmtDTO.cmt}<!-- 댓글 삭제 시 삭제 해야할 태그 2 -->
		</b>
		</c:when>
		<c:otherwise>
		<b id="output_cmt${cmtDTO.cmt_seq}" class="output_cmt">
		[삭제된 댓글입니다.]<!-- 댓글 삭제 시 삭제 해야할 태그 2/-->
		</b>
		</c:otherwise>
	</c:choose>
	
	
	<div id="update_cmt${cmtDTO.cmt_seq}" class="update_myCmt" style="padding-left: ${40*cmtDTO.lvl}; height: 120px;">
	<!-- 댓글 수정을 하기위한 입력창(기본으로 숨기기) -->
		<textarea name="modify_cmt">${cmtDTO.cmt}</textarea>
		<span class="update_btn">
			<button type="button" onclick="
				modify_cmt(${cmtDTO.cmt_seq}, '${cmtDTO.cmt}');
			">수정</button>
		</span>
	</div>
	
	<div id="reply_cmt${cmtDTO.cmt_seq}" class="reply_cmtToCmt" style="padding-left: ${40*(cmtDTO.lvl+1)}px; height: 120px;">
	<!-- 대댓글을 하기위한 입력창(기본으로 숨기기) -->
		<textarea name="input_cmtToCmt" placeholder="댓글을 남겨주세요."></textarea>
		<span class="reply_btn">
			<button type="button" onclick="
				write_cmtToCmt(${cmtDTO.cmt_seq}, '${cmtDTO.mem_id}', ${cmtDTO.lvl});
			">등록</button>
		</span>
	</div>
	
	<br class="jump">
	<hr class="separator">
</c:forEach>