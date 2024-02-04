package com.backend.alianza.repository;

import com.backend.alianza.model.FichaDesvinculacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaDesvinculacionRepository extends JpaRepository<FichaDesvinculacion, Long> {

    @Query(value = "SELECT *  " +
            "  FROM ficha_desvinculacion f  " +
            "  WHERE f.id_ficha_personal = :id ORDER BY fecha_desvinculacion desc   ", nativeQuery = true)
    List<FichaDesvinculacion> busquedaID(@Param("id") Long id);
}
