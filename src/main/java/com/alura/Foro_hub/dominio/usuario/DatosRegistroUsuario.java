package com.alura.Foro_hub.dominio.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(@NotBlank String nombre,
                                   @NotBlank String clave,
                                   @NotBlank @Email String email
                                   ) {
}
