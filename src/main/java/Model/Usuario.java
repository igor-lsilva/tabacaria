/*
 * To change this license header, choose License Headers in Project Properties.
 * To change th-+is template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author igor.lsilva9
 */
public class Usuario extends Funcionario {

    private static final long serialVersionUID = 1L;

    private String username;
    private String hashSenha;
    private List<Modulo> modulos;

    public Usuario(String username, String hashSenha, List<Modulo> modulos, int idEmpresa, String nomeCompleto, String cpf, String contato) {
        super(idEmpresa, nomeCompleto, cpf, contato);
        this.username = username;
        this.hashSenha = hashSenha;
        this.modulos = modulos;
    }

    public Usuario(int id,String username, String hashSenha, List<Modulo> modulos, int idEmpresa, String nomeCompleto, String cpf, String contato) {
        super(id, idEmpresa, nomeCompleto, cpf, contato);
        this.username = username;
        this.hashSenha = hashSenha;
        this.modulos = modulos;
    }
      
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
    
    public boolean verificarPapel(String nomePapel) {
        for (Modulo m : modulos) {
            if (m.getNomeModulo().equals(nomePapel)) {
                return true;
            }
        }
        return false;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
}
