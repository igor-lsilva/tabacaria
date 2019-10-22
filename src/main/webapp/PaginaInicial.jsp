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
        <div>
            <ul>
                <li><a href="${pageContext.request.contextPath}/ClienteController">Cliente</a></li>
                <li><a href="${pageContext.request.contextPath}/ProdutoController">Produto</a></li>
                <li><a href="${pageContext.request.contextPath}/UsuarioController">Usuario</a></li>
                <li><a href="#">Estoque</a></li>
                <li><a href="${pageContext.request.contextPath}/FilialController">Filial</a></li>               
                <li><a href="#">Venda</a></li>
                <li><a href="#">Relatório</a></li>
                <li><a href="#">Faturamento</a></li>
                <li><a href="#">Sair</a></li>
            </ul>
        </div>

    </body>
</html>
