<%-- 
    Document   : ListaUsuario
    Created on : 17/10/2019, 19:17:23
    Author     : igor.lsilva9
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
                <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
       
        <title>Lista Usuario</title>
    </head>
    <body>
        
            <div class="tituloTopo">
                <h1 style="text-align: center">NOME DA EMPRESA</h1>
            </div>
        
        <div class="subTitulo">
            <h1 style="text-align: center">Usuários do Sistema</h1>
        </div>

        <div class="tabelaListagem">
            <form action="${pageContext.request.contextPath}/CadastroUsuario" method="post">
                <div class="campoBuscas">
                    <label for="txtBuscar">Nome:</label>
                    <div>
                        <input type="text" name="busca" id="txtBuscar" placeholder=" Nome do Usuario">
                        <button type="submit">Buscar</button>
                    </div>
                </div>
            </form>
            <br>
            <table border=1 cellspacing=0 cellpadding=2 bordercolor="666633"> 
                <tr>
                    <th>Cargo</th>
                    <th>Id </th>
                    <th>Contato </th>
                    <th>Cargo</th>
                    <th>Id </th>
                    <th>Contato </th>
                    

                </tr>                
                <c:forEach items="${TodosUsuarios}" var="user">
                    <tr>                       
                        <td>${user.id}</td>
                        <td>${user.nomeCompleto}</td> 
                        <td>${user.cpf}</td>               
                        <td>${user.login}</td>
                        <td>${user.idEmpresa}</td>                        
                        <td>${user.cargo}</td>                        
                        <td>${user.contato}</td>                        
                        <td> 
                            <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                                <input type="hidden" value="alterar" name="acao">
                                <input type="hidden" value="${user.id}" name="id">
                                <input type="hidden" value="${user.nomeCompleto}" name="nome">
                                <input type="hidden" value="${user.cpf}" name="cpf">
                                <input type="hidden" value="${user.login}" name="login">
                                <input type="hidden" value="${user.idEmpresa}" name="filial">
                                <input type="hidden" value="${user.cargo}" name="cargo">
                                <input type="hidden" value="${user.contato}" name="contato">

                                <button type="submit">Editar</button>
                            </form>                           
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                                <input type="hidden" value="excluir" name="acao">
                                <input type="hidden" value="${user.id}" name="id">
                                <button type="submit">Excluir</button>
                            </form>
                        </td>                            
                    </tr>
                </c:forEach> 

            </table>
            <div class="campoCadastro">
                <a href="/Tabacaria/CadastroUsuario.jsp">Cadastrar</a>
            </div>
        </div>

    </body>
</html>
