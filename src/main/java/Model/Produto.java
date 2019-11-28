/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Eduardo.mpaz
 */
public class Produto {
    private int id; 
    private String nome;
    private String descricao;
    private double valorCompra;
    private double valorVenda;
    private int qtde;
    private Date dataEntrada;

    public Produto() {
        
    }

    public Produto(int id, String nome, String descricao, double valorCompra, double valorVenda) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public Produto(int id, String nome, int qtde) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
    }
   
    public Produto(int id, double valorCompra, double valorVenda, int qtde, Date dataEntrada) {
        this.id = id;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.qtde = qtde;
        this.dataEntrada = dataEntrada;
    }
   
    public Produto(String nome, String descricao, double valorCompra, double valorVenda, int qtde, Date dataEntrada) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.qtde = qtde;
        this.dataEntrada = dataEntrada;
    }

    public Produto(String nome, String descricao, double valorCompra, double valorVenda, Date dataEntrada) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.dataEntrada = dataEntrada;
    }
    
    

    public Produto(int id, String nome, String descricao, double valorCompra, double valorVenda, int qtde) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.qtde = qtde;
    }

    public Produto(int id, String nome, String descricao, double valorCompra, double valorVenda, int qtde, Date dataEntrada) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.qtde = qtde;
        this.dataEntrada = dataEntrada;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    
    
    
    

}
