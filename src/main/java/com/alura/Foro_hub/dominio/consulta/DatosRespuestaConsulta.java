package com.alura.Foro_hub.dominio.consulta;

import java.time.LocalDateTime;

public record DatosRespuestaConsulta(Long id, String titulo, String mensaje, LocalDateTime fecha, Boolean status,
                                     Long usuario_id, String usuarioNombre, Long curso_id, String cursoNombre) {
}
