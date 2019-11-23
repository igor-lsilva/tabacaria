<%@page import="java.util.ArrayList"%>
<%@page import="Model.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssClienteListar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Lista Clientes</title>
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
                <h2>Lista de Clientes</h2>
            </div>               

            <div style="display: inline-block;">
                <div style="float: left; border-radius: 8px; ">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                        <input type="hidden" value="listar" name="acao">
                        <div>
                            <div>
                                <input  class="inputBusca" type="text" name="busca" id="txtBuscar" placeholder=" Nome Cliente">
                                <button class="campoBuscas" type="submit">Buscar</button>
                            </div>
                        </div>

                    </form>
                </div>
                <div style="display: inline-block;">
                    <form action="${pageContext.request.contextPath}/TADS-PI3/CadastroCliente.jsp" method="post">
                        <button class="campoCadastro" type="submit">Cadastrar</button>
                    </form>

                </div>
            </div>
            <div class="tabelaLista">
            <table>
                <tr>
                    <th class="campoID">Cod. </th>
                    <th class="campoNome">Nome do Cliente</th>
                    <th class="campoCPF">CPF </th>
                    <th class="campoDtNascimento">Data Nascimento</th>
                    <th class="campoContato">Contato</th>
                    <th class="campoEditar">Editar</th>
                </tr>                
                <c:forEach items="${TodosClientes}" var="c">
                    <tr>
                        <td class="campoID">${c.idCliente}</td>
                        <td class="campoNome">${c.nomeCliente}</td>              
                        <td class="CampoCPF">${c.CPF}</td>
                        <td class="campoDtNascimento">${c.dtNascimento}</td>
                        <td class="campoContato">${c.contato}</td>                        
                        <td class="campoEditar"> 
                            <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
                                    <input type="hidden" value="adicionarCliente" name="acao">                                  
                                    <input type="hidden" value="${c.idCliente}" name="id">
                                    <button class="buttonEditar" type="submit">Adicionar</button>
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
