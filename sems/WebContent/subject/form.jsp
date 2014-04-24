<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<jsp:include page="/header.jsp"/>
<title>과목입력폼</title>
</head>
<body>
<style>
h1 {
  text-align: center;
}
#title {
  text-align: center;
  font-size: 14px;
  color: #D8D8D8;
  width: 205px;
  margin-left: 2px; 
}
#description {
  text-align: center;
  font-size: 14px;
  color: #D8D8D8;
}
#main {
  width: 209px;
}
#input {
  text-align: center;
}
input {
  border: 0px;
}
</style>
</head>
<body>
  <script>
  
  $(function(){
    
    $("#form").css("display", "none");
    $("h1").click(function(){
      $("#form").css("display", "");
    });
  }); 
  
  
  function clearText(field) {
      if (field.defaultValue == field.value)
        field.value = "";
      $("#title").css("color", "black");
      $("#description").css("color", "black");
    }

    function send() {
      if (form.title.value == "과목을 입력하세요" || form.title.value == 0) {
        document.form.title.value = "과목을 입력하세요";
        $("#title").css("color", "red");
        return false;
      }

      if (form.description.value == "내용을 입력하세요" || form.description.value == 0) {
        document.form.description.value = "내용을 입력하세요";
        $("#description").css("color", "red");
        return false;
      }
    }
  </script>
  <div id="main">
  <h1>과목추가</h1>
  <form id="form" name="form" action="insert.bit" method="post"
    onsubmit="return send()">
    <input id="title" name="title" type="text" value="과목을 입력하세요"
      onfocus="clearText(this)"><br>
    <textarea id="description" name="description" rows="10" cols="26"
      onfocus="clearText(this)">내용을 입력하세요</textarea>
    <br> 
    <div id="input">
    <input type="button" value="목록" onclick="history.back()">
    <input type="submit" value="등록"> 
    <input type="reset" value="취소">
    </div>
  </form>
  </div>
<jsp:include page="/footer.jsp"/>
</body>
</html>