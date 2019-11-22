/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author igor.silva
 */
@WebServlet(name = "VendaController", urlPatterns = {"/TADS-PI3/VendaController"})
public class VendaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        // Verifica se já existe atributo itensSelecionados na sessao
        // Se nao existir cria um novo
        if (sessao.getAttribute("itensSelecionados") == null) {
            sessao.setAttribute("itensSelecionados", new Venda());
        }
        Venda venda = (Venda) sessao.getAttribute("itensSelecionados");

        String acao = request.getParameter("acao");

        switch (acao) {
            case "listar":
                listarCliente(request, response);
                break;
            case "adicionarCliente":
                adicionarCliente(request, response, venda);
                break;
            case "listarProduto":
                listarProduto(request, response);
                break;
            case "adicionarProduto":
                adicionarProduto(request, response, venda);
                break;
            case "retirarProduto":
                retirarProduto(request, response, venda);
                break;
            case "cadastrarVenda":
                cadastrarVenda(request, response, venda);
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/VendaCliente.jsp");
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

    protected void adicionarCliente(HttpServletRequest request, HttpServletResponse response, Venda venda)
            throws ServletException, IOException {

        String idCliente = request.getParameter("id");
        venda.setIdCliente(Integer.parseInt(idCliente));
        request.setAttribute("idClienteAttr", idCliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Venda.jsp");
        dispatcher.forward(request, response);
    }

    protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response, Venda venda)
            throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("id"));
        int qtd = Integer.parseInt(request.getParameter("qtd"));
        String nomeProduto = request.getParameter("nomeProduto");
        String descricao = request.getParameter("descricao");
        double valorCompra = Double.parseDouble(request.getParameter("valorCompra"));
        double valorVenda = Double.parseDouble(request.getParameter("valorVenda"));
        Produto p = new Produto(idProduto, nomeProduto, descricao, valorCompra, valorVenda);
        Item item = new Item(p, qtd, 0);
        item.precoTotal();
        venda.adicionarItem(item);
        venda.precoFinal();
        request.setAttribute("itens", venda.getItens());
        request.setAttribute("precoFinal", venda.getPrecoFinal());
        response.sendRedirect(request.getContextPath() + "/Venda.jsp");
    }

    protected void retirarProduto(HttpServletRequest request, HttpServletResponse response, Venda venda)
            throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        venda.removerItem(idProduto);
        venda.precoFinal();
        request.setAttribute("itens", venda.getItens());
        request.setAttribute("precoFinal", venda.getPrecoFinal());
        response.sendRedirect(request.getContextPath() + "/Venda.jsp");
    }

    protected void cadastrarVenda(HttpServletRequest request, HttpServletResponse response, Venda venda)
            throws ServletException, IOException {
        venda.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
        venda.setIdFilial(Integer.parseInt(request.getParameter("idEmpresa")));
        if (VendaDAO.salvar(venda)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaInicial.jsp");
            dispatcher.forward(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/Venda.jsp");

    }

}
