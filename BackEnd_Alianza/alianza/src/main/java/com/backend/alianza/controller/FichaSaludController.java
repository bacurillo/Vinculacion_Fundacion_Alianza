package com.backend.alianza.controller;

import com.backend.alianza.model.FichaSalud;
import com.backend.alianza.service.FichaSaludServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaSalud")
@CrossOrigin(origins = {"*"})
public class FichaSaludController {

    @Autowired
    FichaSaludServiceImpl fichaSaludService;

    @GetMapping("/get")
    public ResponseEntity<List<FichaSalud>> list() {
        return new ResponseEntity<>(fichaSaludService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaSalud>> busquedaID(@PathVariable Long id){

        return new ResponseEntity<>(fichaSaludService.busquedaID(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaSalud> create(@RequestBody FichaSalud a) {
        return new ResponseEntity<>(fichaSaludService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaSalud> update(@PathVariable Long id, @RequestBody FichaSalud a) {
        FichaSalud fichaSalud = fichaSaludService.findById(id);
        if (fichaSalud != null) {
            try {
                fichaSalud.setPesoFichaSalud(a.getPesoFichaSalud());
                fichaSalud.setTallaFichaSalud(a.getTallaFichaSalud());
                fichaSalud.setDiscapacidadNNAFichaSalud(a.getDiscapacidadNNAFichaSalud());
                fichaSalud.setEnfermedadesPrevalentesFichaSalud(a.getEnfermedadesPrevalentesFichaSalud());
                fichaSalud.setPorcentajeDiscapacidadFichaSalud(a.getPorcentajeDiscapacidadFichaSalud());
                fichaSalud.setEnfermedadesPrevalentesFichaSalud(a.getEnfermedadesPrevalentesFichaSalud());
                fichaSalud.setCondicionesMedicas(a.getCondicionesMedicas());
                fichaSalud.setTipoDiscapacidadFichaSalud(a.getTipoDiscapacidadFichaSalud());
                fichaSalud.setFichaPersonal(a.getFichaPersonal());
                fichaSalud.setFechaRegistro(a.getFechaRegistro());
                fichaSalud.setAnexosCertificadoSalud(a.getAnexosCertificadoSalud());
                fichaSalud.setAnexosCertificadoSalud2(a.getAnexosCertificadoSalud2());
                fichaSalud.setAnexosDiscapacidad(a.getAnexosDiscapacidad());


                return new ResponseEntity<>(fichaSaludService.save(fichaSalud), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaSalud> delete(@PathVariable Long id) {
        fichaSaludService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
