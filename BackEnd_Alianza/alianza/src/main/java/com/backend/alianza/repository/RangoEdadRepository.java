package com.backend.alianza.repository;

import com.backend.alianza.model.Provincia;
import com.backend.alianza.model.RangoEdad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RangoEdadRepository extends JpaRepository<RangoEdad, Long> {
}
