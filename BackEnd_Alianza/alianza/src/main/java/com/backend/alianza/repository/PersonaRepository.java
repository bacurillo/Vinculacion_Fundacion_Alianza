package com.backend.alianza.repository;

import com.backend.alianza.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Boolean existsByCiPasaporte(String ciPasaporte);
}
