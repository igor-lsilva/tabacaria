/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Eduardo.mpaz
 */
public class Produto {
    private int id; 
    private String nomeProduto;
    private String preco;
    private String tipo;

    public Produto() {
        
    }

    public Produto(String nomeProduto, String preco, String tipo) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.tipo = tipo;
    }
    
    public Produto(int id, String nomeProduto, String preco, String tipo) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.tipo = tipo;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String Preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
