package com.backend.alianza.controller;

import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.model.Reporte;
import com.backend.alianza.repository.*;
import com.backend.alianza.service.FichaPersonalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fichaPersonal")
public class FichaPersonalController {

    @Autowired
    public FichaPersonalServiceImpl service;

    @Autowired
    FichaPersonalRepository repository;

    @Autowired
    FichaInscripcionRepository insRepository;
    @Autowired
    FichaRepresentanteRepository repRepository;
    @Autowired
    FichaSaludRepository salRepository;
    @Autowired
    FichaFamiliarRepository famRepository;
    @Autowired
    FichaEducativaRepository eduRepository;
    @Autowired
    FichaDesvinculacionRepository desRepository;

    @GetMapping("/get")
    public ResponseEntity<List<FichaPersonal>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/cedulaUnicaFP")
    public ResponseEntity<Boolean> cedulaUnicaFP(@RequestParam String ci) {
        return new ResponseEntity<>(service.cedulaUnicaFP(ci), HttpStatus.OK);
    }

    @GetMapping("/busquedaRE/{ci}/{gen}/{rang}/{est}")
    public ResponseEntity<List<FichaPersonal>> busquedaRE(@PathVariable String ci, @PathVariable String gen,
                                                          @PathVariable int rang, @PathVariable boolean est) {
        if (ci.equalsIgnoreCase("NA")) {
            ci = "";
        }
        if (gen.equalsIgnoreCase("NA")) {
            gen = "";
        }
        return new ResponseEntity<>(service.busquedaRE(ci, gen, rang, est), HttpStatus.OK);
    }

    @GetMapping("/reporteGeneralRE/{ci}/{gen}/{rang}/{est}")
    public ResponseEntity<List<Reporte>> reporteGeneralRE(@PathVariable String ci, @PathVariable String gen,
                                                        @PathVariable int rang, @PathVariable boolean est) {
        if (ci.equalsIgnoreCase("NA")) {
            ci = "";
        }
        if (gen.equalsIgnoreCase("NA")) {
            gen = "";
        }


        List<Object[]> userData = service.reporteGeneralRE(ci, gen, rang, est);
        List<Reporte> users = new ArrayList<>();

        for (Object[] data : userData) {

            Reporte reporte = new Reporte();

            System.out.println("\n\n\n\n"+data[0]+"\n\n\n\n");

            Long perId = (data[0] != null) ? ((BigInteger) data[0]).longValue() : 0L;
            Long insId = (data[1] != null) ? ((BigInteger) data[1]).longValue() : 0L;
            Long repId = (data[2] != null) ? ((BigInteger) data[2]).longValue() : 0L;
            Long salId = (data[3] != null) ? ((BigInteger) data[3]).longValue() : 0L;
            Long famId = (data[4] != null) ? ((BigInteger) data[4]).longValue() : 0L;
            Long eduId = (data[5] != null) ? ((BigInteger) data[5]).longValue() : 0L;
            Long desId = (data[6] != null) ? ((BigInteger) data[6]).longValue() : 0L;

            System.out.println("\n\n\n\n"+perId+"\n\n\n\n");

            reporte.setFichaPersonal(repository.findById(perId).orElse(null));

            reporte.setFichaInscripcion(insRepository.findById(insId).orElse(null));

            reporte.setFichaRepresentante(repRepository.findById(repId).orElse(null));

            reporte.setFichaSalud(salRepository.findById(salId).orElse(null));

            reporte.setFichaFamiliar(famRepository.findById(famId).orElse(null));

            reporte.setFichaEducativa(eduRepository.findById(eduId).orElse(null));

            reporte.setFichaDesvinculacion(desRepository.findById(desId).orElse(null));

            users.add(reporte);


        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/reporteGeneral/{ci}/{gen}/{est}")
    public ResponseEntity<List<Reporte>> reporteGeneral(@PathVariable String ci, @PathVariable String gen,
                                                        @PathVariable boolean est) {
        if (ci.equalsIgnoreCase("NA")) {
            ci = "";
        }
        if (gen.equalsIgnoreCase("NA")) {
            gen = "";
        }


        List<Object[]> userData = service.reporteGeneral(ci, gen, est);
        List<Reporte> users = new ArrayList<>();

        for (Object[] data : userData) {

            Reporte reporte = new Reporte();

            System.out.println("\n\n\n\n"+data[0]+"\n\n\n\n");

            Long perId = (data[0] != null) ? ((BigInteger) data[0]).longValue() : 0L;
            Long insId = (data[1] != null) ? ((BigInteger) data[1]).longValue() : 0L;
            Long repId = (data[2] != null) ? ((BigInteger) data[2]).longValue() : 0L;
            Long salId = (data[3] != null) ? ((BigInteger) data[3]).longValue() : 0L;
            Long famId = (data[4] != null) ? ((BigInteger) data[4]).longValue() : 0L;
            Long eduId = (data[5] != null) ? ((BigInteger) data[5]).longValue() : 0L;
            Long desId = (data[6] != null) ? ((BigInteger) data[6]).longValue() : 0L;

            System.out.println("\n\n\n\n"+perId+"\n\n\n\n");

            reporte.setFichaPersonal(repository.findById(perId).orElse(null));

            reporte.setFichaInscripcion(insRepository.findById(insId).orElse(null));

            reporte.setFichaRepresentante(repRepository.findById(repId).orElse(null));

            reporte.setFichaSalud(salRepository.findById(salId).orElse(null));

            reporte.setFichaFamiliar(famRepository.findById(famId).orElse(null));

            reporte.setFichaEducativa(eduRepository.findById(eduId).orElse(null));

            reporte.setFichaDesvinculacion(desRepository.findById(desId).orElse(null));

            users.add(reporte);


        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }




    @GetMapping("/gelAllByEst/{est}")
    public ResponseEntity<List<FichaPersonal>> gelAllByEst(@PathVariable boolean est) {
        return new ResponseEntity<>(service.gelAllByEst(est), HttpStatus.OK);
    }

    @GetMapping("/busqueda/{ci}/{gen}/{est}")
    public ResponseEntity<List<FichaPersonal>> busqueda(@PathVariable String ci, @PathVariable String gen,
                                                        @PathVariable boolean est) {
        if (ci.equalsIgnoreCase("NA")) {
            ci = "";
        }
        if (gen.equalsIgnoreCase("NA")) {
            gen = "";

        }
        return new ResponseEntity<>(service.busqueda(ci, gen, est), HttpStatus.OK);
    }




    @GetMapping("/busquedaID/{id}")
    public ResponseEntity<List<FichaPersonal>> busquedaID(@PathVariable Long id) {

        return new ResponseEntity<>(service.busquedaID(id), HttpStatus.OK);
    }

    @GetMapping("/busquedaCiNombre/{est}/{busqueda}")
    public ResponseEntity<List<Map<String, Object>>> busquedaCiNombre(@PathVariable boolean est,
                                                                      @PathVariable String busqueda) {
        busqueda = busqueda.trim();
        if (busqueda.equalsIgnoreCase("NA")) {
            busqueda = "";
        }

        List<Object[]> resultados = service.busquedaCiNombre(est, busqueda);
        List<Map<String, Object>> resultadosConNombres = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> resultadoMap = new HashMap<>();
            resultadoMap.put("idFichaPersonal", fila[0]);
            resultadoMap.put("apellidos", fila[1]);
            resultadoMap.put("nombres", fila[2]);
            resultadoMap.put("ciPasaporte", fila[3]);
            resultadoMap.put("estVinculacion", fila[4]);
            resultadoMap.put("foto", fila[5]);
            resultadosConNombres.add(resultadoMap);
        }

        return new ResponseEntity<>(resultadosConNombres, HttpStatus.OK);
    }

    @GetMapping("/busquedaFP/{est}/{busqueda}")
    public ResponseEntity<List<FichaPersonal>> busquedaFP(@PathVariable boolean est,
                                                          @PathVariable String busqueda) {
        busqueda = busqueda.trim();
        if (busqueda.equalsIgnoreCase("NA")) {
            busqueda = "";
        }
        return new ResponseEntity<>(service.busquedaFP(est, busqueda), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaPersonal> create(@RequestBody FichaPersonal fp) {
        return new ResponseEntity<>(service.save(fp), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaPersonal> update(@PathVariable Long id, @RequestBody FichaPersonal fp) {
        FichaPersonal fichaPersonal = service.findById(id);
        if (fichaPersonal != null) {
            try {
                fichaPersonal.setFoto(fp.getFoto());
                fichaPersonal.setApellidos(fp.getApellidos());
                fichaPersonal.setNombres(fp.getNombres());
                fichaPersonal.setTipoIdentificacion(fp.getTipoIdentificacion());
                fichaPersonal.setCiPasaporte(fp.getCiPasaporte());
                fichaPersonal.setNacionalidad(fp.getNacionalidad());
                fichaPersonal.setFechaNacimiento(fp.getFechaNacimiento());
                fichaPersonal.setGenero(fp.getGenero());
                fichaPersonal.setZona(fp.getZona());
                fichaPersonal.setActTrabInfantil(fp.isActTrabInfantil());
                fichaPersonal.setDetalleActTrabInfantil(fp.getDetalleActTrabInfantil());
                fichaPersonal.setBarrioSector(fp.getBarrioSector());
                fichaPersonal.setDireccion(fp.getDireccion());
                fichaPersonal.setReferencia(fp.getReferencia());
                fichaPersonal.setCoordenadaX(fp.getCoordenadaX());
                fichaPersonal.setCoordenadaY(fp.getCoordenadaY());
                fichaPersonal.setRangoEdad(fp.getRangoEdad());
                fichaPersonal.setEtnia(fp.getEtnia());
                fichaPersonal.setParroquia(fp.getParroquia());
                fichaPersonal.setEstVinculacion(fp.isEstVinculacion());
                fichaPersonal.setFechaRegistro(fp.getFechaRegistro());
                fichaPersonal.setAnexosCedula(fp.getAnexosCedula());
                fichaPersonal.setAnexosDocumentosLegales(fp.getAnexosDocumentosLegales());
                return new ResponseEntity<>(service.save(fichaPersonal), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaPersonal> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
