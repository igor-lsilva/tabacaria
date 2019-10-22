/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import Model.Funcionario;
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

    public static ArrayList<Funcionario> getUsuarios() {
        boolean retorno = false;
        
        ArrayList<Funcionario> listaUsuarios = new ArrayList<>();
        
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT *FROM usuario");
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next()) {
                
                Funcionario c = new Funcionario(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5),  rs.getInt(6),  rs.getString(7),  rs.getString(8));

                listaUsuarios.add(c);
            }

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }
        return listaUsuarios;
    }

    public static ArrayList<Filial> getFilial() {
        boolean retorno = false;
        
        ArrayList<Filial> listaFilial = new ArrayList<>();
        
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT *FROM filial");
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next()) {
                
                Filial f = new Filial(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4));

                listaFilial.add(f);
            }

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }
        return listaFilial;
    }

public static boolean salvar(Funcionario user) {
        boolean retorno = false;
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO usuario (login,senha,nome,cpf,cargo,idfilial,contato) VALUES (?,?,?,?,?,?,?)");

            comando.setString(1, user.getLogin());
            comando.setString(2, user.getSenha());
            comando.setString(3, user.getNomeCompleto());
            comando.setString(4, user.getCpf());
            comando.setString(5, user.getCargo());
            comando.setInt(6, user.getIdEmpresa());
            comando.setString(7, user.getContato());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }
        return retorno;
    }

    public static boolean remover(int id) {
        boolean retorno = false;
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM usuario WHERE idusuario = '"+id+"'");

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }
        return retorno;
    }
    
    public static boolean editar(Funcionario user) {
        boolean retorno = false;
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE usuario SET nome=?, cpf=?, login=?, senha=?, idfilial=?, cargo=?, contato=? WHERE idusuario= ?");

            comando.setString(1, user.getNomeCompleto());
            comando.setString(2, user.getCpf());
            comando.setString(3, user.getLogin());
            comando.setString(4, user.getSenha());
            comando.setInt(5, user.getIdEmpresa());
            comando.setString(6, user.getCargo());
            comando.setString(7, user.getContato());
            comando.setInt(8, user.getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }
        return retorno;
    }
}
