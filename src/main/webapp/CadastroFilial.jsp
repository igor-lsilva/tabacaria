
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssFilialCadastro.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastro Filial</title>
        <script>
            function validacao() {
                var formulario = document.forms["formCadastroFilial"];
                var nomeFilial = formulario.nomeFilial.value;
                var cnpj = formulario.CNPJ.value;
                var enderecoFilial = formulario.endereco.value;
                var erro = false;

                if (nomeFilial.length < 1) {
                    document.getElementById("nomeFilial").style.backgroundColor = "#ffcccc";
                    document.getElementById("nomeFilial").placeholder = "Preencha o nome da Filial";
                    document.getElementById("nomeFilial").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("nomeFilial").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (cnpj.length != 14) {
                    document.getElementById("cnpjFilial").style.backgroundColor = "#ffcccc";
                    document.getElementById("cnpjFilial").placeholder = "O CNPJ deve conter 14 digitos";
                    document.getElementById("cnpjFilial").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("cnpjFilial").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (enderecoFilial.length < 1) {
                    document.getElementById("endFilial").style.backgroundColor = "#ffcccc";
                    document.getElementById("endFilial").placeholder = "Preencha o endereço da Filial";
                    document.getElementById("endFilial").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("endFilial").style.backgroundColor = "#ffffff";
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

            function reset() {
                document.getElementById("nomeFilial").placeholder = "Nome da Filial";
                document.getElementById("cnpjFilial").placeholder = "CNPJ da Filial";
                document.getElementById("endFilial").placeholder = "Endereço da Filial";
                document.getElementById("nomeFilial").style.backgroundColor = "#ffffff";
                document.getElementById("cnpjFilial").style.backgroundColor = "#ffffff";
                document.getElementById("endFilial").style.backgroundColor = "#ffffff";
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
                <h2>Cadastro de Filial</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">

                <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post" onsubmit="return validacao()" onreset ="reset()" name="formCadastroFilial">

                    <input type="hidden" name="acao" value="salvar">

                    <div>
                        <label>Nome Filial: </label>
                        <div>
                            <input type="text" id="nomeFilial" name="nomeFilial" value="${nomeFilialAttr}" placeholder="Nome da Filial">
                        </div>				
                    </div>

                    <div>
                        <label>CNPJ: </label>
                        <div>
                            <input type="text" id="cnpjFilial" name="CNPJ" value="${CNPJAttr}" placeholder="CNPJ da Filial">
                        </div>
                    </div>

                    <div>
                        <label>Endereço: </label>
                        <div>
                            <input type="text" id="endFilial" name="endereco" value="${enderecoAttr}" placeholder="Endereço da Filial">
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
                        <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div> 

        </div>
    </body>
</html>
