package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Curso;
import com.backend.alianza.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Long> implements GenericService<Curso, Long> {
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoRepository;
    }

    public List<Curso> cursoByUser(Long userId) {
        return cursoRepository.cursoByUser(userId);
    }

    public List<Curso> busquedaCurso(String busqueda) {
        return cursoRepository.busquedaCurso(busqueda);
    }
}
