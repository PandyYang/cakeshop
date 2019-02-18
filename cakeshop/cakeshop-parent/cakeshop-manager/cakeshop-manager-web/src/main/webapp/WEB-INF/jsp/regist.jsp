<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
 <h1>用户注册</h1>
 <form action="addUser.htm" method="post" enctype="multipart/form-data">
     用户名:<input type="text" name="username"/><br/>
     密码：<input type="password" name="password"/><br/>
     性别: <input type="text" name="sex"/><br/>
     年龄: <input type="text" name="age"/><br/>
     签名: <input type="text" name="signd"/><br/>
     图片: <input type="file" name="photo"/><br/>
     电话: <input type="text" name="telephone"/><br/>
     邮箱: <input type="text" name="email"/><br/>
   <input type="submit" value="注册"/><br/>
 </form>
</center>
</body>
</html>