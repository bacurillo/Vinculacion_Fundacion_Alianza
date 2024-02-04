package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.TipoFamilia;
import com.backend.alianza.repository.TipoFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoFamiliaServiceImpl  extends GenericServiceImpl<TipoFamilia, Long> implements GenericService<TipoFamilia, Long> {

    @Autowired
    private TipoFamiliaRepository repository;
    @Override
    public CrudRepository<TipoFamilia, Long> getDao() {
        return repository;
    }


}
