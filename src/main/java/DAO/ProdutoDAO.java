/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
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
public class ProdutoDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3307/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

   
    public static boolean salvar(String nomeProduto, String preco, String tipo) {
        boolean retorno = false;
        Produto p = new Produto(nomeProduto, preco, tipo);

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO produto (nome,preco,tipo) VALUES (?,?,?)");

            comando.setString(1, p.getNomeProduto());
            comando.setString(2, p.getPreco());
            comando.setString(3, p.getTipo());

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

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM produto WHERE id= ?");

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
    
    public static boolean atualizar(int id,String nomeProduto, String preco, String tipo) {

        boolean retorno = false;
        Produto p = new Produto(id, nomeProduto, preco, tipo);
        
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE tabacaria.produto SET nome=?, preco=?, tipo=? WHERE idproduto= ?");

            comando.setString(1, p.getNomeProduto());
            comando.setString(2, p.getPreco());
            comando.setString(3, p.getTipo());
            comando.setInt(4, p.getId());

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

    public static ArrayList<Produto> getProduto() {
        
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM produto limit 10");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                
                Produto p = new Produto(rs.getInt(1), rs.getString(2), String.valueOf(rs.getFloat(3)), rs.getString(4));

                listaProdutos.add(p);
            }

        } catch (ClassNotFoundException ex) {
            listaProdutos = null;
        } catch (SQLException ex) {
            listaProdutos = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaProdutos = null;
            }
        }

        return listaProdutos;
    }

}
