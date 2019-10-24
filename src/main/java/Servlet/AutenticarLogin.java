/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UsuarioDAO;
import Model.Funcionario;
import Model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas.asilva89
 */
@WebServlet(name = "AutenticarLogin", urlPatterns = {"/AutenticarLogin"})
public class AutenticarLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Funcionario f = UsuarioDAO.login(login, senha);
        
        if (f != null) {
            request.setAttribute("usuario", f);
            request.setAttribute("senha", senha);
            request.setAttribute("login", login);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaInicial.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagemFalha", "Usuario ou Senha incorreta!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
            dispatcher.forward(request, response);

        }

    }

}
