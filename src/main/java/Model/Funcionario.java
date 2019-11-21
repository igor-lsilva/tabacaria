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
public abstract class Funcionario extends Object {

    private int id;
    private int idEmpresa;
    private String nomeCompleto;
    private String cpf;
    private String contato;


    public Funcionario() {
    }

    public Funcionario(int idEmpresa, String nomeCompleto, String cpf, String contato) {
        this.idEmpresa = idEmpresa;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.contato = contato;
    }

    public Funcionario(int id, int idEmpresa, String nomeCompleto, String cpf, String contato) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.contato = contato;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    
}
