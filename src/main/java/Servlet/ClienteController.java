/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ClienteDAO;
import Model.Cliente;
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
@WebServlet(name = "ClienteController", urlPatterns = {"/TADS-PI3/ClienteController"})
public class ClienteController extends HttpServlet {

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
        try {

            String nome = request.getParameter("busca");

            if ("".equals(nome) || nome == null) {

                ArrayList<Cliente> c = ClienteDAO.getClientes();
                request.setAttribute("TodosClientes", c);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaCliente.jsp");
                dispatcher.forward(request, response);

            } else {

                ArrayList<Cliente> c = ClienteDAO.getClientes(nome);
                request.setAttribute("TodosClientes", c);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaCliente.jsp");
                dispatcher.forward(request, response);

            }

            ArrayList<Cliente> c = ClienteDAO.getClientes();
            request.setAttribute("TodosClientes", c);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaCliente.jsp");
            dispatcher.forward(request, response);

        } catch (IOException | SQLException | ServletException e) {

        }
    }

    protected void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean verifica = false;

        String nomeCliente = request.getParameter("nomeCliente");
        String CPF = request.getParameter("CPF");
        String dtNascimento = request.getParameter("dtNascimento");
        String contato = request.getParameter("contato");

        if (nomeCliente == null || nomeCliente.trim().length() < 1) {

            verifica = true;

        }

        if (CPF == null || CPF.trim().length() < 1) {

            verifica = true;
        }

        if (dtNascimento == null || dtNascimento.trim().length() < 1) {

            verifica = true;
        }

        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroCliente.jsp");
            dispatcher.forward(request, response);

        } else if (ClienteDAO.salvar(nomeCliente, CPF, dtNascimento, contato)) {

            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroCliente.jsp");
            dispatcher.forward(request, response);

        } else {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroCliente.jsp");
            dispatcher.forward(request, response);

        }
    }

    protected void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCliente = Integer.parseInt(request.getParameter("id"));
        String nomeCliente = request.getParameter("nomeCliente");
        String CPF = request.getParameter("CPF");
        String dtNascimento = request.getParameter("dtNascimento");
        String contato = request.getParameter("contato");

        request.setAttribute("idClienteAttr", idCliente);
        request.setAttribute("nomeClienteAttr", nomeCliente);
        request.setAttribute("CPFAttr", CPF);
        request.setAttribute("dtNascimentoAttr", dtNascimento);
        request.setAttribute("contatoAttr", contato);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCliente.jsp");
        dispatcher.forward(request, response);
    }

    protected void salvarAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nomeCliente = request.getParameter("nomeCliente");
        String CPF = request.getParameter("CPF");
        String dtNascimento = request.getParameter("dtNascimento");
        String contato = request.getParameter("contato");

        boolean verifica = false;

        if (nomeCliente == null || nomeCliente.trim().length() < 1) {

            verifica = true;

        }

        if (CPF == null || CPF.trim().length() < 1) {

            verifica = true;
        }

        if (dtNascimento == null || dtNascimento.trim().length() < 1) {

            verifica = true;
        }

        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idClienteAttr", idCliente);
            request.setAttribute("nomeClienteAttr", nomeCliente);
            request.setAttribute("CPFAttr", CPF);
            request.setAttribute("dtNascimentoAttr", dtNascimento);
            request.setAttribute("contatoAttr", contato);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCliente.jsp");
            dispatcher.forward(request, response);
        } else if (ClienteDAO.atualizar(idCliente, nomeCliente, CPF, dtNascimento, contato)) {

            request.setAttribute("mensagemSucesso", "Atualização realizada com sucesso!");
            request.setAttribute("idClienteAttr", idCliente);
            request.setAttribute("nomeClienteAttr", nomeCliente);
            request.setAttribute("CPFAttr", CPF);
            request.setAttribute("dtNascimentoAttr", dtNascimento);
            request.setAttribute("contatoAttr", contato);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCliente.jsp");
            dispatcher.forward(request, response);
        } else {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idClienteAttr", idCliente);
            request.setAttribute("nomeClienteAttr", nomeCliente);
            request.setAttribute("CPFAttr", CPF);
            request.setAttribute("dtNascimentoAttr", dtNascimento);
            request.setAttribute("contatoAttr", contato);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCliente.jsp");
            dispatcher.forward(request, response);

        }
    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (ClienteDAO.excluir(Integer.parseInt(request.getParameter("id")))) {

            listar(request, response);

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Fail.jsp");
            dispatcher.forward(request, response);
        }
    }
}
