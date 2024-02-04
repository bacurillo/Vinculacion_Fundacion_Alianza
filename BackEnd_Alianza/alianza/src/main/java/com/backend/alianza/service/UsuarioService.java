package com.backend.alianza.service;


import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.model.Usuario;

public interface UsuarioService extends GenericService<Usuario, Long> {
    public Usuario search(String username);

}
