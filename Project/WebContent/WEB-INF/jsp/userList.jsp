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
  <li class="nav-item"> ${userInfo.name}さん </li>
  <li class="nav-item">
    <a class="nav-link" href="LogoutServlet">ログアウト</a>
  </li>
</ul>
</div>

<h1 class="title">ユーザ一覧</h1>

<div class="link">
<a href="SignUpServlet">新規登録</a>
</div>

<form class="login-form" action="UserListServlet" method="post">
  <div class="form-group">
    <label for="Login ID">ログインID</label>
    <input type="text" class="form-control" id="LoginID" placeholder="LoginID" name="loginId">
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">ユーザ名</label>
    <input type="text" class="form-control" id="name" placeholder="User Name" name="name">
  </div>

 <div class="form-group">
    <label for="exampleInputPassword1">生年月日</label>
    <div class="row">
    	<div class="col-5">
	    	<input type="date" name="birth_date1" class="form-control"  max="9999-12-31" placeholder="入力例 → 20181010">
	    </div>
	    <div class="col-2 button_wrapper">
	    	～
	    </div>
	    <div class="col-5">
			<input type="date" name="birth_date2" class="form-control"  max="9999-12-31" placeholder="入力例 → 20181231">
		</div>
	</div>
  </div>
	<div class="button_wrapper" >
	<button type="submit" class="btn btn-danger">検索</button>
	</div>
</form>

<br>
<br>


 <div class="table-responsive">
   <table class="table">
      <thead>
    <tr>
      <th scope="col">ログインID</th>
      <th scope="col">ユーザ名</th>
      <th scope="col">生年月日</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>


   <c:forEach var="user" items="${userList}" >
    <tr>
    <td>${user.loginId}</td>
    <td>${user.name}</td>
    <td>${user.birthDate}</td>

  <td>
  <a  class="btn btn-outline-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
  <c:if test="${userInfo.loginId == user.loginId}">
      <a  class="btn btn-outline-success" href="UserUpdateServlet?id=${user.id}">更新</a></c:if>
  <c:if test="${userInfo.loginId =='admin'}">
      <a  class="btn btn-outline-danger" href="DeleteUserServlet?id=${user.id}">削除</a></c:if>
  </td>
    </tr>
     </c:forEach>


  </tbody>
</table>
</div>


</body>
</html>