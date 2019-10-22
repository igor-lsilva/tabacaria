<%-- 
    Document   : EditarCliente
    Created on : 17/10/2019, 20:55:05
    Author     : matheus.eleoterio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssClienteEditar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Editar Cliente</title>
    </head>
    <body>
        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <div class="itens">

            <div class="subTitulo">
                <h2>Editar Filial</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">
                <form action="${pageContext.request.contextPath}/ClienteController" method="post">

                    <input type="hidden" name="acao" value="salvarAlterar">

                    <input type="hidden" name="idCliente" value="${idClienteAttr}">          

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
                    <div>
                        <label>Contato: </label>
                        <div>
                            <input type="text" name="contato" value="${contatoAttr}">
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
                        <form action="${pageContext.request.contextPath}/ClienteController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
