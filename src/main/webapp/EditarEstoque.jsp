<%-- 
    Document   : EditarEstoque
    Created on : 17/11/2019, 08:03:46
    Author     : Ochaus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssProdutoEditar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Editar Produto</title>
    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <div class="itens">

            <div class="subTitulo">
                <h2>Editar Produto</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">
                <form action="${pageContext.request.contextPath}/TADS-PI3/EstoqueController" method="post">

                    <input type="hidden" name="acao" value="salvarAlterar">

                    <input type="hidden" name="id" value="${idAttr}">
                    <input type="hidden" value="${valorCompraAttr}" name="valorCompra">
                    <input type="hidden" value="${valorVendaAttr}" name="valorVenda">

                    <div>
                        <label>Nome: </label>
                        <div>
                            <input type="text" name="nomeProduto" value="${nomeProdutoAttr}" >
                        </div>				
                    </div>

                    <div>
                        <label>Quantidade: </label>
                        <div>
                            <input type="number" name="qtde" value="${qtdeAttr}">
                        </div>
                    </div>
                    <br>
                    <div class="posicaoButtons">
                        <button class="campoSalvar" type="submit">Salvar</button>
                        <button class="campoSalvar" type="reset">Resetar</button>                       
                    </div>

                </form>
                <div class="campoVoltarPosicao">
                    <br><br>
                    <div>
                        <form action="${pageContext.request.contextPath}/TADS-PI3/EstoqueController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div> 
        </div>
    </body>
</html>
