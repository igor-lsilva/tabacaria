/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LogoutController", urlPatterns = {"/TADS-PI3/LogoutController"})
public class LogoutController extends HttpServlet {

    private void sair(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        // Invalidar sessao do usuario
        HttpSession sessao = request.getSession();
        sessao.invalidate();
        
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sair(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sair(request, response);
    }

}
