package com.alura.Foro_hub.dominio.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarConsulta(@NotNull Long id, String titulo, String mensaje, Long curso_id) {
}
