
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssProdutoCadastro.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastrar Produto</title>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">
        <script>
            function validacao() {
                var formulario = document.forms["formCadastroProduto"];
                var nomeP = formulario.nomeProduto.value;
                var valorCompraP = formulario.valorCompra.value;
                var valorVendaP = formulario.valorVenda.value;
                var descricaoP = formulario.descricao.value;
                var erro = false;

                if (nomeP.length < 1) {
                    document.getElementById("nomeProduto").style.backgroundColor = "#ffcccc";
                    document.getElementById("nomeProduto").placeholder = "Preencha o nome do produto";
                    document.getElementById("nomeProduto").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("nomeProduto").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (valorCompraP.length < 1) {
                    document.getElementById("valorCompra").style.backgroundColor = "#ffcccc";
                    document.getElementById("valorCompra").placeholder = "Preencha o valor de compra";
                    document.getElementById("valorCompra").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("valorCompra").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (valorVendaP.length < 1) {
                    document.getElementById("valorVenda").style.backgroundColor = "#ffcccc";
                    document.getElementById("valorVenda").placeholder = "Preencha o valor de venda";
                    document.getElementById("valorVenda").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("valorVenda").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (descricaoP.length < 1) {
                    document.getElementById("descricaoProduto").style.backgroundColor = "#ffcccc";
                    document.getElementById("descricaoProduto").placeholder = "Preencha a descrição do produto";
                    document.getElementById("descricaoProduto").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("descricaoProduto").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (erro) {
                    alert("Cadastro não realizado.");
                    return false;
                } else {
                    alert("Cadastro realizado com sucesso!");
                    return true;
                }
            }

        </script>
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

                <form action="${pageContext.request.contextPath}/TADS-PI3/ProdutoController" method="post" name="formCadastroProduto" onsubmit="return validacao()" >

                    <input type="hidden" name="acao" value="salvar">

                    <div>
                        <label>Nome: </label>
                        <div>
                            <input type="text" id="nomeProduto" name="nomeProduto" value="${nomeProdutoAttr}" placeholder="Nome do Produto">
                        </div>				
                    </div>

                    <div>
                        <label>Valor de Compra: </label>
                        <div>
                            <input type="number" id="valorCompra" name="valorCompra" value="${valorCompraAttr}" placeholder="Valor de Compra do Produto">
                        </div>
                    </div>

                    <div>
                        <label>Valor de Venda: </label>
                        <div>
                            <input type="number" id="valorVenda" name="valorVenda" value="${valorVendaAttr}" placeholder="Valor de Venda do Produto">
                        </div>
                    </div>

                    <div>
                        <label>Descrição: </label>
                        <div>
                            <input type="text" id="descricaoProduto" name="descricao" value="${descricaoAttr}" placeholder="Descrição do Produto">
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
