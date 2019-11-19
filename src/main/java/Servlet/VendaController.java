/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import Model.Cliente;
import Model.Item;
import Model.Produto;
import Model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author igor.silva
 */
@WebServlet(name = "VendaController", urlPatterns = {"/VendaController"})
public class VendaController extends HttpServlet {

   private static Venda venda = new Venda();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listarCliente(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        switch (acao) {
            case "listar":
                listarCliente(request, response);
                break;
            case "adicionarCliente":
                adicionarCliente(request, response);
                break;
            case "listarProduto":
                listarProduto(request, response);
                break;
            case "adicionarProduto":
                adicionarProduto(request, response);
                break;
        }
    }

    protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String nome = request.getParameter("busca");

            if ("".equals(nome) || nome == null) {

                ArrayList<Cliente> c = ClienteDAO.getClientes();
                request.setAttribute("TodosClientes", c);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaCliente.jsp");
                dispatcher.forward(request, response);

            } else {

                ArrayList<Cliente> c = ClienteDAO.getClientes(nome);
                request.setAttribute("TodosClientes", c);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaCliente.jsp");
                dispatcher.forward(request, response);

            }

            ArrayList<Cliente> c = ClienteDAO.getClientes();
            request.setAttribute("TodosClientes", c);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaCliente.jsp.jsp");
            dispatcher.forward(request, response);

        } catch (IOException | SQLException | ServletException e) {

        }
    }
    
    protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("busca");

            if ("".equals(nome) || nome == null) {

                ArrayList<Produto> p = ProdutoDAO.getProduto();
                request.setAttribute("TodosProdutos", p);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaProduto.jsp");
                dispatcher.forward(request, response);

            } else {

                ArrayList<Produto> p = ProdutoDAO.getProduto(nome);
                request.setAttribute("TodosProdutos", p);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaProduto.jsp");
                dispatcher.forward(request, response);

            }

            ArrayList<Produto> p = ProdutoDAO.getProduto();
            request.setAttribute("TodosProdutos", p);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaProduto.jsp");
            dispatcher.forward(request, response);
    }

    protected void adicionarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCliente = request.getParameter("id");
        request.setAttribute("idClienteAttr", idCliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Venda.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Item item = new Item(null, qtd, preco)
        String idCliente = request.getParameter("id");
        request.setAttribute("idClienteAttr", idCliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Venda.jsp");
        dispatcher.forward(request, response);
    }
}
