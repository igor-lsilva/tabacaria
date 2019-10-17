<%-- 
    Document   : Foi
    Created on : 13/10/2019, 23:53:11
    Author     : Ochaus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Filial"%>
<%@page import="Controller.FilialController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilial.css" />
        <title>Lista Filiais</title>
    </head>
    <body>
        <h1 style="text-align: center">NOME DA EMPRESA</h1>
        <br>
        <h1 style="text-align: center">Filias</h1>
        
        <div style="border: 1px solid black; padding: 12px; float: left; position: 
             absolute; left: 50%; top: 50%; margin-right: -50%;transform: translate(-50%,-50%);">
            <form action="${pageContext.request.contextPath}/ListarFilial" method="post">
                <label>Nome:</label><br>
                <input type="text" name="busca">
                <button type="submit">OK</button>
                <br>
            </form>
                <table border="1" celpadding="10">

                <tr>
                    <th class="campoID">Cod. </th>
                    <th class="campoNome">Nome </th>
                    <th class="campoCNPJ">CNPJ </th>
                    <th class="campoEndereco">Endereço </th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
                <c:forEach items="${TodasFiliais}" var="f">
                    <tr>                       
                        <td>${f.id}</td>              
                        <td>${f.nomeFilial}</td>               
                        <td>${f.CNPJ}</td>
                        <td>${f.endereco}</td>                                               
                        <td> 
                            <a href="${pageContext.request.contextPath}/EditarFilial?id=${f.id}&nomeFilial=${f.nomeFilial}&CNPJ=${f.CNPJ}&endereco=${f.endereco}"><img src="${pageContext.request.contextPath}/Icones/alterar.png"></a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ExcluirFilial?id=${f.id}" ><img src="${pageContext.request.contextPath}/Icones/excluir.png"></a>
                        </td>               
                    </tr>
                </c:forEach>
            </table>

            <a href="/Tabacaria/CadastroFilial.jsp">Novo</a>
        </div>

    </body>
</html>
