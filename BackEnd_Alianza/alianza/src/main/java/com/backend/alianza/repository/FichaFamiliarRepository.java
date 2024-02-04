package com.backend.alianza.repository;

import com.backend.alianza.model.FichaFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaFamiliarRepository extends JpaRepository<FichaFamiliar, Long> {

    @Query(value = "SELECT * " +
            " FROM ficha_familiar f " +
            " WHERE f.id_ficha_personal = :id", nativeQuery = true)
    List<FichaFamiliar> busquedaID(@Param("id") Long id);
}
