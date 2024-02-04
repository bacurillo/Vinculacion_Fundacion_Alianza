package com.backend.alianza.repository;

import com.backend.alianza.model.AnexoEducativo;
import com.backend.alianza.model.AnexoMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoMedicoRepository extends JpaRepository<AnexoMedico, Long> {
}
