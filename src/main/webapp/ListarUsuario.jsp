<%@page import="java.util.ArrayList"%>
<%@page import="Model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/ValidarUsuario.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssUsuarioLista.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Lista Usuario</title>
    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>

        <div class="tabelaListagem">
            <div class="subTitulo">
                <h2>Lista de usuários</h2>
            </div>  
            <div style="display: inline-block;">
                <div style="float: left; border-radius: 8px; ">
                    <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                        <input type="hidden" value="listar" name="acao">
                        <div>
                            <div>
                                <input  class="inputBusca" type="text" name="busca" id="txtBuscar" placeholder=" Digite um usuário">
                                <button class="campoBuscas" type="submit">Buscar</button>
                            </div>
                        </div>

                    </form>
                </div>
                <div style="display: inline-block;">
                    <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                        <input type="hidden" value="cadastrar" name="acao">
                        <button class="campoCadastro" type="submit">Cadastrar</button>
                    </form>

                </div>
            </div>
            <br>
            <table class="table"> 
                <tr>
                    <th class="campoId">Id</th>
                    <th class="campoNome">Nome </th>
                    <th class="campoCpf">CPF</th>
                    <th class="campologin">Login</th>
                    <th class="campoEmpresa">Empresa</th>
                    <th class="campoCargo">Modulo</th>
                    <th class="campoContato">Contato</th>
                    <th class="campoEditar">Editar</th>
                    <th class="campoExcluir">Excluir</th>


                </tr>                
                <c:forEach items="${TodosUsuarios}" var="user">
                    <tr>                       
                        <td>${user.id}</td>
                        <td>${user.nomeCompleto}</td> 
                        <td>${user.cpf}</td>               
                        <td>${user.login}</td>
                        <td>${user.idEmpresa}</td>                        
                        <td>${user.idModulo}</td>                        
                        <td>${user.contato}</td>                        
                        <td> 
                            <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                                <input type="hidden" value="editar" name="acao">
                                <input type="hidden" value="${user.id}" name="id">
                                <input type="hidden" value="${user.nomeCompleto}" name="nome">
                                <input type="hidden" value="${user.cpf}" name="cpf">
                                <input type="hidden" value="${user.login}" name="login">
                                <input type="hidden" value="${user.idEmpresa}" name="filial">
                                <input type="hidden" value="${user.idModulo}" name="modulo">
                                <input type="hidden" value="${user.contato}" name="contato">
                                <input type="hidden" value="${user.senha}" name="senha">
                                <button type="submit" class="buttonPadrao">Editar</button>
                            </form>                           
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                                <input type="hidden" value="excluir" name="acao">
                                <input type="hidden" value="${user.id}" name="id">
                                <button type="submit" class="buttonPadrao">Excluir</button>
                            </form>
                        </td>                            
                    </tr>
                </c:forEach> 
            </table>
            <div class="campoVoltarPosicao">
                <form action="${pageContext.request.contextPath}/PaginaInicial.jsp" method="post">
                    <button type="submit" class="campoVoltar">Voltar</button>
                </form>
            </div>
        </div>

    </body>
</html>
