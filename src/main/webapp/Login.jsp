<%-- 
    Document   : Login
    Created on : 16/10/2019, 18:19:25
    Author     : lucas.asilva89
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nome do Sistema</h1>
        <form action="${pageContext.request.contextPath}/AutenticarLogin" method="post">
            <label>Login:</label><input type="text" name="login">
            <br>
            <label>Senha:</label><input type="password" name="senha">
            <button type="submit">ENTRAR</button>
        </form>
    </body>
</html>
