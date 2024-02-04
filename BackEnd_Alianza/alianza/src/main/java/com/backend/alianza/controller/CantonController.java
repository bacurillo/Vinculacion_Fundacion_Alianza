package com.backend.alianza.controller;

import com.backend.alianza.model.Canton;
import com.backend.alianza.service.CantonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canton")
public class CantonController {

    @Autowired
    public CantonServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<Canton>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busqueda/{id}")
    public ResponseEntity<List<Canton>> busqueda(@PathVariable Long id) {
        return new ResponseEntity<>(service.busqueda(id), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<Canton> create(@RequestBody Canton c) {
        return new ResponseEntity<>(service.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Canton> update(@PathVariable Long id, @RequestBody Canton c) {
        Canton canton = service.findById(id);
        if (canton != null) {
            try {
                canton.setCantonNombre(c.getCantonNombre());
                canton.setProvincia(c.getProvincia());

                return new ResponseEntity<>(service.save(canton), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Canton> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
