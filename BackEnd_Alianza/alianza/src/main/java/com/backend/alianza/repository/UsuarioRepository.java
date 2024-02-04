package com.backend.alianza.repository;


import com.backend.alianza.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

    Boolean existsByUsername(String username);

    Usuario findByusernameAndPassword(String username, String password);

    public boolean existsByPassword(String password);

    @Query(value = "SELECT u.* " +
            " FROM usuario u JOIN persona p ON(u.id_persona = p.id_persona) " +
            " WHERE u.id_rol = :rol " +
            " AND(p.ci_pasaporte LIKE (CONCAT('%', :busqueda ,'%'))  " +
            " OR CONCAT(LOWER(p.apellidos_persona), ' ', LOWER(p.nombres_persona)) LIKE LOWER (CONCAT('%', :busqueda ,'%'))  " +
            " OR CONCAT(LOWER(p.nombres_persona), ' ', LOWER(p.apellidos_persona)) LIKE LOWER (CONCAT('%', :busqueda ,'%'))  " +
            "   OR LOWER(u.username)LIKE LOWER (CONCAT('%', :busqueda ,'%'))  " +
            "    ) " +
            " ORDER BY p.apellidos_persona, p.nombres_persona", nativeQuery = true)
    List<Usuario> filtroUser(@Param("busqueda") String busqueda, @Param("rol") long rol);


    @Query(value = "SELECT u.* " +
            " FROM usuario u JOIN persona p ON(u.id_persona = p.id_persona) " +
            " WHERE p.ci_pasaporte LIKE (CONCAT('%', :busqueda ,'%'))  " +
            " OR CONCAT(LOWER(p.apellidos_persona), ' ', LOWER(p.nombres_persona)) LIKE LOWER (CONCAT('%', :busqueda ,'%'))  " +
            " OR CONCAT(LOWER(p.nombres_persona), ' ', LOWER(p.apellidos_persona)) LIKE LOWER (CONCAT('%', :busqueda ,'%'))  " +
            "   OR LOWER(u.username)LIKE LOWER (CONCAT('%', :busqueda ,'%'))  " +
            " ORDER BY p.apellidos_persona, p.nombres_persona", nativeQuery = true)
    List<Usuario> filtroUserSR(@Param("busqueda") String busqueda);

    @Query(value = "SELECT u.* " +
            " FROM usuario u JOIN persona p ON(u.id_persona = p.id_persona) " +
            " WHERE u.id_rol = :rol " +
            " ORDER BY p.apellidos_persona, p.nombres_persona", nativeQuery = true)
    List<Usuario> userXrol(@Param("rol") long rol);


}
