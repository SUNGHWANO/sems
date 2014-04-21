<%-- JSTL 및 EL 적용하기 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <jsp:include page="/header.jsp"/>
  <title>과정목록</title>
</head>
<body>
<h1>과정 목록(JSTL,EL)</h1>
<a href='form.html'>새과정</a><br>
<table border='1'>
<tr>
  <th>번호</th>
  <th>과정명</th>
</tr>
<c:forEach var="course" items="${list}">
<tr>
  <td>${course.no}</td>
  <td><a href='detail.bit?no=${course.no}'>${course.title}</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body></html>















    