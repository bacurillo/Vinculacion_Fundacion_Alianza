package com.backend.alianza.repository;

import com.backend.alianza.model.AnexoEducativo;
import com.backend.alianza.model.AnexoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoEducativoRepository extends JpaRepository<AnexoEducativo, Long> {
}
