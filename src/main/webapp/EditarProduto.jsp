<%-- 
    Document   : EditarProduto
    Created on : 17/10/2019, 20:58:58
    Author     : Eduardo.mpaz
--%>
<%@include file="/ValidarUsuario.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>
    </head>
    <body>
        <h1 style="text-align: center;">Editar Produto</h1>

        <div style="text-align: center; color: green;">
            <h4>${mensagemSucesso}</h4>
        </div>

        <div style="text-align: center; color: red;">
            <h4>${mensagemFalha}</h4>
        </div>

        <form action="${pageContext.request.contextPath}/ProdutoController" method="post" style="border: 1px solid black; padding: 12px; float: left; position: 
              absolute; left: 50%; top: 30%; margin-right: -50%;transform: translate(-50%,-30%);" >
            
            <input type="hidden" name="acao" value="atualizar">
            
            <input type="hidden" name="id" value="${idAttr}">          
            
            <div>
                <label>Nome Produto: </label>
                <div>
                    <input type="text" name="nomeProduto" value="${nomeProdutoAttr}">
                </div>				
            </div>

            <div>
                <label>preço: </label>
                <div>
                    <input type="text" name="preco" value="${precoJAttr}">
                </div>
            </div>

            <div>
                <label>Tipo: </label>
                <div>
                    <input type="text" name="tipo" value="${tipoAttr}">
                </div>
            </div>
            <br>
            <div>
                <button type="submit">Salvar</button>
                <button>Cancelar</button>
            </div>

        </form>
        <div>
            <a href="/Tabacaria/RedirecionarProduto.jsp">Voltar</a>
        </div>
    </body>
</html>
