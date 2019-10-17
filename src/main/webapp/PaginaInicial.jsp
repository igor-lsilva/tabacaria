<%-- 
    Document   : PaginaInicial
    Created on : 15/10/2019, 06:19:50
    Author     : Ochaus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..:: Tabacaria ::..</title>
    </head>
    <body>
        <h1 style="text-align: center;">HOOKAH BUZZ</h1>
        
        <input type="hidden" name="login" value="${loginAttr}">
        <input type="hidden" name="senha" value="${senhaAttr}">
        <a href="/Tabacaria/RedirecionarFilial.jsp">Filiais</a>
        <a href="/Tabacaria/CadastroUsuario.jsp">Usuario</a>
    </body>
</html>
