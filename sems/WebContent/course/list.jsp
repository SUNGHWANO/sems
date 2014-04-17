<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<CourseVo> list = 
  (List<CourseVo>) request.getAttribute("list"); 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<title>과정목록</title>
</head>
<body>
	<h1>과정 목록(by JSP)</h1>
	<a href='form.html'>새과정</a>
	<br>
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>과정명</th>
		</tr>
		<tr>
		<%for(CourseVo course : list) {%>
			<td><%=course.getNo()%></td>
			<td><a href='list.bit?no=<%=course.getNo()
			%>'><%=course.getTitle()%></a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>
