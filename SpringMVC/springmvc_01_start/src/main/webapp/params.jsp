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
<form action="/user/saveAccount" method="post">
    <%--    将三个属性封装到一个Account对象，再把2个Account对象封装到集合中--%>
    <div>
        姓名：<input type="text" name="accountList[0].username">
    </div>
    <div>
        密码：<input type="text" name="accountList[0].password">
    </div>
    <div>
        金额：<input type="text" name="accountList[0].money">
    </div>

    <div>
        姓名：<input type="text" name="accountMap['one'].username">
    </div>
    <div>
        密码：<input type="text" name="accountMap['one'].password">
    </div>
    <div>
        金额：<input type="text" name="accountMap['one'].money">
    </div>

    <div>
        用户姓名：<input type="text" name="uname">
    </div>
    <div>
        用户年龄：<input type="text" name="age">
    </div>
    <input type="submit" value="提交">
</form>
</body>
</html>
