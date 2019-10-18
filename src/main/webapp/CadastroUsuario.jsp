<%-- 
    Document   : CadastroUsuario
    Created on : 17/10/2019, 11:14:22
    Author     : igor.silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>

        </script>

    </head>
    <body>
        <h1>Cadastro de usuário</h1>
        <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
            <input type="hidden" name="acao" value="salvar">
            <label>Nome:</label><input type="text" name="nome"><br>
            <label>CPF:</label><input type="text" name="cpf"><br>
            <label>Cargo:</label><input type="text" name="cargo"><br>
             <label>Código da Filial:</label><input type="text" name="codEmp"><br> 
            <label>Contato:</label><input type="text" name="contato"><br>
            <label>Login:</label><input type="text" name="login"><br>
            <label>Senha:</label><input type="password" name="senha" id="senha"><br>
            <button type="submit" name="cadastrar">Cadastrar</button>
            <button type="reset" value="Resentar"</button>
        </form>
    </body>
</html>
