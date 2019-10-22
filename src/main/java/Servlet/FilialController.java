/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.FilialDAO;
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
@WebServlet(name = "FilialController", urlPatterns = {"/FilialController"})
public class FilialController extends HttpServlet {

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

                ArrayList<Filial> f = FilialDAO.getFilial();
                request.setAttribute("TodasFiliais", f);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarFilial.jsp");
                dispatcher.forward(request, response);

            } else {

                ArrayList<Filial> f = FilialDAO.getFilial(nome);
                request.setAttribute("TodasFiliais", f);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarFilial.jsp");
                dispatcher.forward(request, response);

            }

            ArrayList<Filial> f = FilialDAO.getFilial();
            request.setAttribute("TodasFiliais", f);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarFilial.jsp");
            dispatcher.forward(request, response);

        } catch (IOException | SQLException | ServletException e) {

        }
    }

    protected void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean verifica = false;

        String nomeFilial = request.getParameter("nomeFilial");
        String CNPJ = request.getParameter("CNPJ");
        String endereco = request.getParameter("endereco");

        if (nomeFilial == null || nomeFilial.trim().length() < 1) {

            verifica = true;

        }

        if (CNPJ == null || CNPJ.trim().length() < 1) {

            verifica = true;
        }

        if (endereco == null || endereco.trim().length() < 1) {

            verifica = true;
        }

        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFilial.jsp");
            dispatcher.forward(request, response);

        } else if (FilialDAO.salvar(nomeFilial, CNPJ, endereco)) {

            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFilial.jsp");
            dispatcher.forward(request, response);

        } else {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFilial.jsp");
            dispatcher.forward(request, response);

        }
    }

    protected void alterar(HttpServletRequest request, HttpServletResponse response)
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

    protected void salvarAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nomeFilial = request.getParameter("nomeFilial");
        String CNPJ = request.getParameter("CNPJ");
        String endereco = request.getParameter("endereco");

        boolean verifica = false;

        if (nomeFilial == null || nomeFilial.trim().length() < 1) {

            verifica = true;

        }

        if (CNPJ == null || CNPJ.trim().length() < 1) {

            verifica = true;
        }

        if (endereco == null || endereco.trim().length() < 1) {

            verifica = true;
        }
                   
        if (verifica) {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeFilialAttr", nomeFilial);
            request.setAttribute("CNPJAttr", CNPJ);
            request.setAttribute("enderecoAttr", endereco);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
            dispatcher.forward(request, response);

        } else if (FilialDAO.atualizar(id, nomeFilial, CNPJ, endereco)) {
            
            request.setAttribute("mensagemSucesso", "Atualização realizada com sucesso!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeFilialAttr", nomeFilial);
            request.setAttribute("CNPJAttr", CNPJ);
            request.setAttribute("enderecoAttr", endereco);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
            dispatcher.forward(request, response);
        } else {

            request.setAttribute("mensagemFalha", "Falha ao editar!");
            request.setAttribute("idAttr", id);
            request.setAttribute("nomeFilialAttr", nomeFilial);
            request.setAttribute("CNPJAttr", CNPJ);
            request.setAttribute("enderecoAttr", endereco);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
            dispatcher.forward(request, response);

        }

    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (FilialDAO.excluir(Integer.parseInt(request.getParameter("id")))) {

                listar(request, response);

            } else {

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Fail.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            
        }
    }
}
