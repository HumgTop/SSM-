<%--
  Created by IntelliJ IDEA.
  User: STONE
  Date: 2020-7-22
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>params</title>
</head>
<body>
<a href="anno/testRequestParam?username=humg">Servlet原生api</a>

<form action="anno/testModelAttribute" method="post">
    <div>
        用户姓名：<input type="text" name="uname">
    </div>
    <div>
        用户年龄：<input type="text" name="age">
    </div>
    <input type="submit" value="提交">
</form>

<a href="anno/testRequestHeader">测试@RequestHeader注解</a><br>
<a href="anno/testCookieValue">测试CookieValue注解</a><br>
<a href="anno/testModelAttribute">测试ModelAttribute注解</a><br>
<a href="anno/testSessionAttribute">测试sessionAttribute注解</a><br>
<a href="anno/testGetSessionAttribute">从request域中取值</a><br>
<a href="anno/testDelSessionAttribute">清除session域</a><br>

</form>
</body>
</html>
