package com.alura.Foro_hub.dominio.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByStatusTrue(Pageable pageable);
    UserDetails findByNombre(String nombre);

    @Query(""" 
            select u.status
            from Usuario u
            where
            u.id = :id
            """)
    boolean findStatusById(Long id);
    boolean existsByNombreAndStatusTrue(String nombre);
    boolean existsByEmailAndStatusTrue(String email);
    boolean existsByNombreAndEmailAndStatusTrue(String nombre, String email);
}
