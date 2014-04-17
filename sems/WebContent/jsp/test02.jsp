<%--
템플릿 데이터

- JSP 엔진은 JSP에 작성한 문장을 가지고 자바 출력문을 생성한다.
- JSP 엔진이 만든 자바 소스 파일은 
     웹 플로그인 폴더의 work 폴더에 들어있다.
- 톰캣이 JSP를 실행 할 때 자바 코드가 생성된다.      
 --%>
 
 
 
 <%--
 스크립트릿
 -<%자바코드%> => 자바 파일로 그대로 복사
    void _jsp
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test01</title>
</head>
<%
int i = 20;
int j = 30;
%>
<body>
<h1>스크립트릿</h1>
<% 
if(i > 10){
	out.println("<p> i > 10 </p>");
}
for(int x = 0; x < j; x++){
	out.print("$");
}
%>
<p>JSP 파일에 작성하는 일반 텍스르를 "템플릿 데이터"라 부른다.</p>
</body>
</html>