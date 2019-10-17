/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.FilialController;
import Model.Filial;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ListarFilial", urlPatterns = {"/ListarFilial"})
public class ListarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ArrayList<Filial> f = FilialController.getFilial();
            request.setAttribute("TodasFiliais", f);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarFilial.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException sQLException) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String nome = request.getParameter("busca");

            if ("".equals(nome) || nome == null) {

                ArrayList<Filial> f = FilialController.getFilial();
                request.setAttribute("TodasFiliais", f);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarFilial.jsp");
                dispatcher.forward(request, response);

            } else {

                ArrayList<Filial> f = FilialController.getFilial(nome);
                request.setAttribute("TodasFiliais", f);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarFilial.jsp");
                dispatcher.forward(request, response);

            }

        } catch (IOException | SQLException | ServletException e) {

        }
    }
}
