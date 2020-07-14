function delete_cmt(cmt_seq) {
	// 삭제 확인 절차
	if (confirm("정말 삭제하시겠습니까??\n삭제된 댓글은 복구할 수 없습니다.") != true) {
		return false;
	}
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		type: "POST",
		url : "/recipe/deleteCmt.do",
		data: {
			seq: $("#get_seq").val(),
			cmt_seq: cmt_seq
        },
		beforeSend: function(xhr){
			xhr.setRequestHeader(header, token);
		}
	}).done(function(data) {
		if (data > 0) {
			alert("이미 댓글이 작성되어 있어 댓글을 제거할 수 없습니다");
			return false;
		}
		
		$(".info_cmt_none, #get_totalC").remove();	// 대댓글 달기 전, 기존 대댓글 입력 창 제거(중복 됨), 또는 새로고침을 위해 기존에 달린 댓글 입력창 제거
		$(".reply_cmtToCmt, .update_myCmt").remove(); // 댓글 답글/수정 후에 다시 보여질 때 중복을 제거하기 위함.
		$(".info_parent_id, .output_cmt").remove();	// 부모댓글 작성자와  댓글 작성자의 댓글 중복 제거
		
		showRecipeCmtList();	// 게시글에 대한 댓글 추가할 때마다 댓글 목록 갱신
		
	}).fail(function(request, status, error) {
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	});
	
	return false;
}


// 특정 댓글 수정하기
function modify_cmt(cmt_seq, cmt)  {
	
	// 입력 검사
	if($("#update_cmt" + cmt_seq + " > textarea[name='modify_cmt']").val() == cmt) {
		alert("댓글을 수정하지 않안았어요.");
		$("#update_cmt" + cmt_seq + " > textarea[name='modify_cmt']").focus();
		
		return false;
	}
	
	// 수정한 댓글
	var modifyCmt = $("#update_cmt" + cmt_seq + " > textarea[name='modify_cmt']").val();
	
	var mem_id = $("#get_mem_id").val();	// 로그인 후 세션으로부터 받아야 한다!
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		type: "POST",
		url : "/recipe/modifyCmt.do",
		data: {
			seq: $("#get_seq").val(),
			cmt_seq: cmt_seq,
        	cmt: modifyCmt
        },
		beforeSend: function(xhr){
			xhr.setRequestHeader(header, token);
		}
	}).done(function() {
		$(".info_cmt_none, #get_totalC").remove();
		$(".update_myCmt, .reply_cmtToCmt").remove();
		$(".info_parent_id, .output_cmt").remove();
		showRecipeCmtList();
	}).fail(function(request, status, error) {
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	});

	return false;
}


function write_cmtToCmt(cmt_seq, parent_id, lvl) {

	// 입력 검사
	if(!$("#reply_cmt" + cmt_seq + " > textarea[name='input_cmtToCmt']").val()) {
		alert("댓글을 입력하세요.");
		$("#reply_cmt" + cmt_seq + " > textarea[name='input_cmtToCmt']").focus();
		return false;
	}
	
	// 대댓글 입력
	var cmtToCmt = $("#reply_cmt" + cmt_seq + "> textarea[name='input_cmtToCmt']").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var mem_id = $("#get_mem_id").val();	// 로그인 후 세션으로부터 받아야 한다!
	$.ajax({
		type: "POST",
		url : "/recipe/writeCmt.do",
		data: {
        	seq: $("#get_seq").val(),
        	parent_seq: cmt_seq, // 댓글 부모 번호(원본 글인 경우는 0, 대댓글인 경우 부모글의 seq)
        	mem_id: mem_id,	// 로그인 후 세션으로부터 받아야 한다!
        	parent_id: parent_id, 
        	cmt: cmtToCmt,
        	lvl: lvl
        },
		beforeSend: function(xhr){
			xhr.setRequestHeader(header, token);
		}
	}).done(function() {
		$(".info_cmt_none, #get_totalC").remove();	// 대댓글 달기 전, 기존 대댓글 입력 창 제거(중복 됨), 또는 새로고침을 위해 기존에 달린 댓글 입력창 제거
		$(".reply_cmtToCmt, .update_myCmt").remove(); // 댓글 답글/수정 후에 다시 보여질 때 중복을 제거하기 위함.
		$(".info_parent_id, .output_cmt").remove();	// 부모댓글 작성자와  댓글 작성자의 댓글 중복 제거
		showRecipeCmtList();	// 게시글에 대한 댓글 추가할 때마다 댓글 목록 갱신
	}).fail(function(request, status, error) {
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	});
	
	return false;
}

/*
// 작성한 댓글로 이동하기(보류)
function Move_input_cmt(cmt_seq){
    var offset = $("#cmt_body" + cmt_seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
}
*/

// 게시글에 대한 댓글 작성하기
function writeCmtToRecipe(seq) {
	// 입력 검사
	if(!$(".write_cmtToRecipe > textarea[name='write_cmt']").val()) {
		alert("댓글을 입력하세요.");
		$(".write_cmtToRecipe > textarea[name='write_cmt']").focus();
		return false;
	}
	
	var mem_id = $("#get_mem_id").val();	// 로그인 후 세션으로 받아야 한다!
	cmtToRecipe = $(".write_cmtToRecipe > textarea[name='write_cmt']").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
        type: "POST",
        url : "/recipe/writeCmt.do",
        data: {
        	seq: seq,
        	mem_id: mem_id,	// 로그인 후 세션으로 받아야 한다!
        	cmt: cmtToRecipe
        },
        beforeSend: function(xhr){
			xhr.setRequestHeader(header, token);
		}
    }).done(function() {
    	$(".reply_cmtToCmt, .update_myCmt").remove(); // 댓글 답글/수정 후에 다시 보여질 때 중복을 제거하기 위함.
    	$(".info_cmt_none, #get_totalC").remove();	// 기존 댓글 표시 영역을 비움 / 새로고침을 위해 기존에 달린 댓글 일부 태그 제거
    	$(".info_parent_id, .output_cmt").remove();	// 부모댓글 작성자와  댓글 작성자의 댓글 중복 제거
    	$(".write_cmtToRecipe > textarea[name='write_cmt']").val(''); // 입력한 댓글 입력창에서 지우기
    	showRecipeCmtList();	// 게시글에 대한 댓글 추가할 때마다 댓글 목록 갱신
	}).fail(function(request,status,error) {
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	});
	
	return false;
}

// 댓글 목록 가져오기	
function showRecipeCmtList(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		type: 'get',
		url: '/recipe/getRecipeCmtList.do',
		dataType: 'text',							// 해당 url로 보내는 데이터의 타입
		contentType: 'text/text; charset=utf-8',	// 해당 url로부터 받는 데이터 타입
		data: {
			seq: $("#get_seq").val(),
			mem_id: $("#get_mem_id").val()
		},
		beforeSend: function(xhr){
			xhr.setRequestHeader(header, token);
		}
	}).done(function(cmtData) {
		//console.log('trim: '+ cmtData.trim());
		if(cmtData.trim().length > 0) {		// 댓글이 이미 달려있는 경우	
			$(".info_cmt_none, #getTotalC").remove();
			$(".cmt_body, .jump, .separator").remove();
			$('.content_cmt').append(cmtData.trim());
			$(".reply_cmtToCmt").hide();	// 해당 셀렉터(대댓글 입력창) 숨기기(작동 순서 중요!)
			$(".update_myCmt").hide();		// 해당 셀렉터(댓글수정 입력창) 숨기기(작동 순서 중요!)
			$('.set_totalC').html($('#get_totalC').val());	// 댓글 수 새로고침
		} else {	// 불러온 댓글이 존재하지 않는 경우
			var info_cmt_none = $("<div>");
			info_cmt_none.addClass("info_cmt_none")
			
			var h5 = $("<h5>");
			var stg = $("<strong>");
			stg.html("등록된 댓글이 없습니다.");
			
			h5.append(stg);
			info_cmt_none.append(h5);
			
			$('.content_cmt').append(info_cmt_none);
		}
	}).fail(function(request,status,error) {
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	});
}


// 이 해당 상세 레시피에 방문할 때 이 함수를 호출하게 된다.(onload)
$(function() {
	// 외부에서 이 게시물에 방문할 경우 바로 먼저 실행
	showRecipeCmtList();-
	
	// 대댓글 입력 버튼 클릭 시 실행
	/* $(".write_cmtToCmt").click(function() {  }); 오류 원인 : 
	$(document).ready(function(){ ... }); 함수를 통해
	페이지가 이미 로드 해오면서 진행이 됬기에 실행이 안되는 것으로 파악됨.*/
	$(document).on('click','.write_cmtToCmt', function() {
		// 클릭된 요소의 형제 요소 중 다음 형제 노드 중 class가 'get_cmt_seq'인 value값 가져오기
		var cmt_seq = $(this).nextAll(".get_cmt_seq").val();
		$("#reply_cmt" + cmt_seq).toggle(10, function() {
			
			// 수정/취소 버튼과 구분자  숨기기
			$(".modify_myCmt, .delete_myCmt, .write_cmtToCmt").not("#write_cmtToCmt" + cmt_seq).toggle();
			$(".cmt_text > span").not(".cmt_text > span.fix" + cmt_seq).toggle();
			
			// 답글 버튼을 클릭 시 버튼 글자를 '취소' 변경 
			if($("#reply_cmt" + cmt_seq).css('display') == 'inline-block') {
				$("#write_cmtToCmt" + cmt_seq).text('취소');
			} else {
				$("#write_cmtToCmt" + cmt_seq).text('답글');
			}
			
			// 다른 댓글의 '답글' 버튼을 클릭 시 사전에 열었놨던 버튼 글자 되돌리기
			$(".write_cmtToCmt").not("#write_cmtToCmt" + cmt_seq).each(function(i, element) {
				if($(element).text().trim()=="취소") {
					$(element).text('답글');
				}
			});
			
		});
		
		// 특정 div 중에서 class 명이 'reply_cmtToCmt'을 찾되,
		// 그 중 id가 'reply_cmt'을 가진 요소를 제외하고 hide()를 수행하여 답글 창 닫기
		$("div").find(".reply_cmtToCmt").not("#reply_cmt" + cmt_seq).hide();
		
		return false;
	});
	
	// 수정 버튼 클릭 시 실행
	$(document).on("click", ".modify_myCmt", function() {
		var cmt_seq = $(this).nextAll(".get_cmt_seq").val();
		
		$("#update_cmt" + cmt_seq).toggle(10, function() {
			// 답글/취소 버튼과 구분자  숨기기
			$(".modify_myCmt, .delete_myCmt, .write_cmtToCmt").not("#modify_cmtBtn" + cmt_seq).toggle();
			$(".cmt_text > span").not(".cmt_text > span.fix" + cmt_seq).toggle();
			
			// 수정 버튼을 클릭 시 버튼 글자를 '취소'/'수정' 변경 
			if($("#update_cmt" + cmt_seq).css('display') == 'inline-block') {
				$("#modify_cmtBtn" + cmt_seq).text('취소');
				$("#output_cmt" + cmt_seq).hide();
			} else {
				$("#modify_cmtBtn" + cmt_seq).text('수정');
				$("#output_cmt" + cmt_seq).show();
			}
			
			// 다른 댓글의 '취소' 버튼을 클릭 시 전에 열었전 버튼 글자 되돌리기
			$(".modify_myCmt").not("#modify_cmtBtn" + cmt_seq).each(function(i, element) {
				if($(element).text().trim()=="취소") {
					$(element).text('수정');
				}
			});
		});
		
		$("div").find(".update_myCmt").not("#update_cmt" + cmt_seq).hide();
		
		return false;
	});
	
	// 삭제 버튼 클릭 시 실행(실제 데이터 삭제가 아닌, 댓글 내용만 null 값으로 변경)
	$(document).on("click", ".delete_myCmt", function() {
		var cmt_seq = $(this).nextAll(".get_cmt_seq").val();
//		getChildernCnt(cmt_seq);
		delete_cmt(cmt_seq);
		
		return false;
	});
	
});