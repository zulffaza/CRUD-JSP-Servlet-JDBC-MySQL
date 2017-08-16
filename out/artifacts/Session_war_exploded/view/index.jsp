<%--
  Created by IntelliJ IDEA.
  User: faza
  Date: 20/04/17
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session - Home</title>
</head>
<body>
    <h2>
        Welcome

        <%
            if (session.getAttribute("username") != null)
                out.print(session.getAttribute("username") + "...");
            else
                out.print("Anonymous...");
        %>
    </h2>

    <%
        if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
    %>

    <a href="../controller/actionLogout.jsp">
        <button>Logout</button>
    </a>

    <%
        } else {
    %>

    <a href="../controller/actionLogin.jsp">
        <button>Login</button>
    </a>

    <%
        }
    %>
</body>
</html>