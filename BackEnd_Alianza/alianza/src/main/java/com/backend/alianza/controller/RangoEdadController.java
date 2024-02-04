package com.backend.alianza.controller;

import com.backend.alianza.model.RangoEdad;
import com.backend.alianza.service.RangoEdadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rangoEdad")
public class RangoEdadController {

    @Autowired
    public RangoEdadServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<RangoEdad>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<RangoEdad> create(@RequestBody RangoEdad re) {
        return new ResponseEntity<>(service.save(re), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<RangoEdad> update(@PathVariable Long id, @RequestBody RangoEdad re) {
        RangoEdad rangoEdad = service.findById(id);
        if (rangoEdad != null) {
            try {
                rangoEdad.setLimInferior(re.getLimInferior());
                rangoEdad.setLimSuperior(re.getLimSuperior());

                return new ResponseEntity<>(service.save(rangoEdad), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RangoEdad> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
