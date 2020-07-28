<%--
  Created by IntelliJ IDEA.
  User: STONE
  Date: 2020-7-27
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>response</title>
    <%--    引入jQuery文件--%>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>

<body>

<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url: "user/testAjax",
                contentType: "application/json;charset=utf-8",
                //发送请求参数
                data: '{"username":"hmg","password":"123","age":"22"}',
                dataType: "json",
                type: "post",
                success: function (user) {
                    //data为服务器端响应回的json数据
                    alert(user.username);
                }
            })
        });
    })
</script>

<a href="user/testString">testString</a><br>
<a href="user/testVoid">testVoid</a><br>
<a href="user/testModelAndView">testModelAndView</a><br>
<a href="user/testForward">testForward</a><br>

<button id="btn">发送ajax请求</button>
</body>
</html>
