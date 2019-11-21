<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>JSP Page</title>
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
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/ProdutoController">PRODUTO</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('ESTOQUE')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/EstoqueController">ESTOQUE</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('VENDA')}">
                            <li><a href="${pageContext.request.contextPath}/TADS-PI3/VendaController">VENDA</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('ADMINISTRADOR')}">
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
                    <p>Usuário não fez login</p>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
