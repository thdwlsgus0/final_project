<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<c:if test="${check eq true}">인증 성공! 이제 로그인할 수 있어요!</c:if>
<c:if test="${check ne true}">인증 실패! 인증번호를 확인해주세요!</c:if>