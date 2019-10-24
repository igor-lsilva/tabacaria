<%-- 
    Document   : ListarProduto
    Created on : 17/10/2019, 21:03:46
    Author     : Eduardo.mpaz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Produto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/ValidarUsuario.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilial.css" />
        <title>Lista produtos</title>
    </head>
    <body>
        
            <div class="tituloTopo">
                <h1 style="text-align: center">NOME DO PRODUTO</h1>
            </div>
        
        <div class="subTitulo">
            <h1 style="text-align: center">Produtos</h1>
        </div>

        <div class="tabelaListagem">
            <form action="${pageContext.request.contextPath}/ListarProduto" method="post">
                <div class="campoBuscas">
                    <label for="txtBuscar">Nome:</label>
                    <div>
                        <input type="text" name="busca" id="txtBuscar" placeholder=" Nome do Produto">
                        <button type="submit">Buscar</button>
                    </div>
                </div>
            </form>
            <br>
            <table> 
                <tr>
                    <th class="campoID">Cod. </th>
                    <th class="campoNome">Nome </th>
                    <th class="campoPreco">Preco </th>
                    <th class="campoTipo">Tipo </th>
                    <th class="campoEditar">Editar</th>
                    <th class="campExcluir">Excluir</th>
                </tr>                
                <c:forEach items="${TodosProdutos}" var="p">
                    <tr>                       
                        <td>${p.id}</td>              
                        <td>${p.nomeFilial}</td>               
                        <td>${p.preco}</td>
                        <td>${p.tipo}</td>                        
                        <td> 
                            <form>
                                <a href="${pageContext.request.contextPath}/EditarProduto?id=${p.id}&nomeProduto=${p.nomeProduto}&preco=${p.preco}&tipo=${p.tipo}">Editar</a>
                            </form>                            
                        </td>
                        <td>
                            <form>
                                <a href="${pageContext.request.contextPath}/ExcluirProduto?id=${p.id}" >Excluir</a>
                            </form>
                        </td>                            
                    </tr>
                </c:forEach> 

            </table>
            <div class="campoCadastro">
                <a href="/Tabacaria/CadastroProduto.jsp">Cadastrar</a>
            </div>
        </div>
    </body>
</html>
