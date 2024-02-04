package com.backend.alianza.repository;

import com.backend.alianza.model.Curso;
import com.backend.alianza.model.FichaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Long> {

    Boolean existsByNombreCurso(String username);

    @Query(value = "Select c.* from curso c where c.id_usuario = :id", nativeQuery = true)
    List<Curso> cursoByUser(@Param("id") Long id);

    @Query(value = "SELECT c.* " +
            " FROM curso c JOIN usuario u ON (u.id_usuario = c.id_usuario) " +
            " JOIN persona p ON (p.id_persona = u.id_persona) " +
            " WHERE " +
            " CONCAT(LOWER(p.nombres_persona), ' ', LOWER(p.apellidos_persona)) LIKE LOWER (CONCAT('%', :busqueda ,'%'))" +
            " OR CONCAT(LOWER(p.apellidos_persona), ' ', LOWER(p.nombres_persona)) LIKE LOWER (CONCAT('%', :busqueda ,'%'))" +
            " OR LOWER(c.nombre_curso) LIKE LOWER (CONCAT('%', :busqueda ,'%'))", nativeQuery = true)
    List<Curso> busquedaCurso(@Param("busqueda") String busqueda);

}
