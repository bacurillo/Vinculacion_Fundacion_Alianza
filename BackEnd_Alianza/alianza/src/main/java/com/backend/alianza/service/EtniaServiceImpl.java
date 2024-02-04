package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Etnia;
import com.backend.alianza.repository.EtniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EtniaServiceImpl extends GenericServiceImpl<Etnia, Long> implements GenericService<Etnia, Long> {

    @Autowired
    private EtniaRepository repository;

    @Override
    public CrudRepository<Etnia, Long> getDao() {
        return repository;
    }
}
