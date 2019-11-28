
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastro Filial</title>
        <script> src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js";</script>
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script> src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js";</script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-notify.min.js"></script>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">
        <script>
            function validacao() {
                var formulario = document.forms["formCadastroFilial"];
                var nomeFilial = formulario.nomeFilial.value;
                var cnpj = formulario.CNPJ.value;
                var enderecoFilial = formulario.endereco.value;
                var erro = false;

                if (nomeFilial.length < 1) {
                    document.getElementById("nomeFilial").style.backgroundColor = "#ffcccc";
                    document.getElementById("nomeFilial").focus();
                    erro = true;
                    $.notify({
                        // options
                        message: 'Preencha o nome da filial'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    return false;
                } else {
                    document.getElementById("nomeFilial").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (cnpj.length != 18) {
                    document.getElementById("cnpjFilial").style.backgroundColor = "#ffcccc";
                    $.notify({
                        // options
                        message: 'O CNPJ deve conter 14 digitos'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    document.getElementById("cnpjFilial").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("cnpjFilial").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (enderecoFilial.length < 1) {
                    document.getElementById("endFilial").style.backgroundColor = "#ffcccc";
                                        $.notify({
                        // options
                        message: 'Preencha o estado da filial'
                    }, {
                        // settings
                        type: 'danger'
                    });
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
            <div class="text-center">
            </div>
            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="form-group">
                <div class="container">
                    <div class = "h2">
                        <br>
                        <h2>Cadastro de Produto</h2>
                    </div>
                    <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post" onsubmit="return validacao()" name="formCadastroFilial">
                        <input type="hidden" name="acao" value="salvar">
                        <div class="form-group">
                            <label>Nome Filial: </label>
                            <input type="text" id="nomeFilial" name="nomeFilial" value="${nomeFilialAttr}" placeholder="Nome da Filial" class="form-control">
                        </div>				
                        <div class="form-group">
                            <label>CNPJ: </label>
                            <div>
                                <input type="text" id="cnpjFilial" name="CNPJ" value="${CNPJAttr}" placeholder="CNPJ da Filial" class="form-control" onkeypress= "$(this).mask('00.000.000/0000-00')">
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Estado: </label>
                            <div>
                                <input type="text" id="endFilial" name="endereco" value="${enderecoAttr}" placeholder="Endereço da Filial" class="form-control">
                            </div>
                        </div>
                        <br>
                        <div class="posicaoButtons">
                            <button class="btn btn-primary" type="submit">Cadastrar
                                <span class = "glyphicon glyphicon-send"></span>
                            </button>
                            <button class="btn btn-primary" type="reset">Resetar
                                <span class = "glyphicon glyphicon-refresh"></span>
                            </button>                       
                        </div>
                    </form>
                    <div class="campoVoltarPosicao">
                        <br><br>
                        <div>
                            <form action="${pageContext.request.contextPath}/TADS-PI3/FilialController" method="post">
                                <input type="hidden" value="listar" name="acao">
                                <button class="btn btn-primary" type="submit">Voltar
                                    <span class = "glyphicon glyphicon-arrow-left"></span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
