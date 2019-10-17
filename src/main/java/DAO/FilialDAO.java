/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ochaus
 */
public class FilialDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3307/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

   
    public static boolean salvar(Filial f) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO filial (nome,cnpj,endereco) VALUES (?,?,?)");

            comando.setString(1, f.getNomeFilial());
            comando.setString(2, f.getCNPJ());
            comando.setString(3, f.getEndereco());

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

   
    public static boolean excluir(int cID) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM filial WHERE idFilial= ?");

            comando.setInt(1, cID);

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
    
    public static boolean atualizar(Filial f) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE tabacaria.filial SET nome=?, cnpj=?, endereco=? WHERE idfilial= ?");

            comando.setString(1, f.getNomeFilial());
            comando.setString(2, f.getCNPJ());
            comando.setString(3, f.getEndereco());
            comando.setInt(4, f.getId());

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

    public static ArrayList<Filial> getFilial() throws SQLException {
        
        ArrayList<Filial> listaFiliais = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM filial limit 10");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                
                Filial c = new Filial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

                listaFiliais.add(c);
            }

        } catch (ClassNotFoundException ex) {
            listaFiliais = null;
        } catch (SQLException ex) {
            listaFiliais = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaFiliais = null;
            }
        }

        return listaFiliais;
    }
    
     public static ArrayList<Filial> getFilial(String nome) throws SQLException {
        
        ArrayList<Filial> listaClientes = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM filial WHERE nome LIKE '%"+nome+"%'");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                
                Filial c = new Filial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

                listaClientes.add(c);
            }

        } catch (ClassNotFoundException ex) {
            listaClientes = null;
        } catch (SQLException ex) {
            listaClientes = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaClientes = null;
            }
        }

        return listaClientes;
    }
}
