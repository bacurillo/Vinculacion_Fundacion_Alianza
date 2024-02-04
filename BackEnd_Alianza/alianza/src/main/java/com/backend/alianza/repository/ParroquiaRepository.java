package com.backend.alianza.repository;

import com.backend.alianza.model.Parroquia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParroquiaRepository extends JpaRepository<Parroquia, Long> {
    @Query(value = "SELECT * " +
            " FROM parroquia " +
            " WHERE id_canton = :id", nativeQuery = true)
    List<Parroquia> busqueda(@Param("id") Long id);
}
