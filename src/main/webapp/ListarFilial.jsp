<%@page import="java.util.ArrayList"%>
<%@page import="Model.Filial"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilialListar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Lista Filiais</title>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">
        <script>

        </script>
    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>

        <div class="tabelaListagem">
            <div class="subTitulo">
                <h2>Lista de Filias</h2>
            </div>               

            <div style="display: inline-block;">
                <div style="float: left; border-radius: 8px; ">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post">
                        <input type="hidden" value="listar" name="acao">
                        <div>
                            <div>
                                <input  class="inputBusca" type="text" name="busca" id="txtBuscar" placeholder="Buscar Filial">
                                <button class="campoBuscas" type="submit">Buscar</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div style="display: inline-block;">
                    <form action="${pageContext.request.contextPath}/CadastroFilial.jsp" method="post">
                        <button class="campoCadastro" type="submit">Cadastrar</button>
                    </form>

                </div>
            </div>
            <div class="tabelaLista">
                <table>
                    <tr>
                        <th class="campoID">Cod.</th>
                        <th class="campoNome">Nome</th>
                        <th class="campoCNPJ">CNPJ</th>
                        <th class="campoEndereco">Estado</th>
                        <th class="campoEditar">Editar</th>
                        <th class="campExcluir">Excluir</th>
                    </tr>
                    <c:forEach items="${TodasFiliais}" var="f">

                        <tr>                       
                            <td class="campoID">${f.id}</td>              
                            <td class="campoNome">${f.nomeFilial}</td>               
                            <td class="campoCNPJ">${f.CNPJ}</td>
                            <td class="campoEndereco">${f.endereco}</td>                        
                            <td class="campoEditar"> 
                                <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post">
                                    <input type="hidden" value="alterar" name="acao">
                                    <input type="hidden" value="${f.id}" name="id">
                                    <input type="hidden" value="${f.nomeFilial}" name="nomeFilial">
                                    <input type="hidden" value="${f.CNPJ}" name="CNPJ">
                                    <input type="hidden" value="${f.endereco}" name="endereco">
                                    <button class="buttonEditar" type="submit">Editar</button>
                                </form>                            
                            </td>
                            <td class="campExcluir">
                                <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post">
                                    <input type="hidden" value="excluir" name="acao">
                                    <input type="hidden" value="${f.id}" name="id">
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