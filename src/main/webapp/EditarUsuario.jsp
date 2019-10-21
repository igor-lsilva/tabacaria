<%@page import="java.util.ArrayList"%>
<%@page import="Model.Funcionario"%>
<%@page import="Model.Filial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Edição usuário</h1>
    <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
        <input type="hidden" name="acao" value="atualizar">
        <label>Codigo:</label><input type="text" name="id" value="${f.id}" readonly="true"><br>
        <label>Nome:</label><input type="text" name="nome" value="${f.nomeCompleto}"><br>
        <label>CPF:</label><input type="text" name="cpf" value="${f.cpf}"><br>
        <label>Cargo:</label><input type="text" name="cargo" value="${f.cargo}"><br>
        <label>Código da Filial:</label>
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
        </select><br>
        <label>Contato:</label><input type="text" name="contato" value="${f.contato}"><br>
        <label>Login:</label><input type="text" name="login" value="${f.login}"><br>
        <label>Senha:</label><input type="password" name="senha" value="${f.senha}" id="senha"><br>
        <button type="submit" name="atualizarr">Cadastrar</button>
        <button type="reset" value="Resentar"</button>
    </form>
</body>
</html>
