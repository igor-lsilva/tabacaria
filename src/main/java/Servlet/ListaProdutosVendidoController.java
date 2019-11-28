/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import DAO.VendaDAO;
import Model.Filial;
import Model.Produto;
import Model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igor.lsilva9
 */
@WebServlet(name = "ListaProdutosVendidoController", urlPatterns = {"/TADS-PI3/FaturamentoController"})
public class ListaProdutosVendidoController extends HttpServlet {


   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listarFiliais(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        switch (acao) {

            case "listar": {
                try {
                    listarVenda(request, response);
                } catch (ParseException ex) {

                }
                break;
            }

        }
    }

    protected void listarVenda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        int idfilial = Integer.parseInt(request.getParameter("codEmp"));
        java.sql.Date datainicio = java.sql.Date.valueOf(request.getParameter("dataInicio"));
        java.sql.Date datafim = java.sql.Date.valueOf(request.getParameter("dataFim"));
//        if ("".equals(nome) || nome == null) {
//
//            ArrayList<Filial> filiais = UsuarioDAO.getFilial();
//            request.setAttribute("todasFilial", filiais);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/Relatorio.jsp");
//            dispatcher.forward(request, response);
//
//        } else {                             
        ArrayList<Produto> produtos = ProdutoDAO.getProduto(idfilial, datainicio, datafim);
        request.setAttribute("TodosProdutos", produtos);
        ArrayList<Filial> filiais = UsuarioDAO.getFilial();
        request.setAttribute("todasFilial", filiais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Faturamento.jsp");
        dispatcher.forward(request, response);
//        }
    }

    protected void listarFiliais(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Filial> filiais = UsuarioDAO.getFilial();
        request.setAttribute("todasFilial", filiais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Faturamento.jsp");
        dispatcher.forward(request, response);
    }

}
