package com.backend.alianza.repository;

import com.backend.alianza.model.Provincia;
import com.backend.alianza.model.TipoFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoFamiliaRepository extends JpaRepository<TipoFamilia, Long> {
}
