/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ModuloDAO;
import DAO.UsuarioDAO;
import Model.Filial;
import Model.Modulo;
import Model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "UsuarioController", urlPatterns = {"/TADS-PI3/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
            case "editar":
                editar(request, response);
                break;
            case "excluir":
                excluir(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            case "cadastrar":
                retornaFilial(request, response);
                break;
            case "atualizar":
                atualizar(request, response);
                break;
        }

    }

    protected void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        int idEmp = Integer.parseInt(request.getParameter("codEmp"));
        String idModulo[] = request.getParameterValues("modulo");
        String contato = request.getParameter("contato");

        List<Modulo> modulos = new ArrayList<>();

        if (idModulo != null) {
            for (int i = 0; i < idModulo.length; i++) {

                Modulo m = new Modulo(i, idModulo[i]);
                modulos.add(m);
            }
        }
        Usuario user = new Usuario(login, senha, modulos, idEmp, nome, cpf, contato);

        if (UsuarioDAO.salvar(user)) {

            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
            ArrayList<Filial> filiais = UsuarioDAO.getFilial();
            request.setAttribute("todasFilial", filiais);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
            dispatcher.forward(request, response);

        }
    }

    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        int idEmp = Integer.parseInt(request.getParameter("codEmp"));
        String idModulo[] = request.getParameterValues("modulo");
        String contato = request.getParameter("contato");

        List<Modulo> modulos = new ArrayList<>();

        if (idModulo != null) {
            for (int i = 0; i < idModulo.length; i++) {

                Modulo m = new Modulo(i, idModulo[i]);
                modulos.add(m);
            }
        }
        Usuario user = new Usuario(id, login, senha, modulos, idEmp, nome, cpf, contato);

        if (UsuarioDAO.editar(user)) {
            request.setAttribute("f", user);
            request.setAttribute("mensagemSucesso", "Edição realizada com sucesso");
            ArrayList<Filial> filiais = UsuarioDAO.getFilial();
            request.setAttribute("todasFilial", filiais);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarUsuario.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("f", user);
            request.setAttribute("mensagemFalha", "Erro ao editar");
            ArrayList<Filial> filiais = UsuarioDAO.getFilial();
            request.setAttribute("todasFilial", filiais);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarUsuario.jsp");
            dispatcher.forward(request, response);

        }
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        int idEmp = Integer.parseInt(request.getParameter("codEmp"));
        String idModulo[] = request.getParameterValues("modulo");
        String contato = request.getParameter("contato");

//        request.setAttribute("idAttr", id);
//        request.setAttribute("nomeAttr", nome);
//        request.setAttribute("loginAttr", login);
//        request.setAttribute("senhaAttr", senha);
//        request.setAttribute("cpfAttr", cpf);
//        request.setAttribute("codEmpAttr", idEmp);
//        request.setAttribute("contatoAttr", contato);
        List<Modulo> modulos = new ArrayList<>();

        if (idModulo != null) {
            for (int i = 0; i < idModulo.length; i++) {

                Modulo mo = new Modulo(i, idModulo[i]);
                modulos.add(mo);
            }
        }
        Usuario f = new Usuario(id, login, senha, modulos, idEmp, nome, cpf, contato);

        request.setAttribute("f", f);

        ArrayList<Filial> filiais = UsuarioDAO.getFilial();
        request.setAttribute("todasFilial", filiais);
        ArrayList<Modulo> modulo = ModuloDAO.getModulo();
        request.setAttribute("todosModulos", modulo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarUsuario.jsp");
        dispatcher.forward(request, response);

    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("busca");

        if ("".equals(nome) || nome == null) {

            ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
            request.setAttribute("TodosUsuarios", usuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuario.jsp");
            dispatcher.forward(request, response);

        } else {

            ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios(nome);
            request.setAttribute("TodosUsuarios", usuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuario.jsp");
            dispatcher.forward(request, response);

        }

        ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
        request.setAttribute("TodosUsuarios", usuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuario.jsp");
        dispatcher.forward(request, response);

    }

    protected void retornaFilial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Filial> filiais = UsuarioDAO.getFilial();
        request.setAttribute("todasFilial", filiais);
        ArrayList<Modulo> modulo = ModuloDAO.getModulo();
        request.setAttribute("todosModulos", modulo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
        dispatcher.forward(request, response);

    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        if (UsuarioDAO.remover(id)) {

            listar(request, response);

        } else {
            request.setAttribute("mensagemFalha", "Falha ao excluir!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuario.jsp");
            dispatcher.forward(request, response);

        }
    }
}
