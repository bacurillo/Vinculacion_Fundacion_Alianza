package com.backend.alianza.repository;

import com.backend.alianza.model.FichaSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaSaludRepository extends JpaRepository<FichaSalud,Long> {
    @Query(value = "SELECT * " +
            " FROM public.ficha_salud f " +
            "  WHERE f.id_ficha_personal = :id", nativeQuery = true)
    List<FichaSalud> busquedaID(@Param("id") Long id);
}
