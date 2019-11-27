/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ochaus
 */
public class ProdutoDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static boolean salvar(String nomeProduto, String descricao, double valorCompra, double valorVenda, int idEmp) {
        boolean retorno = false;
        java.sql.Date mysqlDate = new java.sql.Date(new java.util.Date().getTime());

        Produto p = new Produto(nomeProduto, descricao, valorCompra, valorVenda, mysqlDate);

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO produto (nome,descricao,id_filial) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, p.getNome());
            comando.setString(2, p.getDescricao());
            comando.setInt(3, idEmp);

            int linhasAfetadas = comando.executeUpdate();

            ResultSet rs = comando.getGeneratedKeys();
            int idProduto = 0;

            if (rs.next()) {

                idProduto = rs.getInt(1);
            }

            if (linhasAfetadas > 0) {

                comando = conexao.prepareStatement("INSERT INTO entrada_produto (id_produto, qtde, valor_compra, valor_venda, data_entrada) VALUES (?, ?, ?, ?, ?)");
                comando.setInt(1, idProduto);
                comando.setInt(2, p.getQtde());
                comando.setDouble(3, p.getValorCompra());
                comando.setDouble(4, p.getValorVenda());
                comando.setDate(5, p.getDataEntrada());

                linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {

                    retorno = true;

                } else {

                    retorno = false;
                }

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

            PreparedStatement comando = conexao.prepareStatement("UPDATE produto SET status=0 WHERE id= ?");

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

    public static boolean atualizar(int id, String nomeProduto, String descricao, double valorCompra, double valorVenda) {

        boolean retorno = false;
        Produto p = new Produto(id, nomeProduto, descricao, valorCompra, valorVenda);

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE tabacaria.produto, tabacaria.entrada_produto SET nome=?, descricao=?, entrada_produto.valor_compra=?, entrada_produto.valor_venda=?  WHERE entrada_produto.id_produto=? AND produto.id=?");

            comando.setString(1, p.getNome());
            comando.setString(2, p.getDescricao());
            comando.setDouble(3, p.getValorCompra());
            comando.setDouble(4, p.getValorVenda());
            comando.setInt(5, p.getId());
            comando.setInt(6, p.getId());

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

    public static boolean atualizarEstoque(int id, int qtde, double valorCompra, double valorVenda) {

        boolean retorno = false;
        java.sql.Date mysqlDate = new java.sql.Date(new java.util.Date().getTime());

        Produto p = new Produto(id, valorCompra, valorVenda, qtde, mysqlDate);

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO entrada_produto (id_produto, qtde, valor_compra, valor_venda, data_entrada) VALUES (?, ?, ?, ?, ?)");

            comando.setInt(1, p.getId());
            comando.setInt(2, p.getQtde());
            comando.setDouble(3, p.getValorCompra());
            comando.setDouble(4, p.getValorVenda());
            comando.setDate(5, p.getDataEntrada());

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

            PreparedStatement comando = conexao.prepareStatement("SELECT produto.id, produto.nome, produto.descricao, entrada_produto.valor_compra, entrada_produto.valor_venda, estoque.qtde FROM produto, entrada_produto, estoque WHERE produto.status =1 AND entrada_produto.id_produto = produto.id AND estoque.id_produto = produto.id GROUP BY produto.id");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                Produto p = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6));

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

    public static ArrayList<Produto> getProduto(String nome) {

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT produto.id, produto.nome, produto.descricao, entrada_produto.valor_compra, entrada_produto.valor_venda, estoque.qtde FROM produto, entrada_produto, estoque WHERE produto.status =1 AND entrada_produto.id_produto = produto.id AND estoque.id_produto = produto.id AND produto.nome LIKE '%" + nome + "%' GROUP BY produto.id");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                Produto p = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6));

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

    public static ArrayList<Produto> getProduto(int idEmp) {

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT produto.id, produto.nome, produto.descricao, entrada_produto.valor_compra, entrada_produto.valor_venda, estoque.qtde FROM produto, entrada_produto, estoque WHERE produto.status =1 AND entrada_produto.id_produto = produto.id AND estoque.id_produto = produto.id AND produto.id_filial = "+idEmp+" GROUP BY produto.id;");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                Produto p = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6));

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

    public static ArrayList<Produto> getProduto(String nome, int idEmp) {

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT produto.id, produto.nome, produto.descricao, entrada_produto.valor_compra, entrada_produto.valor_venda, estoque.qtde FROM produto, entrada_produto, estoque WHERE produto.status =1 AND entrada_produto.id_produto = produto.id AND estoque.id_produto = produto.id AND produto.nome LIKE '%" + nome + "%' AND produto.id_filial = "+idEmp+" GROUP BY produto.id");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                Produto p = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6));

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
