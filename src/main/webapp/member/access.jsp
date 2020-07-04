<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잘못된 접근</title>
<script type="text/javascript">
	window.onload = function(){
		alert('잘못된 접근입니다.');
		window.location.href = "/recipe/member/index.do";
	}
</script>
</head>
</html>