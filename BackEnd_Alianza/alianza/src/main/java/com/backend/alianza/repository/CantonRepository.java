package com.backend.alianza.repository;

import com.backend.alianza.model.Canton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CantonRepository extends JpaRepository<Canton, Long> {

    @Query(value = "SELECT * " +
            " FROM canton " +
            " WHERE id_provincia = :id", nativeQuery = true)
    List<Canton> busqueda(@Param("id") Long id);
}
