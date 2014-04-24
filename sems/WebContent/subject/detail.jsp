<%-- EL 적용 --%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel="Stylesheet" href="../css/common.css"> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <jsp:include page="/header.jsp"/>
<div class="container">
  <title>과목상세정보</title>
</head>
<body>
<h1>과목 상세정보(EL)</h1>
<table class="table">
<tr>
  <th>번호</th>
  <td>${subject.no}</td>
</tr>
<tr>
  <th>과목명</th>
  <td>${subject.title}</td>
</tr>
<tr>
  <th>내용</th>
 <td><textarea rows='5' cols='60'>${subject.description}</textarea></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10' class="btn btn-info">목록</a> 
<a href='delete.bit?no=${subject.no}' class="btn btn-info">삭제</a> 
<a href='update.bit?no=${subject.no}' class="btn btn-info">변경</a><br>
<jsp:include page="/footer.jsp"/>
</div>
</body></html>










