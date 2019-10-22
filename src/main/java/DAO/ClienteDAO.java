package DAO;

/**
 *
 * @author matheus.eleoterio
 */

import Model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3307/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

   
    public static boolean salvar(String nomeCliente,String CPF, String dtNascimento, String contato) {
        boolean retorno = false;
        Cliente c = new Cliente(nomeCliente, CPF, dtNascimento, contato);

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO cliente (nomeCliente,cpfCliente,dtNascimento,contato) VALUES (?,?,?,?)");

            comando.setString(1, c.getNomeCliente());
            comando.setString(2, c.getCPF());
            comando.setString(3, c.getDtNascimento());
            comando.setString(4, c.getContato());

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

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM cliente WHERE idCliente= ?");

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
    
    public static boolean atualizar(int idCliente,String nomeCliente,String CPF, String dtNascimento, String contato) {

        boolean retorno = false;
        Cliente c = new Cliente(idCliente, nomeCliente, CPF, dtNascimento, contato);
        
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE tabacaria.cliente SET nomeCliente=?, cpfCliente=?, dtNascimento=?, contato=? WHERE idCliente= ?");

            comando.setString(1, c.getNomeCliente());
            comando.setString(2, c.getCPF());
            comando.setString(3, c.getDtNascimento());
            comando.setString(4, c.getContato());
            comando.setInt(5, c.getIdCliente());

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

    public static ArrayList<Cliente> getClientes() throws SQLException {
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                
                Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

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
    
     public static ArrayList<Cliente> getClientes(String nome) throws SQLException {
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente WHERE nomeCliente LIKE '%"+nome+"%'");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                
                Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

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
