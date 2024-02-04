package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Asistencia;
import com.backend.alianza.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl extends GenericServiceImpl<Asistencia,Long>implements GenericService<Asistencia,Long> {

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Override
    public CrudRepository<Asistencia, Long> getDao() {
        return asistenciaRepository;
    }

    public List<Asistencia> saveAll(List<Asistencia> asistencias) {
        return (List<Asistencia>) asistenciaRepository.saveAll(asistencias);
    }

    public List<Asistencia> updateAll(List<Asistencia> asistencias) {
        List<Asistencia> updatedAsistencias = new ArrayList<>();

        for (Asistencia asistencia : asistencias) {
            // Verificar si la asistencia ya existe en la base de datos por su ID
            Asistencia existingAsistencia = asistenciaRepository.findById(asistencia.getIdAsistencia()).orElse(null);

            if (existingAsistencia != null) {

                System.out.println("\n\n\n\n\n"+existingAsistencia.getFechaAsistencia()+"\n\n\n\n\n");
                // Actualizar los campos de la asistencia existente con los valores de la asistencia proporcionada
                existingAsistencia.setFechaAsistencia(asistencia.getFechaAsistencia());
                existingAsistencia.setEstadoAsistencia(asistencia.getEstadoAsistencia());
                existingAsistencia.setObservacionesAsistencia(asistencia.getObservacionesAsistencia());

                // Guardar la asistencia actualizada en la base de datos
                updatedAsistencias.add(asistenciaRepository.save(existingAsistencia));
            } else {
                // Si la asistencia no existe, puedes manejarlo de acuerdo a tus necesidades,
                // como ignorarla o lanzar una excepción.
            }
        }

        return updatedAsistencias;
    }


    public List<Asistencia> buscarAsistencia(Date fecha, Long id){
        return asistenciaRepository.buscarAsistencia(fecha,id);
    }
}
