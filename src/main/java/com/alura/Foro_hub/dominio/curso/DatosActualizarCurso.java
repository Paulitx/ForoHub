package com.alura.Foro_hub.dominio.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(@NotNull Long id, String nombre, Categoria categoria) {
}
