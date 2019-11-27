<%-- 
    Document   : Fail
    Created on : 13/10/2019, 23:47:37
    Author     : Ochaus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilialListar.css" />
        <title>Error</title>
    </head>
    <body>
        <h1 style="text-align: center; color: red;">ACESSO NÃO PERMITIDO!</h1>
        <div class="campoVoltarPosicao">           
            <div>
                <form action="${pageContext.request.contextPath}/PaginaInicial.jsp">
                    <button class="campoVoltar" type="submit">Voltar</button>
                </form>
            </div>
        </div>
    </body>
</html>
