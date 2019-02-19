<%--
  Created by IntelliJ IDEA.
  User: Pandy
  Date: 2019/2/19
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="edit.htm" method="post">
    用户名:<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    性别: <input type="text" name="sex"/><br/>
    年龄: <input type="text" name="age"/><br/>
    签名: <input type="text" name="signd"/><br/>
    图片: <input type="file" name="photo"/><br/>
    电话: <input type="text" name="telephone"/><br/>
    邮箱: <input type="text" name="email"/><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
