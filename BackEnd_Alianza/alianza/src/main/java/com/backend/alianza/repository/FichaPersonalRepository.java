package com.backend.alianza.repository;

import com.backend.alianza.model.FichaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FichaPersonalRepository extends JpaRepository<FichaPersonal, Long> {








    @Query(value = "SELECT *" +
            "  FROM ficha_personal p  " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  (p.ci_pasaporte LIKE CONCAT ('%', :ci, '%') " +
            "  OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            "  OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            ")  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  " +
            "  AND p.id_rango_edad = :rang   ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busquedaRE(@Param("ci") String ci,
                                   @Param("gen") String gen,
                                   @Param("rang") int rang,
                                   @Param("est") boolean est);

//    @Query(value = "SELECT COUNT(*) FROM ficha_personal WHERE ci_pasaporte = :ci ", nativeQuery = true)
//    int cedulaUnicaFP(@Param("ci") String ci);

    @Query(value = "SELECT     " +
            "    p.id_ficha_personal,      " +
            "    fi.id_ficha_inscripcion,      " +
            "    fr.id_ficha_representante,      " +
            "    fs.id_ficha_salud,      " +
            "    ff.id_ficha_familiar,      " +
            "    fe.id_ficha_educativa,      " +
            "    fd.id_ficha_desvinculacion     " +
            "     " +
            "     " +
            "FROM     " +
            "    ficha_personal p     " +
            "LEFT JOIN (     " +
            "    SELECT     " +
            "        p.id_ficha_personal AS persona_id,     " +
            "        MAX(fi.id_ficha_inscripcion) AS ficha_inscripcion_id,     " +
            "        MAX(fr.id_ficha_representante) AS ficha_representante_id,     " +
            "        MAX(fs.id_ficha_salud) AS ficha_salud_id,     " +
            "        MAX(ff.id_ficha_familiar) AS ficha_familiar_id,     " +
            "        MAX(fe.id_ficha_educativa) AS ficha_educativa_id,     " +
            "        MAX(fd.id_ficha_desvinculacion) AS ficha_desvinculacion_id     " +
            "    FROM     " +
            "        ficha_personal p     " +
            "    LEFT JOIN ficha_inscripcion fi ON p.id_ficha_personal = fi.id_ficha_personal     " +
            "    LEFT JOIN ficha_representante fr ON p.id_ficha_personal = fr.id_ficha_personal     " +
            "    LEFT JOIN ficha_salud fs ON p.id_ficha_personal = fs.id_ficha_personal     " +
            "    LEFT JOIN ficha_familiar ff ON p.id_ficha_personal = ff.id_ficha_personal     " +
            "    LEFT JOIN ficha_educativa fe ON p.id_ficha_personal = fe.id_ficha_educativa     " +
            "    LEFT JOIN ficha_desvinculacion fd ON p.id_ficha_personal = fd.id_ficha_desvinculacion     " +
            "    GROUP BY p.id_ficha_personal     " +
            ") AS u ON p.id_ficha_personal = u.persona_id     " +
            "LEFT JOIN ficha_inscripcion fi ON u.ficha_inscripcion_id = fi.id_ficha_inscripcion     " +
            "LEFT JOIN ficha_representante fr ON u.ficha_representante_id = fr.id_ficha_representante     " +
            "LEFT JOIN ficha_salud fs ON u.ficha_salud_id = fs.id_ficha_salud     " +
            "LEFT JOIN ficha_familiar ff ON u.ficha_familiar_id = ff.id_ficha_familiar     " +
            "LEFT JOIN ficha_educativa fe ON u.ficha_educativa_id = fe.id_ficha_educativa     " +
            "LEFT JOIN ficha_desvinculacion fd ON u.ficha_desvinculacion_id = fd.id_ficha_desvinculacion     " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  (p.ci_pasaporte LIKE CONCAT ('%', :ci, '%') " +
            "  OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            "  OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            ")  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  " +
            "  AND p.id_rango_edad = :rang   ORDER BY apellidos, nombres", nativeQuery = true)
    List<Object[]> reporteGeneralRE(@Param("ci") String ci,
                                   @Param("gen") String gen,
                                   @Param("rang") int rang,
                                   @Param("est") boolean est);

    Boolean existsByCiPasaporte(String username);


    @Query(value = "SELECT * " +
            " FROM ficha_personal where est_vinculacion = :est ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> gelAllByEst(@Param("est") boolean est);



    @Query(value = "SELECT *" +
            "  FROM ficha_personal p  " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  (p.ci_pasaporte LIKE CONCAT ('%', :ci, '%') " +
            "  OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            "  OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            ")  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busqueda(@Param("ci") String ci,
                                 @Param("gen") String gen,
                                 @Param("est") boolean est);

    @Query(value = "SELECT     " +
            "    p.id_ficha_personal,      " +
            "    fi.id_ficha_inscripcion,      " +
            "    fr.id_ficha_representante,      " +
            "    fs.id_ficha_salud,      " +
            "    ff.id_ficha_familiar,      " +
            "    fe.id_ficha_educativa,      " +
            "    fd.id_ficha_desvinculacion     " +
            "     " +
            "     " +
            "FROM     " +
            "    ficha_personal p     " +
            "LEFT JOIN (     " +
            "    SELECT     " +
            "        p.id_ficha_personal AS persona_id,     " +
            "        MAX(fi.id_ficha_inscripcion) AS ficha_inscripcion_id,     " +
            "        MAX(fr.id_ficha_representante) AS ficha_representante_id,     " +
            "        MAX(fs.id_ficha_salud) AS ficha_salud_id,     " +
            "        MAX(ff.id_ficha_familiar) AS ficha_familiar_id,     " +
            "        MAX(fe.id_ficha_educativa) AS ficha_educativa_id,     " +
            "        MAX(fd.id_ficha_desvinculacion) AS ficha_desvinculacion_id     " +
            "    FROM     " +
            "        ficha_personal p     " +
            "    LEFT JOIN ficha_inscripcion fi ON p.id_ficha_personal = fi.id_ficha_personal     " +
            "    LEFT JOIN ficha_representante fr ON p.id_ficha_personal = fr.id_ficha_personal     " +
            "    LEFT JOIN ficha_salud fs ON p.id_ficha_personal = fs.id_ficha_personal     " +
            "    LEFT JOIN ficha_familiar ff ON p.id_ficha_personal = ff.id_ficha_personal     " +
            "    LEFT JOIN ficha_educativa fe ON p.id_ficha_personal = fe.id_ficha_educativa     " +
            "    LEFT JOIN ficha_desvinculacion fd ON p.id_ficha_personal = fd.id_ficha_desvinculacion     " +
            "    GROUP BY p.id_ficha_personal     " +
            ") AS u ON p.id_ficha_personal = u.persona_id     " +
            "LEFT JOIN ficha_inscripcion fi ON u.ficha_inscripcion_id = fi.id_ficha_inscripcion     " +
            "LEFT JOIN ficha_representante fr ON u.ficha_representante_id = fr.id_ficha_representante     " +
            "LEFT JOIN ficha_salud fs ON u.ficha_salud_id = fs.id_ficha_salud     " +
            "LEFT JOIN ficha_familiar ff ON u.ficha_familiar_id = ff.id_ficha_familiar     " +
            "LEFT JOIN ficha_educativa fe ON u.ficha_educativa_id = fe.id_ficha_educativa     " +
            "LEFT JOIN ficha_desvinculacion fd ON u.ficha_desvinculacion_id = fd.id_ficha_desvinculacion     " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  (p.ci_pasaporte LIKE CONCAT ('%', :ci, '%') " +
            "  OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            "  OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :ci ,'%'))" +
            ")  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  ORDER BY apellidos, nombres", nativeQuery = true)
    List<Object[]> reporteGeneral(@Param("ci") String ci,
                                  @Param("gen") String gen,
                                  @Param("est") boolean est);



    @Query(value = " SELECT p.id_ficha_personal, p.apellidos, p.nombres, p.ci_pasaporte, p.est_vinculacion, p.foto  "
            +
            "             FROM ficha_personal p " +
            "             WHERE p.est_vinculacion = :est" +
            "             AND ( " +
            "               p.ci_pasaporte LIKE (CONCAT('%', :busqueda ,'%')) " +
            "                OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "                OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "            ) ORDER BY apellidos, nombres", nativeQuery = true)
    List<Object[]> busquedaCiNombre(@Param("est") boolean est,
                                    @Param("busqueda") String busqueda);


    @Query(value = " SELECT *  " +
            "             FROM ficha_personal p " +
            "             WHERE p.est_vinculacion = :est" +
            "             AND ( " +
            "               p.ci_pasaporte LIKE (CONCAT('%', :busqueda ,'%')) " +
            "                OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "                OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "            ) ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busquedaFP(@Param("est") boolean est,
                                   @Param("busqueda") String busqueda);


    @Query(value = "SELECT *   " +
            " FROM ficha_personal f   " +
            " WHERE f.id_ficha_personal = :id ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busquedaID(@Param("id") Long id);

}
