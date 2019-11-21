<%-- 
    Document   : Relatorio
    Created on : 20/11/2019, 19:40:50
    Author     : Ochaus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
    </head>
    <body>

        <div class="subTitulo">
            <h2>Lista de Produtos</h2>
        </div>
        <form>
            <div>
                <div>
                    <label>Data de Inicio</label>
                    <input type="date" name="dtInicio" >
                </div>
                <div>
                    <label>Data Final</label>
                    <input type="date" name="dtFim">
                </div>
            </div>
            <div>
                <table>
                    <tr>
                        <th>Cod. Venda</th>
                        <th>Nome Cliente</th>
                        <th>CPF</th>
                        <th>Total</th>
                        <th>Data Compra</th>
                    </tr>
                    <c:forEach items="${TodasVendas}" var="v">
                        <tr>
                            <td>${v.idVenda}</td>
                            <td>${v.nomeCliente}</td>
                            <td>${v.cpf}</td>
                            <td>${v.total}</td>
                            <td>${v.data}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div>
                <table>
                    <tr>
                        <th>Cod. Produto</th>
                        <th>Nome Produto</th>
                        <th>Valor</th>
                        <th>Quantidade</th>
                        <th>Sub Total</th>
                    </tr>
                    <c:forEach items="${TodosProdutos}" var="v">
                        <tr>
                            <td>${v.idProduto}</td>
                            <td>${v.nomeProduto}</td>
                            <td>${v.valorVenda}</td>
                            <td>${v.qtde}</td>
                            <td>${v.subTotal}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>

        <br><br>
        <div class="campoVoltarPosicao">           
            <div>
                <form action="${pageContext.request.contextPath}/PaginaInicial.jsp">
                    <button class="campoVoltar" type="submit">Voltar</button>
                </form>
            </div>
        </div>
    </body>
</html>
