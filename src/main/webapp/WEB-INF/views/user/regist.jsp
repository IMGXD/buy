<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>注册</h1>
<p style="color: red; font-weight: 900">${message }</p>
<form action="/user/registSubmit" method="post">
	<input type="hidden" name="method" value="regist"/>
	用户名：<input type="text" name="userCustom.username" value="${user.username}"/>
    <p style="color: red; font-weight: 900">${errors.username}</p>
    <br/>
	密　码：<input type="password" name="userCustom.password"/>
    <p style="color: red; font-weight: 900">${errors.password}</p>
    <br/>
	邮　箱：<input type="text" name="userCustom.email" value="" value="${user.email}"/>
    <p style="color: red; font-weight: 900">${errors.email}</p>
    <br/>
	<input type="submit" value="注册"/>
</form>
  </body>
</html>
