<%@page import="com.sun.xml.internal.ws.client.RequestContext"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<c:set var="age" value="70"/>

<c:choose>
  <c:when test="${age <  18 }">
    청소년
  </c:when>
  <c:when test="${age <60 }">
  성인
  </c:when>
  <c:otherwise>
   노인
  </c:otherwise>
</c:choose>


</body>
</html>