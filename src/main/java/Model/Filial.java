/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ochaus
 */
public class Filial {
    
    private int id; 
    private String nomeFilial;
    private String CNPJ;
    private String endereco;

    public Filial() {
        
    }

    public Filial(String nomeFilial, String CNPJ, String endereco) {
        this.nomeFilial = nomeFilial;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }
    
    public Filial(int id, String nomeFilial, String CNPJ, String endereco) {
        this.id = id;
        this.nomeFilial = nomeFilial;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
   
}
