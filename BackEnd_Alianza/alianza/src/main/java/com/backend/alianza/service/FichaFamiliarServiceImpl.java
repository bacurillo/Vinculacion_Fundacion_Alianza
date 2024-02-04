package com.backend.alianza.service;

import com.backend.alianza.model.FichaFamiliar;
import com.backend.alianza.repository.FichaFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;

import java.util.List;

@Service
public class FichaFamiliarServiceImpl extends GenericServiceImpl<FichaFamiliar, Long> implements GenericService<FichaFamiliar, Long> {

    @Autowired
    private FichaFamiliarRepository repository;

    @Override
    public CrudRepository<FichaFamiliar, Long> getDao() {
        return repository;
    }

    public List<FichaFamiliar> busquedaID(Long id) {
        return repository.busquedaID(id);
    }
}
