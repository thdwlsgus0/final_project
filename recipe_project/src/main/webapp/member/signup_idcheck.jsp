<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<c:if test="${idcheck eq true}"><font color="green">����� �� �ִ� ���̵��Դϴ�.</font></c:if>
<c:if test="${idcheck ne true}"><font color="red">�̹� ��� ���� ���̵��Դϴ�.</font></c:if>