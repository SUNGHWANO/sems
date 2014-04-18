<%-- EL 적용 --%>
<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과정상세정보</title>
</head>
<body>
<h1>과정 상세정보(EL)</h1>
<table border='1'>
<tr>
  <th>번호</th>
  <td>${course.no}</td>
</tr>
<tr>
  <th>과정명</th>
  <td>${course.title}</td>
</tr>
<tr>
  <th>내용</th>
 <td><textarea rows='5' cols='60'>${course.description}</textarea></td>
</tr>
<tr>
  <th>교육시간</th>
  <td>${course.hours}</td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a> 
<a href='delete.bit?no=${course.no}'>삭제</a> 
<a href='update.bit?no=${course.no}'>변경</a><br>
<jsp:include page="/footer.jsp"/>
</body></html>










