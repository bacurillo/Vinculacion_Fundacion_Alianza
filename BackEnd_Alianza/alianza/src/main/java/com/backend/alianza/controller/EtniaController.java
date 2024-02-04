package com.backend.alianza.controller;

import com.backend.alianza.model.Etnia;
import com.backend.alianza.service.EtniaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etnia")
public class EtniaController {
    @Autowired
    public EtniaServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<Etnia>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Etnia> create(@RequestBody Etnia et) {
        return new ResponseEntity<>(service.save(et), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Etnia> update(@PathVariable Long id, @RequestBody Etnia et) {
        Etnia etnia = service.findById(id);
        if (etnia != null) {
            try {
                etnia.setEtniaNombre(et.getEtniaNombre());

                return new ResponseEntity<>(service.save(etnia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Etnia> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
