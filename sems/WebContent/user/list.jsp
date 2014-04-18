
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
<link rel="stylesheet" type="text/css" href="list.css">
<title>사용자 목록</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">

  $(document).ready(function(){
		 $(".listDataBox").css({
			 "display": "none"
		 });
	  
			 	$(".listOpen").click(function(){
			 		 $(".listOpen").hide();
					 $(".listDataBox").show(1000).css({"display":""});
				});	
			 	
			 	$("h1.listDataBox").click(function(){
			 		 $(".listDataBox").hide(1000);
			 		 $(".listOpen").show(1000);
			 	});
			 	
			 	
}); 

</script>
</head>
<body>

<div class="listBox">
	<div class="listOpen">세미콜록콜록서버 사용자보기! </div>
	<h1 class="listDataBox">여러분은 지금 세미콜록콜록의 사용자들을 보고계십니다. </h1>
	<div class="listDataBox">
			<div class="newUserLink"><a href='form.html' >새사용자 바로가기</a><br></div>
			<table>
				<colgroup>
					<col class="userNo"/>
					<col class="email"/>
					<col class="name"/>
				</colgroup>
				<thead>
					<tr>
						<th scope="col">No.</th>
						<th scope="col">Email</th>
						<th scope="col">Name</th>
					</tr>
				</thead>
				<tbody>
			<%for(UserVo user : list) {%>
				<tr>
					<td class='noData'> <%=user.getNo() %></td>
					<td class='emailData'> <a href='detail.bit?no=<%=user.getNo()%>'><%=user.getEmail()%></a></td>
					<td class='nameData'> <%=user.getName()%></td>
				</tr>
			<%} %>	
				</tbody>
			
				</table>
		</div>
</div>
</body>
</html>