<%--
  Created by IntelliJ IDEA.
  User: Gumo
  Date: 2016/9/19
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>findUser</h1>
<table>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.uid}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
