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
    private static final String URL = "jdbc:mysql://localhost:3306/tabacaria?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static ArrayList<Usuario> getUsuarios() {
        boolean retorno = false;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT usuario.idusuario, usuario.nome, usuario.cpf, usuario.login, usuario.senha, usuario.idfilial, usuario.contato, usuario_modulo.idmodulo FROM usuario, usuario_modulo where estatus = 1 group by usuario.idusuario;");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                ArrayList<Modulo> modulos = new ArrayList<>();
                
                PreparedStatement comando1 = conexao.prepareStatement("SELECT modulo.idmodulo, modulo.nome FROM modulo, usuario_modulo where modulo.idmodulo = usuario_modulo.idmodulo and usuario_modulo.idusuario = "+id+";");
                ResultSet rs1 = comando1.executeQuery();

                while (rs1.next()) {
                    Modulo m = new Modulo(rs1.getInt(1), rs1.getString(2));
                    modulos.add(m);
                }

                //id,login,senha, lista, idempresa,nome,cpf,contato
                Usuario u = new Usuario(id, rs.getString("usuario.login"), rs.getString("usuario.senha"), modulos, rs.getInt("usuario.idfilial"), rs.getString("usuario.nome"), rs.getString("usuario.cpf"), rs.getString("usuario.contato"));

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
    public static ArrayList<Usuario> getUsuarios(String nome) {
        boolean retorno = false;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT usuario.idusuario, usuario.nome, usuario.cpf, usuario.login, usuario.senha, usuario.idfilial, usuario.contato, usuario_modulo.idmodulo FROM usuario, usuario_modulo where usuario.nome like '%"+nome+"%' and usuario.idusuario = usuario_modulo.idusuario and estatus = 1 group by usuario.idusuario;");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                ArrayList<Modulo> modulos = new ArrayList<>();
                
                PreparedStatement comando1 = conexao.prepareStatement("SELECT modulo.nome FROM modulo, usuario_modulo, usuario  where usuario.idusuario = usuario_modulo.idusuario and usuario.idusuario = "+id+" group by modulo.nome;");
                ResultSet rs1 = comando1.executeQuery();

                while (rs1.next()) {
                    Modulo m = new Modulo(id, rs1.getString(1));
                    modulos.add(m);
                }

                //id,login,senha, lista, idempresa,nome,cpf,contato                                        
                Usuario u = new Usuario(id, rs.getString("usuario.login"), rs.getString("usuario.senha"), modulos, rs.getInt("usuario.idfilial"), rs.getString("usuario.nome"), rs.getString("usuario.cpf"), rs.getString("usuario.contato"));

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
                retorno = true;
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

    public static boolean editar(Usuario user) {
        boolean retorno = false;
        try {
            
            if(removerModulos(user.getId())){
                    
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            
                
            PreparedStatement comando = conexao.prepareStatement("update usuario set nome=?, cpf=?, login=?, senha=?,idfilial=?, contato=? where idusuario= ?");

            comando.setString(1, user.getNomeCompleto());
            comando.setString(2, user.getCpf());
            comando.setString(3, user.getUsername());
            comando.setString(4, user.getHashSenha());
            comando.setInt(5, user.getIdEmpresa());
            comando.setString(6, user.getContato());
            comando.setInt(7, user.getId());

            int linhasAfetadas = comando.executeUpdate();

            int idUsuario = user.getId();

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
    
    public static boolean removerModulos(int id) {
        boolean retorno = false;
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("delete from usuario_modulo where idusuario =?");
            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = true;
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
