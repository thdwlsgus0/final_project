<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!-- client_id=앱키  redirect_uri=내 uri-->
    <c:if test="${userId eq null}">
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=1356aced5c32878850cc1596142752e4&redirect_uri=http://localhost:8090/recipe/login&response_type=code">
            <img src="img/kakao_login_medium_narrow.png">
        </a>
    </c:if>
    <c:if test="${userId ne null}">
        <h1>로그인 성공입니다</h1>
    </c:if>
</body>
</html>
