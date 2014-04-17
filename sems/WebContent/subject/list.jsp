<%@page import="java.util.List"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<SubjectVo> list = (List<SubjectVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>과목목록</title>
</head>
<body>
<h1>과목 목록</h1>
<table border='1'>
  <tr>
    <th>번호</th><th>과목</th>
  </tr>
<%for(SubjectVo subject : list){%>
  <tr>
    <td><%=subject.getNo()%></td>
    <td><a href='detail.bit?no=<%=subject.getNo()%>'><%=subject.getTitle()%></a></td>
  </tr>
<%}%>
</table>
</body>
</html>