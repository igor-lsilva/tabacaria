<%-- 
    Document   : Venda
    Created on : 18/11/2019, 10:16:43
    Author     : igor.silva
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Item"%>
<%@page import="Model.Venda"%>
<%@page import="Model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssUsuarioLista.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Lista Usuario</title>
    </head>
    <body>

        =======
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">

            <h1>Cliente: </h1>
            <input type="text" name="idCliente" value="${idClienteAttr}">
            <input type="hidden" value="listar" name="acao">
            <button>Add</button>
        </form>
        <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
            <h1>Produto: </h1>
            <input type="hidden" value="listarProduto" name="acao">
            <button>Add</button>
        </form>
        <div class="tabelaLista">
            <table> 
                <tr>
                    <th class="campoNome">Cod.</th>
                    <th class="campoNome">Nome</th>
                    <th class="campoNome">Qtd</th>
                    <th class="campoNome">Preco Uni.</th>
                    <th class="campoNome">Preco Total.</th>
                    <th class="campoNome">Remover</th>
                </tr>                
                <c:forEach items="${sessionScope.itensSelecionados.itens}" var="p">
                    <tr>                       
                        <td>${p.p.id}</td>              
                        <td>${p.p.nome}</td>              
                        <td>${p.qtd}</td>                                                                             
                        <td>${p.p.valorVenda}</td>                                                                             
                        <td>${p.preco}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                                <input type="hidden" value="retirarProduto" name="acao">
                                <input type="hidden" value="${p.p.id}" name="idProduto">
                                <button type="submit">Remover</button>   
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <label>PREÇO FINAL: </label>
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>${sessionScope.itensSelecionados.precoFinal}</td>
                </tr>
            </table>
        </div>
        <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
            <input type="hidden" value="${idClienteAttr}" name="idCliente">
            <input type="hidden" value="${sessionScope.usuario.idEmpresa}" name="idEmpresa">
            <input type="hidden" value="cadastrarVenda" name="acao">
            <button type="submit">Cadastrar Venda</button> 
        </form>
</body>
</html>
