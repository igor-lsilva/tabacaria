/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FilialDAO;
import Model.Filial;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilialController {
    
    public static boolean salvar(String nomeFilial,String CNPJ, String endereco) {
        
        Filial f = new Filial(nomeFilial, CNPJ, endereco);
        return FilialDAO.salvar(f);
    }

   
    public static boolean excluir(int fID) {
        return FilialDAO.excluir(fID);
    }
     
    
    public static boolean atualizar(int id,String nomeFilial,String CNPJ, String endereco){
        
        Filial f = new Filial(id, nomeFilial, CNPJ, endereco);
        
        return FilialDAO.atualizar(f);
    }
    
     public static ArrayList<Filial> getFilial() throws SQLException  {
        ArrayList<Filial> filiais = FilialDAO.getFilial();

        return filiais;
    }
     
    public static ArrayList<Filial> getFilial(String nome) throws SQLException  {
        ArrayList<Filial> filiais = FilialDAO.getFilial(nome);

        return filiais;
    }
}
