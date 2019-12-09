<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/6
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数绑定</title>
</head>
<body>

<form action="/param/saveAccount" method="post">
    姓名：<input type="text" name="username" >
    密码：<input type="password" name="password" >
    金额：<input type="text" name="money">
    用户名：<input type="text" name="user.uuname">
    年龄：<input type="text" name="user.age">
    用户名2：<input type="text" name="list[0].uuname2">
    年龄2：<input type="text" name="list[0].age">

    <input type="submit" value="提交">

</form>
</body>
</html>
