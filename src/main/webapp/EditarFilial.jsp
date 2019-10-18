<%-- 
    Document   : EditarFilial
    Created on : 15/10/2019, 06:41:05
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
        <h1 style="text-align: center;">Alterar Filial</h1>

        <div style="text-align: center; color: green;">
            <h4>${mensagemSucesso}</h4>
        </div>

        <div style="text-align: center; color: red;">
            <h4>${mensagemFalha}</h4>
        </div>

        <form action="${pageContext.request.contextPath}/FilialController" method="post" style="border: 1px solid black; padding: 12px; float: left; position: 
              absolute; left: 50%; top: 30%; margin-right: -50%;transform: translate(-50%,-30%);" >
            
            <input type="hidden" name="acao" value="salvarAlterar">
            
            <input type="hidden" name="id" value="${idAttr}">          
            
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
                <button type="submit">Salvar</button>
                <button>Cancelar</button>
            </div>

        </form>
        <div>
            <a href="/Tabacaria/RedirecionarFilial.jsp">Voltar</a>
        </div>
    </body>
</html>
