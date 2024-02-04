package com.backend.alianza.controller;

import com.backend.alianza.model.Secretaria;
import com.backend.alianza.service.SecretariaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretaria")
public class SecretariaController {

    @Autowired
    public SecretariaServiceImpl secretariaService;


    @GetMapping("/get")
    public ResponseEntity<List<Secretaria>> list() {
        return new ResponseEntity<>(secretariaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Secretaria> create(@RequestBody Secretaria en) {
        return new ResponseEntity<>(secretariaService.save(en), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Secretaria> update(@PathVariable Long id, @RequestBody Secretaria sec) {
        Secretaria secretaria = secretariaService.findById(id);
        if (secretaria != null) {
            try {
                secretaria.setActividadesSecretaria(sec.getActividadesSecretaria());
                secretaria.setHorarioSecretaria(sec.getHorarioSecretaria());
                secretaria.setPersona(sec.getPersona());

                return new ResponseEntity<>(secretariaService.save(secretaria), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Secretaria> delete(@PathVariable Long id) {
        secretariaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
