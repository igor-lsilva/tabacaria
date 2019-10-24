<%-- 
    Document   : CadastroUsuario
    Created on : 17/10/2019, 11:14:22
    Author     : igor.silva
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Filial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/ValidarUsuario.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssEditar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />

    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <div class="itens">

            <div class="subTitulo">
                <h2>Cadastro de Usuário</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">
                <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                    <input type="hidden" name="acao" value="salvar">
                    <div>
                        <label>Nome:</label>
                        <div>
                            <input type="text" name="nome">
                        </div>
                    </div>
                    <div>
                        <label>CPF:</label>
                        <div>
                            <input type="text" name="cpf">
                        </div>
                    </div>
                    <div>
                        <label>Cargo:</label>
                        <div>
                            <input type="text" name="cargo">
                        </div>
                    </div>
                    <div>
                        <label>Codigo Empresa</label>
                        <div>
                            <select name="codEmp">
                                <c:forEach items="${todasFilial}" var="filial">
                                    <option value="${filial.id}">
                                        ${filial.nomeFilial}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div>
                        <label>Contato:</label>
                        <div>
                            <input type="text" name="contato">
                        </div>
                    </div>
                    <div>
                        <label>login:</label>
                        <div>
                            <input type="text" name="login" id="login">
                        </div>
                    </div>
                    <div>
                        <label>Senha:</label>
                        <div>
                            <input type="password" name="senha" id="senha">
                        </div>
                    </div>
                    <div class="posicaoButtons">
                        <button type="submit" name="cadastrar" class="botaoPadrao">Cadastrar</button>
                        <button type="reset" class="botaoPadrao">Resetar</button>
                    </div>
                </form>
                <div class="campoVoltarPosicao">
                    <div>
                        <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
