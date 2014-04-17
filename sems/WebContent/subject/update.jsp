<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SubjectVo subject = (SubjectVo)request.getAttribute("subject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 변경</title>
</head>
<body>
<h1>과목변경</h1>
<form action='update.bit' method='POST'>
번호 : <input name='no' type='text' value='<%=subject.getNo()%>' readonly><br>
제목 : <input name='title' type='text' value='<%=subject.getTitle()%>'><br>
내용 :<br>
<textarea name='description' rows='5' cols='50'><%=subject.getDescription()%></textarea><br>
<input type='submit' value='변경'>
<input type='button' value='취소' onclick="location.href='detail.bit?no=<%=subject.getNo()%>'">
</form>
</body>
</html>