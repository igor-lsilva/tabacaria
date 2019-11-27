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
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssProdutoListar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Lista produtos</title>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">
    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <div>            
        </div>
        <div class="tabelaListagem">
            <div class="subTitulo">
                <h2>Tabela de Itens:</h2>
            </div>                       

            <div style="display: inline-block;">
                <div style="float: left; border-radius: 8px;">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                        <input type="hidden" value="listarProduto" name="acao">
                        <input type="hidden" value="${sessionScope.usuario.idEmpresa}" name="idEmpresa">
                        <div>
                            <button class="campoBuscas" type="submit">Adicionar Item</button>
                        </div>                        
                    </form>
                </div>
                <div style="display: inline-block;">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">                       
                        <input type="hidden" value="listar" name="acao">                       
                        <input type="text" name="idCliente" value="${idClienteAttr}" readonly="true">
                        <button class="campoBuscas" type="submit">Adicionar Cliente</button>
                    </form>
                </div>
            </div>
            <div class="tabelaLista">
                <table> 
                    <tr>
                        <th class="campoID">Cod.</th>
                        <th class="campoNome">Nome</th>
                        <th class="campoID">Qtd</th>
                        <th class="campoPreco">Preco Uni.</th>
                        <th class="campoPreco">Preco Total.</th>
                        <th class="campoEditar">Remover</th>
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
                                    <input type="hidden" name="idProduto">
                                    <button class="campoEditar"type="submit">Remover</button>   
                                </form>
                            </td>                          
                        </tr>
                    </c:forEach> 
                </table>
                <br>
            </div>
            <div class="subTitulo1">
                <h1>Preço Final: ${sessionScope.itensSelecionados.precoFinal}</h1>             
                <br>
            </div>
            <div class="campoVoltarPosicao">           
                <div>
                    <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                        <input type="hidden" name="idCliente">
                        <input type="hidden" value="${sessionScope.usuario.idEmpresa}" name="idEmpresa">
                        <input type="hidden" value="cadastrarVenda" name="acao">
                        <button class="campoBuscas" type="submit">Cadastrar Venda</button> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>