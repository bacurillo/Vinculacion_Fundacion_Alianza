package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.RangoEdad;
import com.backend.alianza.repository.RangoEdadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RangoEdadServiceImpl  extends GenericServiceImpl<RangoEdad, Long> implements GenericService<RangoEdad, Long> {

    @Autowired
    private RangoEdadRepository repository;
    @Override
    public CrudRepository<RangoEdad, Long> getDao() {
        return repository;
    }
}
