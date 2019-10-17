/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ochaus
 */
@WebServlet(name = "EditarFilial", urlPatterns = {"/EditarFilial"})
public class EditarFilial extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String nomeFilial = request.getParameter("nomeFilial");
        String CNPJ = request.getParameter("CNPJ");
        String endereco = request.getParameter("endereco");
        
        request.setAttribute("idAttr", id);
        request.setAttribute("nomeFilialAttr", nomeFilial);
        request.setAttribute("CNPJAttr", CNPJ);
        request.setAttribute("enderecoAttr", endereco);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
