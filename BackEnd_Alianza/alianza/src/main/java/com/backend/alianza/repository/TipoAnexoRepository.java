package com.backend.alianza.repository;

import com.backend.alianza.model.AnexoEducativo;
import com.backend.alianza.model.TipoAnexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAnexoRepository extends JpaRepository<TipoAnexo, Long> {
}
