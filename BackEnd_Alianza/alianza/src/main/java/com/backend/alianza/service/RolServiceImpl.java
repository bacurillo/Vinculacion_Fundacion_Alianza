package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Rol;
import com.backend.alianza.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements RolService{
    @Autowired
    RolRepository rolRepository;
    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolRepository;
    }

}
