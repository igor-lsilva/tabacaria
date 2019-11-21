/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.ModuloDAO;
import DAO.ProdutoDAO;
import Model.Modulo;
import Model.Produto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Ochaus
 */
public class NewClass {
    public static void main(String[] args) {
        
        ProdutoDAO.salvar("TESTE", "", 4, 5);
        
//        ProdutoDAO.excluir(1);
//        
//        ArrayList<Produto> p = ProdutoDAO.getProduto();
//        
//        for (int i = 0; i < p.size(); i++) {
//            System.out.println("--------------------------------------");
//            System.out.println(p.get(i).getId());
//            System.out.println(p.get(i).getNome());
//            System.out.println(p.get(i).getDescricao());
//            System.out.println(p.get(i).getValorCompra());
//            System.out.println(p.get(i).getValorVenda());
//            System.out.println(p.get(i).getQtde());
//            System.out.println(p.get(i).getDataEntrada());
//            System.out.println("--------------------------------------");
//        }
//
//        Map<String, String> mapPapeis;
//        ArrayList<Modulo> modulo;
//        mapPapeis = new LinkedHashMap<>();
//        modulo = ModuloDAO.getModulo();
//        
//        for (Modulo m : modulo) {
//            String teste = m.getNomeModulo();
//            System.out.println(mapPapeis.put(teste, teste));
//            System.out.println(teste);
//        }
//        mapPapeis = LinkedHashMap<>();
        
//        for (String i : mapPapeis.keySet()) {
//            Modulo m = mapPapeis.get(i);
//            System.out.println(m.getNomeModulo()+ new Modulo(m.getNomeModulo()));
//        }
    }
}
