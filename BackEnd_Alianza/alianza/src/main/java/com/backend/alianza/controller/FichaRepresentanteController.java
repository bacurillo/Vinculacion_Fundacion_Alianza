package com.backend.alianza.controller;

import com.backend.alianza.model.FichaRepresentante;
import com.backend.alianza.service.FichaRepresentanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaRepresentante")
@CrossOrigin(origins = {"*"})
public class FichaRepresentanteController {


    @Autowired
    FichaRepresentanteServiceImpl fichaRepresentanteService;

    @GetMapping("/get")
    public ResponseEntity<List<FichaRepresentante>> list() {
        return new ResponseEntity<>(fichaRepresentanteService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaRepresentante>> busquedaID(@PathVariable Long id) {

        return new ResponseEntity<>(fichaRepresentanteService.busquedaID(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaRepresentante> create(@RequestBody FichaRepresentante a) {
        return new ResponseEntity<>(fichaRepresentanteService.save(a), HttpStatus.CREATED);

    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaRepresentante> update(@PathVariable Long id, @RequestBody FichaRepresentante a) {
        FichaRepresentante fichaRepresentante = fichaRepresentanteService.findById(id);
        if (fichaRepresentante != null) {
            try {
                fichaRepresentante.setNombresRepre(a.getNombresRepre());
                fichaRepresentante.setApellidosRepre(a.getApellidosRepre());
                fichaRepresentante.setCedulaRepre(a.getCedulaRepre());
                fichaRepresentante.setContactoRepre(a.getContactoRepre());
                fichaRepresentante.setContactoEmergenciaRepre(a.getContactoEmergenciaRepre());
                fichaRepresentante.setFechaNacimientoRepre(a.getFechaNacimientoRepre());
                fichaRepresentante.setOcupacionPrimariaRepre(a.getOcupacionPrimariaRepre());
                fichaRepresentante.setOcupacionSecundariaRepre(a.getOcupacionSecundariaRepre());
                fichaRepresentante.setLugarTrabajoRepre(a.getLugarTrabajoRepre());
                fichaRepresentante.setObservacionesRepre(a.getObservacionesRepre());
                fichaRepresentante.setNivelInstruccionRepre(a.getNivelInstruccionRepre());
                fichaRepresentante.setParentescoRepre(a.getParentescoRepre());
                fichaRepresentante.setFichaPersonal(a.getFichaPersonal());
                fichaRepresentante.setFechaRegistro(a.getFechaRegistro());
                fichaRepresentante.setTipoIdentificacionRepre(a.getTipoIdentificacionRepre());
                fichaRepresentante.setGeneroRepre(a.getGeneroRepre());
                fichaRepresentante.setNacionalidadRepre(a.getNacionalidadRepre());
                fichaRepresentante.setAnexosCedulaPPFF(a.getAnexosCedulaPPFF());
                return new ResponseEntity<>(fichaRepresentanteService.save(fichaRepresentante), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaRepresentante> delete(@PathVariable Long id) {
        fichaRepresentanteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
