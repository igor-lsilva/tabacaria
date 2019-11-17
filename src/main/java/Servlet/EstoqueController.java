/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
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
@WebServlet(name = "EstoqueController", urlPatterns = {"/EstoqueController"})
public class EstoqueController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listar(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        switch (acao) {
            case "alterar":
                alterar(request, response);
                break;
            case "salvarAlterar":
                salvarAlterar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
        }

    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String nome = request.getParameter("busca");

            if ("".equals(nome) || nome == null) {

                ArrayList<Produto> p = ProdutoDAO.getProduto();
                request.setAttribute("TodosProdutos", p);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarEstoque.jsp");
                dispatcher.forward(request, response);

            } else {

                ArrayList<Produto> p = ProdutoDAO.getProduto(nome);
                request.setAttribute("TodosProdutos", p);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarEstoque.jsp");
                dispatcher.forward(request, response);

            }

            ArrayList<Produto> p = ProdutoDAO.getProduto();
            request.setAttribute("TodosProdutos", p);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarEstoque.jsp");
            dispatcher.forward(request, response);

       
    }


    protected void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nomeProduto = request.getParameter("nomeProduto");
        int qtde = Integer.parseInt(request.getParameter("qtde"));

        request.setAttribute("idAttr", id);
        request.setAttribute("nomeProdutoAttr", nomeProduto);
        request.setAttribute("qtdeAttr", qtde);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarEstoque.jsp");
        dispatcher.forward(request, response);

    }

    protected void salvarAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nomeProduto = request.getParameter("nomeProduto");
        int qtde = Integer.parseInt(request.getParameter("qtde"));

        boolean verifica = false;

        try {
                   
        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeProdutoAttr", nomeProduto);
            request.setAttribute("qtdeAttr", qtde);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarEstoque.jsp");
            dispatcher.forward(request, response);

        } else if (ProdutoDAO.atualizarEstoque(id, nomeProduto, qtde)) {
            
            request.setAttribute("mensagemSucesso", "Atualização realizada com sucesso!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeProdutoAttr", nomeProduto);
            request.setAttribute("qtdeAttr", qtde);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarEstoque.jsp");
            dispatcher.forward(request, response);
        } else {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeProdutoAttr", nomeProduto);
            request.setAttribute("qtdeAttr", qtde);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarEstoque.jsp");
            dispatcher.forward(request, response);

        }
        } catch (IOException | ServletException e) {
            
        }
    }
}

