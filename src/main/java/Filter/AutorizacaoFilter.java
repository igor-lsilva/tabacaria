/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ochaus
 */
@WebFilter(filterName = "AutorizacaoFilter",
        servletNames = {"HomeServlet"},
        urlPatterns = {"/TADS-PI3/*"})
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verificar se usuario esta na sessao
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login.jsp");
            return;
        }
        // Verificar se usuario tem permissao de acesso na pagina
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        if (verificarPermissaoAcesso(httpRequest, usuario)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Fail.jsp");
        }
    }

    private boolean verificarPermissaoAcesso(
            HttpServletRequest httpRequest, Usuario usuario) {
        String urlAcessada = httpRequest.getRequestURI();
        if (urlAcessada.endsWith("/PaginaInicial.jsp")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/LogoutController")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/EstoqueController")
                && usuario.verificarPapel("ESTOQUE")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/ProdutoController")
                && usuario.verificarPapel("PRODUTO")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/FilialController")
                && usuario.verificarPapel("FILIAL")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/UsuarioController")
                && usuario.verificarPapel("USUARIO")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/ClienteController")
                && usuario.verificarPapel("CLIENTE")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/VendaController")
                && usuario.verificarPapel("VENDA")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/RelatorioController")
                && usuario.verificarPapel("DIRETORIA")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/RelatorioController")
                && usuario.verificarPapel("GERENCIA")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/FaturamentoController")
                && usuario.verificarPapel("DIRETORIA")) {
            return true;
        } else if (urlAcessada.endsWith("/TADS-PI3/FaturamentoController")
                && usuario.verificarPapel("GERENCIA")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }
}
