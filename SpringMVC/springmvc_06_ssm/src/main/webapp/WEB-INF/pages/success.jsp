<%--
  Created by IntelliJ IDEA.
  User: STONE
  Date: 2020-8-3
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>success</title>
</head>
<body>
<h3>success</h3>

<c:forEach items="${list}" var="account" varStatus="i">
    ${account.name}<br>
</c:forEach>
</body>
</html>
