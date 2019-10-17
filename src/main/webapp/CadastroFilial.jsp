<%-- 
    Document   : CadastroFilial
    Created on : 14/10/2019, 02:18:33
    Author     : Ochaus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Filial</title>
    </head>
    <body>
        <h1 style="text-align: center;">Cadastrar Filial</h1>

        <div style="text-align: center; color: green;">
            <h4>${mensagemSucesso}</h4>
        </div>

        <div style="text-align: center; color: red;">
            <h4>${mensagemFalha}</h4>
        </div>

            <form action="${pageContext.request.contextPath}/FilialController" method="post" style="border: 1px solid black; padding: 12px; float: left; position: 
              absolute; left: 50%; top: 30%; margin-right: -50%;transform: translate(-50%,-30%);" >
                
                <input type="hidden" name="acao" value="salvar">
                
            <div>
                <label>Nome Filial: </label>
                <div>
                    <input type="text" name="nomeFilial" value="${nomeFilialAttr}">
                </div>				
            </div>

            <div>
                <label>CNPJ: </label>
                <div>
                    <input type="text" name="CNPJ" value="${CNPJAttr}">
                </div>
            </div>

            <div>
                <label>Endereço: </label>
                <div>
                    <input type="text" name="endereco" value="${enderecoAttr}">
                </div>
            </div>
            <br>
            <div>
                <button type="submit">Enviar</button>
                <button type="reset">Cancelar</button>
            </div>

        </form>
        <div>
            <a href="/Tabacaria/RedirecionarFilial.jsp">Voltar</a>
        </div>
    </body>
</html>
