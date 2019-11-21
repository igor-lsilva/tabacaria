<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssLogin.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="titulo">
            <h1>Tabacaria</h1>
        </div>
        <div class="posicao">

            <div class="formularioBorda">
                <div class="tituloFormulario">
                    <h2>Acesso ao Sistema</h2>
                </div>
                <c:if test="${msgErro != null}">
                    <div>
                        <h3><c:out value="${msgErro}" /></h3>
                    </div>
                </c:if>
                <div class="formulario">
                    <form action="${pageContext.request.contextPath}/LoginController" method="post">
                        <div>
                            <label>Login: </label>
                            <div>
                                <input type="text" name="login">
                            </div>				
                        </div>
                        <div>
                            <label>Senha: </label>
                            <div>
                                <input type="password" name="senha">
                            </div>				
                        </div>
                        <br><br>
                        <div>
                            <div class="posicaoBotao">
                                <button class="botaoPadrao" type="submit">ENTRAR</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
