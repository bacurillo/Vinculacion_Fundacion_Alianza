package com.backend.alianza.repository;

import com.backend.alianza.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia,Long> {


    @Query(value = "SELECT a.*   " +
            "FROM asistencia a JOIN ficha_inscripcion i ON i.id_ficha_inscripcion = a.id_ficha_inscripcion   " +
            "JOIN ficha_personal p ON p.id_ficha_personal = i.id_ficha_personal   " +
            "WHERE a.fecha_asistencia = :fecha AND a.id_curso = :id   " +
            "ORDER BY p.apellidos, p.nombres", nativeQuery = true)
    List<Asistencia> buscarAsistencia(@Param("fecha") Date fecha,
                                   @Param("id") Long id);
}
