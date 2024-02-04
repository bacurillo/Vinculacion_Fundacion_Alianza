package com.backend.alianza.repository;

import com.backend.alianza.model.FichaRepresentante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaRepresentanteRepository extends JpaRepository<FichaRepresentante,Long> {
    @Query(value = "SELECT * " +
            " FROM public.ficha_representante f " +
            "  WHERE f.id_ficha_personal = :id", nativeQuery = true)
    List<FichaRepresentante> busquedaID(@Param("id") Long id);

    Boolean existsByCedulaRepre(String cedulaRepre);
}
