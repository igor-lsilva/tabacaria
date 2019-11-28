<%-- 
    Document   : CadastroCliente
    Created on : 17/10/2019, 19:52:48
    Author     : MatheusEleoterio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title> Cadastro Cliente </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <script> src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js";</script>
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script> src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js";</script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-notify.min.js"></script>

        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png"/>
        <script>
            function validacao() {
                var formulario = document.forms["formCadastroCliente"];
                var nome = formulario.nomeCliente.value;
                var cpf = formulario.CPF.value;
                var dtNasc = formulario.dtNascimento.value;
                var contato = formulario.contato.value;
                var erro = false;
                if (nome.indexOf(" ") == -1 || nome.length < 3)
                {
                    document.getElementById("nomeCliente").style.backgroundColor = "#ffcccc";
                    $.notify({
                        // options
                        message: 'Preencha o nome completo do cliente'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    document.getElementById("nomeCliente").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("nomeCliente").style.backgroundColor = "#ffffff";
                    erro = false;
                }

                if (cpf.length != 14) {
                    document.getElementById("cpfCliente").style.backgroundColor = "#ffcccc";
                    $.notify({
                        // options
                        message: 'O CPF deve conter conter 11 digitos'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    document.getElementById("cpfCliente").focus();
                    erro = true;
                    return false;
                }

                if (dtNasc.length < 1) {
                    document.getElementById("dtNascCliente").style.backgroundColor = "#ffcccc";
                    $.notify({
                        // options
                        message: 'Preencha a data de nascimento do cliente'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    $.notify({
                        // options
                        icon: 'glyphicon glyphicon-hand-right',
                        message: 'O Cliente deve ter mais de 18 anos.'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    document.getElementById("dtNascCliente").focus();
                    erro = true;
                    return false;
                }

                if (contato.length < 1) {
                    document.getElementById("contatoCliente").style.backgroundColor = "#ffcccc";
                    $.notify({
                        // options
                        message: 'Preencha o contato do cliente'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    document.getElementById("contatoCliente").focus();
                    erro = true;
                    return false;
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
                        <h2>Cadastro de Cliente</h2>
                    </div>
                    <form name="formCadastroCliente" action="${pageContext.request.contextPath}/TADS-PI3/ClienteController" method="post" onsubmit="return validacao()">
                        <input type="hidden" name="acao" value="salvar">
                        <div class="form-group">
                            <label>Nome Completo do Cliente:</label>
                            <input type="text" name="nomeCliente" value="${nomeClienteAttr}" placeholder="Nome do Cliente" id="nomeCliente" class="form-control">			
                        </div>
                        <div class="form-group">
                            <label>CPF: </label>
                            <input type="text" name="CPF" value="${CPFAttr}" placeholder="CPF do Cliente (Apenas maiores de 18 anos)" id="cpfCliente" class="form-control" maxlength="14" onkeypress= "$(this).mask('000.000.000-00')" >
                        </div>
                        <div class="form-group">
                            <label>Data de Nascimento: </label>
                            <input type="text" name="dtNascimento" value="${dtNascimentoAttr}" placeholder="Data de Nascimento" id="dtNascCliente" class="form-control" onkeypress= "$(this).mask('00/00/0000')">
                        </div>
                        <div class="form-group">
                            <label>Contato: </label>
                            <input type="text" name="contato" value="${contatoAttr}" placeholder="Contato do Cliente" id="contatoCliente" class="form-control">
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
                            <form action="${pageContext.request.contextPath}/TADS-PI3/ClienteController" method="post">
                                <input type="hidden" value="listar" name="acao">
                                <button class="btn btn-primary" type="submit" class="btn btn-primary">Voltar
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