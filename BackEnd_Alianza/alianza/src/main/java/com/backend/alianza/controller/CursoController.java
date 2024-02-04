package com.backend.alianza.controller;


import com.backend.alianza.model.Curso;
import com.backend.alianza.repository.CursoRepository;
import com.backend.alianza.service.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    public CursoServiceImpl service;

    @Autowired
    CursoRepository cursoRepository;


    @GetMapping("/existsByNombreCurso/{nombreCurso}")
    public ResponseEntity<Boolean> existsByNombreCurso(@PathVariable String nombreCurso) {
        boolean exists = cursoRepository.existsByNombreCurso(nombreCurso);
        return ResponseEntity.ok(exists);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Curso>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaCurso/{busqueda}")
    public ResponseEntity<List<Curso>> busquedaCurso(@PathVariable String busqueda) {
        busqueda = busqueda.trim();
        if (busqueda.equalsIgnoreCase("NA")) {
            busqueda = "";
        }

        return new ResponseEntity<>(service.busquedaCurso(busqueda), HttpStatus.OK);
    }


    @GetMapping("/cursoByUser")
    public ResponseEntity<List<Curso>> cursoByUser(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.cursoByUser(id), HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity<Curso> create(@RequestBody Curso c) {
        return new ResponseEntity<>(service.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso c) {
        Curso curso = service.findById(id);
        if (curso != null) {
            try {
                curso.setNombreCurso(c.getNombreCurso());
                curso.setDocente(c.getDocente());
                curso.setFechaInicio(c.getFechaInicio());
                curso.setRangoEdad(c.getRangoEdad());
                curso.setFechaRegistro(c.getFechaRegistro());

                return new ResponseEntity<>(service.save(curso), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


