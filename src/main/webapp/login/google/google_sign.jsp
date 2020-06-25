<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/recipe/login/google/google_sign.js"></script>
<script src="https://apis.google.com/js/platform.js?onload=google_init" async defer></script>
</head>
<body>

<input type="button" value="checking..." id="authBtn" onclick="login();">
<div id="get_email"></div>

</body>
</html>