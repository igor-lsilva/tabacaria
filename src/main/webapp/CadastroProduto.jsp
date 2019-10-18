<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssProduto.css" />
        <title>Cadastrar Produto</title>
    </head>
    <body>
        
            <div class="tituloTopo">
                <h1 style="text-align: center">Cadastro de produto</h1>
            </div>
        
        <div class="subTitulo">
            <h1 style="text-align: center">Produtos</h1>
        </div>

        <div class="tabelaListagem">
            <form action="${pageContext.request.contextPath}/Listarproduto" method="post">
                <div class="campoBuscas">
                    <label for="txtBuscar">Nome:</label>
                    <div>
                        <input type="text" name="busca" id="txtBuscar" placeholder=" Nome do Produto">
                        <button type="submit">Buscar</button>
                    </div>
                </div>
            </form>
            <br>
            <table> 
                <tr>
                    <th class="campoNome">Nome </th>
                    <th class="campoPreco">Preco </th>
                    <th class="campoTipo">Tipo </th>
                    <th class="campoEditar">Salvar</th>
                    <th class="campExcluir">Excluir</th>
                </tr>                
                <c:forEach items="${TodasProdutos}" var="p">
                    <tr>                       
                        <td>${p.id}</td>              
                        <td>${p.nomeProduto}</td>               
                        <td>${p.Preco}</td>
                        <td>${p.Tipo}</td>                        
                        <td> 
                            <form>
                                <a href="${pageContext.request.contextPath}/EditarProduto?id=${p.id}&nomeProduto=${p.nomeProduto}&CNPJ=${p.preco}&endereco=${p.tipo}">Editar</a>
                            </form>                            
                        </td>
                        <td>
                            <form>
                                <a href="${pageContext.request.contextPath}/ExcluirFilial?id=${p.id}" >Excluir</a>
                            </form>
                        </td>                            
                    </tr>
                </c:forEach> 

            </table>
            <div class="campoCadastro">
                <a href="/Tabacaria/CadastroProduto.jsp">Cadastrar</a>
            </div>
        </div>

    </body>
</html>
