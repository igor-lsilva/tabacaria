<%@page import="java.util.ArrayList"%>
<%@page import="Model.Produto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="tabelaListagem">
            <div class="subTitulo">
                <h2>Lista de Produtos</h2>
            </div>               

            <div style="display: inline-block;">
                <div style="float: left; border-radius: 8px;">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                        <input type="hidden" value="listar" name="acao">
                        <div>
                            <div>
                                <input  class="inputBusca" type="text" name="busca" id="txtBuscar" placeholder=" Nome Produto">
                                <button class="campoBuscas" type="submit">Buscar</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            <div class="tabelaLista">
                <table> 
                    <tr>
                        <th class="campoID">Cod.</th>
                        <th class="campoNome">Nome</th>
                        <th class="campoDescricao">Descrição</th>
                        <th class="campoEditar">Adicionar</th>
                    </tr>                
                    <c:forEach items="${TodosProdutos}" var="p">
                        <tr>                       
                            <td class="campoID">${p.id}</td>              
                            <td class="campoNome">${p.nome}</td>               
                            <td class="campoDescricao">${p.descricao}</td>
                            <td class="campoEditar"> 
                                <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                                    <input type="hidden" value="adicionarProduto" name="acao">
                                    <input type="hidden" value="${p.id}" name="id">
                                    <input type="hidden" value="${p.nome}" name="nomeProduto">
                                    <input type="hidden" value="${p.valorCompra}" name="valorCompra">
                                    <input type="hidden" value="${p.valorVenda}" name="valorVenda">
                                    <input type="hidden" value="${p.qtde}" name="qtde">
                                    <input type="hidden" value="${p.descricao}" name="descricao">
                                    <input type="number" name="qtd">
                                    <button class="buttonEditar" type="submit">Adicionar</button>
                                </form>                            
                            </td>                           
                        </tr>
                    </c:forEach> 
                </table>
                <br>
            </div>
            <div>
                <label>Quantidade:</label>
                <input type="number" name="qtd">
            </div>
            <br><br>
            <div class="campoVoltarPosicao">           
                <div>
                    <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController">
                        <input type="hidden" value="adicionarProduto">
                        <button class="campoVoltar" type="submit">Adicionar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
