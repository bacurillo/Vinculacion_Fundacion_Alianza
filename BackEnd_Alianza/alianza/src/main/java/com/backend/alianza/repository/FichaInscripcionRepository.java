package com.backend.alianza.repository;

import com.backend.alianza.model.FichaInscripcion;
import com.backend.alianza.model.FichaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaInscripcionRepository extends JpaRepository<FichaInscripcion, Long> {
    @Query(value = "SELECT * " +
            " FROM public.ficha_inscripcion f " +
            " WHERE f.id_ficha_personal = :id ", nativeQuery = true)
    List<FichaInscripcion> busquedaID(@Param("id") Long id);

    @Query(value = "SELECT f.* " +
            "FROM ficha_inscripcion f  " +
            "JOIN ficha_personal p ON p.id_ficha_personal = f.id_ficha_personal  " +
            "WHERE f.id_curso = :id  " +
            "ORDER BY p.apellidos, p.nombres", nativeQuery = true)
    List<FichaInscripcion> listaEstudiantes(@Param("id") Long id);
}
