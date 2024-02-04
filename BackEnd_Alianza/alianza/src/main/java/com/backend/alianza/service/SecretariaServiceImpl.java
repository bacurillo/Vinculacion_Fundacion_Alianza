package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Secretaria;

import com.backend.alianza.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SecretariaServiceImpl extends GenericServiceImpl<Secretaria,Long>implements GenericService<Secretaria,Long> {
    @Autowired
    SecretariaRepository secretariaRepository;
    @Override
    public CrudRepository<Secretaria, Long> getDao() {
        return secretariaRepository;
    }
}
