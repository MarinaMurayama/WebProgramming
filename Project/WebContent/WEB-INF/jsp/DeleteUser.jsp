<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除確認</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>


<body>
<div class="alert alert-danger" role="alert">
 <ul class="nav justify-content-end">
  <li class="nav-item">
   <li class="nav-item"> ${userInfo.name}さん </li>
  <li class="nav-item">
    <a class="nav-link" href="LogoutServlet">ログアウト</a>
  </li>
</ul>
</div>

<br>
<h1 class="title">ユーザ削除確認</h1>
<br>
<p class="text">ログインID:${User.loginId}</p>
<p class="text">本当に削除してよろしいでしょうか？</p>
<br>

<form class="login-form" action="DeleteUserServlet" method="post">
	<div class="button_wrapper">
	<button type="submit" class="btn btn-danger" >OK</button>
	<input type="hidden" value="${User.id}" class="form-control"  name="id">
</div>
</form>
<div class="button_wrapper">
<a type="button" class="btn btn-danger"  href="UserListServlet">cancel</a>
</div>
</body>
</html>