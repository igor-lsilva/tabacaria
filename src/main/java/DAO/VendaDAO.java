/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Item;
import Model.Produto;
import Model.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author igor.silva
 */
public class VendaDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "tabacaria";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://tabacaria-aws.cjmt1xx5nvfs.us-east-1.rds.amazonaws.com:3306/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    
    public static boolean salvar(Venda venda) {
        boolean retorno = false;
        java.sql.Date mysqlDate = new java.sql.Date(new java.util.Date().getTime());
        
        venda.setDataVenda(mysqlDate);

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO venda (idcliente, idfilial, precofinal, datavenda) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            comando.setInt(1, venda.getIdCliente());
            comando.setInt(2, venda.getIdFilial());
            comando.setFloat(3, venda.getPrecoFinal());
            comando.setDate(4, venda.getDataVenda());
            

            int linhasAfetadas = comando.executeUpdate();
            
            ResultSet rs = comando.getGeneratedKeys();
            
            if (rs.next()) {
                
                venda.setIdVenda(rs.getInt(1));
            }
            ArrayList<Item> itemVenda = venda.getItens();           
            if (linhasAfetadas > 0) {
                for (int i = 0; i < itemVenda.size(); i++) {
                    
                    comando = conexao.prepareStatement("INSERT INTO saida_produto (id_venda, id_produto, qtde, data_saida, valor_compra, valor_venda) VALUES (?, ?, ?, ?, ?,?)");                               
                    comando.setInt(1,venda.getIdVenda());
                    comando.setInt(2, itemVenda.get(i).getP().getId());
                    comando.setInt(3, itemVenda.get(i).getQtd());
                    comando.setDate(4, venda.getDataVenda());
                    comando.setDouble(5, itemVenda.get(i).getP().getValorCompra());
                    comando.setDouble(6, itemVenda.get(i).getP().getValorVenda());
                   
                    linhasAfetadas = comando.executeUpdate();
                                           
                    if (linhasAfetadas > 0) {

                        retorno = true;
                        
                    } else {
                        
                        retorno = false;
                    }                    
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

    public static ArrayList<Venda> getVenda(int id, java.sql.Date datainicio, java.sql.Date datafim) {
        boolean retorno = false;

        ArrayList<Venda> listaVendas = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM tabacaria.venda where idfilial = "+id+" AND datavenda BETWEEN '"+datainicio+"' and '"+datafim+"';");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
              
               
                Venda v = new Venda(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5));

                listaVendas.add(v);
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
        return listaVendas;
    }
 
}
