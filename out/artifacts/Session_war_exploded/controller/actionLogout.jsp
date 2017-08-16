<%--
  Created by IntelliJ IDEA.
  User: faza
  Date: 20/04/17
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session - Action Logout</title>
</head>
<body>
    <%
        session.removeAttribute("username");
        session.removeAttribute("password");

        response.sendRedirect("../web/view/index.jsp");
    %>
</body>
</html>
