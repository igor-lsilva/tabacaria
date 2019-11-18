/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author igor.silva
 */
public class ItensVendas {

    //private List<Produto> item;
    private ArrayList<Item> itens;

    public ItensVendas() {
        itens = new ArrayList<>();
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public double precoTotal(){
        double preco = 0;
        for (Item itensVendas : itens) {
            preco =+ itensVendas.getPreco();
        }
        return preco;
    }
    
    public boolean excluirItem(Item item){
        for (Item itemVenda : itens) {
            return itemVenda.getP().getId() == item.getP().getId();
        }
        return false;
    }
    
    

}
