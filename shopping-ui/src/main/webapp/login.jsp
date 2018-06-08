<%--
  Created by IntelliJ IDEA.
  User: CHRISTIAN
  Date: 07/06/2018
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login Page</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <label for="txtUsuario">Usuario</label>
        <input type="text" id="txtUsuario" name="txtUsuario" />
    </p>
    <p>
        <label for="txtContrasena">Contraseña</label>
        <input type="password" id="txtContrasena" name="txtContrasena" />
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Ingresar</button>
</form>
</body>
</html>
