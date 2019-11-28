<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Sistema de Tabacaria</title>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.usuario != null}">
                <div>

                    <ul>
                        <c:if test="${sessionScope.usuario.verificarPapel('USUARIO')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/UsuarioController">USUARIO</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('CLIENTE')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/ClienteController">CLIENTE</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('FILIAL')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/FilialController">FILIAL</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('PRODUTO')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/ProdutoController?idEmpresa=${sessionScope.usuario.idEmpresa}">PRODUTO</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('ESTOQUE')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/EstoqueController?idEmpresa=${sessionScope.usuario.idEmpresa}">ESTOQUE</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('VENDA')}">
                            <li><a href="/Tabacaria/Venda.jsp">VENDA</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('DIRETORIA') || sessionScope.usuario.verificarPapel('GERENCIA')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/RelatorioController">RELATÓRIO</a></li>
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/FaturamentoController">FATURAMENTO</a></li>
                            </c:if>
                        <a href="${pageContext.request.contextPath}/TADS-PI3/LogoutController">SAIR</a>
                    </ul>                                       
                </div>
                <div class="dadosUsuario">
                    <div style="text-align: center;">
                        <h1>Seja bem vindo!</h1>
                        <h2>Nome: <c:out value="${sessionScope.usuario.nomeCompleto}" /></h2>
                        <p>Username: <c:out value="${sessionScope.usuario.username}" /></p>
                        <p>Filial ID: <c:out value="${sessionScope.usuario.idEmpresa}" /></p>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <h1 style="text-align: center; color: red;">Sessão Encerrada!</h1>
                    <div class="campoVoltarPosicao">           
                        <div>
                            <form action="${pageContext.request.contextPath}/Login.jsp">
                                <button class="campoVoltar" type="submit">Login</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
