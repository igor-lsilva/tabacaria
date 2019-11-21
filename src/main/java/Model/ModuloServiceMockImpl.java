/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ModuloDAO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Ochaus
 */
public class ModuloServiceMockImpl implements ModuloService{
    
private static Map<String, Modulo> mapPapeis;
private static ArrayList<Modulo> modulo;

    private static boolean initialized = false;

    public ModuloServiceMockImpl() {
        synchronized (ModuloServiceMockImpl.class) {
            if (!initialized) {
                init();
                initialized = true;
            }
        }
    }

    private void init() {
//        mapPapeis = ModuloDAO.getModulo();
//        
//        for (String i : mapPapeis.keySet()) {
//            Modulo m = mapPapeis.get(i.toString());
//          System.out.println(m.getNomeModulo()+ new Modulo(m.getNomeModulo()));
//            mapPapeis.put(m.getNomeModulo(), new Modulo(m.getNomeModulo()));
//        }
        
        mapPapeis = new LinkedHashMap<>();
//        modulo = ModuloDAO.getModulo();
//        
//        for (Modulo m : modulo) {
//            String x = m.getNomeModulo();
//            mapPapeis.put(x, new Modulo(x));
//        }
        mapPapeis.put("USUARIO", new Modulo("USUARIO"));
        mapPapeis.put("CLIENTE", new Modulo("CLIENTE"));
        mapPapeis.put("FILIAL", new Modulo("FILIAL"));
        mapPapeis.put("PRODUTO", new Modulo("PRODUTO"));
        mapPapeis.put("ESTOQUE", new Modulo("ESTOQUE"));
        mapPapeis.put("VENDA", new Modulo("VENDA"));
        mapPapeis.put("ADMINISTRADOR", new Modulo("ADMINISTRADOR"));
                
    }

    @Override
    public Modulo findByNome(String nomeModulo) {
        return mapPapeis.get(nomeModulo);
    }
}