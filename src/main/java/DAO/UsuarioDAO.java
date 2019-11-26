/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import Model.Modulo;
import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public static ArrayList<Usuario> getUsuarios() {
        boolean retorno = false;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuario, usuario_modulo where usuario.idusuario = usuario_modulo.idusuario and estatus = 1;");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                
                //id,login,senha, lista, idempresa,nome,cpf,contato

                Usuario u = new Usuario(rs.getInt("idusuario"), rs.getString("login"), rs.getString("senha"), (List<Modulo>) rs.getArray("idmodulo"), rs.getInt("idfilial"), rs.getString("nome"), rs.getString("cpf"), rs.getString("contato"));

                listaUsuarios.add(u);
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
        return listaUsuarios;
    }
//    public static ArrayList<Funcionario> getUsuarios(String nome) {
//        boolean retorno = false;
//        
//        ArrayList<Funcionario> listaUsuarios = new ArrayList<>();
//        
//        try {
//
//            Class.forName(DRIVER);
//            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
//
//            PreparedStatement comando = conexao.prepareStatement("SELECT *FROM usuario WHERE nome LIKE '%"+nome+"%' AND estatus=1");
//            
//            ResultSet rs = comando.executeQuery();
//            
//            while (rs.next()) {
//                
//                Funcionario c = new Funcionario(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5),  rs.getInt(6),  rs.getInt(7),  rs.getString(8));
//
//                listaUsuarios.add(c);
//            }
//
//            int linhasAfetadas = comando.executeUpdate();
//
//        } catch (ClassNotFoundException ex) {
//            retorno = false;
//        } catch (SQLException ex) {
//            retorno = false;
//        } finally {
//            try {
//                conexao.close();
//            } catch (SQLException ex) {
//                retorno = false;
//            }
//
//        }
//        return listaUsuarios;
//    }

    public static ArrayList<Filial> getFilial() {
        boolean retorno = false;

        ArrayList<Filial> listaFilial = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT *FROM filial");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                Filial f = new Filial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

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

    public static boolean salvar(Usuario user) {
        boolean retorno = false;
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("insert into usuario (nome,cpf,login,senha,idfilial,contato) values(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, user.getNomeCompleto());
            comando.setString(2, user.getCpf());
            comando.setString(3, user.getUsername());
            comando.setString(4, user.getHashSenha());
            comando.setInt(5, user.getIdEmpresa());
            comando.setString(6, user.getContato());

            int linhasAfetadas = comando.executeUpdate();

            ResultSet rs = comando.getGeneratedKeys();
            int idUsuario = 0;

            if (rs.next()) {

                idUsuario = rs.getInt(1);
            }

            if (linhasAfetadas > 0) {

                int linhasAfetadas2 = 0;

                for (int i = 0; i < user.getModulos().size(); i++) {

                    comando = conexao.prepareStatement("insert into usuario_modulo(idusuario,idmodulo) values(?, ?)");
                    comando.setInt(1, idUsuario);
                    comando.setInt(2, Integer.parseInt(user.getModulos().get(i).getNomeModulo()));
                    linhasAfetadas2 = comando.executeUpdate();
                }

                if (linhasAfetadas2 > 0) {

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

    public static boolean remover(int id) {
        boolean retorno = false;
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE usuario SET estatus=0 WHERE idusuario = '" + id + "'");

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

//    public static boolean editar(Funcionario user) {
//        boolean retorno = false;
//        try {
//
//            Class.forName(DRIVER);
//            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
//
//            PreparedStatement comando = conexao.prepareStatement("UPDATE usuario SET nome=?, cpf=?, login=?, senha=?, idfilial=?, idmodulo=?, contato=? WHERE idusuario= ?");
//
//            comando.setString(1, user.getNomeCompleto());
//            comando.setString(2, user.getCpf());
//            comando.setString(3, user.getLogin());
//            comando.setString(4, user.getSenha());
//            comando.setInt(5, user.getIdEmpresa());
//            comando.setInt(6, user.getIdModulo());
//            comando.setString(7, user.getContato());
//            comando.setInt(8, user.getId());
//
//            int linhasAfetadas = comando.executeUpdate();
//
//            if (linhasAfetadas > 0) {
//                retorno = true;
//            } else {
//                retorno = false;
//            }
//
//        } catch (ClassNotFoundException ex) {
//            retorno = false;
//        } catch (SQLException ex) {
//            retorno = false;
//        } finally {
//            try {
//                conexao.close();
//            } catch (SQLException ex) {
//                retorno = false;
//            }
//
//        }
//        return retorno;
//    }
//        public static Funcionario login(String login,String senha){
//        Funcionario f = null;
//        try {
//
//            Class.forName(DRIVER);
//            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
//
//            PreparedStatement comando = conexao.prepareStatement("SELECT *FROM usuario WHERE login like'"+login+"' AND senha like '"+senha+"' AND estatus=1");
//
//            ResultSet rs = comando.executeQuery();          
//            
//            while (rs.next()) {               
//                f = new Funcionario(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5),  rs.getInt(6),  rs.getInt(7),  rs.getString(8));
//            }
//
//        } catch (ClassNotFoundException ex) {
//            f = null;
//        } catch (SQLException ex) {
//            f = null;
//        } finally {
//            try {
//                conexao.close();
//            } catch (SQLException ex) {
//                f = null;
//            }
//
//        }
//        return f;
//        }
}
