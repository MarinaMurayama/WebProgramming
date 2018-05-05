<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ新規登録</title>
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
  ${errMsg1}
  ${errMsg2}
</div>

<h1 class="title">ユーザ新規登録</h1>



<form class="login-form" action="SignUpServlet" method="post">
<input type="hidden" name="id">


  <div class="form-group">
    <label for="Login ID">ログインID</label>
    <input type="text" class="form-control" id="LoginID" placeholder="Login ID" name="loginId" required>
  </div>

  <div class="form-group" >
    <label for="exampleInputPassword1">パスワード</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" required>
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">パスワード(確認)</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="password" name="passwordcheck" required>
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">ユーザ名</label>
    <input type="text" class="form-control" id="name" placeholder="User Name" name="name" required>
  </div>

 <div class="form-group">
    <label for="exampleInputPassword1">生年月日</label>
   <input type="date" class="form-control" name="birth_date" max="9999-12-31"  placeholder="入力例 → 20181010 (2001年04月01日生まれの場合)" required>
  </div>


<div class="button_wrapper">
<button type="submit" class="btn btn-danger">登録</button>

</div>

</form>

<div class="link">
<a href="UserListServlet">戻る</a>
</div>


</body>
</html>