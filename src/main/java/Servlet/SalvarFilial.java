/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.FilialController;
import java.io.IOException;
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
@WebServlet(name = "SalvarFilial", urlPatterns = {"/SalvarFilial"})
public class SalvarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        switch(acao){
            case "salvar":
                salvar(request, response);
                break;
            case "atualizar":
                atualizar(request, response);
                break;
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
            
        } else if (FilialController.salvar(nomeFilial, CNPJ, endereco)) {

            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFilial.jsp");
            dispatcher.forward(request, response);
            
        } else {

            request.setAttribute("mensagemFalha", "Falha ao cadastrar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFilial.jsp");
            dispatcher.forward(request, response);

        }
    }
    
    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
            dispatcher.forward(request, response);
        }

        else if (FilialController.atualizar(id, nomeFilial, CNPJ, endereco)) {
            
            request.setAttribute("mensagemSucesso", "Atualização realizada com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
            dispatcher.forward(request, response);
        }else{
        
            request.setAttribute("mensagemFalha", "Falha ao editar!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarFilial.jsp");
            dispatcher.forward(request, response);
        
        }
    }
}
