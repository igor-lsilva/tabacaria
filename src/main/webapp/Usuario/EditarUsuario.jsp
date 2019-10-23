<%@page import="java.util.ArrayList"%>
<%@page import="Model.Funcionario"%>
<%@page import="Model.Filial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssEditar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <h1>Edição usuário</h1>
        <div class="itens">
            <div class="subTitulo">
                <h2>Editar Usuário</h2>
            </div>
            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>
            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">
                <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
                    <input type="hidden" name="acao" value="atualizar">
                    <div>
                        <label>Codigo:</label>
                        <div>
                            <input type="text" name="id" value="${f.id}" readonly="true">
                        </div>
                    </div>
                    <div>
                        <label>Nome:</label>
                        <div>
                            <input type="text" name="nome" value="${f.nomeCompleto}">
                        </div>
                    </div>
                    <div>
                        <label>CPF:</label>
                        <div>
                            <input type="text" name="cpf" value="${f.cpf}">
                        </div>
                    </div>
                    <div>
                        <label>Cargo:</label>
                        <div>
                            <input type="text" name="cargo" value="${f.cargo}">
                        </div>
                    </div>
                    <div>
                        <label>Código da Filial:</label>
                        <div>
                            <select name="filial">
                                <c:forEach items="${todasFilial}" var="filial">
                                    <c:if test="${$filial.id == $f.id}">
                                        <option value="${filial.id}" selected="selected">
                                            ${filial.nomeFilial}
                                        </option>
                                    </c:if>
                                    <c:if test="${$filial.id != $f.id}">
                                        <option value="${filial.id}">
                                            ${filial.nomeFilial}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div>
                        <label>Contato:</label>
                        <div>
                            <input type="text" name="contato" value="${f.contato}">
                        </div>
                    </div>
                    <div>
                        <label>Login:</label>
                        <div>
                            <input type="text" name="login" value="${f.login}">
                        </div>
                    </div>
                    <div>
                        <label>Senha:</label>
                        <div>
                            </label><input type="password" name="senha" value="${f.senha}" id="senha">
                        </div>
                    </div>
                    <div class="posicaoButtons">
                        <button type="submit" name="atualizar" class="botaoPadrao">Editar</button>
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