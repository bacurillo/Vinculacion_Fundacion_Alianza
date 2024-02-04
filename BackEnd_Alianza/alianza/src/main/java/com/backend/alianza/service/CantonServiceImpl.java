package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Canton;
import com.backend.alianza.repository.CantonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantonServiceImpl extends GenericServiceImpl<Canton, Long> implements GenericService<Canton, Long> {

    @Autowired
    private CantonRepository repository;

    @Override
    public CrudRepository<Canton, Long> getDao() {
        return repository;
    }

    public List<Canton> busqueda(Long id) {
        return repository.busqueda(id);
    }
}
