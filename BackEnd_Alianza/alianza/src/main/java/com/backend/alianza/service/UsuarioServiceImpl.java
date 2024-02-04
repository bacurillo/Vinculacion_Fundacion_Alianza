package com.backend.alianza.service;


import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.model.Usuario;
import com.backend.alianza.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return repository;
    }

    @Override
    public Usuario search(String username) {
        return repository.findByUsername(username);
    }

    public List<Usuario> filtroUser(String busqueda, long rol) {
        return repository.filtroUser(busqueda, rol);
    }

    public List<Usuario> filtroUserSR(String busqueda) {
        return repository.filtroUserSR(busqueda);
    }


    public List<Usuario> userXrol(long rol) {
        return repository.userXrol(rol);
    }
}