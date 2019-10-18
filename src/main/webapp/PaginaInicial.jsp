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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>..:: Tabacaria ::..</title>
    </head>
    <body>
        <div class="tituloTopo">
            <h1>NOME DA EMPRESA</h1>
        </div>
        
        <input type="hidden" name="login" value="${loginAttr}">
        <input type="hidden" name="senha" value="${senhaAttr}">
        
        <a href="${pageContext.request.contextPath}/RedirecionarFilial.jsp">Filiais</a>
        
        <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
            <input type="hidden" name="acao" value="listar">
            <button type="submit"> USUARIOS </button>
        </form>
    </body>
</html>
