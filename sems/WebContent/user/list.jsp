
<%@page import="vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<UserVo> list = (List<UserVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 목록</title>
</head>
<body>
<h1>여러분은 지금 세미콜론콜론의 사용자들을 보고계십니다.</h1>
<a href='form.html'>새과목</a><br>
<table>
	<colgroup>
		<col class="사용자번호"/>
		<col class="이메일"/>
		<col class="이름"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">사용자번호</th>
			<th scope="col">이메일</th>
			<th scope="col">이름</th>
		</tr>
	</thead>
	<tbody>
<%for(UserVo user : list) {%>
	<tr>
		<td> <%=user.getNo() %></td>
		<td><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getEmail()%></a></td>
		<td> <%=user.getName()%></td>
	</tr>
<%} %>	
	</tbody>
</table>

</body>
</html>