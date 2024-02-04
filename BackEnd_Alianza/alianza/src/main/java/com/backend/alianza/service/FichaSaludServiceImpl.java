package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaSalud;
import com.backend.alianza.repository.FichaSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaSaludServiceImpl extends GenericServiceImpl<FichaSalud, Long> implements GenericService<FichaSalud, Long> {

    @Autowired
    FichaSaludRepository fichaSaludRepository;

    @Override
    public CrudRepository<FichaSalud, Long> getDao() {
        return fichaSaludRepository;
    }

    public List<FichaSalud> busquedaID(Long id) {
        return fichaSaludRepository.busquedaID(id);
    }
}
