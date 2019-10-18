/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UsuarioDAO;
import Model.Funcionario;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        switch (acao) {
            case "salvar":
                salvar(request, response);
                break;
//            case "atualizar":
//                atualizar(request, response);
//                break;
//            case "excluir":
//                excluir(request, response);
//            case "listar":
//                listar(request, response);
        }

    }

    protected void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        int idEmp = Integer.parseInt(request.getParameter("codEmp"));
        String contato = request.getParameter("contato");
        String cargo = request.getParameter("cargo");

        Funcionario user = new Funcionario(cargo, idEmp, contato, login, senha, nome, cpf);

        if (UsuarioDAO.salvar(user)) {

            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
            dispatcher.forward(request, response);

        }
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String login = request.getParameter("login");
//        String senha = request.getParameter("senha");
//        int codEmp = Integer.parseInt(request.getParameter("codEmp"));
//        String cargo = "Vendas";
//        Usuario user = new Usuario(login, senha, codEmp, cargo);
//        
//        if (DAO.UsuarioDAO.salvar(user)) {
//            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
//            dispatcher.forward(request, response);
//
//        } else {
//
//            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
//            dispatcher.forward(request, response);
//
//        }
//
//    }
}
