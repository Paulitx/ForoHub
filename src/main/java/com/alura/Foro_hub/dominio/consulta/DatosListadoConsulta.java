package com.alura.Foro_hub.dominio.consulta;

import com.alura.Foro_hub.dominio.curso.Curso;
import com.alura.Foro_hub.dominio.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListadoConsulta(Long id, String titulo, String mensaje, LocalDateTime fecha, Boolean status, Long usuario_id,
                                   String  nombreUsuario, Long curso_id, String nombreCurso) {
    public DatosListadoConsulta (Consulta consulta){
        this(consulta.getId(), consulta.getTitulo(), consulta.getMensaje(), consulta.getFecha(), consulta.getStatus(),
                consulta.getUsuario().getId(), consulta.getUsuario().getNombre(), consulta.getCurso().getId(),
                consulta.getCurso().getNombre());
    }
}
