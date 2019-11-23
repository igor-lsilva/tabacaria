<%-- 
    Document   : CadastroFilial
    Created on : 17/10/2019, 19:52:48
    Author     : MatheusEleoterio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssClienteCadastro.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastro Cliente</title>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">
        <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
        
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
                        document.getElementById("nomeCliente").placeholder = "Preencha o nome completo";
                        document.getElementById("nomeCliente").focus();
                        erro = true;
                        return false;
                    } else {
                        document.getElementById("nomeCliente").style.backgroundColor = "#ffffff";
                        erro = false;
                    }

                    if (cpf.length != 11) {
                        document.getElementById("cpfCliente").style.backgroundColor = "#ffcccc";
                        document.getElementById("cpfCliente").placeholder = "O CPF deve conter 11 digitos e não pode ser vazio";
                        document.getElementById("cpfCliente").focus();
                        erro = true;
                        return false;
                    }

                    if (dtNasc.length < 1) {
                        document.getElementById("dtNascCliente").style.backgroundColor = "#ffcccc";
                        document.getElementById("dtNascCliente").placeholder = "Preencha a data de nascimento do Cliente";
                        document.getElementById("dtNascCliente").focus();
                        erro = true;
                        return false;
                    }

                    if (contato.length < 1) {
                        document.getElementById("contatoCliente").style.backgroundColor = "#ffcccc";
                        document.getElementById("contatoCliente").placeholder = "Preencha um contato do Cliente";
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

            <div class="subTitulo">
                <h2>Cadastro de Cliente</h2>
            </div>

            <div class="msgSucesso">
                <h4>${mensagemSucesso}</h4>
            </div>

            <div class="msgFalha">
                <h4>${mensagemFalha}</h4>
            </div>
            <div class="formulario">

                <form name="formCadastroCliente" action="${pageContext.request.contextPath}/TADS-PI3/ClienteController" method="post" onsubmit="return validacao()">
                    <input type="hidden" name="acao" value="salvar">
                    <div>
                        <label>Nome Cliente: </label>
                        <div>
                            <input type="text" name="nomeCliente" value="${nomeClienteAttr}" placeholder="Nome do Cliente" id="nomeCliente">
                        </div>				
                    </div>

                    <div>
                        <label>CPF: </label>
                        <div>
                            <input type="number" name="CPF" value="${CPFAttr}" placeholder="CPF do Cliente" id="cpfCliente">
                        </div>
                    </div>

                    <div>
                        <label>Data de Nascimento: </label>
                        <div>
                            <input type="text" name="dtNascimento" value="${dtNascimentoAttr}" placeholder="Data de Nascimento" id="dtNascCliente">
                        </div>
                    </div>
                    <div>
                        <label>Contato: </label>
                        <div>
                            <input type="text" name="contato" value="${contatoAttr}" placeholder="Contato do Cliente" id="contatoCliente">
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
                        <form action="${pageContext.request.contextPath}/TADS-PI3/ClienteController" method="post">
                            <input type="hidden" value="listar" name="acao">
                            <button class="campoVoltar" type="submit">Voltar</button>
                        </form>
                    </div>
                </div>
            </div> 

        </div>
    </body>
</html>