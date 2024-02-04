package com.backend.alianza.repository;

import com.backend.alianza.model.FichaEducativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaEducativaRepository extends JpaRepository<FichaEducativa,Long> {

    @Query(value = "SELECT *   " +
            " FROM public.ficha_educativa f   " +
            " WHERE f.id_ficha_personal = :id ", nativeQuery = true)
    List<FichaEducativa> busquedaID(@Param("id") Long id);
}
