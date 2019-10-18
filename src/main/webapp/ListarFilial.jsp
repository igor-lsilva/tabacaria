<%-- 
    Document   : Foi
    Created on : 13/10/2019, 23:53:11
    Author     : Ochaus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Filial"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilial.css" />
        <title>Lista Filiais</title>
    </head>
    <body>

        <div class="tituloTopo">
            <h1>NOME DA EMPRESA</h1>
        </div>

        <div class="subTitulo">
            <h1 style="text-align: center">Filias</h1>
        </div>

        <div class="tabelaListagem">
            <form action="${pageContext.request.contextPath}/ListarFilial" method="post">
                <div class="campoBuscas">
                    <label for="txtBuscar">Nome:</label>
                    <div>
                        <input type="text" name="busca" id="txtBuscar" placeholder=" Nome da Filial">
                        <button type="submit">Buscar</button>
                    </div>
                </div>
            </form>
            <br>
            <table> 
                <tr>
                    <th class="campoID">Cod. </th>
                    <th class="campoNome">Nome </th>
                    <th class="campoCNPJ">CNPJ </th>
                    <th class="campoEndereco">Endereço </th>
                    <th class="campoEditar">Editar</th>
                    <th class="campExcluir">Excluir</th>
                </tr>                
                <c:forEach items="${TodasFiliais}" var="f">
                    <tr>                       
                        <td>${f.id}</td>              
                        <td>${f.nomeFilial}</td>               
                        <td>${f.CNPJ}</td>
                        <td>${f.endereco}</td>                        
                        <td> 
                            <form action="${pageContext.request.contextPath}/FilialController" method="post">
                                <input type="hidden" value="alterar" name="acao">
                                <input type="hidden" value="${f.id}" name="id">
                                <input type="hidden" value="${f.nomeFilial}" name="nomeFilial">
                                <input type="hidden" value="${f.CNPJ}" name="CNPJ">
                                <input type="hidden" value="${f.endereco}" name="endereco">
                                <button type="submit">Editar</button>
                            </form>                            
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/FilialController" method="post">
                                <input type="hidden" value="excluir" name="acao">
                                <input type="hidden" value="${f.id}" name="id">
                                <button type="submit">Excluir</button>
                            </form>
                        </td>                            
                    </tr>
                </c:forEach> 

            </table>
            <div>
                <div class="campoCadastro">
                    <a href="/Tabacaria/CadastroFilial.jsp">Cadastrar</a>
                </div>
                <div class="campoVoltar">
                    <a href="/Tabacaria/PaginaInicial.jsp">Voltar</a>
                </div>
            </div>
        </div>

    </body>
</html>
