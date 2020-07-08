<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=0.25" />
<title>달달한 민족</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- 배달의 민족 주아체 -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../css/style.css" rel="stylesheet" />
<link href="../css/jinhyun.css" rel="stylesheet" />
<link href="../css/index.css" rel="stylesheet" />
<link href="../css/header.css" rel="stylesheet"/>
<link href="../css/footer.css" rel="stylesheet"/>
</head>
<body>
    <%@ include file="../template/nav.jsp"%>
    <div class="main_content">
       <div class="container">
          <h3>레시피 등록</h3>
          <div class="row">
            <label>레시피 제목</label>
            <input type="text" placeholder="소고기 미역국 끓이기"> 
          </div>
          <div class="row">
            <label>요리소개</label>
            <input type="text" placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓어봤어요.">       
          </div>
          <div class="row">
            <label>동영상</label>
            <input type="text" placeholder="동영상이 있으면 주소를 입력하세요(Youtube, 네이버, tvcast,다음(tvpot만 가능))">
          </div>
          <div class="row">
            <label>카테고리</label>
          </div>
       </div>    
    </div>
	<%@ include file="../template/footer.jsp"%>
</body>
</html>