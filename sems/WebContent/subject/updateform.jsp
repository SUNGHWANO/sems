<%-- EL 적용 --%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <jsp:include page="/header.jsp"/>
  <title>과목변경폼</title>
</head>
<body>
<div class="container">
<h1>과목 변경폼(JSP, JSP Action Tag)</h1>
<form action='update.bit' method='post'>
번호: <input type='text' name='no' value='${subject.no}' readonly><br>
과목명: <input type='text' name='title' value='${subject.title}'><br>
설명: <br>
 <textarea name='description' 
        rows='10' cols='80'>${subject.description}</textarea><br>
<input type='submit' value='변경'>
<input type='button' value='취소' onclick='history.back()'>
</form>
<c:set var="studyClass" value="Java48$$" scope="request"/>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    