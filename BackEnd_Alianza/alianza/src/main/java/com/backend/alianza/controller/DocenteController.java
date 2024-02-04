package com.backend.alianza.controller;

import com.backend.alianza.model.Docente;
import com.backend.alianza.service.DocenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    public DocenteServiceImpl docenteService;


    @GetMapping("/get")
    public ResponseEntity<List<Docente>> list() {
        return new ResponseEntity<>(docenteService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Docente> create(@RequestBody Docente en) {
        return new ResponseEntity<>(docenteService.save(en), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Docente> update(@PathVariable Long id, @RequestBody Docente doc) {
        Docente docente = docenteService.findById(id);
        if (docente != null) {
            try {
                docente.setMateriaDocente(doc.getMateriaDocente());
                docente.setTituloDocente(doc.getTituloDocente());
                docente.setPersona(doc.getPersona());

                return new ResponseEntity<>(docenteService.save(docente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Docente> delete(@PathVariable Long id) {
        docenteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
