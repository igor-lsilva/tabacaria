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
public abstract class Usuario extends Object {

    private int id;
    private String login;
    private String senha;
    private String nomeCompleto;
    private String cpf;

    public Usuario() {
    }

    public Usuario(int id, String login, String senha, String nomeCompleto, String cpf) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }

    public Usuario(String login, String senha, String nomeCompleto, String cpf) {
        this.login = login;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

}
