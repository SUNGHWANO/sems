<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CourseVo course = (CourseVo) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과정변경폼</title>
</head>
<body>
<h1>과정 변경폼(by JSP)</h1>
<form action='update.bit' method='post'>
번호: <input type='text' name='no' value='<%=course.getNo()%>' readonly><br>
과정명: <input type='text' name='title' value='<%=course.getTitle()%>'><br>
설명: <textarea name='description' rows='10' cols='80'><%=course.getDescription()%></textarea><br>
교육시간: <input type='text' name='hours' value='<%=course.getHours()%>'><br>
<input type='submit' value='변경'>
<input type='button' value='취소'
        onclick="location.href='update.bit?no=<%=course.getNo()%>'">
</form>
</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    