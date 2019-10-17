/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lucas.asilva89
 */
public class Usuario {

    private int id;
    private String login;
    private String senha;
    private int filial;
    private String cargo;

    public Usuario(int id, String login, String senha, int filial, String cargo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.filial = filial;
        this.cargo = cargo;
    }

     public Usuario(String login, String senha, int filial, String cargo) {
        this.login = login;
        this.senha = senha;
        this.filial = filial;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Usuario(){
    }
    
    

}
