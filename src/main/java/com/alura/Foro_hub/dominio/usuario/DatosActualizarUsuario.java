package com.alura.Foro_hub.dominio.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Long id, String nombre, String clave, String email) {
}
