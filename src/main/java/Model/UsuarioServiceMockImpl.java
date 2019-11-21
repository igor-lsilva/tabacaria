/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Ochaus
 */
public class UsuarioServiceMockImpl implements UsuarioService {

 private static final String SENHA_PADRAO = "123456789";

    private static Map<String, Usuario> mapUsuarios;

    private static boolean initialized = false;

    private ModuloService moduloService;

    public UsuarioServiceMockImpl() {
        synchronized (UsuarioServiceMockImpl.class) {
            if (!initialized) {
                moduloService = new ModuloServiceMockImpl();
                init();
                initialized = true;
            }
        }
    }

    private void init() {
        mapUsuarios = new LinkedHashMap<>();

        mapUsuarios.put("LUCAS", new Usuario("LUCAS", SENHA_PADRAO, Arrays.asList(moduloService.findByNome("ADMINISTRADOR"), moduloService.findByNome("PRODUTO"),moduloService.findByNome("CLIENTE"),moduloService.findByNome("ESTOQUE"),moduloService.findByNome("USUARIO"),moduloService.findByNome("FILIAL"),moduloService.findByNome("VENDA")), 1, "Lucas Arcanjo da Silva", "12345678911", "12345678"));
        mapUsuarios.put("IGOR", new Usuario("IGOR", SENHA_PADRAO, Arrays.asList(moduloService.findByNome("ESTOQUE"),moduloService.findByNome("PRODUTO")), 1, "Igor Lima", "12345678911", "12345678"));
    }

    @Override
    public Usuario findByUsername(String username) {
        return mapUsuarios.get(username);
    }    
}
