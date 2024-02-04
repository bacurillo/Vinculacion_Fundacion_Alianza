package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Docente;
import com.backend.alianza.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl extends GenericServiceImpl<Docente,Long>implements GenericService<Docente,Long> {
    @Autowired
    DocenteRepository docenteRepository;
    @Override
    public CrudRepository<Docente, Long> getDao() {
        return docenteRepository;
    }
}
