<%-- 
    Document   : ListaCliente
    Created on : 17/10/2019, 19:22:47
    Author     : matheus.eleoterio
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Clientes</title>
    </head>
    <body>
        
            <div class="tituloTopo">
                <h1 style="text-align: center">NOME DA EMPRESA</h1>
            </div>
        
        <div class="subTitulo">
            <h1 style="text-align: center">Cliente</h1>
        </div>

        <div class="tabelaListagem">
            <form action="${pageContext.request.contextPath}/ListaCliente" method="post">
                <div class="campoBuscas">
                    <label for="txtBuscar">Nome do Cliente:</label>
                    <div>
                        <input type="text" name="busca" id="txtBuscar" placeholder=" Nome do Cliente">
                        <button type="submit">Buscar</button>
                    </div>
                </div>
            </form>
            <br>
            <table>
                <tr>
                    <th class="camp">Cod. </th>
                    <th class="nomeCliente">Nome do Cliente</th>
                    <th class="CPF">CPF </th>
                    <th class="dtNascimento">Data Nascimento</th>
                    <th class="campoEditar">Editar</th>
                    <th class="campExcluir">Excluir</th>
                </tr>                
                <c:forEach items="${TodosClientes}" var="c">
                    <tr>
                        <td>${c.idCliente}</td>
                        <td>${c.nomeCliente}</td>              
                        <td>${c.CPF}</td>
                        <td>${c.dtNascimento}</td>                        
                        <td> 
                            <form>
                                <a href="${pageContext.request.contextPath}/EditarCliente?id=${c.idCliente}&nomeCliente${c.nomeCliente}&CPF=${c.CPF}&dtNascimento=${c.dtNascimento}">Editar</a>
                            </form>                            
                        </td>
                        <td>
                            <form>
                                <a href="${pageContext.request.contextPath}/ExcluirCliente?id=${c.idCliente}" >Excluir</a>
                            </form>
                        </td>                            
                    </tr>
                </c:forEach> 

            </table>
            <div class="campoCadastro">
                <a href="/Tabacaria/CadastroCliente.jsp">Cadastrar</a>
            </div>
        </div>

    </body>
</html>
