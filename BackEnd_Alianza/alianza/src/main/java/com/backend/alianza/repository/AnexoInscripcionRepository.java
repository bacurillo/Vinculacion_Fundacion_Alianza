package com.backend.alianza.repository;

import com.backend.alianza.model.AnexoEducativo;
import com.backend.alianza.model.AnexoInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoInscripcionRepository extends JpaRepository<AnexoInscripcion, Long> {
}
