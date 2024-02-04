package com.backend.alianza.controller;

import com.backend.alianza.model.Encargado;
import com.backend.alianza.service.EncargadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encargado")
public class EncargadoController {

    @Autowired
    public EncargadoServiceImpl encargadoService;


    @GetMapping("/get")
    public ResponseEntity<List<Encargado>> list() {
        return new ResponseEntity<>(encargadoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Encargado> create(@RequestBody Encargado en) {
        return new ResponseEntity<>(encargadoService.save(en), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Encargado> update(@PathVariable Long id, @RequestBody Encargado en) {
        Encargado encargado = encargadoService.findById(id);
        if (encargado != null) {
            try {
                encargado.setActividadesEncargado(en.getActividadesEncargado());
                encargado.setHorarioEncargado(en.getHorarioEncargado());
                encargado.setPersona(en.getPersona());

                return new ResponseEntity<>(encargadoService.save(encargado), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Encargado> delete(@PathVariable Long id) {
        encargadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
