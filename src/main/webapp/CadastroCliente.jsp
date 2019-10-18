<%-- 
    Document   : CadastroFilial
    Created on : 17/10/2019, 19:52:48
    Author     : MatheusEleoterio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <h1 style="text-align: center;">Cadastrar Cliente</h1>

        <div style="text-align: center; color: green;">
            <h4>${mensagemSucesso}</h4>
        </div>

        <div style="text-align: center; color: red;">
            <h4>${mensagemFalha}</h4>
        </div>

            <form action="${pageContext.request.contextPath}/ClienteController" method="post" style="border: 1px solid black; padding: 12px; float: left; position: 
              absolute; left: 50%; top: 30%; margin-right: -50%;transform: translate(-50%,-30%);" >
                
                <input type="hidden" name="acao" value="salvar">
                
            <div>
                <label>Nome Cliente: </label>
                <div>
                    <input type="text" name="nomeCliente" value="${nomeClienteAttr}">
                </div>				
            </div>

            <div>
                <label>CPF: </label>
                <div>
                    <input type="text" name="CPF" value="${CPFAttr}">
                </div>
            </div>

            <div>
                <label>Data de Nascimento: </label>
                <div>
                    <input type="text" name="dtNascimento" value="${dtNascimentoAttr}">
                </div>
            </div>
            <br>
            <div>
                <button type="submit">Enviar</button>
                <button type="reset">Cancelar</button>
            </div>

        </form>
        <div>
            <a href="/Tabacaria/RedirecionarCliente.jsp">Voltar</a>
        </div>
    </body>
</html>
