<%-- 
    Document   : Venda
    Created on : 18/11/2019, 10:16:43
    Author     : igor.silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/VendaController" method="post">
            <h1>Cliente: </h1>
            <input type="text" name="idCliente" value="${idClienteAttr}">
            <input type="hidden" value="listar" name="acao">
            <button>Add</button>
        </form>
        <form action="${pageContext.request.contextPath}/VendaController" method="post">
            <h1>Cliente: </h1>
            <input type="hidden" value="listar" name="listarProduto">
            <button>Add</button>
        </form>
    </body>
</html>
