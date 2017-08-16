<%--
  Created by IntelliJ IDEA.
  User: faza
  Date: 20/04/17
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session - Action Login</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        session.setAttribute("username", username);
        session.setAttribute("password", password);

        response.sendRedirect("../web/view/index.jsp");
    %>
</body>
</html>