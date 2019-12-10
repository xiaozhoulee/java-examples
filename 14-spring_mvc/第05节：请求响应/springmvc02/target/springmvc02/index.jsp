<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/9
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user/testString">sdsda</a>
<button id="btn">发送ajax</button>

<script src="js/jquery.min.js"></script>

<script>
    $(function () {
     $("#btn").click(function () {
         $.ajax({
             // 请求路径
             url:"/user/testAjax",
             //设置编码集为utf-8
             contentType:"application/json;charset=UTF-8",
             //发送到服务器的数据
             data:'{"username":"xiaozhou","password":"123","age":"20"}',
             //设置为json返回格式
             dataType:"json",
             //设置请求格式
             type:"post",
             success:function (data) {
                 alert(data.username)

             }
             // succsess:function () {
             //     //data服务器端响应的json数据，进行解析
             //     alert(data)
             //     alert(data.username)
             // }
         })
     })
    })
</script>
</body>
</html>
