<%@page import="Model.Funcionario"%>
<%
    Funcionario f = null;
    if(session.getAttribute("usuario") != null){
        f = (Funcionario) session.getAttribute("usuario");
    }else{
        response.sendRedirect("Login.jsp");
    }
%>
