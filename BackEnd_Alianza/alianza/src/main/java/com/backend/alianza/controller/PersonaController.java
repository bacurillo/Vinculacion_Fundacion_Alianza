package com.backend.alianza.controller;

import com.backend.alianza.model.Persona;
import com.backend.alianza.repository.PersonaRepository;
import com.backend.alianza.repository.UsuarioRepository;
import com.backend.alianza.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    public PersonaServiceImpl personaService;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/get")
    public ResponseEntity<List<Persona>> list() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/existsDNI")
    public ResponseEntity<Boolean> existsDNI(@RequestParam String dni) {
        return new ResponseEntity<>(personaRepository.existsByCiPasaporte(dni.trim()), HttpStatus.OK);
    }

//    @PostMapping("/post")
//    public ResponseEntity<Persona> create(@RequestBody Persona pe) {
//
//        return new ResponseEntity<>(personaService.save(pe), HttpStatus.CREATED);
//    }

    @PostMapping("/post")
    public ResponseEntity<Persona> create(@RequestBody Persona pe) {

        System.out.println("\n\n\n\n "+pe.getIdPersona()+"\n\n\n");
            return new ResponseEntity<>(personaService.save(pe), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona pe) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            try {
                persona.setApellidosPersona(pe.getApellidosPersona());
                persona.setNombresPersona(pe.getNombresPersona());
                persona.setCiPasaporte(pe.getCiPasaporte());
                persona.setTipoIdentificacion((pe.getTipoIdentificacion()));


                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
