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
    private String nome;
    private double valorCompra;
    private double valorVenda;
    private String descricao;

    public Produto() {
        
    }

    public Produto(String nome, double valorCompra, double valorVenda, String descricao) {
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.descricao = descricao;
    }

    public Produto(int id, String nome, double valorCompra, double valorVenda, String descricao) {
        this.id = id;
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

}
