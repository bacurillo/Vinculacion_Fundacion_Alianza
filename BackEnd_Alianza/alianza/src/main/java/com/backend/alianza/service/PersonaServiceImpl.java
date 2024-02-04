package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Persona;
import com.backend.alianza.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long>implements GenericService<Persona,Long> {
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }
}
