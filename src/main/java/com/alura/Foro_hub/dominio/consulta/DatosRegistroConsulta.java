package com.alura.Foro_hub.dominio.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroConsulta(@NotBlank String titulo,
                                    @NotBlank String mensaje,
                                    @NotNull Long usuario_id,
                                    @NotNull Long curso_id
                                    ) {
}
