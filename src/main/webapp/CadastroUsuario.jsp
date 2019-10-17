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
        <form action="${pageContext.request.contextPath}/CadastroUsuario" method="post">
            <label>Login:</label><input type="text" name="login"><br>
            <label>Senha:</label><input type="password" name="senha" id="senha"><br>
            <label>Confirma Senha:</label><input type="password" name="conSenha" id="conSenha"><br>
            <label>Código da Filial:</label><input type="password" name="codEmp" id="codEmp"><br>                     
            <select>
                <option name="Vendas">Vendas</option>
                <option name="Vendas Gerente">Vendas Gerente</option>
                <option name="Estoque">Estoque</option>
                <option name="Estoque Gerente">Estoque Gerente</option>
            </select>
            <button type="submit" name="cadastrar">Cadastrar</button>
            <button type="reset" value="Resentar"</button>
        </form>
    </body>
</html>
