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
@WebServlet(name = "EditarProduto", urlPatterns = {"/Editarproduto"})
public class EditarProduto extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String nomeProduto = request.getParameter("nomeproduto");
        String preco = request.getParameter("preco");
        String tipo = request.getParameter("tipo");
        
        request.setAttribute("idAttr", id);
        request.setAttribute("nomeProdutoAttr", nomeProduto);
        request.setAttribute("precoAttr", preco);
        request.setAttribute("tipoAttr", tipo);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarProduto.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
