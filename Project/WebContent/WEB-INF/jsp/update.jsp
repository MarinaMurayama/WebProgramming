<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>


<body>

<div class="alert alert-danger" role="alert">
 <ul class="nav justify-content-end">
  <li class="nav-item">
    <li class="nav-item"> ${userInfo.name}さん </li>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="LogoutServlet">ログアウト</a>
      ${errMsg1}
  </li>
</ul>
</div>

<h1 class="title">ユーザ情報更新</h1>

<form class="login-form" action="UserUpdateServlet" method="post">
  <div class="form-group">
    <label for="Login ID">ログインID : ${User.loginId}</label>
    <input type="hidden" value="${User.loginId}" class="form-control" id="LoginID"  name="loginId" required>
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">パスワード</label>
    <input type="password"  class="form-control" id="exampleInputPassword1"  name="password" >
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">パスワード(確認)</label>
    <input type="password"  class="form-control" id="exampleInputPassword1" name="passwordcheck">
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">ユーザ名</label>
    <input type="text" value="${User.name}" class="form-control" id="name"  name="name" required>
  </div>

 <div class="form-group">
    <label for="exampleInputPassword1">生年月日</label>
   <input type="date" value="${User.birthDateStr}" class="form-control" max="9999-12-31" name="birth_date" required>
  </div>

<div class="button_wrapper">
<button type="submit" class="btn btn-danger">更新</button>
</div>
</form>

<div class="link">
<a href="UserListServlet">戻る</a>
</div>

</body>
</html>