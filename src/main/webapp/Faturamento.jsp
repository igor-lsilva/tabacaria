<%-- 
    Document   : Faturamento
    Created on : 28/11/2019, 18:40:05
    Author     : igor.lsilva9
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilialListar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Relatório</title>
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
                <h2>Relatório de Venda</h2>
            </div>               

            <div style="display: inline-block;">
                <div style="float: left; border-radius: 8px;">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/FaturamentoController" method="post">
                        <input type="hidden" value="listar" name="acao">
                        <div style="display: table;">
                            <div style="float: left;">
                                <c:choose>
                                    <c:when test="${sessionScope.usuario.verificarPapel('DIRETORIA')}">
                                        <div>
                                            <div>

                                                <div>
                                                    <select name="codEmp" style="height: 40px; width: 100px; border-radius: 8px;">
                                                        <c:forEach items="${todasFilial}" var="filial">
                                                            <option value="${filial.id}">
                                                                ${filial.nomeFilial}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>                                                                     
                                        </div>               
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${sessionScope.usuario.verificarPapel('GERENCIA')}">
                                            <label>Empresa</label>
                                            <div>
                                                <select name="codEmp">
                                                    <c:forEach items="${todasFilial}" var="filial">
                                                        <c:if test="${filial.id == sessionScope.usuario.idEmpresa}">
                                                            <option value="${filial.id}">
                                                                ${filial.nomeFilial}
                                                            </option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </c:if>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div style="float: left; font-family: monospace; ">
                                <label> Data Inicial</label>
                                <input type="date" name="dataInicio" min="00/00/0000" max="31/12/9999" required style="border-radius: 8px; height: 40px; width: 150px;">
                            </div>
                            <div style="float: left; font-family: monospace;">
                                <label> Data Final</label>
                                <input type="date" name="dataFim" min="00/00/0000" max="31/12/9999" required style="border-radius: 8px; height: 40px; width: 150px;">
                            </div>
                            <div style="float: left;">
                                <button class="campoBuscas" type="submit">Buscar</button>
                            </div>
                        </div>
                    </form>

                    <div class="tabelaLista">
                        <table>
                            <tr>
                                <th class="campoID">Cod. Produto </th>
                                <th class="campoCNPJ">Nome </th>
                                <th class="campoEndereco">Qtde.</th>
                            </tr>
                            <c:forEach items="${TodosProdutos}" var="p">

                                <tr>                       
                                    <td class="campoID">${p.id}</td>              
                                    <td class="campoNome">${p.nome}</td>               
                                    <td class="campoCNPJ">${p.qtde}</td>
                                </tr>

                            </c:forEach>
                        </table>
                        <br>
                    </div>
                    <div class="campoVoltarPosicao">           
                        <div>
                            <form action="${pageContext.request.contextPath}/PaginaInicial.jsp">
                                <button class="campoVoltar" type="submit">Voltar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
