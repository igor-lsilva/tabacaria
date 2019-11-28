<%-- 
    Document   : CadastroUsuario
    Created on : 17/10/2019, 11:14:22
    Author     : igor.silva
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Filial"%>
<%@page import="Model.Modulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssPaginaInicial.css" />
        <title>Cadastro Usuário</title>
        <script> src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js";</script>
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <script> src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js";</script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-notify.min.js"></script>
        <link rel="shortcut icon" href="http://www.tabacariaroma.com.br/wp-content/uploads/2017/09/cafe.png">

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
                    document.getElementById("nomeUsuario").style.backgroundColor = "#ffcccc";
                    $.notify({
                        // options
                        message: 'Preencha o nome completo do cliente'
                    }, {
                        // settings
                        type: 'danger'
                    });
                    document.getElementById("nomeUsuario").focus();
                    erro = true;
                    return false;
                } else {
                    document.getElementById("nomeUsuario").style.backgroundColor = "#ffffff";
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
                        <h2>Cadastro de Usuário</h2>
                    </div>
                    <form action="${pageContext.request.contextPath}/TADS-PI3/UsuarioController" method="post">
                        <input type="hidden" name="acao" value="salvar">
                        <div class="form-group">
                            <label>Nome do Usuário:</label>
                            <div>
                                <input type="text" name="nome" placeholder="Nome do Usuário" id="nomeUsuario" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>CPF do Usuário:</label>
                            <div>
                                <input type="text" name="cpf" placeholder="CPF do Usuário" id="cpfUsuario" class="form-control"  maxlength="14" onkeypress= "$(this).mask('000.000.000-00')">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Cargo:</label>
                            <div>
                                <select name="modulo" multiple style="height: 100px;">
                                    <c:forEach items="${todosModulos}" var="modulo">
                                        <option value="${modulo.id}">
                                            ${modulo.nomeModulo}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Codigo Empresa</label>
                            <div>
                                <select name="codEmp">
                                    <c:forEach items="${todasFilial}" var="filial">
                                        <option value="${filial.id}">
                                            ${filial.nomeFilial}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Contato:</label>
                            <div>
                                <input type="text" name="contato" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>login:</label>
                            <div>
                                <input type="text" name="login" id="login" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Senha:</label>
                            <div>
                                <input type="password" name="senha" id="senha" class="form-control">
                            </div>
                        </div>
                        <div class="posicaoButtons">
                            <button class="btn btn-primary" type="submit">Cadastrar
                                <span class = "glyphicon glyphicon-send"></span>
                            </button>    
                            <button class="btn btn-primary" type="reset">Resetar
                                <span class = "glyphicon glyphicon-refresh"></span>
                            </button>   
                        </div>
                        <br>
                        <br>
                    </form>
                    <div class="campoVoltarPosicao">
                        <div>
                            <form action="${pageContext.request.contextPath}/TADS-PI3/UsuarioController" method="post">
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
