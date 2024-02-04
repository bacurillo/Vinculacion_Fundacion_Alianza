package com.backend.alianza.controller;

import com.backend.alianza.model.Parroquia;
import com.backend.alianza.service.ParroquiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parroquia")
public class ParroquiaController {

    @Autowired
    public ParroquiaServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<Parroquia>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busqueda/{id}")
    public ResponseEntity<List<Parroquia>> busqueda(@PathVariable Long id) {
        return new ResponseEntity<>(service.busqueda(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Parroquia> create(@RequestBody Parroquia p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Parroquia> update(@PathVariable Long id, @RequestBody Parroquia p) {
        Parroquia parroquia = service.findById(id);
        if (parroquia != null) {
            try {
                parroquia.setParroquiaNombre(p.getParroquiaNombre());
                parroquia.setCanton(p.getCanton());

                return new ResponseEntity<>(service.save(parroquia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Parroquia> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
