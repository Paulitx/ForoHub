package com.alura.Foro_hub.dominio.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findByStatusTrue(Pageable pageable);

    @Query(""" 
            select c.status
            from Curso c
            where
            c.id = :id
            """)
    boolean findStatusById(Long id);


}
