package com.backend.alianza.controller;

import com.backend.alianza.model.Provincia;
import com.backend.alianza.service.ProvinciaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController {

    @Autowired
    public ProvinciaServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<Provincia>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Provincia> create(@RequestBody Provincia c) {
        return new ResponseEntity<>(service.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Provincia> update(@PathVariable Long id, @RequestBody Provincia re) {
        Provincia provincia = service.findById(id);
        if (provincia != null) {
            try {
                provincia.setProvinciaNombre(re.getProvinciaNombre());

                return new ResponseEntity<>(service.save(provincia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Provincia> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
