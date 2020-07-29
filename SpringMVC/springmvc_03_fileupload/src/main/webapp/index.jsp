<%--
  Created by IntelliJ IDEA.
  User: STONE
  Date: 2020-7-27
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div>正常方式上传文件</div>
<form action="user/fileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>

<br>

<div>传统方式上传文件</div>

<form action="user/fileUpload2" method="post" enctype="multipart/form-data">
    <%--    file标签的name必须与multipartFile对象变量名一致--%>
    选择文件：<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>

<div>跨服务器上传文件</div>

<form action="user/fileUpload3" method="post" enctype="multipart/form-data">
    <%--    file标签的name必须与multipartFile对象变量名一致--%>
    选择文件：<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
