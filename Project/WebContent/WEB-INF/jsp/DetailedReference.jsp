<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報詳細参照</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>


<body>

<div class="alert alert-danger" role="alert">
 <ul class="nav justify-content-end">
  <li class="nav-item">
    <li class="nav-item"> ${userInfo.name}さん</li>
  <li class="nav-item">
    <a class="nav-link" href="LogoutServlet">ログアウト</a>
  </li>
</ul>
</div>

<h1 class="title">ユーザ情報詳細参照</h1>

<form class="login-form">

  <div class="form-group">
    <label for="Login ID">ログインID :${User.loginId}</label>
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">ユーザ名 :${User.name}</label>
  </div>

  <div class="form-group">
    <label for="birthDate">生年月日 :${User.birthDateFmt}</label>
  </div>

  <div class="form-group">
  <label for="create_date">登録日時 :${User.createDateFmt}</label>
  </div>

  <div class="form-group">
  <label for="update_date">更新日時 :${User.updateDateFmt}</label>
  </div>


</form>

<div class="link">
<a href="UserListServlet">戻る</a>
</div>

</body>
</html>