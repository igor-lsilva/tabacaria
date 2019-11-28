<%-- 
    Document   : VendaSucesso
    Created on : 28/11/2019, 15:39:34
    Author     : Ochaus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilialListar.css" />
        <title>Sucesso</title>
    </head>
    <body>
        <h1 style="text-align: center; color: green;">VENDA REALIZADA COM SUCESSO!</h1>
        <div class="campoVoltarPosicao">           
            <div>
                <form action="${pageContext.request.contextPath}/PaginaInicial.jsp">
                    <button class="campoVoltar" type="submit">Voltar</button>
                </form>
            </div>
        </div>
    </body>
</html>
