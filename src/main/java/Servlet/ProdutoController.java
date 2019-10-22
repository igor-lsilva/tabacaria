/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ProdutoDAO;
import Model.Produto;
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
@WebServlet(name = "ProdutoController", urlPatterns = {"/ProdutoController"})
public class ProdutoController extends HttpServlet {

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
            case "salvar":
                salvar(request, response);
                break;
            case "alterar":
                alterar(request, response);
                break;
            case "salvarAlterar":
                salvarAlterar(request, response);
                break;
            case "excluir":
                excluir(request, response);
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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Listarproduto.jsp");
                dispatcher.forward(request, response);

            } else {

                //ArrayList<Produto> p = ProdutoDAO.getProduto(nome);
                //request.setAttribute("TodosProdutos", p);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarProduto.jsp");
                dispatcher.forward(request, response);

            }

            ArrayList<Produto> p = ProdutoDAO.getProduto();
            request.setAttribute("TodosProdutos", p);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarProduto.jsp");
            dispatcher.forward(request, response);

       
    }

    protected void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean verifica = false;

        String nomeProduto = request.getParameter("nomeProduto");
        String preco = request.getParameter("preco");
        String tipo = request.getParameter("tipo");

        if (nomeProduto == null || nomeProduto.trim().length() < 1) {

            verifica = true;

        }

        if (preco == null || preco.trim().length() < 1) {

            verifica = true;
        }

        if (tipo == null || tipo.trim().length() < 1) {

            verifica = true;
        }

        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFilial.jsp");
            dispatcher.forward(request, response);

        } else if (ProdutoDAO.salvar(nomeProduto, preco, tipo)) {

            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroProduto.jsp");
            dispatcher.forward(request, response);

        } else {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroProduto.jsp");
            dispatcher.forward(request, response);

        }
    }

    protected void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nomeProduto = request.getParameter("nomeProduto");
        String preco = request.getParameter("preco");
        String tipo = request.getParameter("tipo");

        request.setAttribute("idAttr", id);
        request.setAttribute("nomeProdutoAttr", nomeProduto);
        request.setAttribute("precoAttr", preco);
        request.setAttribute("tipoAttr", tipo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarProduto.jsp");
        dispatcher.forward(request, response);

    }

    protected void salvarAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nomeProduto = request.getParameter("nomeProduto");
        String preco = request.getParameter("preco");
        String tipo = request.getParameter("tipo");

        boolean verifica = false;

        if (nomeProduto == null || nomeProduto.trim().length() < 1) {

            verifica = true;

        }

        if (preco == null || preco.trim().length() < 1) {

            verifica = true;
        }

        if (tipo == null || tipo.trim().length() < 1) {

            verifica = true;
        }
        try {
                   
        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeProdutoAttr", nomeProduto);
            request.setAttribute("precoAttr", preco);
            request.setAttribute("tipoAttr", tipo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarProduto.jsp");
            dispatcher.forward(request, response);

        } else if (ProdutoDAO.atualizar(id, nomeProduto, preco, tipo)) {
            
            request.setAttribute("mensagemSucesso", "Atualização realizada com sucesso!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeProdutoAttr", nomeProduto);
            request.setAttribute("precoAttr", preco);
            request.setAttribute("tipoAttr", tipo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarProduto.jsp");
            dispatcher.forward(request, response);
        } else {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeProdutoAttr", nomeProduto);
            request.setAttribute("precoAttr", preco);
            request.setAttribute("tipoAttr", tipo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarProduto.jsp");
            dispatcher.forward(request, response);

        }
        } catch (IOException | ServletException e) {
            
        }
    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (ProdutoDAO.excluir(Integer.parseInt(request.getParameter("id")))) {

                listar(request, response);

            } else {

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Fail.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            
        }
    }
}
