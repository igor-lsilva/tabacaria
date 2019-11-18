
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilialCadastro.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastro Filial</title>
    </head>
    <body>

        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <div class="itens">

            <div class="subTitulo">
                <h2>Cadastro de Filial</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">

                <form action="${pageContext.request.contextPath}/FilialController" method="post">

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
                    <div class="posicaoButtons">
                        <button class="campoSalvar" type="submit">Cadastrar</button>
                        <button class="campoSalvar" type="reset">Resetar</button>                       
                    </div>
                </form>
                <div class="campoVoltarPosicao">
                    <br><br>
                    <div>
                        <form action="${pageContext.request.contextPath}/FilialController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div> 

        </div>
    </body>
</html>
