/*
 * To change this license header, choose License Headers in Project Properties.
 * To change th-+is template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author igor.lsilva9
 */
public class Funcionario extends Usuario {

    private int idModulo;
    private int idEmpresa;
    private String contato;

    public Funcionario(String nome, String cpf,String login, String senha, int idEmpresa, int idModulo, String contato) {
        super(login, senha, nome, cpf);
        this.idModulo = idModulo;
        this.idEmpresa = idEmpresa;
        this.contato = contato;
    }

    public Funcionario() {

    }

    public Funcionario(int id, String nome, String cpf,String login, String senha, int idEmpresa, int idModulo, String contato) {
        super(id, login, senha, nome, cpf);
        this.idModulo = idModulo;
        this.idEmpresa = idEmpresa;
        this.contato = contato;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSenha() {
        return super.getSenha(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLogin() {
        return super.getLogin(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCpf() {
        return super.getCpf(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNomeCompleto(String nomeCompleto) {
        super.setNomeCompleto(nomeCompleto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomeCompleto() {
        return super.getNomeCompleto(); //To change body of generated methods, choose Tools | Templates.
    }
    

}
