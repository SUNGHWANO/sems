<%-- JSTL 및 EL 적용하기 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<jsp:include page="/header.jsp"/>
  <title>과목목록</title>
<style>
h1 {
  text-align: center;
}

#new {
  text-align: right;
  margin-right: 50px;
}
</style>
</head>
<body>
<h1>과목 목록</h1>
<table class="table">
<tr>
  <th>번호</th>
  <th>과목명</th>
</tr>
<c:forEach var="subject" items="${list}">
<tr>
  <td>${subject.no}</td>
  <td><a href='detail.bit?no=${subject.no}'>${subject.title}</a></td>
</tr>
</c:forEach>
</table>
<div id="new">
<a href='form.html' class="btn btn-info">새과목</a><br>
</div>
<jsp:include page="/footer.jsp"/>
</body></html>















    