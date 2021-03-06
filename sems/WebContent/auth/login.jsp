<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
h1 {
  text-align: center;
}

body {
  background-color: #4C0B5F;
}



#div {
  margin-left: 800px;
}

#context {
  margin-top: 70px;
  border: 1px solid red;
  height: 300px;
  background-color: #F2F2F2;
}

</style>
<script>
$(function(){
	  $("#fm").css("display", "none");

$("h1").click(function(){
	$("#fm").css("display", "");
});
});
</script>
</head>
<body>
<div id="context">
<div id="main">
<div id="div">
<h1>로그인</h1>
<form id="fm" action="login.bit" method="post" class="form-horizontal" role="form">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-6">
      <input type="email" name="email" value="${cookie.loginEmail.value}" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-6">
      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="saveEmail"
          <c:if test="${cookie.loginEmail != null}">
          checked
          </c:if>
          >Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>
</div>
</div>
</div>





</body>
</html>