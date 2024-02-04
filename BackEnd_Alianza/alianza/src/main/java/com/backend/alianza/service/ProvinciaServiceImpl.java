package com.backend.alianza.service;

import com.backend.alianza.model.Provincia;
import com.backend.alianza.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;

@Service
public class ProvinciaServiceImpl extends GenericServiceImpl<Provincia, Long> implements GenericService<Provincia, Long> {

    @Autowired
    private ProvinciaRepository repository;

    @Override
    public CrudRepository<Provincia, Long> getDao() {
        return repository;
    }
}
