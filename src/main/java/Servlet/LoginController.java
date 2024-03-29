/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ochaus
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

//    private UsuarioService service = new UsuarioServiceMockImpl();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/PaginaInicial.jsp");
            return;
        }
        request.getRequestDispatcher("/Login.jsp")
                .forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario usuario = UsuarioDAO.login(username, senha);
        
        if (usuario != null && usuario.getHashSenha().equals(senha)) {
            // Usuario válido - adiciona na sessão
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            
            // Apresenta tela home para usuario.
            response.sendRedirect(request.getContextPath() + "/PaginaInicial.jsp");
        } else {
            // Usuario não está cadastrado, deve mostrar erro
            request.setAttribute("msgErro", "Usuario inexistente ou senha inválida");
            request.getRequestDispatcher("/Login.jsp")
                .forward(request, response);
        }

    }

}