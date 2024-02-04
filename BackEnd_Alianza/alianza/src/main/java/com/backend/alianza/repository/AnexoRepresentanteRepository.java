package com.backend.alianza.repository;

import com.backend.alianza.model.AnexoMedico;
import com.backend.alianza.model.AnexoRepresentante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoRepresentanteRepository extends JpaRepository<AnexoRepresentante, Long> {
}
