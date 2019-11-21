<%-- 
    Document   : Venda
    Created on : 18/11/2019, 10:16:43
    Author     : igor.silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
            <h1>Cliente: </h1>
            <input type="text" name="idCliente" value="${idClienteAttr}">
            <input type="hidden" value="listar" name="acao">
            <button>Add</button>
        </form>
        <form action="${pageContext.request.contextPath}/TADS-PI3/VendaController" method="post">
            <h1>Cliente: </h1>
            <input type="hidden" value="listarProduto" name="acao">
            <button>Add</button>
        </form>

        <div class="tabelaLista">
            <table> 
                <tr>
                    <th class="campoID">Cod.</th>
                    <th class="campoNome">Nome</th>
                    <th class="campoDescricao">Descrição</th>
                    <th class="campoEditar">Editar</th>
                    <th class="campExcluir">Excluir</th>
                </tr>                
                <c:forEach items="${TodosProdutos}" var="p">
                    <tr>                       
                        <td class="campoID">${p.id}</td>              
                        <td class="campoNome">${p.nome}</td>               
                        <td class="campoDescricao">${p.descricao}</td>                            
                    </tr>
                </c:forEach> 
            </table>
    </body>
</html>
