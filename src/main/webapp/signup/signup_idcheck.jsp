<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<c:if test="${idcheck eq true}"><font color="green">사용할 수 있는 아이디입니다.</font></c:if>
<c:if test="${idcheck ne true}"><font color="red">이미 사용 중인 아이디입니다.</font></c:if>