package com.alura.Foro_hub.dominio.consulta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findAllByStatusTrue(Pageable pageable);
    Boolean existsByMensajeAndIdNotAndStatusTrue(String mensaje, Long id);
    Boolean existsByTituloAndMensajeAndStatusTrue(String titulo, String mensaje);
    Boolean existsByMensajeAndStatusTrue(String mensaje);



}
