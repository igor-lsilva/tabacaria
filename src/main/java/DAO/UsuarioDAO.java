/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucas.asilva89
 */
public class UsuarioDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3307/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    public static Usuario getUsuario(String login, String senha) throws SQLException {
        Usuario x = null;
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("select *from usuario where login like '"+login+"' AND senha like '"+senha+"'");

            ResultSet rs = comando.executeQuery();
            
             

            while (rs.next()) {                
                Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
                
                listaUsuario.add(u);
            }
            
            for (Usuario usuario : listaUsuario) {
                
                x = usuario;
            }
 

        } catch (ClassNotFoundException ex) {
            listaUsuario = null;
        } catch (SQLException ex) {
            listaUsuario = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaUsuario = null;
            }
        }

        return x;
    }
}
