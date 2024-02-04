package com.backend.alianza.repository;

import com.backend.alianza.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
}
