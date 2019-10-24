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
