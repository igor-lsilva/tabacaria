<%-- 
    Document   : ListarProduto
    Created on : 17/10/2019, 21:03:46
    Author     : Eduardo.mpaz
--%>

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
                <div style="float: left; border-radius: 8px; ">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/ProdutoController" method="post">
                        <input type="hidden" value="listar" name="acao">
                        <div>
                            <div>
                                <input type="hidden" value="${sessionScope.usuario.idEmpresa}" name="idEmpresa">
                                <input  class="inputBusca" type="text" name="busca" id="txtBuscar" placeholder=" Nome Produto">
                                <button class="campoBuscas" type="submit">Buscar</button>
                            </div>
                        </div>

                    </form>
                </div>
                <div style="display: inline-block;">
                    <form action="${pageContext.request.contextPath}/CadastroProduto.jsp" method="post">
                        <button class="campoCadastro" type="submit">Cadastrar</button>
                    </form>

                </div>
            </div>
            <div class="tabelaLista">
                <table> 
                    <tr>
                        <th class="campoID">Cod.</th>
                        <th class="campoNome">Nome</th>
                        <th class="campoDescricao">Descrição</th>
                        <th class="campoEditar">Editar</th>
                        <th class="campExcluir">Excluir</th>
                    </tr>                
                    <c:forEach items="${TodosProdutos}" var="p">
                        <tr>                       
                            <td class="campoID">${p.id}</td>              
                            <td class="campoNome">${p.nome}</td>               
                            <td class="campoDescricao">${p.descricao}</td>
                            <td class="campoEditar"> 
                                <form action="${pageContext.request.contextPath}/TADS-PI3/ProdutoController" method="post">
                                    <input type="hidden" value="alterar" name="acao">
                                    <input type="hidden" value="${p.id}" name="id">
                                    <input type="hidden" value="${p.nome}" name="nomeProduto">
                                    <input type="hidden" value="${p.valorCompra}" name="valorCompra">
                                    <input type="hidden" value="${p.valorVenda}" name="valorVenda">
                                    <input type="hidden" value="${p.qtde}" name="qtde">
                                    <input type="hidden" value="${p.descricao}" name="descricao">
                                    <button class="buttonEditar" type="submit">Editar</button>
                                </form>                            
                            </td>
                            <td class="campExcluir">
                                <form action="${pageContext.request.contextPath}/TADS-PI3/ProdutoController" method="post">
                                    <input type="hidden" value="excluir" name="acao">
                                    <input type="hidden" value="${p.id}" name="id">
                                    <button class="buttonExcluir" type="submit">Excluir</button>
                                </form>
                            </td>                            
                        </tr>
                    </c:forEach> 
                </table>
                <br>
            </div>
            <br><br>
            <div class="campoVoltarPosicao">           
                <div>
                    <form action="${pageContext.request.contextPath}/PaginaInicial.jsp">
                        <button class="campoVoltar" type="submit">Voltar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
