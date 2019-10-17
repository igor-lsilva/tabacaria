/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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

        try {
            
            Usuario x = UsuarioDAO.getUsuario(login, senha);
            
            if(x.getLogin().equals(request.getParameter("login")) && x.getSenha().equals(request.getParameter("senha"))){
                
                request.setAttribute("loginAttr", x.getLogin());
                request.setAttribute("senhaAttr", x.getSenha());
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaInicial.jsp");
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AutenticarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
