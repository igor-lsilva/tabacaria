<%-- 
    Document   : Logar
    Created on : 23/10/2019, 11:29:28
    Author     : igor.silva
--%>


<%@page import="DAO.UsuarioDAO"%>
<%@page import="Model.Funcionario"%>
<%
    String login  = request.getParameter("login");
    String senha  = request.getParameter("senha");
    Funcionario usuario = UsuarioDAO.login(login, senha);
    if (usuario == null){
        
        response.sendRedirect("Login.jsp");
    }else{
        session.setAttribute("usuario", usuario);
        response.sendRedirect("PaginaInicial.jsp");
    }
%>
