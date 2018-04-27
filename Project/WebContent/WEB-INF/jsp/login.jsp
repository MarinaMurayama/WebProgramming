<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
 <head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/origin/common.css">
 </head>


<body>
<br>
<br>
<br>
<h1 class="title">ログイン画面</h1>

<div class="container">
   <c:if test="${errMsg != null}" >
	 <div class="alert alert-danger" role="alert">
	  ${errMsg}
	 </div>
   </c:if>

<form class="login-form" action="LoginServlet" method="post">
  	<div class="form-group">
    	<label for="Login ID"></label>
    	<input type="text" class="form-control" id="Login ID"  placeholder="Login ID" name="loginId">
  	</div>
   <div class="form-group">
    	<label for="exampleInputPassword1"></label>
    	<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
   </div>
    <div class="button_wrapper">
   		<button class="btn btn-danger" type="submit" >Login</button>
	</div>
</form>
</div>

</body>
</html>