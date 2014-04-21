<%-- EL 적용 --%>
<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과정변경폼</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
<h1>과정 변경폼(JSP, JSP Action Tag)</h1>
<form action='update.bit' method='post'>
번호: <input type='text' name='no' value='${course.no}' readonly><br>
과정명: <input type='text' name='title' value='${course.title}'><br>
설명: <textarea name='description' 
        rows='10' cols='80'>${course.description}</textarea><br>
교육시간: <input type='text' name='hours' value='${course.hours}'><br>
<input type='submit' value='변경'>
<input type='button' value='취소' 
        onclick="location.href='detail.bit?no=${course.no}'">
</form>
<c:set var="studyClass" value="Java48$$" scope="request"/>
<jsp:include page="/footer.jsp"/>
</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    