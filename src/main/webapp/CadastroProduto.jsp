
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssProdutoCadastro.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastrar Produto</title>
    </head>
    <body>

        <div class="linksPosicao">
            <ul>              
                <li class="posicaoSair"><a class="ativado" href="#">Sair</a></li>
            </ul>
        </div>
        <div class="itens">

            <div class="subTitulo">
                <h2>Cadastro de Produto</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">

                <form action="${pageContext.request.contextPath}/TADS-PI3/ProdutoController" method="post">

                    <input type="hidden" name="acao" value="salvar">

                    <div>
                        <label>Nome: </label>
                        <div>
                            <input type="text" name="nomeProduto" value="${nomeProdutoAttr}" placeholder="Nome do Produto">
                        </div>				
                    </div>

                    <div>
                        <label>Valor de Compra: </label>
                        <div>
                            <input type="number" name="valorCompra" value="${valorCompraAttr}" placeholder="Valor de Compra do Produto">
                        </div>
                    </div>
                        
                    <div>
                        <label>Valor de Venda: </label>
                        <div>
                            <input type="number" name="valorVenda" value="${valorVendaAttr}" placeholder="Valor de Venda do Produto">
                        </div>
                    </div>

                    <div>
                        <label>Descrição: </label>
                        <div>
                            <input type="text" name="descricao" value="${descricaoAttr}" placeholder="Descrição do Produto">
                        </div>
                    </div>
                    <div>
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
                        <form action="${pageContext.request.contextPath}/TADS-PI3/ProdutoController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div> 
        </div>
    </body>
</html>
